package com.Practical.Backend.Repository;

import com.Practical.Backend.Entity.Teacher;
import com.Practical.Backend.Entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable,Long> {


    @Query("SELECT t FROM TimeTable t WHERE t.day = :desiredDay")
    public List<TimeTable> timeTableByDay(@Param("desiredDay") String desiredDay);


    @Query("SELECT t FROM TimeTable t WHERE t.day = :day AND t.teacher.id <> :teacherId")
    public List<TimeTable> timeTableByDayExcludingTeacher(
            @Param("day") String day,
            @Param("teacherId") Long teacherId
    );

}
