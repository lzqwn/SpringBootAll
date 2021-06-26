package com.springboot.springbootemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender jms;

    @Resource
    TemplateEngine templateEngine;


    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("sendSimpleEmail")
    public String sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("3136947767@qq.com"); // 接收地址
            message.setSubject("一封简单的邮件"); // 标题
            message.setText("使用Spring Boot发送简单邮件。"); // 内容
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    /**
     * 发送HTML邮件
     */
    @RequestMapping("sendHtmlEmail")
    public String sendHtmlEmail() {
        try {
            MimeMessage message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("3136947767@qq.com");
            // 标题
            helper.setSubject("一封HTML格式的邮件");
            // 带HTML格式的内容
            StringBuffer sb = new StringBuffer("<p style='color:#6db33f'>使用Spring Boot发送HTML格式邮件。</p>");
            helper.setText(sb.toString(), true);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 发送带有附件邮件
     */
    @RequestMapping("sendAttachmentsMail")
    public String sendAttachmentsMail() {
        try {
            MimeMessage message = jms.createMimeMessage();
            //添加utf-8处理中文乱码
            MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
            helper.setFrom(from);
            // 接收地址
            helper.setTo("3136947767@qq.com");
            // 标题
            helper.setSubject("一封带附件的邮件");
            // 内容
            helper.setText("详情参见附件内容！");
            // 传入附件
            FileSystemResource file = new FileSystemResource(new File("D:\\3work\\code\\SpringBootAll\\10.SpringBoot-Email\\src\\main\\resources\\新建文本文档.txt"));
            helper.addAttachment("附件.txt", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 发送静态资源邮件
     */
    @RequestMapping("sendInlineMail")
    public String sendInlineMail() {
        try {
            MimeMessage message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("3136947767@qq.com"); // 接收地址
            helper.setSubject("一封带静态资源的邮件"); // 标题
            helper.setText("<html><body>博客图：<img src='cid:img'/></body></html>", true); // 内容
            // 传入附件
            // 聚合项目需要指定子模块名称
            FileSystemResource file = new FileSystemResource(new File("10.SpringBoot-Email\\src\\main\\resources\\1.jpg"));
            helper.addInline("img", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    /**
     * 使用模板发送邮件
     */
    @RequestMapping("sendTemplateEmail")
    public String sendTemplateEmail(String code) {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("3136947767@qq.com");
            // 标题
            helper.setSubject("邮件摸板测试");
            // 处理邮件模板
            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
