package com.Practical.Backend.Entity;

import com.Practical.Backend.Serializer.ExaminationSerializer;
import com.Practical.Backend.Serializer.VenueSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

@Entity
@JsonSerialize(using = ExaminationSerializer.class)
public class Examination {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

    String year;

    String section;

    String day;

    String studentGroup;

    String students;

    @ManyToOne
    @JoinColumn(name="internal_examiner_id")
    Teacher internalExaminer;

    @ManyToOne
    @JoinColumn(name = "external_examiner_id")
    Teacher externalExaminer;

    Long phoneNo;

    String email;

    @ManyToOne
    @JoinColumn(name="time_slot_id")
    TimeSlot timeSlot;

    String date;

    @ManyToOne
    @JoinColumn(name="venue_id")
    Venue venue;

    public Examination(){

    }

    public Examination(Long id, Subject subject, String year, String section, String studentGroup,
                       String students, Teacher internalExaminer, Teacher externalExaminer, Long phoneNo, String email,
                       TimeSlot timeSlot, String date, Venue venue) {
        this.id = id;
        this.subject = subject;
        this.year = year;
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.internalExaminer = internalExaminer;
        this.externalExaminer = externalExaminer;
        this.phoneNo = phoneNo;
        this.email = email;
        this.timeSlot = timeSlot;
        this.date = date;
        this.venue = venue;
    }

    public Examination(Long id, Subject subject, String year, String section, String day, String studentGroup,
                       String students, Teacher internalExaminer, Teacher externalExaminer, Long phoneNo,
                       String email, TimeSlot timeSlot, String date, Venue venue) {
        this.id = id;
        this.subject = subject;
        this.year = year;
        this.section = section;
        this.day = day;
        this.studentGroup = studentGroup;
        this.students = students;
        this.internalExaminer = internalExaminer;
        this.externalExaminer = externalExaminer;
        this.phoneNo = phoneNo;
        this.email = email;
        this.timeSlot = timeSlot;
        this.date = date;
        this.venue = venue;
    }

    public Examination(Subject subject, String year, String section, String day,
                       String studentGroup, String students, Teacher internalExaminer, Teacher externalExaminer,
                       Long phoneNo, String email, TimeSlot timeSlot, String date, Venue venue) {
        this.subject = subject;
        this.year = year;
        this.section = section;
        this.day = day;
        this.studentGroup = studentGroup;
        this.students = students;
        this.internalExaminer = internalExaminer;
        this.externalExaminer = externalExaminer;
        this.phoneNo = phoneNo;
        this.email = email;
        this.timeSlot = timeSlot;
        this.date = date;
        this.venue = venue;
    }

    public Examination(Subject subject, String year, String section, String studentGroup, String students,
                       Teacher internalExaminer, Teacher externalExaminer, Long phoneNo, String email,
                       TimeSlot timeSlot, String date, Venue venue) {
        this.subject = subject;
        this.year = year;
        this.section = section;
        this.studentGroup = studentGroup;
        this.students = students;
        this.internalExaminer = internalExaminer;
        this.externalExaminer = externalExaminer;
        this.phoneNo = phoneNo;
        this.email = email;
        this.timeSlot = timeSlot;
        this.date = date;
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Teacher getInternalExaminer() {
        return internalExaminer;
    }

    public void setInternalExaminer(Teacher internalExaminer) {
        this.internalExaminer = internalExaminer;
    }

    public Teacher getExternalExaminer() {
        return externalExaminer;
    }

    public void setExternalExaminer(Teacher externalExaminer) {
        this.externalExaminer = externalExaminer;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", subject=" + subject +
                ", year='" + year + '\'' +
                ", section='" + section + '\'' +
                ", day='" + day + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", students='" + students + '\'' +
                ", internalExaminer=" + internalExaminer +
                ", externalExaminer=" + externalExaminer +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", timeSlot=" + timeSlot +
                ", date='" + date + '\'' +
                ", venue=" + venue +
                '}';
    }
}
