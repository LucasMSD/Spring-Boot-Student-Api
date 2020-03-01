package com.lucas.Dao;

import com.lucas.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@Qualifier("SqlServerData")
public class SqlServerStudentDaoImple implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Lucas", "Physics"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setName(student.getName());
        s.setCourse(student.getCourse());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
    }
}
