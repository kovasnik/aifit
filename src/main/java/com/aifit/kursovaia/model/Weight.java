package com.aifit.kursovaia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "weight")
@Data
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "weight")
    private int weight ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Consumer client;

}
