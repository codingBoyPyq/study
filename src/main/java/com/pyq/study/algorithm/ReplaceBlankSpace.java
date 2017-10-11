package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/24.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {
    public static String replaceSpace(StringBuffer str) {
        if(str==null | str.length()==0)
            return null;
        char[] array = str.toString().toCharArray();
        int counter = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==' ')
                counter++;
        }
        char[] tempArray = new char[array.length+2*counter];
        for(int i=array.length-1,j=tempArray.length-1;i>=0&j>=0;){
            if(array[i]==' '){
                tempArray[j--]='0';
                tempArray[j--]='2';
                tempArray[j--]='%';
                i--;
            }else{
                tempArray[j--]=array[i--];
            }
        }
        return new String(tempArray);
    }
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are friend !")));
    }
}
