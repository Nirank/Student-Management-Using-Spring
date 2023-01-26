package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Repository
public class studentRepositary {

    HashMap< Integer, Student > db = new HashMap<>();

    //get info

    public Student getStudent( int  admNo){
        return db.get(admNo);
    }

    //adding info
    //end point ...add_student
    public String addStudent(Student student){
        int admNo = student.getAdmNo();
        db.put(admNo, student);
        return "Student added Successfully";
    }

    public String deleteStudent( int id){
        if(!db.containsKey(id)){
            return "Invalid Student AdmNo";
        }
        db.remove(id);
        return "Student Removed Successfully";
    }


    public String updateStudent( int id , int age){
        if(!db.containsKey(id)){
            return "Invalid Student AdmNo";
        }
        db.get(id).setAge(age);
        return "Student Data Updated Successfully";

    }
}
