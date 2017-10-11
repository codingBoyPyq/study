package com.pyq.study.rsa;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by pangyueqiang on 17/5/2.
 */
public class Coder {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] decryptBASE64(String str){
        byte[] bt = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer( str );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }
    public static String encryptBASE64(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }



    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    public static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    /***
     * 通过反射使用java 中不对外公开的类：
     * encode by Base64
     */
    public static String encodeBase64(byte[]input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("encode", byte[].class);
        mainMethod.setAccessible(true);
        Object retObj=mainMethod.invoke(null, new Object[]{input});
        return (String)retObj;
    }
    /***
     * 通过反射使用java 中不对外公开的类：
     * decode by Base64
     */
    public static byte[] decodeBase64(String input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj=mainMethod.invoke(null, input);
        return (byte[])retObj;
    }

    public static void main(String[] args) {

    }
}
