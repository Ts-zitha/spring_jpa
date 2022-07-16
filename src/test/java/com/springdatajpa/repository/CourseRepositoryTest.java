package com.springdatajpa.repository;

import com.springdatajpa.entity.Course;
import com.springdatajpa.entity.Student;
import com.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = "+ courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Kalawa")
                .lastName("Khoza")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .credit(2)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public  void findAllPagination(){
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll((Sort) firstPageWithThreeRecords);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("msand")
                .lastName("ntini")
                .build();


        Student student = Student.builder()
                .firstName("SS")
                .emailId("ss@gmail.com")
                .lastName("west")
                .build();
        Course course = Course
                .builder()
                .title("AI")
                .credit(23)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}