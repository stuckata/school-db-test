package com.stoyankirkov.schooldbtest.controller;

import com.stoyankirkov.schooldbtest.exception.ResourceNotFoundException;
import com.stoyankirkov.schooldbtest.model.SchoolClass;
import com.stoyankirkov.schooldbtest.repository.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SchoolClassController {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @GetMapping("/classes")
    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<SchoolClass> getClassById(@PathVariable(value = "id") Long classId)
            throws ResourceNotFoundException {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found for this id :: " + classId));
        return ResponseEntity.ok().body(schoolClass);
    }

    @PostMapping("/classes")
    public SchoolClass createClass(@Valid @RequestBody SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<SchoolClass> updateClass(@PathVariable(value = "id") Long classId,
                                           @Valid @RequestBody SchoolClass updatedSchoolClass) throws ResourceNotFoundException {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found for this id :: " + classId));
        schoolClass.setName(updatedSchoolClass.getName());
        schoolClass.setStudents(updatedSchoolClass.getStudents());
        schoolClass.setSubjects(updatedSchoolClass.getSubjects());
        final SchoolClass savedSchoolClass = schoolClassRepository.save(schoolClass);
        return ResponseEntity.ok(savedSchoolClass);
    }

    @DeleteMapping("/classes/{id}")
    public Map<String, Boolean> deleteClass(@PathVariable(value = "id") Long classId)
            throws ResourceNotFoundException {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found for this id :: " + classId));
        schoolClassRepository.delete(schoolClass);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
