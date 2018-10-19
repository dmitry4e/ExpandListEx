package homework.che.expandablelistex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
    private ExpandableListView myExpListView;
    Academy academy=initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myExpListView=findViewById(R.id.expandableListView);
        AcademyListAdapter adapter=new AcademyListAdapter(this,this,academy);
        myExpListView.setAdapter(adapter);

    }
    private Academy initData(){
        Student student_1 = new Student("Иван","Пупкин","муж");
        Student student_2 = new Student("Женя","Добролюбов","муж");
        Student student_3 = new Student("Людмила","Иванова","жен");
        Student student_4 = new Student("Петр","Трофименко","муж");
        Student student_5 = new Student("Федор","Ветров","муж");
        Student student_6 = new Student("Ольга","Космодемьянская","жен");
        Student student_7 = new Student("Василиса","Гаврикова","жен");
        Student student_8 = new Student("Гендольф","Проселов","муж");
        Student student_9 = new Student("Прохор","Ильин","муж");
        Student student_10 = new Student("Наталья","Иванова","жен");




        Academy academy=new Academy();

        StudentGroup programmerGroup=new StudentGroup("Программисты");
        programmerGroup.addStudent(student_1);
        programmerGroup.addStudent(student_2);
        programmerGroup.addStudent(student_3);

        StudentGroup disignersGroup=new StudentGroup("Дизайнеры");
        disignersGroup.addStudent(student_4);
        disignersGroup.addStudent(student_5);
        disignersGroup.addStudent(student_6);
        disignersGroup.addStudent(student_7);

        StudentGroup administratorsGroup=new StudentGroup("Админы");
        administratorsGroup.addStudent(student_8);
        administratorsGroup.addStudent(student_9);
        administratorsGroup.addStudent(student_10);

        academy.addStudentGroup(programmerGroup);
        academy.addStudentGroup(administratorsGroup);
        academy.addStudentGroup(disignersGroup);



        return  academy;
    }



}
