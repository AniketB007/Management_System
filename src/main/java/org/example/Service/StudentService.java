package org.example.Service;

import org.example.Model.Student;
import org.example.Repository.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{
    @Autowired
    private StudentRepoImpl repo;
    @Override
    public void insertStudent(Student s1){
        repo.insertStudent(s1);
    }
    @Override
    public Student selectStudent(int id,int id1){
        return repo.selectStudent(id,id1);
    }

    @Override
    public List<Student> selectStudents() {
        return repo.selectStudents();
    }

    @Override
    public void insertStudents(List<Student>studentList) {
        repo.insertStudents(studentList);
    }
    @Override
    public List<Student> selectMultiple(List<Integer>ids,List<Integer>ids1){
        return repo.selectMultiple(ids,ids1);
    }
    @Override
    public Student updateStudent(Student s2){
        return repo.updateStudent(s2);
    }
    @Override
    public List<Student>updateStudents(List<Student>studentList){
        return repo.updateStudents(studentList);
    }
    @Override
    public Boolean deleteSingle(int id,int idT){
        return repo.deleteSingle(id,idT);
    }
    @Override
    public Boolean deleteMultiple(List<Integer>ids,List<Integer>idT){
        return repo.deleteMultiple(ids,idT);
    }
    @Override
    public Boolean deleteAll(){
        return repo.deleteAll();
    }
}
