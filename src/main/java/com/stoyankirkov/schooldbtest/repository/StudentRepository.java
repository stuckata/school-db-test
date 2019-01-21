package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Sort SORT_BY_NAME = new Sort(Sort.Direction.ASC, "name");

    default List<Student> findAll(){
        return findAll(SORT_BY_NAME);
    }
}
