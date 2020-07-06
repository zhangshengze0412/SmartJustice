package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: MarryCase
 * @description: 婚姻案件
 * @author: ZSZ
 * @date: 2020/7/2 16:25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarryCase {

    private String id;
    private String original_claim;              //原告诉称
    private String defendant_argued;            //被告辩称
    private String result;                      //结果
    private String prob_BrokenFeelings;         //prob_感情破裂
    private String prob_DomesticViolence;       //prob_家庭暴力
    private String prob_Derailed;               //prob_出轨
    private String prob_Bigamy;                 //prob_重婚
    private String prob_RealEstate;             //prob_房产
    private String prob_Vehicle;                //prob_车辆
    private String prob_Debt;                   //prob_债权债务
    private String prob_ParentingIssues;        //prob_抚养问题
    private String prob_CommonProperty;         //prob_共同财产


}
