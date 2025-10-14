package com.abha.prep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    private Long id;
    private String name;
}
