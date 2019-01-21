package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
}