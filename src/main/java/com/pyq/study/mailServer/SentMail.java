package com.pyq.study.mailServer;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
/*  596048781
                  POP3/SMTP服务     swkytfqqsvkqbfcg
                  IMAP/SMTP服务     qfxpsntlhuspbdeb
*/

/*  2276854544
                  POP3/SMTP服务     ujueeerzysvaebja
                  IMAP/SMTP服务     aozzwtjdsfiheafg
*/

public class SentMail {
    public static Transport transport;
    public static Message message;
    public static void main(String[] args) throws AddressException,MessagingException{
        init();
        for(int i=0;i<10;i++){
            sent("自如房子可以预定了","手慢无，手慢无");
        }
        close();
    }

    public static void init() throws AddressException,MessagingException{

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "false");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("2276854544@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("596048781@qq.com"));
        // 得到邮差对象
        transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("2276854544@qq.com", "ujueeerzysvaebja");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
    }

    public static void sent(String title,String content) throws MessagingException {
        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(content);
        transport.sendMessage(message, message.getAllRecipients());
    }
    public static void close () throws MessagingException {
        transport.close();
    }

}
