import java.util.ArrayList;

public class Bradebook {
    private String Student_name;
    private String Student_last_name;
    private String Student_patronymic;

    private ArrayList<Session> sessions = new ArrayList<Session>();

    public Bradebook() {}

    public Bradebook(String student_name, String student_last_name,
                     String student_patronymic, ArrayList<Session> sessions) {
        Student_name = student_name;
        Student_last_name = student_last_name;
        Student_patronymic = student_patronymic;
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Bradebook{" +
                "Student_name=' " + Student_name + '\'' +
                ", Student_last_name=' " + Student_last_name + '\'' +
                ", Student_patronymic=' " + Student_patronymic + '\'' +
                ", sessions= " + sessions +
                '}';
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getStudent_last_name() {
        return Student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        Student_last_name = student_last_name;
    }

    public String getStudent_patronymic() {
        return Student_patronymic;
    }

    public void setStudent_patronymic(String student_patronymic) {
        Student_patronymic = student_patronymic;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public static class Session { // одна сессия в частности
        private int session_number; // номер сессии 1-7
        private int number_of_exams; // кол-во экзаменов

        private ArrayList<Exam> exams = new ArrayList<Exam>(); //            Arraylist - названий экзаменов и преподов

        private ArrayList<Test> tests = new ArrayList<Test>();

        public Session() {}

        public Session(int session_number, int number_of_exams, ArrayList<Exam> exams /*, ArrayList<Test> tests*/) {
            this.session_number = session_number;
            this.number_of_exams = number_of_exams;
            this.exams = exams;
            //this.tests = tests;
        }

        @Override
        public String toString() {
            return "Session{" +
                    "session_number=" + session_number +
                    ", number_of_exams=" + number_of_exams +
                    ", exams=" + exams +
                    ", tests=" + tests +
                    '}';
        }

        public int getSession_number() {
            return session_number;
        }

        public void setSession_number(int session_number) {
            this.session_number = session_number;
        }

        public int getNumber_of_exams() {
            return number_of_exams;
        }

        public void setNumber_of_exams(int number_of_exams) {
            this.number_of_exams = number_of_exams;
        }

        public ArrayList<Exam> getExams() {
            return exams;
        }

        public void setExams(ArrayList<Exam> exams) {
            this.exams = exams;
        }

        public ArrayList<Test> getTests() {
            return tests;
        }

        public void setTests(ArrayList<Test> tests) {
            this.tests = tests;
        }

        public static class Exam { // STATIC ??????????????/
            private String name_exam;
            private String name_of_professor;
            private Integer grade;


            public Exam() {}
            public Exam(String name_exam, String name_of_professor, Integer grade) {
                this.name_exam = name_exam;
                this.name_of_professor = name_of_professor;
                this.grade = grade;
            }

            @Override
            public String toString() {
                return "Exam{" +
                        "name_exam='" + name_exam + '\'' +
                        ", name_of_professor='" + name_of_professor + '\'' +
                        '}';
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
        }

        public class Test {

        }
    }

}
