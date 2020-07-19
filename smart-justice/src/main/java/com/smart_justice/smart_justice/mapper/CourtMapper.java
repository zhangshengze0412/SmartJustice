package com.smart_justice.smart_justice.mapper;

import com.smart_justice.smart_justice.model.IntentionalInjuryCase;
import com.smart_justice.smart_justice.model.MarryCase;
import com.smart_justice.smart_justice.model.ScamCase;
import com.smart_justice.smart_justice.model.TrafficCase;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 法院mapper
 */
@Mapper
@Repository
public interface CourtMapper {

    /**
     * 插入新的intentinjurycase记录
     * @param intentionalInjuryCase
     */
    @Insert("insert into intentinjurycase(id,original_claim,defendant_argued,result,prob_SubjectiveIntention,"+
            " prob_IntentionalInjury,prob_InjuryDet,prob_CausalityIAD,prob_ConstituteII,prob_ConstituteIM,prob_NegligentDeath,"+
            " prob_NegligentSeriousInjury,prob_DefensiveDeg,prob_CriminalRes,prob_ConstitutesAtt,prob_ConstitutesSus,prob_ConstituteCrimePre,"+
            " prob_ConstituteJointCrime,prob_CogSauJoiCrimes,prob_ThreatenAccessory,prob_WheVictimIsFault,prob_MeritoriousPlot,prob_OtherSenCir," +
            " prob_Surrender,prob_Probation,prob_IllegalEvidence) values(#{id},#{original_claim},#{defendant_argued},#{result},#{prob_SubjectiveIntention}," +
            "#{prob_IntentionalInjury},#{prob_InjuryDet},#{prob_CausalityIAD},#{prob_ConstituteII},#{prob_ConstituteIM},#{prob_NegligentDeath}," +
            "#{prob_NegligentSeriousInjury},#{prob_DefensiveDeg},#{prob_CriminalRes},#{prob_ConstitutesAtt},#{prob_ConstitutesSus},#{prob_ConstituteCrimePre}," +
            "#{prob_ConstituteJointCrime},#{prob_CogSauJoiCrimes},#{prob_ThreatenAccessory},#{prob_WheVictimIsFault},#{prob_MeritoriousPlot},#{prob_OtherSenCir}," +
            "#{prob_Surrender},#{prob_Probation},#{prob_IllegalEvidence})")
    void insertIntent(IntentionalInjuryCase intentionalInjuryCase);

    /**
     * 插入新的marrycase记录
     * @param marryCase
     */
    @Insert("insert into marrycase values(#{id},#{original_claim},#{defendant_argued},#{result}," +
            "#{prob_BrokenFeelings},#{prob_DomesticViolence},#{prob_Derailed},#{prob_Bigamy},#{prob_RealEstate}," +
            "#{prob_Vehicle},#{prob_Debt},#{prob_ParentingIssues},#{prob_CommonProperty},null)")
    void insertMarry(MarryCase marryCase);

    /**
     * 插入新的trafficcase记录
     * @param trafficCase
     */
    @Insert("insert into trafficcase values(#{id},#{original_claim},#{defendant_argued},#{result}," +
            "#{prob_TrafficAccCer},#{prob_TrafficAccCompAgr},#{prob_InjuryCompScope},#{prob_InjuryOrDeathCorr}," +
            "#{prob_insCompComp},#{prob_IfInsComp},#{prob_MotorVehResp},#{prob_RespMotVehCal},#{prob_ScopeOfDeaComp}," +
            "#{prob_MentalComfort},#{prob_PropertyCompScope},#{prob_DivisionResp},#{prob_RoadManResp},#{prob_AppraisalOpi},#{prob_EmployerResp},null)")
    void insertTraffic(TrafficCase trafficCase);

    /**
     * 插入新的scamcase记录
     * @param scamCase
     */
    @Insert("insert into scamcase values(#{id},#{original_claim},#{defendant_argued},#{result}," +
            "#{prob_SubjectiveIntention},#{prob_FraudBehavior},#{prob_FraudAmount},#{prob_CausalRelationship}," +
            "#{prob_Fraud},#{prob_FraudOtherSpeCri},#{prob_UnitCrime},#{prob_Responsibility},#{prob_AttemptedCrime}," +
            "#{prob_SuspensionCrime},#{prob_CriminalPre},#{prob_JointCrime},#{prob_DetAmountLegLia},#{prob_CogStatusJoiCri}," +
            "#{prob_ThreatenAcc},#{prob_MerService},#{prob_Surrender},#{prob_VictimFault},#{prob_ImpactSen},#{prob_ApplyProbation}," +
            "#{prob_ProsLimit},#{prob_Evidence},null)")
    void insertScam(ScamCase scamCase);

    /**
     * 关联表索引
     * @param id
     * @param tabId
     */
    @Insert("insert into tabindex values(#{id},#{tabId})")
    void withTabIndex(@Param("id")String id,@Param("tabId")int tabId);

    /**
     * 获得表索引
     * @param id
     * @return
     */
    @Select("select tabId from tabindex where id=#{id}")
    List<Integer> getTabId(@Param("id")String id);

    /**
     * 更新intentinjurycase的专家建议
     * @param id
     * @param recommend
     */
    @Update("update intentinjurycase set expertRec=#{recommend} where id=#{id}")
    void updateIntent(@Param("id") String id, @Param("recommend") String recommend);

    /**
     * 更新marrycase的专家建议
     * @param id
     * @param recommend
     */
    @Update("update marrycase set expertRec=#{recommend} where id=#{id}")
    void updateMarry(@Param("id") String id, @Param("recommend") String recommend);

    /**
     * 更新scamcase的专家建议
     * @param id
     * @param recommend
     */
    @Update("update scamcase set expertRec=#{recommend} where id=#{id}")
    void updateScam(@Param("id") String id, @Param("recommend") String recommend);

    /**
     * 更新trafficcase的专家建议
     * @param id
     * @param recommend
     */
    @Update("update trafficcase set expertRec=#{recommend} where id=#{id}")
    void updateTraffic(@Param("id") String id, @Param("recommend") String recommend);


    /**
     * 通过id查询历史marrycase
     * @param id
     * @return
     */
    @Select("select * from marrycase where id=#{id} limit 1")
    MarryCase getMarryCaseById(@Param("id")String id);

    /**
     * 通过id查询历史trafficcase
     * @param id
     * @return
     */
    @Select("select * from trafficcase where id=#{id} limit 1")
    TrafficCase getTrafficCaseById(@Param("id")String id);

    /**
     * 通过id查询历史scamcase
     * @param id
     * @return
     */
    @Select("select * from scamcase where id=#{id} limit 1")
    ScamCase getScamCaseById(@Param("id")String id);

    /**
     * 通过id查询历史intentinjurycase
     * @param id
     * @return
     */
    @Select("select * from intentinjurycase where id=#{id} limit 1")
    IntentionalInjuryCase getIntentionalInjuryCaseById(@Param("id")String id);

}
