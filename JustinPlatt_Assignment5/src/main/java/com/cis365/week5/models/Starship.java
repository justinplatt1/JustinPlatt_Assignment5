package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "STARSHIP")
public class Starship {

    public Starship(){}

    @Id
    @Column(name = "STARSHIPID")
    private String starshipId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREWSIZE")
    private String crewSize;

    @Column(name = "SHIPCLASS")
    private String shipClass;

    @Column(name = "LAUNCHSTARDATE")
    private String launchStarDate;

    

    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String starshipId) {
        this.starshipId = starshipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(String crewSize) {
        this.crewSize = crewSize;
    }

    public String getLaunchStarDate() {
        return launchStarDate;
    }

    

}
