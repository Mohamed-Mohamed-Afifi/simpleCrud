package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 50, unique = true)
    private String email;
    private int age;
    @Column(length = 15)
    private String phone;

    public User(String name, String email, int age, String phone) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }
}
