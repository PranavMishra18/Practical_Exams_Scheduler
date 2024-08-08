package com.Practical.Backend.Entity;


import com.Practical.Backend.Serializer.VenueSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = VenueSerializer.class)
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String venue;

    @OneToMany(mappedBy="venue")
    public List<TimeTable> timeTables = new ArrayList<>();

    @OneToMany(mappedBy="venue")
    public List<Examination> examinations = new ArrayList<>();

    public Venue(){

    }

    public Venue(String venue) {
        this.venue = venue;
    }

    public Venue(Long id, String venue, List<Examination> examinations, List<TimeTable> timeTables) {
        this.id = id;
        this.venue = venue;
        this.examinations = examinations;
        this.timeTables = timeTables;
    }

    public Venue(String venue, List<TimeTable> timeTables, List<Examination> examinations) {
        this.venue = venue;
        this.timeTables = timeTables;
        this.examinations = examinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", venue='" + venue + '\'' +
                ", timeTables=" + timeTables +
                ", examinations=" + examinations +
                '}';
    }
}
