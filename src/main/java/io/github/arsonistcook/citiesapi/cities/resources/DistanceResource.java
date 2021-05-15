package io.github.arsonistcook.citiesapi.cities.resources;

import io.github.arsonistcook.citiesapi.cities.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities/distance")
public class DistanceResource {
    private Logger log = LoggerFactory.getLogger(DistanceResource.class);

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/by-points")
    public double calculateDistanceByPoints(@RequestParam(name = "from") long origin, @RequestParam(name = "to") long destiny) {
        log.info("Access Method 'by-points' with params:: (origin, destiny) = (%f, %f)", origin, destiny);

        return distanceService.distanceByPointsInMiles(origin, destiny);
    }

    @GetMapping("/by-cube")
    public double calculateDistanceByCube(@RequestParam(name = "from") long origin, @RequestParam(name = "to") long destiny) {
        log.info("Access Method 'by-cube' with params:: (origin, destiny) = (%f, %f)", origin, destiny);

        return distanceService.distanceByCubeInMeters(origin, destiny);
    }
}
