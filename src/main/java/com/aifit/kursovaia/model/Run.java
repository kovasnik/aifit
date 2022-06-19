package com.aifit.kursovaia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "run")
@Data
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "averageSpeed")
    private int averageSpeed;

    @Column(name = "time")
    private String time;

    @Column(name = "distance")
    private int distance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Consumer client;
}
