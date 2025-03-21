package com.sucodev.student.repository;

import com.sucodev.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findByIdAndLopId(UUID id, UUID lopId);
    List<Student> findByLopId(UUID lopId);
}
