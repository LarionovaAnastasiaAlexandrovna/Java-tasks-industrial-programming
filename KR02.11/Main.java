package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
class Student implements Comparable<Student> {
    String name;
    int course;
    int group;
    int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " " + course + " " + group + " " + grade;
    }

    @Override
    public int compareTo(Student o) {
        int res = this.name.compareTo(o.name);
        if (res == 0)
        {
            res = Integer.compare(o.group, this.group);
            if (res == 0)
            {
                res = Integer.compare(o.course, this.course);
            }
        }
        return res;
    }
}
class StudentCollection {
    ArrayList<Student> studentsList = new ArrayList<>();
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Student student : studentsList)
        {
            res.append(student.name).append(" ").append(student.course).append(" ").append(student.group).append(" ").append(student.grade).append("\n");
        }
        return res.toString();
    }
    public void add(Student student)
    {
        studentsList.add(student);
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
    //    public void setHotelsList(ArrayList<Hotel> hotelsList) {
//        this.hotelsList = hotelsList;
//    }
    public ArrayList<Student> takeInformName(String searchableName)
    {
        ArrayList<Student> subStudents = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.name.equals(searchableName)) {
                subStudents.add(student);
            }
        }
        for (Student student : subStudents) {
            System.out.println(student.toString());
        }
        return subStudents;
    }
    public ArrayList<Student> takeInformCourse(Integer searchableCourse)
    {
        ArrayList<Student> StudentsWithThisCourse = new ArrayList<>();
        for(Student student : studentsList)
        {
            if(student.course == searchableCourse)
                StudentsWithThisCourse.add(student);

            System.out.println(student);
        }
        return StudentsWithThisCourse;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("stud.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String[] allstr; // = str.split(" ");
        ArrayList<Student> studentList = new ArrayList<>();
        StudentCollection studentCollection = new StudentCollection();

        while (str != null) {
            Student student = new Student();
            allstr = str.split(" ");
            student.name = allstr[0];
            student.course = Integer.parseInt(allstr[1]);
            student.group = Integer.parseInt(allstr[2]);
            student.grade = Integer.parseInt(allstr[3]);
            studentCollection.add(student);
            studentList.add(student);
            str = br.readLine();
        }
       Collections.sort(studentList);
       Collections.sort(studentCollection.studentsList);


        //System.out.println(studentCollection);

        System.out.println("\n" + studentCollection.takeInformCourse(2) + "\n");
        studentCollection.takeInformName("Larionov");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("output.json"), studentCollection);
    }
}
