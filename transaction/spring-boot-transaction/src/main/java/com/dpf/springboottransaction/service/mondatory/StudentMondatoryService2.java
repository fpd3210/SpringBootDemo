package com.dpf.springboottransaction.service.mondatory;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
@Service
public class StudentMondatoryService2 {

   @Autowired
   private StudentRepository studentRepository;

   @Transactional(propagation = Propagation.MANDATORY)
    public void update2(Student student) {
        student.setUserName(student.getUserName() + "update2");
        studentRepository.save(student);
    }
}
