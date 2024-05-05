package com.application.rest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class Customer implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
     private Long id;
     private String name;
     private String lastname;
     private String email;
     @Column(name = "phone_number")
     private String phoneNumber;
     @Column(name = "created_at")
     private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
