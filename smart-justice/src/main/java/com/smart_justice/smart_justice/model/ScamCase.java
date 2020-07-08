package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ScamCase
 * @description: 诈骗类案件
 * @author: ZSZ
 * @date: 2020/7/2 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScamCase {

    private String id;
    private String original_claim;                            //原告诉称
    private String defendant_argued;                          //被告辩称
    private String result;                                    //结果
    private String prob_SubjectiveIntention;                  //prob_主观意图
    private String prob_FraudBehavior;                        //prob_诈骗行为
    private String prob_FraudAmount;                          //prob_诈骗数额
    private String prob_CausalRelationship;                   //prob_因果关系
    private String prob_Fraud;                                //prob_诈骗罪
    private String prob_FraudOtherSpeCri;                     //prob_诈骗/其它特殊犯罪
    private String prob_UnitCrime;                            //prob_单位犯罪
    private String prob_Responsibility;                       //prob_责任能力
    private String prob_AttemptedCrime;                       //prob_犯罪形态未遂
    private String prob_SuspensionCrime;                      //prob_犯罪形态中止
    private String prob_CriminalPre;                          //prob_犯罪形态预备
    private String prob_JointCrime;                           //prob_共同犯罪
    private String prob_DetAmountLegLia;                      //prob_法律责任的数额认定
    private String prob_CogStatusJoiCri;                      //prob_共同犯罪中的地位认定
    private String prob_ThreatenAcc;                          //prob_胁从犯
    private String prob_MerService;                           //prob_立功
    private String prob_Surrender;                            //prob_自首
    private String prob_VictimFault;                          //prob_被害人过错
    private String prob_ImpactSen;                            //prob_影响量刑
    private String prob_ApplyProbation;                       //prob_适用缓刑
    private String prob_ProsLimit;                            //prob_追诉时效
    private String prob_Evidence;                             //prob_证据



}
