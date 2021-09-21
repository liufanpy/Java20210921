package com.itheima.demo9_发送邮件;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件工具类
 */
public class MailUtil {
	private MailUtil(){}
	/**
	 * 发送邮件
	 * 参数一:发送邮件给谁
	 * 参数二:发送邮件的内容
	 */
	public static void sendMail(String toEmail, String emailMsg) throws Exception {
		//1_创建Java程序与eyou邮件服务器的连接对象
		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zs", "123456"); //类似登录
			}
		};
		Session session = Session.getInstance(props, auth);
		//2_创建一封邮件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("zs@itheima.com"));//设置发件人
		message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));//设置收件人
		message.setSubject("用户激活");
		message.setContent(emailMsg, "text/html;charset=UTF-8");//设置发送的内容
		//3_发送邮件
		Transport.send(message);
	}

	public static void sendMail(String fromName,String password,String fromEmail,String toEmail,String subject, String emailMsg) throws Exception {
		//1_创建Java程序与eyou邮件服务器的连接对象
		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromName, password); //类似登录
			}
		};
		Session session = Session.getInstance(props, auth);
		//2_创建一封邮件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));//设置发件人
		message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));//设置收件人
		message.setSubject(subject);
		message.setContent(emailMsg, "text/html;charset=UTF-8");//设置发送的内容
		//3_发送邮件
		Transport.send(message);
	}
	/**
	 * 测试类
	 */
	public static void main(String[] args) throws Exception{
		// String toEmail = "ls@itheima.com";// 收件人邮箱
		// String emailMsg = "<a href = 'http://www.itheima.com'>激活账户</a>";
		// sendMail(toEmail,emailMsg);
		String fromName = "ww";// 发件人邮箱的名字
		String password = "123456";// 发件人邮箱的密码
		String fromEmail = "ww@itheima.com";// 发件人的邮箱
		String toEmail = "zs@itheima.com";// 收件人的邮箱
		String subject = "5月份会议内容";// 邮件主题
		String emailMsg = "5月份一直加班到月底....";// 邮件内容
		sendMail(fromName,password,fromEmail,toEmail,subject,emailMsg);

		System.out.println("发送邮件成功!");
	}
}








