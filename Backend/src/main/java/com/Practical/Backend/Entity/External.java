package com.Practical.Backend.Entity;

import com.Practical.Backend.Serializer.ExternalSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

@Entity
@JsonSerialize(using = ExternalSerializer.class)
public class External {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @ManyToOne
    @JoinColumn(name="teacher_id")
    Teacher externalExaminer;

    String date;

    String day;

    @ManyToOne
    @JoinColumn(name="time_slot_id")
    TimeSlot timeSlot;

    public External(){

    }

    public External(Long id, Teacher externalExaminer, String date, String day, TimeSlot timeSlot) {
        this.id = id;
        this.externalExaminer = externalExaminer;
        this.date = date;
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public External(TimeSlot timeSlot, String day, String date, Teacher externalExaminer) {
        this.timeSlot = timeSlot;
        this.day = day;
        this.date = date;
        this.externalExaminer = externalExaminer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getExternalExaminer() {
        return externalExaminer;
    }

    public void setExternalExaminer(Teacher externalExaminer) {
        this.externalExaminer = externalExaminer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "External{" +
                "id=" + id +
                ", externalExaminer=" + externalExaminer +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", timeSlot=" + timeSlot +
                '}';
    }
}
