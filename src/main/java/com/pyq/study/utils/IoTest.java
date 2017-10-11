package com.pyq.study.utils;

import java.io.*;

/**
 * Created by pangyueqiang on 16/7/7.
 */
public class IoTest {
    public static void main (String args[]) throws IOException{
        //readFile();
       //genarator();
        genarator_t_vacate();
    }
    private static void readFile() throws IOException{
        //BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter("/Users/pangyueqiang/Desktop/mengniumergeUser.data"));
        PrintStream out = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/pangyueqiang/Desktop/mengniumergeUser.data")));
        String str = null;
        while((str = br.readLine())!=null)
        {
            String[] arr = str.split("=");
            //保留
            String source = arr[0].trim();
            //舍弃
            String tar = arr[1].trim();
            System.out.println("|" +source+"|"+tar+"|");
        }
    }
    private static void genarator_t_vacate() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter("/Users/pangyueqiang/Desktop/mengniu_vacate_merge.sql"));
        PrintStream out = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/pangyueqiang/Desktop/mengniumergeUser1.data")));
        String str = null;
        String[] table = {"t_vacate_data","t_reimburse_data"};

        while((str = br.readLine())!=null)
        {
            for(int i = 0;i<table.length;i++)
            {
                StringBuffer sb1 = new StringBuffer();
                sb1.append("update "+ table[i] +" set userId = ");
                String[] arr = str.split("=");
                String source = arr[0].trim();
                String tar = arr[1].trim();
                sb1.append( source + " where tenantId = 616741 and userId = "+tar+ " ; \n");

                 bufferedWriter.write(sb1.toString());
            }
        }
        //out.print("update t_vacate_data set tenantId = 1155347 where tenantId in (17606 ,616741); \n");
        //out.print("update t_reimburse_data set tenantId = 1155347 where tenantId in (17606 ,616741);");
        bufferedWriter.write("update t_vacate_data set tenantId = 1155347 where tenantId in (17606 ,616741); \n");
        bufferedWriter.write("update t_reimburse_data set tenantId = 1155347 where tenantId in (17606 ,616741); \n");
        bufferedWriter.flush();
    }
    private static void genarator() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter("/Users/pangyueqiang/Desktop/mengniu_TweekData_merge.sql"));
        PrintStream out = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/pangyueqiang/Desktop/mengniumergeUser1.data")));
        String str = null;
        int count = 0;
        String[] fileds = {"hard_work_desc","outdoor_desc","customer_desc","contact_desc","record_desc","outdoor_customer_desc","opportunity_desc","record_customer_desc"};
        while((str = br.readLine())!=null)
        {
            count++;
            StringBuffer sb1 = new StringBuffer();
            sb1.append("update `t_week_company_data` set ");
            String[] arr = str.split("=");
            String source = arr[0].trim();
            String tar = arr[1].trim();
            for(int i = 0;i<fileds.length;i++)
            {
                sb1.append(getReplace(fileds[i],source,tar));
                if(i!=fileds.length-1)
                {
                    sb1.append(" , ");
                }
            }
            sb1.append(" where tenant_id = 616741 ; \n");
            //out.print(sb1.toString());
            bufferedWriter.write(sb1.toString());
        }
        bufferedWriter.flush();
        System.out.println("count:"+count);
    }
    private static String getReplace(String filed, String source ,String tar){
        return filed +" = REPLACE("+filed +",'\"userId\":"+tar+"','\"userId\":"+source+"')";
    }
}
