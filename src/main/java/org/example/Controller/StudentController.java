package org.example.Controller;

import org.example.Model.Student;
import org.example.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController{
    @Autowired                         //using this anno...to direct connect with interface
    private StudentServiceImpl service;  //create only object of interface

    @RequestMapping("/insertStudent")               //insert single
    @ResponseBody
    void insertStudent(@RequestBody Student s1){   //object of Model-Student (encapsulation) class
        service.insertStudent(s1);                 //call to service to method and s1 object pass to service
    }

    @RequestMapping("/selectStudent")                         //select single
    @ResponseBody
    Student selectStudent(@RequestParam int id, @RequestParam int id1){
        return service.selectStudent(id,id1);
    }


    @RequestMapping("/selectStudents")                          //select All
    @ResponseBody
    List<Student> selectStudents(){
        return service.selectStudents();
    }

    @RequestMapping("/insertStudents")                           //insert All
    @ResponseBody
    void insertStudents(@RequestBody List<Student>studentList){
        service.insertStudents(studentList);
    }
    @RequestMapping("/selectMultiple")                          //select multiple
    @ResponseBody
    List<Student> selectMultiple(@RequestParam List<Integer>ids,@RequestParam List<Integer>ids1){
        return service.selectMultiple(ids,ids1);
    }

    @RequestMapping("/updateStudent")                          //update single
    @ResponseBody
    Student updateStudent(@RequestBody Student s2){
        return service.updateStudent(s2);
    }
    @RequestMapping("/updateMultiple")                       //update multiple
    @ResponseBody
    List<Student> updateStudents(@RequestBody List<Student>studentList){
        return service.updateStudents(studentList);
    }
    @RequestMapping("/deleteSingle")                          //delete single
    @ResponseBody
    Boolean deleteSingle(@RequestParam int id,@RequestParam int idT){
        return service.deleteSingle(id,idT);
    }
    @RequestMapping("deleteMultiple")                         //delete multiple
    @ResponseBody
    Boolean deleteMultiple(@RequestParam List<Integer>ids,@RequestParam List<Integer>idT){
        return service.deleteMultiple(ids,idT);
    }
    @RequestMapping("deleteAll")                              //delete all
    @ResponseBody
    Boolean deleteAll(){
        return service.deleteAll();
    }
}
//@RequestBody for student data     DELETE FROM `student` WHERE 0

