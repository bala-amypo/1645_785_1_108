// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import jakarta.validation.constraints.Email;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     @Column(unique = true)
//     @Email
//     private String email;
//     @Size(min=8)
//     private String password;
//     @NotBlank
//     private String role;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;
}
