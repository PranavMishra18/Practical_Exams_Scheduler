package com.Practical.Backend.Controller;

import com.Practical.Backend.Entity.*;
import com.Practical.Backend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {


    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    VenueService venueService;

    @Autowired
    TimeSlotService timeSlotService;

    @Autowired
    ExaminationService examinationService;

    @Autowired
    TimeTableService timeTableService;

    @Autowired
    ExternalService externalService;

//------------------------------------------------------------------------------------------------------------------------------------------

    // TEACHER

    @GetMapping("/teachers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Teacher> getTeachers(){

        return teacherService.getTeachers();

    }



    @GetMapping("/teachers/{id}")
        @CrossOrigin(origins = "http://localhost:4200")
    public Teacher getTeacher(@PathVariable Long id){

        return teacherService.getTeacher(id);

    }


    @PostMapping("/teachers/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Teacher saveTeacher(@RequestBody Teacher teacher, @RequestParam("subjectIds") List<Long> subjectIds) {
        return teacherService.saveTeacherWithSubjects(teacher, subjectIds);
    }

    @DeleteMapping("/teachers/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteTeacher(@PathVariable Long id){

        teacherService.deleteTeacher(id);


    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // SUBJECT

    @GetMapping("/subjects")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Subject> getSubjects(){

        return subjectService.getSubjects();

    }

    @GetMapping("/subjects/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Subject getSubject(@PathVariable Long id){

        return subjectService.getSubject(id);

    }

    @PostMapping("/subjects/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Subject createSubject(@RequestBody Subject subject){

        return subjectService.saveSubject(subject);

    }


    @DeleteMapping("/subjects/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // TIMESLOTS

    @GetMapping("/timeslots")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TimeSlot> getTimeSlots(){

        return timeSlotService.getTimeSlots();

    }

    @GetMapping("/timeslots/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TimeSlot getTImeSlot(@PathVariable Long id){

        return timeSlotService.getTimeSlot(id);

    }

    @PostMapping("/timeslots/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public TimeSlot createTimeSlot(@RequestBody TimeSlot timeSlot){

        return timeSlotService.saveTimeSlot(timeSlot);

    }

    @DeleteMapping("/timeslots/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteTimeSlot(@PathVariable Long id){

        timeSlotService.deleteTimeSlot(id);

    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // VENUES

    @GetMapping("/venues")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Venue> getVenues(){

        return venueService.getVenues();

    }

    @GetMapping("/venues/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Venue getVenue(@PathVariable Long id){

        return venueService.getVenue(id);

    }

    @PostMapping("/venues/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Venue createVenue(@RequestBody Venue venue){

        return venueService.saveVenue(venue);

    }

    @DeleteMapping("/venues/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteVenue(@PathVariable Long id){

        venueService.deleteVenue(id);

    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // TIMETABLE

    @GetMapping("/timetables")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TimeTable> getTimeTables(){

        return timeTableService.getTimeTables();

    }

    @GetMapping("/timetables/by/{day}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TimeTable> getTimeTablesByDay(@PathVariable String day){
        return timeTableService.getTimeTableByDay(day);
    }

    @GetMapping("/timetables/exclude/{day}/{teacherId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TimeTable> getTimeTableExcludingTeacher(@PathVariable String day, @PathVariable Long teacherId){

        return timeTableService.timeTableExcludingTeacher(day,teacherId);

    }


    @GetMapping("/timetables/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TimeTable getTimeTable(@PathVariable Long id){
        return timeTableService.getTimeTable(id);
    }

    @PostMapping("/timetables/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public TimeTable createTimeTable(@RequestBody TimeTable timeTable){


        return timeTableService.saveTimeTable(timeTable);

    }


    @DeleteMapping("/timetables/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteTimeTable(@PathVariable Long id){
        timeTableService.deleteTimeTable(id);
    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // EXAMINATION

    @GetMapping("/examinations")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Examination> getExaminations(){

        return examinationService.getExaminationOrdered();

    }

    @GetMapping("/examinations/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Examination getExamination(@PathVariable Long id){

        return examinationService.getExamination(id);

    }

    @PostMapping("/examinations/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Examination saveExamination(@RequestBody Examination examination){
        return examinationService.saveExamination(examination);
    }



    @DeleteMapping("/examinations/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteExamination(@PathVariable Long id){
        examinationService.deleteExamination(id);
    }

//------------------------------------------------------------------------------------------------------------------------------------------

    // EXTERNAL

    @GetMapping("/externals")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<External> getExternals(){
        return externalService.getExternals();
    }

    @GetMapping("/externals/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public External getExternal(@PathVariable Long id){

        return externalService.getExternal(id);

    }

    @PostMapping("/externals/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public External saveExternal(@RequestBody External external){
        return externalService.saveExternal(external);
    }

    @DeleteMapping("/externals/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteExternal(@PathVariable Long id){

        externalService.deleteExternal(id);

    }

    @GetMapping("/externals/count/{teacherId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public long countExternalByTeacher(@PathVariable Long teacherId){
        return externalService.countExternalByTeacher(teacherId);
    }

    @GetMapping("/externals/exists/{teacherId}/{date}/{day}/{timeSlotId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean checkExternalExists(@PathVariable Long teacherId, @PathVariable String date, @PathVariable String day,
                                       @PathVariable Long timeSlotId){

        return externalService.checkExternalExists(teacherId, date, day, timeSlotId);

    }
}
