package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    List<Mark> findMarksByStudent_IdAndAndSubject_Id(Integer studentId, Integer subjectId);
    List<Mark> findMarksBySchoolClass_IdAndSubject_Id(Integer classId, Integer subjectId);
}