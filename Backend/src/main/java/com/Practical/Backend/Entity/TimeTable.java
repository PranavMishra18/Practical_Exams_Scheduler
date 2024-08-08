package com.Practical.Backend.Entity;


import com.Practical.Backend.Serializer.TimeTableSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = TimeTableSerializer.class)
public class TimeTable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String section;

    String studentGroup;

    String students;

    String year;

    String day;

    @ManyToOne
    @JoinColumn(name="subject_id")
    Subject subject;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    Teacher teacher;

    String phoneNumber;


    @ManyToOne
    @JoinColumn(name="time_slot_id")
    TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name="venue_id")
    Venue venue;

    public TimeTable(){

    }


    public TimeTable(Long id, String section, String studentGroup, String students, String year, Subject subject, Teacher teacher, String phoneNumber, TimeSlot timeSlot, Venue venue) {
        this.id = id;
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.year = year;
        this.subject = subject;
        this.teacher = teacher;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.venue = venue;
    }

    public TimeTable(Long id, String section, String studentGroup, String students, String year, String day, Subject subject, Teacher teacher, String phoneNumber, TimeSlot timeSlot, Venue venue) {
        this.id = id;
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.year = year;
        this.day = day;
        this.subject = subject;
        this.teacher = teacher;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.venue = venue;
    }

    public TimeTable(String section, String studentGroup, String students, String year, Subject subject, Teacher teacher, String phoneNumber, TimeSlot timeSlot, Venue venue) {
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.year = year;
        this.subject = subject;
        this.teacher = teacher;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.venue = venue;
    }

    public TimeTable(String section, String studentGroup, String students, String year, String day, Subject subject, Teacher teacher, TimeSlot timeSlot, Venue venue) {
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.year = year;
        this.day = day;
        this.subject = subject;
        this.teacher = teacher;
        this.timeSlot = timeSlot;
        this.venue = venue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", students='" + students + '\'' +
                ", year='" + year + '\'' +
                ", day='" + day + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", timeSlot=" + timeSlot +
                ", venue=" + venue +
                '}';
    }
}
