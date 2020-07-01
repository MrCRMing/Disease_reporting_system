package JavaEE.service;

import JavaEE.domain.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getPlaces();
    Place getPlaceById(int place_id);
}
