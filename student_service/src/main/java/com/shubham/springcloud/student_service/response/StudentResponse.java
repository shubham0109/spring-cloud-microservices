package com.shubham.springcloud.student_service.response;

import com.shubham.springcloud.student_service.entity.Student;
import com.shubham.springcloud.student_service.repository.StudentRepository;

public class StudentResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private AddressResponse addressResponse;

    public StudentResponse(Student student){
        this.email = student.getEmail();
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.id = student.getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }
}
