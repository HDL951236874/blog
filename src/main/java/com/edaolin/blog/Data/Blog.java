package com.edaolin.blog.Data;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Blog {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title", nullable = true, columnDefinition = "TEXT")
    private String title;

    @Column(name = "text", nullable = true, columnDefinition = "TEXT")
    private String text;

    @Column(name = "date_create", nullable = true)
    private Date dateCreated;

    @Column(name = "date_update", nullable = true)
    private Date dateUpdated;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pics", referencedColumnName = "id")
    private List<Pic> pics = new ArrayList<>();

}
