package JavaEE.service;

import JavaEE.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticsPerDayPlaceServiceTest extends BaseTest {
    @Autowired
    private StatisticsPerDayPlaceService statisticsPerDayPlaceService;

    @Test
    public void testClear(){
        statisticsPerDayPlaceService.clearAll();
    }

    @Test
    public void test1(){
        statisticsPerDayPlaceService.updateFromDataBase();
    }
}
