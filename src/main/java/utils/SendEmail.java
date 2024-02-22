package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    public static void sendEmail(String code, String email) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "n21dccn013@student.ptithcm.edu.vn";
        // Mat khai email cua ban
        final String password = "mmay jfmj dgrc qxpq";
        // dia chi email nguoi nhan
        final String toEmail = email;
        final String subject = "Mã xác nhận";
//        String body = "Mã xác nhận của bạn là: " + code;
        String body = """
              <!DOCTYPE html>
              <html lang="en">
              <head>
              </head>
              <body>
                <h3 style="color: blue;">Mã xác nhận của bạn là:</h3>
                <p>%s</p>
              </body>
              </html>
              """.formatted(code);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        //set message headers

        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setHeader("X-Mailer", "JavaMail");
        msg.setHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
        msg.setFrom(new InternetAddress(fromEmail, "PTIT"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setContent(body, "text/html; charset=utf-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }

}
