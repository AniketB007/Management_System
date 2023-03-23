package org.example.Repository;

import org.example.Model.Student;

import java.util.List;

public interface StudentRepoImpl{
    void insertStudent(Student s1);
    Student selectStudent(int id,int id1);
    List<Student> selectStudents();
    void insertStudents(List<Student>studentList);
    List<Student> selectMultiple(List<Integer>ids,List<Integer>ids1);
    Student updateStudent(Student s2);
    List<Student>updateStudents(List<Student>studentList);
    Boolean deleteSingle(int id,int idT);
    Boolean deleteMultiple(List<Integer>ids,List<Integer>idT);
    Boolean deleteAll();


}
