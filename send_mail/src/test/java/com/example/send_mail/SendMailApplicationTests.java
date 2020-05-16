package com.example.send_mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PutMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

@SpringBootTest
class SendMailApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    JavaMailSender javaMailSender;


    /**
     * 发送简单邮件
     */
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件对象：这是一封测试邮件");
        message.setFrom("446933040@qq.com");
        message.setTo("446933040@qq.com");
        message.setCc("446933040@qq.com");
        message.setBcc("446933040@qq.com");
        message.setSentDate(new Date());
        message.setText("测试邮件正文");
        javaMailSender.send(message);
    }


    /**
     * 发送带附件的邮件
     * @throws MessagingException
     */
    @Test
    public void sendAttachFileMail() throws MessagingException {
        //通过 javaMailSender 来获取一个复杂邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //利用 MimeMessageHelper 对邮件进行配置，MimeMessageHelper 是一个邮件配置的辅助工具类 ,true 表示构建一个 multipart message 类型的邮件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("邮件对象：这是一封测试邮件");
        helper.setFrom("446933040@qq.com");
        helper.setTo("446933040@qq.com");
        helper.setCc("446933040@qq.com");
        helper.setBcc("446933040@qq.com");
        helper.setSentDate(new Date());
        helper.setText("测试邮件正文");
        helper.addAttachment("222.jpg",new File("E:\\amuse\\img\\one\\pikachues.jpg"));
        javaMailSender.send(mimeMessage);
    }


    /**
     * 发送带图片资源的邮件
     * @throws MessagingException
     */
    @Test
    public void sendImgResMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("邮件对象：这是一封测试邮件");
        helper.setFrom("446933040@qq.com");
        helper.setTo("446933040@qq.com");
        helper.setCc("446933040@qq.com");
        helper.setBcc("446933040@qq.com");
        helper.setSentDate(new Date());
        //第二个参数true表示是一个html文本
        helper.setText("<p>hello 大家好，这是一封测试邮件，这封邮件包含一张张图片，分别如下</P><p><img src='cid:p01'/></p>",true);
        helper.addInline("p01",new FileSystemResource(new File("E:\\amuse\\img\\one\\pikachues.jpg")));
        javaMailSender.send(mimeMessage);
    }


    @Test
    public void sendFreemarkerMail() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("邮件对象：这是一封测试邮件");
        helper.setFrom("446933040@qq.com");
        helper.setTo("446933040@qq.com");
        helper.setCc("446933040@qq.com");
        helper.setBcc("446933040@qq.com");
        helper.setSentDate(new Date());

        //构建freemarker的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        //配置模板位置
        ClassLoader loader = SendMailApplication.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(loader,"templates");
        //加载模板
        Template template = configuration.getTemplate("mail.ftl");
        User user = new User();
        user.setUsername("pikachues");
        user.setNum("11");
        user.setSalary("9999");
        StringWriter out = new StringWriter();

        //模板渲染，渲染结果保存到out中，将out中的html发送即可
        template.process(user,out);
        helper.setText(out.toString(),true);
        javaMailSender.send(mimeMessage);
    }


    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void sendThymeleafMail() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("邮件对象：这是一封测试邮件");
        helper.setFrom("446933040@qq.com");
        helper.setTo("446933040@qq.com");
        helper.setCc("446933040@qq.com");
        helper.setBcc("446933040@qq.com");
        helper.setSentDate(new Date());

        //构建freemarker的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        //配置模板位置
        ClassLoader loader = SendMailApplication.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(loader,"templates");
        //加载模板
        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("num","000001");
        context.setVariable("salary", "99999");
        String process = templateEngine.process("mail.html", context);
        helper.setText(process.toString(),true);
        javaMailSender.send(mimeMessage);
    }



}
