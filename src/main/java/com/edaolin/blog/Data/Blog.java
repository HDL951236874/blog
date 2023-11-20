package com.edaolin.blog.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "text", nullable = true, columnDefinition = "TEXT")
    private String text;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pics", referencedColumnName = "id")
    private List<Pic> Pics = new ArrayList<>();
}
