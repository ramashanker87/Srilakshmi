package com.srilakshmi.app.consumer;

import com.srilakshmi.app.model.Student;
import com.srilakshmi.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentConsumer {
    public static final Logger logger = LoggerFactory.getLogger(StudentConsumer.class.getName());

    @Autowired
    private StudentService studentService;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues ="${rabbitmq.student.queue.name}" )
    public void saveStudent(Student student) {
        logger.info("Received Student object to save: {}", student);
        String response = studentService.saveStudent(student);
        logger.info("Response: {}", response);
    }

    @RabbitListener(queues ="${rabbitmq.queue.name}")
    public void deleteStudent(String studentName) {
        logger.info("Received request to delete Student with name: {}", studentName);
        String response = studentService.deleteStudent(studentName);
        logger.info("Response: {}", response);    }
}
