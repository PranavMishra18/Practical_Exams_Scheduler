package com.Practical.Backend.Entity;


import com.Practical.Backend.Serializer.TeacherSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = TeacherSerializer.class)
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String name;

    String email;

    Long phoneNo;

    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns=@JoinColumn(name="teacher_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();


    @OneToMany(mappedBy = "teacher",cascade = CascadeType.REMOVE)
    private List<TimeTable> timeTables = new ArrayList<>();


    @OneToMany(mappedBy = "internalExaminer")
    private List<Examination> internalExaminations = new ArrayList<>();

    @OneToMany(mappedBy = "externalExaminer")
    private List<Examination> externalExaminations = new ArrayList<>();

    @OneToMany(mappedBy="externalExaminer")
    private List<External> externals = new ArrayList<>();


    public Teacher(){

    }

    public Teacher(Long id, String name, String email, Long phoneNo, List<TimeTable> timeTables, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.timeTables = timeTables;
        this.subjects = subjects;
    }

    public Teacher(String name, String email, Long phoneNo, List<Subject> subjects, List<TimeTable> timeTables) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.subjects = subjects;
        this.timeTables = timeTables;
    }

    public Teacher(Long id, String name, String email, Long phoneNo, List<Subject> subjects, List<TimeTable> timeTables, List<External> externals) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.subjects = subjects;
        this.timeTables = timeTables;
        this.externals = externals;
    }

    public Teacher(String name, String email, Long phoneNo, List<Subject> subjects, List<TimeTable> timeTables, List<External> externals) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.subjects = subjects;
        this.timeTables = timeTables;
        this.externals = externals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public List<External> getExternals() {
        return externals;
    }

    public void setExternals(List<External> externals) {
        this.externals = externals;
    }

    public List<Examination> getInternalExaminations() {
        return internalExaminations;
    }

    public void setInternalExaminations(List<Examination> internalExaminations) {
        this.internalExaminations = internalExaminations;
    }

    public List<Examination> getExternalExaminations() {
        return externalExaminations;
    }

    public void setExternalExaminations(List<Examination> externalExaminations) {
        this.externalExaminations = externalExaminations;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", subjects=" + subjects +
                ", timeTables=" + timeTables +
                ", internalExaminations=" + internalExaminations +
                ", externalExaminations=" + externalExaminations +
                ", externals=" + externals +
                '}';
    }
}
