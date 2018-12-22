package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
