package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 10:25
 **/

@Service
public class MailServiceImpl implements MailService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LawyerMapper lawyerMapper;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public boolean authUserEmail(String email,String username) {
        User user=userMapper.getUserByUsername(username);
        if(user==null){
            return false;
        }
        if(!user.getEmail().equals(email)){
            return false;
        }
        return userMapper.authUser(email);

    }

    @Override
    public boolean authLawyerTeamEmail(String email,String username) {
        User user=userMapper.getUserByUsername(username);
        if(user==null){
            return false;
        }
        if(!user.getEmail().equals(email)){
            return false;
        }
        Lawyer lawyer=lawyerMapper.getLawyerById(user.getId());
        if(lawyer!=null&&lawyer.getTeamId()!=0){
            return lawyerMapper.authLawyer(user.getId());
        }
        return false;
    }

    @Override
    public void sendHtmlMail(String form, String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            mailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
