package com.example.restapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laptop")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    @NonNull
    private String model;

    @Column(name = "price")
    @NonNull
    private int price;
}
