package JavaEE.service.impl;

import JavaEE.cache.PlaceCacheDao;
import JavaEE.dao.PlaceMapper;
import JavaEE.domain.Place;
import JavaEE.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceCacheDao placeCacheDao;

    @Override
    public List<Place> getPlaces() {
        return placeCacheDao.getPlaces();
    }

    @Override
    public Place getPlaceById(int place_id) {
        return placeCacheDao.getPlaceById(place_id);
    }
}
