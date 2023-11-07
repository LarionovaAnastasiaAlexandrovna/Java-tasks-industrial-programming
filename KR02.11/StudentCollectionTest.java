package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentCollectionTest {

    @Test
    void takeInformNameTest1() {
        StudentCollection studentCollection = new StudentCollection();

        Student student1 = new Student();
        student1.setName("Larionova");
        student1.setCourse(2);
        student1.setGroup(6);
        student1.setGrade(4);

        Student student2 = new Student();
        student2.setName("Kot");
        student2.setCourse(3);
        student2.setGroup(8);
        student2.setGrade(3);

        Student student3 = new Student();
        student3.setName("Ivanov");
        student3.setCourse(4);
        student3.setGroup(9);
        student3.setGrade(2);

        Student student4 = new Student();
        student4.setName("Larionova");
        student4.setCourse(4);
        student4.setGroup(9);
        student4.setGrade(2);

        studentCollection.add(student1);
        studentCollection.add(student2);
        studentCollection.add(student3);
        studentCollection.add(student4);

        ArrayList<Student> expectedSubStudents = new ArrayList<>();
        expectedSubStudents.add(student1);
        expectedSubStudents.add(student4);

        ArrayList<Student> subStudents;

        subStudents =  studentCollection.takeInformName("Larionova");
        assertEquals(expectedSubStudents, subStudents);
    }

    @Test
    void takeInformNameTest2() {
        StudentCollection studentCollection = new StudentCollection();

        Student student1 = new Student();
        student1.setName("Larionova");
        student1.setCourse(2);
        student1.setGroup(6);
        student1.setGrade(4);

        Student student2 = new Student();
        student2.setName("Kot");
        student2.setCourse(3);
        student2.setGroup(8);
        student2.setGrade(3);

        Student student3 = new Student();
        student3.setName("Ivanov");
        student3.setCourse(4);
        student3.setGroup(9);
        student3.setGrade(2);

        Student student4 = new Student();
        student4.setName("Larionova");
        student4.setCourse(4);
        student4.setGroup(9);
        student4.setGrade(2);

        studentCollection.add(student1);
        studentCollection.add(student2);
        studentCollection.add(student3);
        studentCollection.add(student4);

        ArrayList<Student> expectedSubStudents = new ArrayList<>();

        ArrayList<Student> subStudents;

        subStudents =  studentCollection.takeInformName("Bodina");
        assertEquals(expectedSubStudents, subStudents);
    }

    @Test
    void takeInformCourseTest1() {
        StudentCollection studentCollection = new StudentCollection();

        Student student1 = new Student();
        student1.setName("Kot");
        student1.setCourse(2);
        student1.setGroup(6);
        student1.setGrade(4);

        Student student2 = new Student();
        student2.setName("Ivanov");
        student2.setCourse(3);
        student2.setGroup(8);
        student2.setGrade(3);

        Student student3 = new Student();
        student3.setName("Ivanov");
        student3.setCourse(4);
        student3.setGroup(9);
        student3.setGrade(2);

        Student student4 = new Student();
        student4.setName("Larionova");
        student4.setCourse(4);
        student4.setGroup(9);
        student4.setGrade(2);

        studentCollection.add(student1);
        studentCollection.add(student2);
        studentCollection.add(student3);
        studentCollection.add(student4);

        ArrayList<Student> expectedCoursesWithName = new ArrayList<>();

        expectedCoursesWithName.add(student2);
        expectedCoursesWithName.add(student3);

        ArrayList<Student> subStudents;
        subStudents = studentCollection.takeInformName("Ivanov");
        assertEquals(expectedCoursesWithName, subStudents);
    }

    @Test
    void takeInformCourseTest2() {
        StudentCollection studentCollection = new StudentCollection();

        Student student1 = new Student();
        student1.setName("Kot");
        student1.setCourse(2);
        student1.setGroup(6);
        student1.setGrade(4);

        Student student2 = new Student();
        student2.setName("Ivanov");
        student2.setCourse(3);
        student2.setGroup(8);
        student2.setGrade(3);

        Student student3 = new Student();
        student3.setName("Ivanov");
        student3.setCourse(4);
        student3.setGroup(9);
        student3.setGrade(2);

        Student student4 = new Student();
        student4.setName("Larionova");
        student4.setCourse(4);
        student4.setGroup(9);
        student4.setGrade(2);

        studentCollection.add(student1);
        studentCollection.add(student2);
        studentCollection.add(student3);
        studentCollection.add(student4);

        ArrayList<Student> expectedCoursesWithName = new ArrayList<>();


        ArrayList<Student> subStudents;
        subStudents = studentCollection.takeInformName("Ivanova");
        assertEquals(expectedCoursesWithName, subStudents);
    }

}



