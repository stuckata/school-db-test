package com.stoyankirkov.schooldbtest.controller;

import com.stoyankirkov.schooldbtest.exception.ResourceNotFoundException;
import com.stoyankirkov.schooldbtest.model.ClassSubjectTeacher;
import com.stoyankirkov.schooldbtest.model.Subject;
import com.stoyankirkov.schooldbtest.repository.ClassSubjectTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClassSubjectTeacherController {

    @Autowired
    private ClassSubjectTeacherRepository classSubjectTeacherRepository;

    @GetMapping("/class-subject-teacher")
    public List<ClassSubjectTeacher> getAllClassesSubjectsTeachers() {
        return this.classSubjectTeacherRepository.findAll();
    }

    @GetMapping("/subjects-by-teacher/{id}")
    public ResponseEntity<List<Integer>>
    getAllSubjectIdsByTeacherId(@PathVariable(value = "id") Integer teacherId) throws ResourceNotFoundException {
        List<ClassSubjectTeacher> classSubjectTeachers =
                this.classSubjectTeacherRepository.findClassSubjectTeachersByTeacher_Id(teacherId)
                        .orElseThrow(() -> new ResourceNotFoundException("Subjects not found for this teacher id :: " + teacherId));
        List<Integer> subjectIds = classSubjectTeachers.stream()
                .map(ClassSubjectTeacher::getSubject)
                .map(Subject::getId)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(subjectIds);
    }

    @GetMapping("/class-subject-teacher-by-class/{id}")
    public ResponseEntity<List<ClassSubjectTeacher>>
    getAllClassesSubjectsTeachersByClassId(@PathVariable(value = "id") Integer schoolClassId) throws ResourceNotFoundException {
        List<ClassSubjectTeacher> classSubjectTeachers =
                this.classSubjectTeacherRepository.findClassSubjectTeachersBySchoolClass_Id(schoolClassId)
                        .orElseThrow(() -> new ResourceNotFoundException("Classes not found for this id :: " + schoolClassId));
        return ResponseEntity.ok().body(classSubjectTeachers);
    }

    @GetMapping("/class-subject-teacher-by-subject/{id}")
    public ResponseEntity<List<ClassSubjectTeacher>>
    getAllClassesSubjectsTeachersBySubjectId(@PathVariable(value = "id") Integer subjectId) throws ResourceNotFoundException {
        List<ClassSubjectTeacher> classSubjectTeachers =
                this.classSubjectTeacherRepository.findClassSubjectTeachersBySubject_Id(subjectId)
                        .orElseThrow(() -> new ResourceNotFoundException("Classes not found for this id :: " + subjectId));
        return ResponseEntity.ok().body(classSubjectTeachers);
    }

    @GetMapping("/class-subject-teacher-by-teacher/{id}")
    public ResponseEntity<List<ClassSubjectTeacher>>
    getAllClassesSubjectsTeachersByTeacherId(@PathVariable(value = "id") Integer teacherId) throws ResourceNotFoundException {
        List<ClassSubjectTeacher> classSubjectTeachers =
                this.classSubjectTeacherRepository.findClassSubjectTeachersByTeacher_Id(teacherId)
                        .orElseThrow(() -> new ResourceNotFoundException("Classes not found for this id :: " + teacherId));
        return ResponseEntity.ok().body(classSubjectTeachers);
    }
}
