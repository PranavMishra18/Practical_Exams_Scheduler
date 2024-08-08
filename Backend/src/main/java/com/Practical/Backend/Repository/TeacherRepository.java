package com.Practical.Backend.Repository;

import com.Practical.Backend.Entity.Subject;
import com.Practical.Backend.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    List<Teacher> findBySubjects(Subject subject);
}
