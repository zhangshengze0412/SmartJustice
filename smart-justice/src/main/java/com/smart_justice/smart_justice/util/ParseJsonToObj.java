package com.smart_justice.smart_justice.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smart_justice.smart_justice.model.IntentionalInjuryCase;
import com.smart_justice.smart_justice.model.MarryCase;
import com.smart_justice.smart_justice.model.ScamCase;
import com.smart_justice.smart_justice.model.TrafficCase;

import java.math.BigDecimal;

//将json字符串转换为java对象
public class ParseJsonToObj {
    public static IntentionalInjuryCase toIntent(String json){
        IntentionalInjuryCase intentionalInjuryCase = new IntentionalInjuryCase();
        JSONObject jjj = getJsonObject(json);
        if(jjj!=null){
            intentionalInjuryCase.setId((String)jjj.get("id"));
            intentionalInjuryCase.setOriginal_claim((String)jjj.get("原告诉称"));
            intentionalInjuryCase.setDefendant_argued((String)jjj.get("被告辩称"));
            intentionalInjuryCase.setResult((String)jjj.get("结果"));
            intentionalInjuryCase.setProb_SubjectiveIntention(jjj.get("prob_伤人主观故意").toString());
            intentionalInjuryCase.setProb_IntentionalInjury(jjj.get("prob_故意伤害行为").toString());
            intentionalInjuryCase.setProb_InjuryDet(jjj.get("prob_伤情认定问题").toString());
            intentionalInjuryCase.setProb_CausalityIAD(jjj.get("prob_伤情与行为的因果关系").toString());
            intentionalInjuryCase.setProb_ConstituteII(jjj.get("prob_构成故意伤害罪").toString());
            intentionalInjuryCase.setProb_ConstituteIM(jjj.get("prob_构成故意杀人罪").toString());
            intentionalInjuryCase.setProb_NegligentDeath(jjj.get("prob_构成过失致人死亡罪").toString());
            intentionalInjuryCase.setProb_NegligentSeriousInjury(jjj.get("prob_构成过失致人重伤罪").toString());
            intentionalInjuryCase.setProb_DefensiveDeg(jjj.get("prob_正当防卫程度").toString());
            intentionalInjuryCase.setProb_CriminalRes(jjj.get("prob_具有刑事责任能力").toString());
            intentionalInjuryCase.setProb_ConstitutesAtt(jjj.get("prob_构成犯罪未遂").toString());
            intentionalInjuryCase.setProb_ConstitutesSus(jjj.get("prob_构成犯罪中止").toString());
            intentionalInjuryCase.setProb_ConstituteCrimePre(jjj.get("prob_构成犯罪预备").toString());
            intentionalInjuryCase.setProb_ConstituteJointCrime(jjj.get("prob_构成共同犯罪").toString());
            intentionalInjuryCase.setProb_CogSauJoiCrimes(jjj.get("prob_共同犯罪中的地位认定").toString());
            intentionalInjuryCase.setProb_ThreatenAccessory(jjj.get("prob_胁从犯").toString());
            intentionalInjuryCase.setProb_WheVictimIsFault(jjj.get("prob_被害人是否存在过错").toString());
            intentionalInjuryCase.setProb_MeritoriousPlot(jjj.get("prob_立功情节").toString());
            intentionalInjuryCase.setProb_OtherSenCir(jjj.get("prob_其他量刑情节问题").toString());
            intentionalInjuryCase.setProb_Surrender(jjj.get("prob_构成自首").toString());
            intentionalInjuryCase.setProb_Probation(jjj.get("prob_缓刑").toString());
            intentionalInjuryCase.setProb_IllegalEvidence(jjj.get("prob_非法证据").toString());
            return intentionalInjuryCase;
        }
        return null;
    }

    public static MarryCase toMarry(String json){
        MarryCase marryCase = new MarryCase();
        JSONObject jjj = getJsonObject(json);
        if(jjj != null){
            marryCase.setId((String)jjj.get("id"));
            marryCase.setOriginal_claim((String)jjj.get("原告诉称"));
            marryCase.setDefendant_argued((String)jjj.get("被告辩称"));
            marryCase.setResult((String)jjj.get("结果"));
            marryCase.setProb_BrokenFeelings(jjj.get("prob_感情破裂").toString());
            marryCase.setProb_DomesticViolence(jjj.get("prob_家庭暴力").toString());
            marryCase.setProb_Derailed(jjj.get("prob_出轨").toString());
            marryCase.setProb_Bigamy(jjj.get("prob_重婚").toString());
            marryCase.setProb_RealEstate(jjj.get("prob_房产").toString());
            marryCase.setProb_Vehicle(jjj.get("prob_车辆").toString());
            marryCase.setProb_Debt(jjj.get("prob_债权债务").toString());
            marryCase.setProb_ParentingIssues(jjj.get("prob_抚养问题").toString());
            marryCase.setProb_CommonProperty(jjj.get("prob_共同财产").toString());
            return marryCase;

        }
        return null;
    }

    public static TrafficCase toTraffic(String json){
        TrafficCase trafficCase = new TrafficCase();
        JSONObject jjj = getJsonObject(json);
        if(jjj != null){
            trafficCase.setId((String)jjj.get("id"));
            trafficCase.setOriginal_claim((String)jjj.get("原告诉称"));
            trafficCase.setDefendant_argued((String)jjj.get("被告辩称"));
            trafficCase.setResult((String)jjj.get("结果"));
            trafficCase.setProb_TrafficAccCer(jjj.get("prob_交通事故认定书").toString());
            trafficCase.setProb_TrafficAccCompAgr(jjj.get("prob_交通事故赔偿协议").toString());
            trafficCase.setProb_InjuryCompScope(jjj.get("prob_伤害赔偿范围").toString());
            trafficCase.setProb_InjuryOrDeathCorr(jjj.get("prob_伤情/死亡相关性").toString());
            trafficCase.setProb_insCompComp(jjj.get("prob_保险公司如何赔偿").toString());
            trafficCase.setProb_IfInsComp(jjj.get("prob_保险公司是否赔偿").toString());
            trafficCase.setProb_MotorVehResp(jjj.get("prob_机动车所有人责任").toString());
            trafficCase.setProb_RespMotVehCal(jjj.get("prob_机动车挂靠方责任").toString());
            trafficCase.setProb_ScopeOfDeaComp(jjj.get("prob_死亡赔偿范围").toString());
            trafficCase.setProb_MentalComfort(jjj.get("prob_精神抚慰金").toString());
            trafficCase.setProb_PropertyCompScope(jjj.get("prob_财产赔偿范围").toString());
            trafficCase.setProb_DivisionResp(jjj.get("prob_责任划分").toString());
            trafficCase.setProb_RoadManResp(jjj.get("prob_道路管理者责任").toString());
            trafficCase.setProb_AppraisalOpi(jjj.get("prob_鉴定意见书").toString());
            trafficCase.setProb_EmployerResp(jjj.get("prob_雇主责任").toString());
            return trafficCase;

        }
        return null;
    }

    public static ScamCase toScam(String json){
        ScamCase scamCase = new ScamCase();
        JSONObject jjj = getJsonObject(json);
        if(jjj != null){
            scamCase.setId((String)jjj.get("id"));
            scamCase.setOriginal_claim((String)jjj.get("原告诉称"));
            scamCase.setDefendant_argued((String)jjj.get("被告辩称"));
            scamCase.setResult((String)jjj.get("结果"));
            scamCase.setProb_SubjectiveIntention(jjj.get("prob_主观意图").toString());
            scamCase.setProb_FraudBehavior(jjj.get("prob_诈骗行为").toString());
            scamCase.setProb_FraudAmount(jjj.get("prob_诈骗数额").toString());
            scamCase.setProb_CausalRelationship(jjj.get("prob_因果关系").toString());
            scamCase.setProb_Fraud(jjj.get("prob_诈骗罪").toString());
            scamCase.setProb_FraudOtherSpeCri(jjj.get("prob_诈骗或其它特殊犯罪").toString());
            scamCase.setProb_UnitCrime(jjj.get("prob_单位犯罪").toString());
            scamCase.setProb_Responsibility(jjj.get("prob_责任能力").toString());
            scamCase.setProb_AttemptedCrime(jjj.get("prob_犯罪形态未遂").toString());
            scamCase.setProb_SuspensionCrime(jjj.get("prob_犯罪形态中止").toString());
            scamCase.setProb_CriminalPre(jjj.get("prob_犯罪形态预备").toString());
            scamCase.setProb_JointCrime(jjj.get("prob_共同犯罪").toString());
            scamCase.setProb_DetAmountLegLia(jjj.get("prob_法律责任的数额认定").toString());
            scamCase.setProb_CogStatusJoiCri(jjj.get("prob_共同犯罪中的地位认定").toString());
            scamCase.setProb_ThreatenAcc(jjj.get("prob_胁从犯").toString());
            scamCase.setProb_MerService(jjj.get("prob_立功").toString());
            scamCase.setProb_Surrender(jjj.get("prob_自首").toString());
            scamCase.setProb_VictimFault(jjj.get("prob_被害人过错").toString());
            scamCase.setProb_ImpactSen(jjj.get("prob_影响量刑").toString());
            scamCase.setProb_ApplyProbation(jjj.get("prob_适用缓刑").toString());
            scamCase.setProb_ProsLimit(jjj.get("prob_追诉时效").toString());
            scamCase.setProb_Evidence(jjj.get("prob_证据").toString());

            return scamCase;

        }
        return null;
    }

    private static JSONObject getJsonObject(String json) {
        JSONArray jsonArray = JSONArray.parseArray(json);
        JSONObject jjj = null;
        System.out.println(jsonArray);
        if(jsonArray != null)
        try{
            for(Object j:jsonArray){
                JSONArray jsonArray1 = (JSONArray)j;
                for(Object jj:jsonArray1){
                    jjj = (JSONObject)jj;
                }
                break;
            }
        } catch (com.alibaba.fastjson.JSONException e) {
            e.printStackTrace();
        }
        return jjj;
    }
}
