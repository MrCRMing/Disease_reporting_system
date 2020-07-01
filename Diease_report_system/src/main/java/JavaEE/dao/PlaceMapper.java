package JavaEE.dao;


import JavaEE.domain.Place;

import java.util.List;

public interface PlaceMapper {
    List<Place> getPlaces();
    Place getPlaceById(int place_id);
    List<Integer> getIds();
}
