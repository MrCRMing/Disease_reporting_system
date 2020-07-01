package JavaEE.service.impl;

import JavaEE.dao.CaseMapper;
import JavaEE.dao.PlaceMapper;
import JavaEE.domain.statistics.StatisticsPerPlaceDay;
import JavaEE.redisDao.StatisticsPerDayPlaceRDao;
import JavaEE.service.StatisticsPerDayPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsPerDayPlaceServiceImpl implements StatisticsPerDayPlaceService {

    @Autowired
    private StatisticsPerDayPlaceRDao statisticsPerDayPlaceRDao;
    @Autowired
    private PlaceMapper placeMapper;
    @Autowired
    private CaseMapper caseMapper;

    @Override
    public void clearAll() {
        List<Integer> ids = placeMapper.getIds();
        statisticsPerDayPlaceRDao.clearByPlaceId(ids);
    }

    @Override
    public void updateFromDataBase() {
        List<StatisticsPerPlaceDay> statistics = caseMapper.getStatistics();
        statisticsPerDayPlaceRDao.updateStatisticPerPlaceDay(statistics);
    }

    @Override
    public StatisticsPerPlaceDay getByPlaceIdAndDate(int place_id, Date date) {
        return statisticsPerDayPlaceRDao.getByPlaceIdAndDate(place_id, date);
    }

    @Override
    public List<StatisticsPerPlaceDay> getByPlaceId(int place_id) {
        return statisticsPerDayPlaceRDao.getAllByPlaceId(place_id);
    }

    @Override
    public List<StatisticsPerPlaceDay> getByDate(Date date) {
        List<Integer> ids = placeMapper.getIds();
        return statisticsPerDayPlaceRDao.getAllByDate(date, ids);
    }
}
