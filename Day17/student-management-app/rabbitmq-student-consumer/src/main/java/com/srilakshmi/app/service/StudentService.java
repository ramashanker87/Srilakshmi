package com.srilakshmi.app.service;

import com.srilakshmi.app.model.Student;
import com.srilakshmi.app.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String saveStudent(Student student) {
        studentRepo.save(student);
        return student.getName()+" is saved successfully";
    }

    public String deleteStudent(String name) {
        Student student = studentRepo.findByName(name);
        studentRepo.delete(student);
        return student.getName()+" is deleted successfully";
    }
}
