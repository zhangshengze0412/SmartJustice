package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: IntentionalInjuryCase
 * @description: 故意伤害类案件
 * @author: ZSZ
 * @date: 2020/7/2 16:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntentionalInjuryCase {

    private String id;
    private String original_claim;                      //原告诉称
    private String defendant_argued;                    //被告辩称
    private String result;                              //结果
    private String prob_SubjectiveIntention;            //prob_伤人主观故意
    private String prob_IntentionalInjury;              //prob_故意伤害行为
    private String prob_InjuryDet;                      //prob_伤情认定问题
    private String prob_CausalityIAD;                   //prob_伤情与行为的因果关系
    private String prob_ConstituteII;                   //prob_构成故意伤害罪
    private String prob_ConstituteIM;                   //prob_构成故意杀人罪
    private String prob_NegligentDeath;                 //prob_构成过失致人死亡罪
    private String prob_NegligentSeriousInjury;         //prob_构成过失致人重伤罪
    private String prob_DefensiveDeg;                   //prob_正当防卫程度
    private String prob_CriminalRes;                    //prob_具有刑事责任能力
    private String prob_ConstitutesAtt;                 //prob_构成犯罪未遂
    private String prob_ConstitutesSus;                 //prob_构成犯罪中止
    private String prob_ConstituteCrimePre;             //prob_构成犯罪预备
    private String prob_ConstituteJointCrime;           //prob_构成共同犯罪
    private String prob_CogSauJoiCrimes;                //prob_共同犯罪中的地位认定
    private String prob_ThreatenAccessory;              //prob_胁从犯
    private String prob_WheVictimIsFault;               //prob_被害人是否存在过错
    private String prob_MeritoriousPlot;                //prob_立功情节
    private String prob_OtherSenCir;                    //prob_其他量刑情节问题
    private String prob_Surrender;                      //prob_构成自首
    private String prob_Probation;                      //prob_缓刑
    private String prob_IllegalEvidence;                //prob_非法证据

}
