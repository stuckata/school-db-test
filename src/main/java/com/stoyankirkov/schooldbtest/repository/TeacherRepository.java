package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
