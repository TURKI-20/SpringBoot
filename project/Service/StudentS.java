package com.example.project.Service;
import com.example.project.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class StudentS {


    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
            {
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
            {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudentById(int id) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
                return students.get(i);
        }
        return null;
    }

    public Student getStudentsByName(String name) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name))
                return students.get(i);
        }
        return null;
    }

    public ArrayList<Student> getMajorStudents(String major) {
        ArrayList<Student> majorStudents = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getMajor().equals(major))
                majorStudents.add(students.get(i));
        }
        return majorStudents;
    }

    public ArrayList<Student> getAgeStudents(Integer age) {
        ArrayList<Student> ageStudents = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getAge() >= age)
                ageStudents.add(students.get(i));
        }
        return ageStudents;
    }

}
