package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: TrafficCase
 * @description: 交通案件
 * @author: ZSZ
 * @date: 2020/7/2 16:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrafficCase {

    private String id;
    private String original_claim;                      //原告诉称
    private String defendant_argued;                    //被告辩称
    private String result;                              //结果
    private String prob_TrafficAccCer;                  //prob_交通事故认定书
    private String prob_TrafficAccCompAgr;              //prob_交通事故赔偿协议
    private String prob_InjuryCompScope;                //prob_伤害赔偿范围
    private String prob_InjuryOrDeathCorr;              //prob_伤情或死亡相关性
    private String prob_insCompComp;                    //prob_保险公司如何赔偿
    private String prob_IfInsComp;                      //prob_保险公司是否赔偿
    private String prob_MotorVehResp;                   //prob_机动车所有人责任
    private String prob_RespMotVehCal;                  //prob_机动车挂靠方责任
    private String prob_ScopeOfDeaComp;                 //prob_死亡赔偿范围
    private String prob_MentalComfort;                  //prob_精神抚慰金
    private String prob_PropertyCompScope;              //prob_财产赔偿范围
    private String prob_DivisionResp;                   //prob_责任划分
    private String prob_RoadManResp;                    //prob_道路管理者责任
    private String prob_AppraisalOpi;                   //prob_鉴定意见书
    private String prob_EmployerResp;                  //prob_雇主责任


}
