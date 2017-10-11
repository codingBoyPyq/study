package com.pyq.study.baseJava;


/**
 * Created by pangyueqiang on 17/9/27.
 *总结：
 * 1: 无论有无异常，finally 代码块 总在 try 或者 catch 中的return 后执行,如果return的非函数运算，那么直接压如栈顶，如果是函数，先运算函数，取函数结果压入栈顶。
 *
 * 2: 然后再执行finally 代码块，如果 finally代码块 中也有return 元素，该return 运算结果将继续入栈顶，复写之前return的值，
 * finally 执行完，真正的返回栈顶元素，返回的结果是 最后一步执行return 压如栈顶的值。
 *
 * 3:如果异常没有catch住 ,finally 代码块中又没有return，主函数最终的return 不会执行，直接抛出异常。
 * 4:如果异常没有catch住 ,finally 代码块中有return，直接执行return，不会抛出异常。
 */
public class TryCatchDemo {
    public static String test1(){
        try{
            Long.parseLong("12s3");
            return print("tag[1]:执行 try return");
        }catch (NullPointerException e){
            print("tag[2]:进入catch模块");
            return print("tag[3]:执行 catch return");
        }
        finally {
            print("tag[4]:进入finally模块");
            return print("tag[5]:执行 finally return");
        }
    }
    public static String test3(){
        try{
            Long.parseLong("12s3");
            return print("tag[1]:执行 try return");
        }catch (NullPointerException e){
            print("tag[2]:进入catch模块");
            //此处不能return，否则最后一步return执行不到，编译不通过
        }
        finally {
            print("tag[3]:进入finally模块");
        }
        return print("tag[4]:执行 catch return");
    }

    public static String test2(){
        try{
            Long.parseLong("12s3");
            return print("tag[1]:执行 try return");
        }catch (NullPointerException e){
            print("tag[2]:进入catch模块");
            return print("tag[3]:执行 catch return");
        }
        finally {
            print("tag[4]:进入finally模块");
        }
    }

    public static String test5(){
        try{
            Long.parseLong("123");
            return print("tag[1]: 执行 try  return");
        }catch (Exception e){
            print("tag[2]:进入catch模块");
            return print("tag[3]:执行 catch return");
        }
        finally {
            print("tag[4]:进入finally模块");
            return print("tag[5]: 执行 finally return");
        }
    }

    public static String test6(){
        try{
            Long.parseLong("123");
        }catch (Exception e){
            print("tag[2]:进入catch模块");
            return print("tag[3]:执行 catch return");
        }
        finally {
            print("tag[4]:进入finally模块");
            return print("tag[5]: 执行 finally return");
        }
    }

    public static String test4(){
        try{
            Long.parseLong("12s3");
            return print("tag[1]: 执行 try  return");
        }catch (NumberFormatException e){
            print("tag[2]:进入catch模块");
            return print("tag[3]:执行 catch return");
        }
        finally {
            print("tag[4]:进入finally模块");
            return print("tag[5]: 执行 finally return");
        }
    }

    public static String print(String str){
        System.out.println(str);
        return str;
    }

    public static void main(String[] args){
        //System.out.println("======================test1============================");
        //System.out.println("真正return value:    "+TryCatchDemo.test1());
        //System.out.println("=======================test2===========================");
        //System.out.println("真正return value:    "+TryCatchDemo.test2());
        //System.out.println("=======================test3===========================");
        //System.out.println("真正return value:    "+TryCatchDemo.test3());




    }



}
