package com.pyq.study.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pangyueqiang on 17/1/20.
 */
public class SqlBuilder {
    private String tableName;
    private Map<String,Object> setFields;
    private Map<String,Map<String,String>> replaceFields;
    private String filter;

    public SqlBuilder() {
        tableName = "";
        setFields = new HashMap();
        replaceFields = new HashMap<>();
        filter = "";
    }

    public SqlBuilder setReplaceFields(Map<String,Map<String,String>> replaceFields){
        this.replaceFields = replaceFields;
        return this;
    }

    public SqlBuilder setSetFields(Map<String,Object> setFields){
        this.setFields = setFields;
        return this;
    }
    public SqlBuilder setTableName(String tableName){
        this.tableName = tableName;
        return this;
    }
    public SqlBuilder  where(String filter){
        this.filter = filter;
        return this;
    }

    public void print(){
        if(check()) {
            System.out.println(generatorSql());
        }
    }
    public void printIntoFile(String path) throws IOException{
        if(!check())
            return;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(path))));
        bufferedWriter.write(generatorSql());
        bufferedWriter.flush();
    }

    private String generatorSql(){
        StringBuilder sball = new StringBuilder();
        if(!(this.setFields==null || this.setFields.size()==0))
        {
            StringBuilder sb = new StringBuilder();
            sb.append(" UPDATE " + this.tableName + " set ");
            for (Map.Entry<String, Object> entry : this.setFields.entrySet())
            {
                String field = entry.getKey();
                Object value = entry.getValue();
                if(value instanceof String)
                {
                    sb.append(field + " = '" + value.toString() +"' , ");
                }else {
                    sb.append(field + " = " + value.toString() +" , ");
                }
            }
            sb.deleteCharAt(sb.lastIndexOf(",")).append(this.filter);
            sball.append(sb.toString()+"\n");
        }

        if(!(this.replaceFields==null || this.replaceFields.size()==0))
        {
            for (Map.Entry<String, Map<String,String>> entry : this.replaceFields.entrySet())
            {
                String field = entry.getKey();
                Map<String ,String> value = entry.getValue();
                for(Map.Entry<String, String> entryReplace : value.entrySet())
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" UPDATE " + this.tableName + " set ");
                    sb.append(field + " = ");
                    sb.append(replace(field,entryReplace.getKey(),entryReplace.getValue()));
                    sball.append(sb.toString() +" "+ this.filter + "\n");
                }

            }
        }
        return sball.toString();
    }
    private boolean check(){
        if(this.tableName==null || this.tableName.equals("")) {
            System.out.println("请调用setTableName方法设置表名。。。");
            return false;
        }
        if((this.setFields==null || this.setFields.size()==0) && (this.replaceFields==null || this.replaceFields.size()==0)){
            System.out.println("没有有效的更新字段设置。");
            return false;
        }
        if(this.filter==null || this.filter.equals("")){
            System.out.println("该条语句没有设置过滤条件，请仔细核对是否全量更新数据库。");
            return true;
        }
        return true;
    }
    private String replace(String field,String oldValue , String newValue){
    return "REPLACE("+field+" , '"+oldValue+"' , '"+newValue+"')";
    }

    public static void main(String[] args) throws IOException{
        //需求1
        // t_vacate_data表中，
        // field1字段设置成123，
        // field2字段值设置成 'abc'
        // field3字段中 "old1" 替换成 "new1" ,    "old2" 替换成 "new2";
        // field4字段中 "old1" 替换成 "new1" ,    "old2" 替换成 "new2";
        Map<String,Object> map = new HashMap<>();
        map.put("field1",123);
        map.put("field2","abc");

        Map<String,String> field3TranslateMap = new HashMap<>();
        field3TranslateMap.put("old1","new1");
        field3TranslateMap.put("old2","new2");

        Map<String,String> field4TranslateMap = new HashMap<>();
        field4TranslateMap.put("old1","new1");
        field4TranslateMap.put("old2","new2");

        Map<String,Map<String,String>> replaceFields = new HashMap<>();
        replaceFields.put("field3",field3TranslateMap);
        replaceFields.put("field4",field4TranslateMap);

        new SqlBuilder().setTableName("t_vacate_data").setSetFields(map).setReplaceFields(replaceFields).where("where tenant_id = 12517 ; ").printIntoFile("/Users/pangyueqiang/Desktop/JsonSql_vacate2.sql");

        //new SqlBuilder().setTableName("t_vacate_data").setSetFields(map).setReplaceFields(replaceFields).where("where tenant_id = 12517 ; ").print();

    }
}
