package com.cis365.week5;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.Starship;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class StarshipController {

    @GetMapping("/starship")
    public List<Starship> listStarships() {
        return DataStore.listStarships();
    }

    @GetMapping("/starship/{starshipid}")
    public Planet getRepById(@PathVariable(value = "starshipid") String starshipName) {
        return DataStore.findStarshipById(starshipName);
    }

    @PostMapping(value="/starship/{starshipid}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Starship addStarship(@PathVariable(value = "starshipid") String starshipName,@RequestBody Starship starshipToUpdate) {
        return DataStore.updateStarship(starshipName, starshipToUpdate);
    }
}
