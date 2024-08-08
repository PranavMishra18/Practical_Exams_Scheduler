package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.TimeSlot;
import com.Practical.Backend.Repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;


    public List<TimeSlot> getTimeSlots(){

        return timeSlotRepository.findAll();

    }

    public TimeSlot getTimeSlot(Long id){

        return timeSlotRepository.findById(id).get();

    }

    public TimeSlot saveTimeSlot(TimeSlot timeSlot){
        return timeSlotRepository.save(timeSlot);
    }

    public void deleteTimeSlot(Long id){

        TimeSlot timeSlot = timeSlotRepository.findById(id).get();

        timeSlotRepository.delete(timeSlot);

    }



}
