package com.stoyankirkov.schooldbtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

//    @OneToMany(mappedBy = "subject")
//    List<ClassSubjectTeacher> subjects;
}
