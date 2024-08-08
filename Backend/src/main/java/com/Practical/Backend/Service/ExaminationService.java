package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.Examination;
import com.Practical.Backend.Repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationService {

    @Autowired
    ExaminationRepository examinationRepository;


    public List<Examination> getExaminations(){

        return examinationRepository.findAll();

    }

    public Examination getExamination(Long id){
        return examinationRepository.findById(id).get();
    }

    public Examination saveExamination(Examination examination){
        return examinationRepository.save(examination);
    }

    public void deleteExamination(Long id){

        Examination examination = examinationRepository.findById(id).get();

        examinationRepository.delete(examination);

    }

    public List<Examination> getExaminationOrdered(){
        return examinationRepository.findAllExaminationsOrdered();
    }
}
