package com.aifit.kursovaia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "training")
@Data
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "intensity")
    private int intensity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Consumer client;
}
