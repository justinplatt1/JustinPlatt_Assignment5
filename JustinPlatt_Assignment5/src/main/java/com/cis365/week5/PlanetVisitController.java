package com.cis365.week5;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class PlanetVisitController {

    @GetMapping("/departureStardate")
    public List<PlanetVisit> visits() {
        return DataStore.listVisits();
    }
/*
    @GetMapping("//{departureStardate}")
    public PlanetVisit getVisitById(@PathVariable(value = "departureStardate") String visitName) {
        return DataStore.findVisitById(visitName);
    }

    @PostMapping(value="/planetvisit/{departureStardate}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Planet addPlanet(@PathVariable(value = "departureStardate") String visitName,@RequestBody PlanetVisit visitToUpdate) {
        return DataStore.updateVisit(visitName, visitToUpdate);
    }
    
    */
}
