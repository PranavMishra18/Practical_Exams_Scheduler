package com.Practical.Backend.Repository;

import com.Practical.Backend.Entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination,Long> {



    @Query("SELECT e FROM Examination e ORDER BY e.section ASC, e.subject.subjectName ASC,e.studentGroup ASC")
    List<Examination> findAllExaminationsOrdered();


}
