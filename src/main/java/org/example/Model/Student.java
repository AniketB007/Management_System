package org.example.Model;

public class Student {
    Teacher t1=new Teacher();
    int id;
    String name;
    String email;

    public int getId(){
        return id;
    }
    public void setId(int id){
       this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setT1(Teacher t1){
        this.t1=t1;
    }
    public Teacher getT1() {
        return t1;
    }
}
