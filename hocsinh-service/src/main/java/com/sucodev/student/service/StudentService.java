package com.sucodev.student.service;


import com.sucodev.lop.domain.Lop;
import com.sucodev.student.domain.Student;
import com.sucodev.student.payload.request.StudentRequest;


import java.util.List;
import java.util.UUID;


public interface StudentService {
    Student createStudent(Lop lop, StudentRequest studentRequest);
    Student getStudentByIdAndLopId(UUID lopId, UUID studentId);
    Student updateStudent(UUID lopId, UUID studentId, StudentRequest studentRequest);
    void deleteStudent(UUID lopId, UUID studentId);
    List<Student> findAllStudentsByLopId(UUID lopId);
}
