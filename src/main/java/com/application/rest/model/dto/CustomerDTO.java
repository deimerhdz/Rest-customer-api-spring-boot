package com.application.rest.model.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CustomerDTO implements Serializable {

 private Long id;

 @Size(min = 2,max = 25)
 @NotEmpty(message = "name is required")
 private String name;

 @Size(min = 2,max = 25)
 @NotEmpty(message = "lastname is required")
 private String lastname;

 @NotEmpty(message = "Email is required")
 @Email
 private String email;

 private String phoneNumber;
 private LocalDateTime createdAt;

 @Override
 public String toString() {
  return "CustomerDTO{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", lastname='" + lastname + '\'' +
          ", email='" + email + '\'' +
          ", phoneNumber='" + phoneNumber + '\'' +
          ", createdAt=" + createdAt +
          '}';
 }
}
