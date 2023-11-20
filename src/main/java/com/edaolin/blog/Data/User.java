package com.edaolin.blog.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = true, columnDefinition = "TEXT")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

}
