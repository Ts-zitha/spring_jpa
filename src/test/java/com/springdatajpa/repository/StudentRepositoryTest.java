package com.springdatajpa.repository;

import com.springdatajpa.entity.Guardian;
import com.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("sipho@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("999-555-555")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikil@gmail.com")
                .name("Nikhil")
                .mobile("999-555-345")
                .build();

        Student student = Student.builder()
                .firstName("Ts")
                .emailId("Ts@gmail.com")
                .lastName("kamal")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = "+ studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Ts");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = "+ students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("Ts@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("Ts@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("Ts@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Madala", "Ts@gmail.com");
    }
}