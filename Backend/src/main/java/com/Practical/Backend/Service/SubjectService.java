package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.Subject;
import com.Practical.Backend.Repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    public List<Subject> getSubjects(){

        return subjectRepository.findAll();

    }

    @Transactional
    public List<Subject> getSubjectsByIds(List<Long> subjectIds) {
        return subjectRepository.findAllById(subjectIds);
    }


    public Subject getSubject(Long id){

        return subjectRepository.findById(id).get();

    }

    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){

        Subject subject = subjectRepository.findById(id).get();

        subjectRepository.delete(subject);

    }





}
