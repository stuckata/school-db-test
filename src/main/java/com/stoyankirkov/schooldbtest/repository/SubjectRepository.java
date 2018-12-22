package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
