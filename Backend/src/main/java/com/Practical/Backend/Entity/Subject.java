package com.Practical.Backend.Entity;

import com.Practical.Backend.Serializer.SubjectSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = SubjectSerializer.class)
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String subjectCode;

    String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<TimeTable> timeTables = new ArrayList<>();


    @OneToMany(mappedBy = "subject")
    private List<Examination> examinations = new ArrayList<>();

    public Subject(){

    }



    public Subject(String subjectCode, String subjectName, List<Teacher> teachers, List<TimeTable> timeTables, List<Examination> examinations) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.teachers = teachers;
        this.timeTables = timeTables;
        this.examinations = examinations;
    }

    public Subject(Long id, String subjectCode, String subjectName, List<Teacher> teachers, List<TimeTable> timeTables, List<Examination> examinations) {
        this.id = id;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.teachers = teachers;
        this.timeTables = timeTables;
        this.examinations = examinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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
        return "Subject{" +
                "id=" + id +
                ", subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", teachers=" + teachers +
                ", timeTables=" + timeTables +
                ", examinations=" + examinations +
                '}';
    }
}
