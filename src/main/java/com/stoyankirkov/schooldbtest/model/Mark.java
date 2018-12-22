package com.stoyankirkov.schooldbtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "marks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "value", nullable = false)
    private int value;

    @Column(name = "date", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @Column(name = "subject", nullable = false)
    private Subject subject;

    @Column(name = "teacher", nullable = false)
    private Teacher teacher;
}
