package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
    @Autowired
    studentRepositary studentrepositary;

    public Student getStudent( int  admNo){
        return studentrepositary.getStudent(admNo);
    }

    //adding info
    //end point ...add_student
    public String addStudent(Student student){
       return studentrepositary.addStudent(student);
    }

    public String deleteStudent( int admNo){
        return studentrepositary.deleteStudent(admNo);
    }


    public String updateStudent( int id , int age){
        return studentrepositary.updateStudent(id, age);

    }
}
