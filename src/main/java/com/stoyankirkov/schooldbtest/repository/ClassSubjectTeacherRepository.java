package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.ClassSubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectTeacherRepository extends JpaRepository<ClassSubjectTeacher, Integer> {
}
