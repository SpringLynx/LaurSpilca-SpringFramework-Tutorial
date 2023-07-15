package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.Student;
import repositories.StudentRepository;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            StudentRepository studentRepository = c.getBean(StudentRepository.class);

            Student student = new Student();

            student.setFirstName("Alex");
            student.setLastName("Pissani");
            student.setDob(LocalDate.of(1980, 02, 01));
            student.setGender('M');
            student.setAddress("H1 St4 San Francisco");
            student.setPhoneNumber("2478365900");
            student.setEmail("alex.pissani@salesforce.com");

            studentRepository.addStudent(student);

        }

    }

}
