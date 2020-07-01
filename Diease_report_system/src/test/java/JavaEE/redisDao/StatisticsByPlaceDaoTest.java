package JavaEE.redisDao;

import JavaEE.BaseTest;
import JavaEE.domain.statistics.StatisticsPerPlaceDay;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StatisticsByPlaceDaoTest extends BaseTest {

    @Autowired
    StatisticsPerDayPlaceRDao statisticsByPlaceDao;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Test
    public void testIncrease() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2020-05-06");
        statisticsByPlaceDao.increaseStatisticsByPlace(1,date);
    }

    @Test
    public void testGetOne() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2020-05-06");
        StatisticsPerPlaceDay byPlaceIdAndDate = statisticsByPlaceDao.getByPlaceIdAndDate(1, date);
        System.out.println(byPlaceIdAndDate);
    }

    @Test
    public void testGetMany() throws ParseException {

        List<StatisticsPerPlaceDay> allByPlaceId = statisticsByPlaceDao.getAllByPlaceId(1);
        for(StatisticsPerPlaceDay statistic: allByPlaceId){
            System.out.println(statistic);
        }
    }

    @Test
    public void testRedisTemplate(){
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("key1","VALUE1");
    }
}
