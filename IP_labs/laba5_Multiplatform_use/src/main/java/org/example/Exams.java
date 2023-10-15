package org.example;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class Exams {
    private String name_exam;
    private String name_of_professor;
    private Integer grade;
    public Exams() {}
    public Exams(String name_exam, String name_of_professor, Integer grade) {
        this.name_exam = name_exam;
        this.name_of_professor = name_of_professor;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\nExam\n{ " +
                "name_exam = '" + name_exam + '\'' +
                ", name_of_professor = '" + name_of_professor + '\'' +
                " }";
    }

    public String getName_exam() {
        return name_exam;
    }

    public void setName_exam(String name_exam) {
        this.name_exam = name_exam;
    }

    public String getName_of_professor() {
        return name_of_professor;
    }

    public void setName_of_professor(String name_of_professor) {
        this.name_of_professor = name_of_professor;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
