package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.ClassSubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassSubjectTeacherRepository extends JpaRepository<ClassSubjectTeacher, Integer> {

    Optional<List<ClassSubjectTeacher>> findClassSubjectTeachersBySchoolClass_Id(int schoolClassId);
    Optional<List<ClassSubjectTeacher>> findClassSubjectTeachersByTeacher_Id(int teacherId);
    Optional<List<ClassSubjectTeacher>> findClassSubjectTeachersBySubject_Id(int subjectId);
}
