package io.github.arsonistcook.citiesapi.cities.repositories;

import io.github.arsonistcook.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    public double distanceByPoints(long idCityOrigin, long idCityDestiny);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1, ?2), ll_to_earth(?3, ?4)) as distance", nativeQuery = true)
    public double distanceByCube(double originLongitude, double originLatitude, double destinyLongitude, double destinyLatitude);
}
