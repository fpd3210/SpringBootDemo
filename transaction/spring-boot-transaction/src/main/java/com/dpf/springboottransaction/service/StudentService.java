package com.dpf.springboottransaction.service;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Pikachues
 * Created 2022/5/26
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(timeout = 10)
    public void add(Student student){
        int i = 10/0;
        studentRepository.save(student);
    }
}
