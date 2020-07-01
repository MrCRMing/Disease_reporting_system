package JavaEE.service;

import JavaEE.domain.statistics.StatisticsPerPlaceDay;

import java.util.Date;
import java.util.List;

public interface StatisticsPerDayPlaceService {
    void clearAll();
    void updateFromDataBase();
    StatisticsPerPlaceDay getByPlaceIdAndDate(int place_id, Date date);
    List<StatisticsPerPlaceDay> getByPlaceId(int place_id);
    List<StatisticsPerPlaceDay> getByDate(Date date);
}
