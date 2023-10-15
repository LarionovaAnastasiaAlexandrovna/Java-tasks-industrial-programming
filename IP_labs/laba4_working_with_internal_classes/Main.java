import java.util.*;
import java.io.*;

// создание и использование компараторов с помощью implements Comparator<Т> @Override compare и @Override compareTo
class NumberBradebookComparator implements Comparator<Bradebook>
{
    @Override
    public int compare(Bradebook o1, Bradebook o2)
    {
        return o1.getNumber_Bradebook().compareTo(o2.getNumber_Bradebook());
    }
}

class LastNameComparator implements Comparator<Bradebook>
{
    @Override
    public int compare(Bradebook o1, Bradebook o2)
    {
        return o1.getStudent_last_name().compareTo(o2.getStudent_last_name());
    }
}


public class Main {
    // метод, в котором происходит поиск и выбор тех студентов у кого будет стипендия
    static void Students_with_a_scholarship(int number_session, Integer count_students, ArrayList<Bradebook> bradebooks)
    {
        boolean flag = false;
        for(int i = 0; i < count_students; ++i)
        {
            if(bradebooks.get(i).Student_with_a_scholarship(number_session, bradebooks.get(i).getSessions().get(number_session).getNumber_of_exams()))
            {
                System.out.println(bradebooks.get(i).getFIO());
                flag = true;
            }
        }
        if(!flag)
        {
            System.out.println("Non students");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        Integer count_students;

        Integer Number_Bradebook;
        String Student_name;
        String Student_last_name;
        String Student_patronymic;
        int count_session;
        int session_number;
        Scanner scanner = new Scanner(new File("input.txt"));
        String line_n = scanner.nextLine();
        count_students = Integer.parseInt(line_n); // считали кол-во зачетных книжек
        ArrayList<Bradebook> bradebooks = new ArrayList<>(count_students);

        ArrayList<Bradebook.Session> sessions;
        ArrayList<Bradebook.Session.Exam> exams;

        for(int student = 0; student < count_students; ++student) // записываем все зачётки по циклу
        {
            Number_Bradebook = Integer.parseInt(scanner.nextLine());
            Student_name = scanner.nextLine();
            Student_last_name = scanner.nextLine();
            Student_patronymic = scanner.nextLine();
            count_session = Integer.parseInt(scanner.nextLine()); // ввели количество сессий

            /* ArrayList<Bradebook.Session> */ sessions = new ArrayList<>(count_session); // создали ArrayList сессий размерностью count_session

            for(int i = 0; i < count_session; ++i) //вводим каждую сессию по циклу
            {
                session_number = Integer.parseInt(scanner.nextLine()); // ввели номер сессии
                int count_of_exams = Integer.parseInt(scanner.nextLine()); // ввели количество экзаменов в i-той сессии
                /* ArrayList<Bradebook.Session.Exam> */ exams = new ArrayList<>(count_of_exams); // создали ArrayList экзаменов размерностью count_of_exams в i-той сессии
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
            Bradebook bradebook = new Bradebook(Number_Bradebook, Student_name, Student_last_name, Student_patronymic, sessions); // создали зачетку студента с заполненными данными : ФИО, кол-во сессий
            bradebooks.add(student, bradebook);
        }

        ArrayList<Integer> Number_Bradebooks = new ArrayList<Integer>(count_students);
        //Collections.sort(bradebooks); // <- сортировка

        LastNameComparator lastNameComparator = new LastNameComparator();
        Collections.sort(bradebooks, lastNameComparator);

        for(int i = 0; i < count_students; ++i)
        {
            System.out.println(bradebooks.get(i).getNumber_Bradebook() + " " + bradebooks.get(i).getStudent_last_name());
            Number_Bradebooks.add(bradebooks.get(i).getNumber_Bradebook());
        }

        NumberBradebookComparator numberBradebookComparator = new NumberBradebookComparator();
        Collections.sort(bradebooks, numberBradebookComparator);

        System.out.println();

        for(int i = 0; i < count_students; ++i)
        {
            System.out.println(bradebooks.get(i).getNumber_Bradebook() + " " + bradebooks.get(i).getStudent_last_name());
            //Number_Bradebooks.add(bradebooks.get(i).getNumber_Bradebook());
        }

        int index = Collections.binarySearch(Number_Bradebooks, 32231120);
        System.out.println("\n" + index);


        Map<Integer, Bradebook> mapBradebook = new HashMap<Integer, Bradebook>();
        for(int i = 0; i < count_students; ++i)
        {
            mapBradebook.put(bradebooks.get(i).getNumber_Bradebook(), bradebooks.get(i));
        }
        System.out.printf(String.valueOf(mapBradebook.get(32231120)));
        for(Map.Entry<Integer, Bradebook> item : mapBradebook.entrySet())
        {
            System.out.printf("\nKey: %d  Value: %s \n", item.getKey(), item.getValue());
        }


        Students_with_a_scholarship(1, 3, bradebooks); // проверка работоспособности ф-ции

        // вывод информации для проверки правильности работы классов и вложенных классов
//        System.out.println("The number of students: ");
//        System.out.println(count_students);
//        String Bradebook_information = bradebooks.get(0).toString();
//        System.out.println(Bradebook_information);
//        String Session_information = bradebooks.get(0).getSessions().get(0).toString();
//        System.out.println(Session_information);
//        String Exam_information = bradebooks.get(0).getSessions().get(0).getExams().get(0).toString();
//        System.out.println(Exam_information);

    }
}
