package com.sucodev.student.domain;

import com.sucodev.lop.domain.Lop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue private UUID id;


    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "lop_id")
    private Lop lop;
}

