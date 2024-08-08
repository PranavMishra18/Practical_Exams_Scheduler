package com.Practical.Backend.Entity;


import com.Practical.Backend.Serializer.TimeSlotSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = TimeSlotSerializer.class)
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String timeSlot;

    @OneToMany(mappedBy = "timeSlot")
    public List<TimeTable> timeTables = new ArrayList<>();

    @OneToMany(mappedBy = "timeSlot")
    public List<Examination> examinations = new ArrayList<>();

    @OneToMany(mappedBy="timeSlot")
    public List<External> externals = new ArrayList<>();

    public TimeSlot(){

    }


    public TimeSlot(String timeSlot, List<TimeTable> timeTables, List<Examination> examinations) {
        this.timeSlot = timeSlot;
        this.timeTables = timeTables;
        this.examinations = examinations;
    }

    public TimeSlot(Long id, String timeSlot, List<TimeTable> timeTables, List<Examination> examinations) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.timeTables = timeTables;
        this.examinations = examinations;
    }

    public TimeSlot(String timeSlot, List<TimeTable> timeTables, List<Examination> examinations, List<External> externals) {
        this.timeSlot = timeSlot;
        this.timeTables = timeTables;
        this.examinations = examinations;
        this.externals = externals;
    }

    public TimeSlot(Long id, String timeSlot, List<TimeTable> timeTables, List<Examination> examinations, List<External> externals) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.timeTables = timeTables;
        this.examinations = examinations;
        this.externals = externals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
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

    public List<External> getExternals() {
        return externals;
    }

    public void setExternals(List<External> externals) {
        this.externals = externals;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", timeSlot='" + timeSlot + '\'' +
                ", timeTables=" + timeTables +
                ", examinations=" + examinations +
                ", externals=" + externals +
                '}';
    }
}
