package com.example.vivek.export_import_using_spring_boot.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;
    @Column(name = "fav_food")
    private String favFood;
    @Column(name = "is_graduated")
    private String isGraduated;
    @Column(name = "passing_graduation_year")
    private Date passingGraduationYear;
    @Column(name = "fav_song")
    private String favSong;
    @Column(name = "fav_sports")
    private String favSports;
    @Column(name = "has_sports_car")
    private boolean hasSportsCar;
    @Column(name = "dream_destination")
    private String dreamDestination;
}
