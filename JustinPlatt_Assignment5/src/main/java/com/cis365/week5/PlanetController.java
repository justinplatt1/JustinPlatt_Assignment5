package com.cis365.week5;

import com.cis365.week5.models.Planet;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class PlanetController {

    @GetMapping("/planetid")
    public List<Planet> planets() {
        return DataStore.listPlanets();
    }
  
    
    //mock
    public List<Planet> planet(){
    Planet p = new Planet();
    p.setPlanetId("abc");
    
    List<Planet> a = new ArrayList<Planet>();
    a.add(p);
    return a;
        
            }

    @GetMapping("//{planet/id}")
    public Planet getPlanetById(@PathVariable(value = "planetid") String planetName) {
        return DataStore.findPlanetById(planetName);
    }

    @PostMapping(value="/planet/{planetid}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Planet addPlanet(@PathVariable(value = "planetid") String planetName,@RequestBody Planet planetToUpdate) {
        return DataStore.updatePlanet(planetName, planetToUpdate);
    }
    
    
}
