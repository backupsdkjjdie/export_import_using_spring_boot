package com.example.vivek.export_import_using_spring_boot.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {
    private int id;
    private String name;
    private String nickname;
    private String favFood;
    private String isGraduated;
    private Date passingGraduationYear;
    private String favSong;
    private String favSports;
    private boolean hasSportsCar;
    private String dreamDestination;
}
