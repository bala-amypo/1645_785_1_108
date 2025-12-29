// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import lombok.Data;
// // import lombok.AllArgsConstructor;
// // import lombok.NoArgsConstructor;
// // import jakarta.validation.constraints.NotBlank;
// // import jakarta.validation.constraints.Size;
// // import jakarta.validation.constraints.Email;

// // @Entity
// // @Data
// // @AllArgsConstructor
// // @NoArgsConstructor
// // public class User {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String fullName;

// //     @Column(unique = true)
// //     @Email
// //     private String email;
// //     @Size(min=8)
// //     private String password;
// //     @NotBlank
// //     private String role;
// // }
// package com.example.demo.model;

// import lombok.Data;
// import jakarta.persistence.*;
// @Data
// @Entity
// @Table(name = "users")
// public class User {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;

//  private String fullName;

//  @Column(unique = true)
//  private String email;

//  private String password;

//  private String role;

//  public User() {}

//  public User(Long id, String fullName, String email,
//  String password, String role) {
//   this.id = id;
//   this.fullName = fullName;
//   this.email = email;
//   this.password = password;
//   this.role = role;
//  }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role; // ADMIN, EVENT_MANAGER, PRICING_ANALYST
}
