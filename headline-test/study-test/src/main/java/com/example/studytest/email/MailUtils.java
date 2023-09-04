package com.example.studytest.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



/**
 * @Author hhy
 * @PackageName headline
 * @Package com.example.studytest.email
 * @Date 2023/8/30 17:20
 * @return
 * @Version 1.0
 */
public class MailUtils {
    private static final String USER = "1992395918@qq.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "jjzdbvveizulegfb"; // 可以使户端授权码

    /**
     *
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        // 测试
        String htmlTable = "<html>" +
                "<head></head>" +
                "<body>" +
                "<h1>HTML Table Example</h1>" +
                "<table border='1'>" +
                "<tr><th>ID</th><th>Name</th><th>Age</th></tr>" +
                "<tr><td>1</td><td>John</td><td>30</td></tr>" +
                "<tr><td>2</td><td>Alice</td><td>25</td></tr>" +
                "<tr><td>3</td><td>Bob</td><td>28</td></tr>" +
                "</table>" +
                "</body>" +
                "</html>";
        boolean mailSent = sendMail("hhydeyx@gmail.com", htmlTable, "HTML Table Email");

        if (mailSent) {
            System.out.println("Email sent successfully.");
        } else {
            System.out.println("Failed to send email.");
        }
    }
}
