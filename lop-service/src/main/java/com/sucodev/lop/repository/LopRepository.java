package com.sucodev.lop.repository;

import com.sucodev.lop.domain.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LopRepository extends JpaRepository<Lop, UUID> {
}
