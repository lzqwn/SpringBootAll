package com.lzqwn.shiro.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    /*@Autowired
    private UserService userService;*/


    /*
     * 跳转到register请求
     */
    @RequestMapping("registerview")
    public String register() {
        System.out.println("跳转之register的html");
        return "register";
    }

    /*  *
     * 跳转到login请求
     */
    @RequestMapping("loginview")
    public String login() {
        System.out.println("跳转之login的html");
        return "login";
    }


    /*
     * 验证码方法
     */
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(os);
        //存入session方便验证
        session.setAttribute("yzm",captcha);
        //验证图形验证码的有效性，返回boolean值
       // captcha.verify("1234");

       /* //验证码放入session
        session.setAttribute("code", code);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(220, 60, os, code);*/
    }

    /*
     * 用户注册
     */
   /* @RequestMapping("register")
    public String register(User user) {
        try {
            userService.register(user);
            return "redirect:/user/loginview";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/user/registerview";
        }
    }*/


    /**
     * 退出登录
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出用户
        return "redirect:/user/loginview";
    }

    /**
     * 用来处理身份认证
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password, String code, HttpSession session) {
        //比较验证码
        String codes = (String) session.getAttribute("code");
        try {
            if (codes.equalsIgnoreCase(code)) {
                //获取主体对象
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(username, password));
                return "redirect:/index";
            } else {
                throw new RuntimeException("验证码错误!");
            }
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "redirect:/user/loginview";
    }

}
