package com.sucodev.web.endpoint;


import com.sucodev.lop.service.LopService;
import com.sucodev.student.domain.Student;
import com.sucodev.student.payload.request.StudentRequest;
import com.sucodev.student.payload.response.StudentResponse;
import com.sucodev.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class StudentController {
    private final StudentService studentService;
    private final LopService lopService;


    @PostMapping("/lops/{lopId}/students")
    public Student createStudent(@PathVariable("lopId") UUID lopId, @RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(lopService.findLopById(lopId), studentRequest);
    }


    @GetMapping("lops/{lopId}/students/{studentId}")
    public StudentResponse findStudentById(@PathVariable("lopId") UUID lopId, @PathVariable("studentId") UUID studentId) {
        return StudentResponse.createStudentResponse(studentService.getStudentByIdAndLopId(lopId, studentId)) ;
    }


    @PatchMapping("lops/{lopId}/students/{studentId}")
    public StudentResponse updateStudent(@PathVariable("lopId") UUID lopId, @PathVariable("studentId") UUID studentId, @RequestBody StudentRequest studentRequest) {
        return StudentResponse.createStudentResponse(studentService.updateStudent(lopId, studentId, studentRequest));
    }


    @DeleteMapping("lops/{lopId}/students/{studentId}")
    public void deleteStudent(@PathVariable("lopId") UUID lopId, @PathVariable("studentId") UUID studentId) {
        studentService.deleteStudent(lopId, studentId);
    }


    @GetMapping("lops/{lopId}")
    public List<Student> findAllByLopId(@PathVariable("lopId") UUID lopId) {
        return studentService.findAllStudentsByLopId(lopId);
    }
}
