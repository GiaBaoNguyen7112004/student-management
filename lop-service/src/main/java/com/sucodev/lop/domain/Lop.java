package com.sucodev.lop.domain;


import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }
}
