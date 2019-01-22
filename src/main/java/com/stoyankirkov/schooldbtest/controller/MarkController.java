package com.stoyankirkov.schooldbtest.controller;

import com.stoyankirkov.schooldbtest.exception.ResourceNotFoundException;
import com.stoyankirkov.schooldbtest.model.Mark;
import com.stoyankirkov.schooldbtest.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @GetMapping("/marks")
    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @GetMapping("/marks/{classId}/{subjectId}")
    public  ResponseEntity<List<Mark>> getMarksByClassIdAndSubjectId(@PathVariable(value = "classId") Integer classId,
                                                                       @PathVariable(value = "subjectId") Integer subjectId) {

        List<Mark> marks = markRepository.findMarksBySchoolClass_IdAndSubject_Id(classId, subjectId);
        return ResponseEntity.ok().body(marks);
    }

    @PostMapping("/marks")
    public Mark createMark(@Valid @RequestBody Mark mark) {
        return markRepository.save(mark);
    }

    @PutMapping("/marks/{id}")
    public ResponseEntity<Mark> updateMark(@PathVariable(value = "id") Integer markId,
                                                   @Valid @RequestBody Mark updatedMark) throws ResourceNotFoundException {
        Mark mark = markRepository.findById(markId)
                .orElseThrow(() -> new ResourceNotFoundException("Mark not found for this id :: " + markId));
        mark.setValue(updatedMark.getValue());
        mark.setDate(updatedMark.getDate());
        mark.setSubject(updatedMark.getSubject());
        mark.setTeacher(updatedMark.getTeacher());
        final Mark savedMark = markRepository.save(mark);
        return ResponseEntity.ok(savedMark);
    }

    @DeleteMapping("/marks/{id}")
    public Map<String, Boolean> deleteMark(@PathVariable(value = "id") Integer markId)
            throws ResourceNotFoundException {
        Mark mark = markRepository.findById(markId)
                .orElseThrow(() -> new ResourceNotFoundException("Mark not found for this id :: " + markId));
        markRepository.delete(mark);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
