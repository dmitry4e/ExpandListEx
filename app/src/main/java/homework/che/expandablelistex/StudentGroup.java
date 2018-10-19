package homework.che.expandablelistex;

import java.util.ArrayList;

public class StudentGroup {
    private String title;
    public ArrayList<Student> students=new ArrayList<>();

    public StudentGroup(String title){
        this.title=title;
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
