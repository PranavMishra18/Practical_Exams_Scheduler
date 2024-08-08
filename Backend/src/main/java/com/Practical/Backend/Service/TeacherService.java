package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.Subject;
import com.Practical.Backend.Entity.Teacher;
import com.Practical.Backend.Repository.SubjectRepository;
import com.Practical.Backend.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SubjectService subjectService;

    public List<Teacher> getTeachers(){

        return teacherRepository.findAll();

    }

    public Teacher getTeacher(Long id){

        return teacherRepository.findById(id).get();

    }

    public List<Teacher> getTeachersBySubject(Subject subject){

        return teacherRepository.findBySubjects(subject);

    }

    @Transactional
    public Teacher saveTeacherWithSubjects(Teacher teacher, List<Long> subjectIds) {
        // Save the teacher first to get its ID
        Teacher savedTeacher = teacherRepository.save(teacher);

        // Fetch subjects based on subjectIds
        List<Subject> subjects = subjectService.getSubjectsByIds(subjectIds);

        // Associate the fetched subjects with the saved teacher
        savedTeacher.setSubjects(subjects);

        // Save the updated teacher with associated subjects
        return teacherRepository.save(savedTeacher);
    }



    @Transactional
    public void deleteTeacher(Long id){

        Teacher teacher = teacherRepository.findById(id).get();

        teacherRepository.delete(teacher);

    }



}
