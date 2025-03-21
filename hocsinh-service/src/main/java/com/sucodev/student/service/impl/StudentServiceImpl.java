package com.sucodev.student.service.impl;


import com.sucodev.lop.domain.Lop;
import com.sucodev.student.domain.Student;
import com.sucodev.student.payload.request.StudentRequest;
import com.sucodev.student.repository.StudentRepository;
import com.sucodev.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Lop lop, StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setLop(lop);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByIdAndLopId(UUID lopId, UUID studentId) {
        return studentRepository.findByIdAndLopId(studentId, lopId);
    }


    @Override
    public Student updateStudent(UUID lopId, UUID studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findByIdAndLopId(studentId, lopId);
        student.setName(studentRequest.getName());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(UUID lopId, UUID studentId) {
        Student student = studentRepository.findByIdAndLopId(studentId, lopId);
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAllStudentsByLopId(UUID lopId) {
        List<Student> students = studentRepository.findByLopId(lopId);
        return students;
    }
}
