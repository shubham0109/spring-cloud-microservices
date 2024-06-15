package com.shubham.springcloud.student_service.controller;

import com.shubham.springcloud.student_service.request.CreateStudentRequest;
import com.shubham.springcloud.student_service.response.StudentResponse;
import com.shubham.springcloud.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentResponse create(@RequestBody CreateStudentRequest studentRequest){
        return studentService.create(studentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getById(id);
    }

}
