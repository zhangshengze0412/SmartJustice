package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.mapper.CourtMapper;
import com.smart_justice.smart_justice.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = RuntimeException.class)
@Service
public class CourtService {

    @Autowired
    CourtMapper courtMapper;

    /**
     * 表索引：0-intentinjurycase, 1-marrycase, 2-scamcase, 3-trafficcase
     * @param id
     * @param recommend
     * @return
     */
    public Result expertRec(String id, String recommend){
        Result result = new Result();
        try{
            List<Integer> tabIds = courtMapper.getTabId(id);
            if(tabIds.isEmpty()){
                result.setMsg("未找到该案件");
                result.setStatus("500");
                return result;
            }
            for(Integer tabId:tabIds){
                switch (tabId){
                    case 0:
                        courtMapper.updateIntent(id,recommend);
                    case 1:
                        courtMapper.updateMarry(id,recommend);
                    case 2:
                        courtMapper.updateScam(id,recommend);
                    case 3:
                        courtMapper.updateTraffic(id,recommend);
                }
            }
            result.setMsg("更新建议成功");
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setStatus("500");
        }
        return result;
    }
}
