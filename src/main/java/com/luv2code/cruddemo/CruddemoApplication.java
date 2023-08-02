package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

        return runner -> {
//           createStudent(studentDAO);

            createMultipleStudents(studentDAO);
//            queryForStud ens(studentDAO);
//            queryForStudensByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);

//            System.out.println(studentDAO.findById(2));
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);

    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student...");
        myStudent.setFirstName("ToTi");

        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudensByLastName(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findByLastName("Muhaxheri");
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudens(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findall();

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "duffy@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student with id: " + theId);
        Student mystudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + mystudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("altin", "Muhaxheri", "toti@gmail.com");
        Student tempStudent2 = new Student("endrit", "Muhaxheri", "endrit@gmail.com");
        Student tempStudent3 = new Student("dion", "Muhaxheri", "dion@gmail.com");


        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Toti", "Muhaxheri", "toti@gmail.com");


        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. generated id: "+ tempStudent.getId());
    }



}
