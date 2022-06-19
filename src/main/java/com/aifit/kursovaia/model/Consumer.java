package com.aifit.kursovaia.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "consumer")
@Data
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Collection<Weight> weight;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Collection<Run> runs;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Collection<Training> trainings;

}

