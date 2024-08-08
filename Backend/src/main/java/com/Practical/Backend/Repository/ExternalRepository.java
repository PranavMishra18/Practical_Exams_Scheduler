package com.Practical.Backend.Repository;

import com.Practical.Backend.Entity.External;
import com.Practical.Backend.Entity.Teacher;
import com.Practical.Backend.Entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalRepository extends JpaRepository<External,Long> {

    @Query("SELECT COUNT(e) FROM External e WHERE e.externalExaminer.id = :teacherId")
    long countByExternalTeacherId(Long teacherId);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM External e WHERE e.externalExaminer.id = :teacherId AND e.date = :date AND e.day = :day AND e.timeSlot.id = :timeSlotId")
    boolean checkExternalExists(Long teacherId, String date, String day, Long timeSlotId);

}
