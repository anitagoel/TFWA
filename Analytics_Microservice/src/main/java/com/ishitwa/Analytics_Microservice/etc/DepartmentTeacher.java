package com.ishitwa.Analytics_Microservice.etc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long key;
    private long departmentId;
    private long teacherId;
}
