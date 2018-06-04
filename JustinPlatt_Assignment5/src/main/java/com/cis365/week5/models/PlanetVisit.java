package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANETVISIT")
public class PlanetVisit {

    public PlanetVisit(){}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Column(name = "STARSHIPID")
    private String starshipId;

    @Column(name = "ARRIVALSTARDATE")
    private String arrivalStarDate;

    @Column(name = "DEPARTURESTARDATE")
    private String departureStarDate;

   
    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String starshipId) {
        this.starshipId = starshipId;
    }

    public String getArrivalStarDate() {
        return arrivalStarDate;
    }

    public void setArrivalStarDate(String arrivalStarDate) {
        this.arrivalStarDate = arrivalStarDate;
    }

    public String getDepartureStarDate() {
        return departureStarDate;
    }

    public void setDepartureStarDate(String departureStarDate) {
        this.departureStarDate = departureStarDate;
    }


}
