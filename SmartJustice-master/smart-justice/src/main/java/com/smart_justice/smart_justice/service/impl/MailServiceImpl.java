package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.mapper.LawyerTeamMapper;
import com.smart_justice.smart_justice.mapper.NormalUserMapper;
import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.NormalUser;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    private NormalUserMapper normalUserMapper;

    @Autowired
    private LawyerTeamMapper lawyerTeamMapper;

    @Autowired
    private JavaMailSender mailSender;


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean authUserEmail(String email,String username) {
        User user=userMapper.getUserByUsername(username);
        if(user==null){
            return false;
        }
        if(!user.getEmail().equals(email)){
            return false;
        }
        NormalUser isNormalUser=normalUserMapper.getNormalUserByUserId(user.getId());
        if(isNormalUser!=null){
            return true;
        }
        NormalUser normalUser=new NormalUser();
        normalUser.setUserId(user.getId());
        boolean is=normalUserMapper.addNormalUser(normalUser);
        if(!is){
            new Exception();
            return false;
        }
        userMapper.authUser(email);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean authLawyerTeamEmail(String email,String username,Integer teamId) {
        User user=userMapper.getUserByUsername(username);
        if(user==null){
            return false;
        }
        if(!user.getEmail().equals(email)){
            return false;
        }
        Lawyer lawyer=lawyerMapper.getLawyerByUserId(user.getId());
        if(lawyer!=null&&lawyer.getIsValid()!=0){
            return true;
        }
        Lawyer reLawyer=new Lawyer();
        reLawyer.setUserId(user.getId());
        reLawyer.setTeamId(teamId);
        boolean is=lawyerMapper.addLawyer(reLawyer);
        boolean reIs=lawyerMapper.authLawyer(user.getId());
        boolean reReIs=lawyerTeamMapper.updateLawyerTeamNum(teamId,1);
        if(!is||!reIs||!reReIs){
            new Exception();
            return false;
        }

        return true;
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
