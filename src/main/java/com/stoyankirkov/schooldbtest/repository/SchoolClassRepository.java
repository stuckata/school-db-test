package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}