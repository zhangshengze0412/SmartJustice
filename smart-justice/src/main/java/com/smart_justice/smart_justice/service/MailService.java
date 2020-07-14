package com.smart_justice.smart_justice.service;

/**
 * 邮箱验证服务
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 10:01
 **/


public interface MailService {

    /**
     * 用户邮箱验证服务
     * @param email 邀请者的邮箱
     * @param username 邀请者用户名
     * @return boolean
     */
    boolean authUserEmail(String email,String username);

    /**
     * 企业邮箱验证服务
     * @param email 邀请者的邮箱
     * @param username 邀请者用户名
     * @return boolean
     */
    boolean authLawyerTeamEmail(String email,String username);

    /**
     * 发送html用户邮箱验证邮件
     * @param form 发送方邮箱
     * @param to 接收方邮箱
     * @param subject 邮箱主题
     * @param content 邮箱内容
     */
    void sendHtmlMail(String form,String to,String subject,String content);

}
