package com.shubham.springcloud.student_service.service;

import com.shubham.springcloud.student_service.entity.Student;
import com.shubham.springcloud.student_service.feignclients.AddressFeignClient;
import com.shubham.springcloud.student_service.repository.StudentRepository;
import com.shubham.springcloud.student_service.request.CreateStudentRequest;
import com.shubham.springcloud.student_service.response.AddressResponse;
import com.shubham.springcloud.student_service.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private WebClient webClient;

    @Autowired
    private AddressFeignClient addressFeignClient;

    public StudentResponse create(CreateStudentRequest studentRequest){

        Student student = new Student();
        student.setId(studentRequest.getId());
        student.setEmail(studentRequest.getEmail());
        student.setFirstname(studentRequest.getFirstname());
        student.setLastname(studentRequest.getLastname());
        student.setAddress_id(studentRequest.getAddress_id());

        studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        //AddressResponse addressResponse = getAddressById(student.getAddress_id()); #using web client
        AddressResponse addressResponse = addressFeignClient.getById(student.getAddress_id());

        studentResponse.setAddressResponse(addressResponse);

        return studentResponse;

    }

    public StudentResponse getById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();

        StudentResponse studentResponse = new StudentResponse(student);
        //AddressResponse addressResponse = getAddressById(student.getAddress_id()); #using web client
        AddressResponse addressResponse = addressFeignClient.getById(student.getAddress_id());
        studentResponse.setAddressResponse(addressResponse);

        return studentResponse;
    }

    //this function is used with WebClient
    public AddressResponse getAddressById(Long address_id){
        Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + address_id).retrieve().bodyToMono(AddressResponse.class);

        return addressResponse.block();
    }

}
