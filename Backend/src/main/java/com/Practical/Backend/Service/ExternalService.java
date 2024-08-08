package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.External;
import com.Practical.Backend.Repository.ExternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalService {

    @Autowired
    ExternalRepository externalRepository;


    public List<External> getExternals(){

        return externalRepository.findAll();

    }

    public External getExternal(Long id){

        return externalRepository.findById(id).get();
    }

    public External saveExternal(External external){
        return externalRepository.save(external);
    }

    public void deleteExternal(Long id){

        External external = externalRepository.findById(id).get();

        externalRepository.delete(external);

    }

    public long countExternalByTeacher(Long teacherId){
        return externalRepository.countByExternalTeacherId(teacherId);
    }

    public boolean checkExternalExists(Long teacherId, String date, String day, Long timeSlotId){
        return externalRepository.checkExternalExists(teacherId, date, day, timeSlotId);
    }
}
