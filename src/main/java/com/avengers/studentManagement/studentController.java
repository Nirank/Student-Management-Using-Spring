package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class studentController {

    //get info
    @Autowired
    studentService studentservice;
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admNo") int  admNo){
        Student student =  studentservice.getStudent(admNo);
        return  new ResponseEntity< >(student , HttpStatus.FOUND);
    }

    //adding info
    @PostMapping("/addStudent")
    //end point ...add_student
    public ResponseEntity addStudent(@RequestBody Student student){
        String response =  studentservice.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @DeleteMapping("/delete_student/{admNo}")
    public ResponseEntity deleteStudent(@PathVariable("admNo") int admNo){
       String response =  studentservice.deleteStudent(admNo);
       if( response.equals("Invalid Student AdmNo"))
           return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

       return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PutMapping("update_student")
    public ResponseEntity updateStudent( @RequestParam("id") int id ,@RequestParam("age") int age){
       String response =  studentservice.updateStudent(id , age);
       if(response.equals("Invalid Student AdmNo"))
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);


    }


}
