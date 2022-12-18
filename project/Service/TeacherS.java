package com.example.project.Service;
import com.example.project.Model.Student;
import com.example.project.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service

public class TeacherS {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getStudents(){
        return teachers;
    }


    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId() == id)
            {
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getId() == id)
            {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacherByName(String name) {
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getName().equals(name))
                return teachers.get(i);
        }
        return null;
    }

    public ArrayList<Teacher> getTeachersBySalary(Integer salary) {
        ArrayList<Teacher> salaryTeachers = new ArrayList<>();
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getSalary() >= salary)
                salaryTeachers.add(teachers.get(i));
        }
        return salaryTeachers;
    }

}
