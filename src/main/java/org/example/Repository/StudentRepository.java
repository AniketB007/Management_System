package org.example.Repository;

import org.example.Model.Student;
import org.example.Model.Teacher;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements StudentRepoImpl{
    @Override
    public void insertStudent(Student s1){                           //insert single
        try{
            String  url="jdbc:mysql://localhost:3306/teststudent";  //teststudent name of database file name
            String userName="root";                                //"root" it is from XAMPP
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");   //This is main class for throw the exception
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("insert into student values ('"+s1.getId()+       //'student' is a table name
                                                             "','"+s1.getName()+
                                                             "','"+s1.getEmail()+"')"); //string manipulation
            st.executeUpdate("insert into teacher value('"+s1.getT1().getId()+"','"+s1.getT1().getEmail()+"','"+s1.getT1().getEmail()+"')");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Student selectStudent(int id,int id1){                                   //select single
        Student std=new Student();
        Teacher s2=new Teacher();
        try{
            String  url="jdbc:mysql://localhost:3306/teststudent";
            String userName="root";
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from student where id='"+id+"'");  // table name=student
            while(rs.next()){
                std.setId(rs.getInt(1));
                std.setName(rs.getString(2));
                std.setEmail(rs.getString(3));
            }
            ResultSet rs1=st.executeQuery("select * from teacher where id='"+id1+"'");
            while(rs1.next()){
                s2.setId(rs1.getInt(1));
                s2.setName(rs1.getString(2));
                s2.setEmail(rs1.getString(3));
            }
            std.setT1(s2);
        }catch(Exception e){
            System.out.println(e);
        }
        return std;

    }
    @Override
    public List<Student> selectStudents(){                              //select all
        List<Student> studentList=new ArrayList<>();
        List<Teacher>teacherList=new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/teststudent";
        String user="root";
        String pass="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            while(rs.next()){
                Student s1=new Student();
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setEmail(rs.getString(3));
                studentList.add(s1);
            }
            ResultSet rs1=st.executeQuery("select * from teacher");
            while(rs.next()){
                Teacher t1= new Teacher();
                t1.setId(rs1.getInt(1));
                t1.setName(rs1.getString(2));
                t1.setEmail(rs1.getString(3));
                teacherList.add(t1);
            }
           // studentList.add(teacherList);
        }catch(Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public void insertStudents(List<Student> studentList){
        //insert multiple
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String user="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            for(int i=0;i<studentList.size();i++){
                st.executeUpdate("insert into student values('" + studentList.get(i).getId() +
                                                                 "','"+studentList.get(i).getName()+
                                                               "','"+studentList.get(i).getEmail()+"')");
                st.executeUpdate("insert into teacher values('"+studentList.get(i).getT1().getId()
                                                                  +"','"+studentList.get(i).getT1().getName()
                                                                  +"','"+studentList.get(i).getT1().getEmail()+"')");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Student> selectMultiple(List<Integer> ids, List<Integer>ids1){             //select multiple={10,20,30}
        List<Student> studentList1=new ArrayList<>();
        List<Student> studentList2=new ArrayList<>();
        List<Teacher>teacherList1=new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/teststudent";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            for (int i = 0; i < ids.size(); i++) {
                ResultSet rs = st.executeQuery("select * from student where id='" + ids.get(i) + "'");
                while (rs.next()) {
                    Student s2 = new Student();
                    s2.setId(rs.getInt(1));
                    s2.setName(rs.getString(2));
                    s2.setEmail(rs.getString(3));
                    studentList1.add(s2);
                }
            }
            for(int i=0;i<ids1.size();i++) {
                ResultSet rs = st.executeQuery("select * from teacher where id='" + ids1.get(i) + "'");
                while (rs.next()) {
                    Teacher t1 = new Teacher();
                    t1.setId(rs.getInt(1));
                    t1.setName(rs.getString(2));
                    t1.setEmail(rs.getString(3));
                    teacherList1.add(t1);
                }
            }
            for(int i=0;i<ids1.size();i++){
                Student s1=studentList1.get(i);
                s1.setT1(teacherList1.get(i));
                studentList2.add(s1);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return studentList2;
    }
    public Student updateStudent(Student s2){                                     //update single
        Student s3=new Student();
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String user="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            st.executeUpdate("update student set name='"+ s2.getName()+"',email='"+ s2.getEmail()+"'where id ='"+s2.getId()+"'");
            st.executeUpdate("update teacher set name='"+s2.getT1().getName()+"',email='"+s2.getT1().getEmail()+"'where id='"+s2.getT1().getId()+"'");

            s3=selectStudent(s2.getId(),s2.getT1().getId());

        }catch(Exception e){
            System.out.println(e);
        }
        return s3;
    }
    @Override
    public List<Student>updateStudents(List<Student>studentList){             //update multiple
        List<Integer>ids=new ArrayList<>();
        List<Integer>ids1=new ArrayList<>();
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String userName="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,pass);
            Statement st=con.createStatement();
            for(int i=0;i<studentList.size();i++){
                st.executeUpdate("update student set name='"+studentList.get(i).getName()
                                                               +"',email='"+studentList.get(i).getEmail()+"'where id='"
                                                               +studentList.get(i).getId()+"'");
                st.executeUpdate("update teacher set name='"+studentList.get(i).getT1().getName()+"',email='"
                                                                +studentList.get(i).getT1().getEmail()
                                                                +"'where id='"+studentList.get(i).getT1().getId()+"'");

                ids.add(studentList.get(i).getId());
                ids1.add(studentList.get(i).getT1().getId());
            }

    }catch(Exception e){
            System.out.println(e);
        }
        return selectMultiple(ids,ids1);
    }
    @Override
    public Boolean deleteSingle(int id,int idT){                                       //delete single
        Boolean result=false;
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String userName="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,pass);
            Statement st=con.createStatement();
            int count=st.executeUpdate("delete from student where id='"+id+"'");
            System.out.println(count);
            if(count!=0){
                result=true;
            }
            int count1=st.executeUpdate("delete from teacher where id='"+idT+"'");
            if(count1>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteMultiple(List<Integer>ids,List<Integer>idT){                      //delete multiple
        Boolean result=false;
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String userName="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,pass);
            Statement st=con.createStatement();
            for(int i=0;i<ids.size();i++) {
                int count=st.executeUpdate("delete from student where id='"+ids.get(i)+"'");
                if(count>0){
                    result=true;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteAll(){                                       // delete All
        Boolean result=false;
        try{
            String url="jdbc:mysql://localhost:3306/teststudent";
            String user="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            int count=st.executeUpdate("delete from student");
            if(count>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
}