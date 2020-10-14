package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.configuration.MyEmailConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EmailController {

    public final JavaMailSender emailSender;

    @ResponseBody
    @PostMapping("/sendTestEmail")
    public String sendTestEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(MyEmailConstants.MY_EMAIL);
        message.setSubject("TestEmail");
        message.setText("Hello, Im testing Email");
        this.emailSender.send(message);
        return "Email Sent!";
    }
}
