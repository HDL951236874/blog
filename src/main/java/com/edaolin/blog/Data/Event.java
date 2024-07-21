package com.edaolin.blog.Data;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "info", nullable = false, columnDefinition = "TEXT")
    private String info;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private EventType type;
    @Column(name = "date", nullable = false)
    private Date date;
}
