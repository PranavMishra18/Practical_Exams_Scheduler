package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.TimeTable;
import com.Practical.Backend.Repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {

    @Autowired
    TimeTableRepository timeTableRepository;

    public List<TimeTable> getTimeTables(){
        return timeTableRepository.findAll();
    }

    public TimeTable getTimeTable(Long id){

        return timeTableRepository.findById(id).get();
    }

    public TimeTable saveTimeTable(TimeTable timeTable){

        return timeTableRepository.save(timeTable);


    }

    public List<TimeTable> getTimeTableByDay(String day){
       return timeTableRepository.timeTableByDay(day);
    }

    public List<TimeTable> timeTableExcludingTeacher(String day, Long teacherId){
        return timeTableRepository.timeTableByDayExcludingTeacher(day,teacherId);
    }

    public void deleteTimeTable(Long id){

        TimeTable timeTable = timeTableRepository.findById(id).get();

        timeTableRepository.delete(timeTable);

    }

}
