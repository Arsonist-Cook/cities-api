package io.github.arsonistcook.citiesapi.cities;

import io.github.arsonistcook.citiesapi.cities.entities.City;
import io.github.arsonistcook.citiesapi.cities.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private Logger log = LoggerFactory.getLogger(DistanceService.class);

    @Autowired
    private CityRepository cityRepository;

    public double distanceByPointsInMiles(long origin, long destiny) {
        return cityRepository.distanceByPoints(origin, destiny);
    }

    public double distanceByCubeInMeters(long origin, long destiny) {
        List<City> cities = cityRepository.findAllById(Arrays.asList(origin, destiny));
        Point originCoordinate = cities.get(0).getLocation();
        Point destinyCoordinate = cities.get(1).getLocation();
        return cityRepository.distanceByCube(originCoordinate.getX(), originCoordinate.getY(), destinyCoordinate.getX(), destinyCoordinate.getY());
    }
}
