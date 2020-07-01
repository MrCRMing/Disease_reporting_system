package JavaEE.service.impl;

import JavaEE.dao.CaseMapper;
import JavaEE.domain.Case;
import JavaEE.redisDao.StatisticsPerDayPlaceRDao;
import JavaEE.service.CaseService;
import JavaEE.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("caseService")
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseMapper caseMapper;
    @Autowired
    private StatisticsPerDayPlaceRDao statisticsByPlaceDao;

    @Override
    public void addCase(Case the_case) {
        caseMapper.addCase(the_case);
        statisticsByPlaceDao.increaseStatisticsByPlace(the_case.getDisease_place_id(), the_case.getDisease_time());
    }

    @Override
    public void deleteCase(int case_id) {
        Case the_case = findCase(case_id);
        int effectedNum = caseMapper.deleteCase(case_id);
        if(effectedNum <=0){
            throw new RuntimeException("删除失败");
        }else{
            statisticsByPlaceDao.decreaseStatisticsByPlace(the_case.getDisease_place_id(), the_case.getDisease_time());
        }
    }

    @Override
    public void updateCase(Case the_case) {
        Case old_case = findCase(the_case.getCase_id());
        int effectedNum = caseMapper.updateCase(the_case);
        if(effectedNum <=0){
            throw new RuntimeException("删除失败");
        }else{
            Integer old_place_id = old_case.getDisease_place_id();
            Integer new_place_id = the_case.getDisease_place_id();
            Date old_date = old_case.getDisease_time();
            Date new_date = the_case.getDisease_time();
            if(new_place_id==null){
                new_place_id = old_place_id;
            }
            if(new_date==null){
                new_date = old_date;
            }
            if(!old_place_id.equals(new_place_id) || !DateUtil.compareDate(old_date,new_date)){
                statisticsByPlaceDao.decreaseStatisticsByPlace(old_place_id, old_date);
                statisticsByPlaceDao.increaseStatisticsByPlace(new_place_id, new_date);
            }
        }
    }

    @Override
    public Case findCase(int case_id) {
        return caseMapper.findCase(case_id);
    }

    @Override
    public List<Case> findMultiCase(Map<String,String> map) {
        return caseMapper.findMultiCase(map);
    }

    @Override
    public List<Case> findAllCase() {
        return caseMapper.findAllCase();
    }
}
