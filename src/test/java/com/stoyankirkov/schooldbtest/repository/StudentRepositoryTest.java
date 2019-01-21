package com.stoyankirkov.schooldbtest.repository;

import com.stoyankirkov.schooldbtest.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenFindById_thenReturnStudent() {
        // given
        Student alex = new Student();
        alex.setName("Alex");
        entityManager.persist(alex);
        //entityManager.flush();

        // when
        Student found = studentRepository.findById(alex.getId()).get();

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());
    }
}
