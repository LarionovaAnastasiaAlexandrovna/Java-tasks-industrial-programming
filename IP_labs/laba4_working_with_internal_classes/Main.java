import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Integer count_students;
        String Student_name;
        String Student_last_name;
        String Student_patronymic;
        int count_session;
        int session_number;
        Scanner scanner = new Scanner(new File("input.txt"));
        String line_n = scanner.nextLine();
        count_students = Integer.parseInt(line_n); // считали кол-во зачетных книжек
        ArrayList<Bradebook> bradebooks = new ArrayList<>(count_students);
        for(int student = 0; student < count_students; ++student) // записываем все зачётки по циклу
        {
            Student_name = scanner.nextLine();
            Student_last_name = scanner.nextLine();
            Student_patronymic = scanner.nextLine();
            count_session = Integer.parseInt(scanner.nextLine()); // ввели количество сессий
            //
            ArrayList<Bradebook.Session> sessions = new ArrayList<>(count_session); // создали ArrayList сессий размерностью count_session
            //
            for(int i = 0; i < count_session; ++i) //вводим каждую сессию по циклу
            {
                session_number = Integer.parseInt(scanner.nextLine()); // ввели номер сессии
                int count_of_exams = Integer.parseInt(scanner.nextLine()); // ввели количество экзаменов в i-той сессии
                ArrayList<Bradebook.Session.Exam> exams = new ArrayList<>(count_of_exams); // создали ArrayList экзаменов размерностью count_of_exams в i-той сессии
                for(int j = 0; j < count_of_exams; ++j) // вводим экзамены
                {
                    String name_exam = scanner.nextLine();
                    String name_of_professor = scanner.nextLine();
                    Integer grade = Integer.parseInt(scanner.nextLine());
                    Bradebook.Session.Exam exam = new Bradebook.Session.Exam(name_exam, name_of_professor, grade);
                    exams.add(j, exam); // добавляем j-й экзамен в ArrayList экзаменов размерностью count_of_exams в i-той сессии
                }
                // ввели экзамены i-той сессии
                Bradebook.Session session = new Bradebook.Session(session_number, count_of_exams, exams);
                sessions.add(i, session);
            } // ввели все сессии
            Bradebook bradebook = new Bradebook(Student_name, Student_last_name, Student_patronymic, sessions); // создали зачетку студента с заполненными данными : ФИО, кол-во сессий
            bradebooks.add(student, bradebook);
        }

        System.out.println("The number of students: ");
        System.out.println(count_students);

    }
}
