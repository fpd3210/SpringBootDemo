package com.dpf.springboottransaction.repository;


import com.dpf.springboottransaction.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pikachues
 * Created 2022/5/26
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
}
