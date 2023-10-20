package com.example.vivek.export_import_using_spring_boot.model;

import java.util.Date;

import com.example.vivek.export_import_using_spring_boot.annotation.ExcelValue;

import lombok.Data;

@Data
public class UsersExportDTO {
    @ExcelValue(name = "id", position = 0)
    private int id;
    @ExcelValue(name = "name", position = 1)
    private String name;
    @ExcelValue(name = "nick name", position = 2)
    private String nickname;
    @ExcelValue(name = "fav food", position = 3)
    private String favFood;
    @ExcelValue(name = "is-graduated", position = 4)
    private String isGraduated;
    @ExcelValue(name = "passing graduation year", position = 5)
    private Date passingGraduationYear;
    @ExcelValue(name = "fav song", position = 6)
    private String favSong;
    @ExcelValue(name = "fav sports", position = 7)
    private String favSports;
    @ExcelValue(name = "has sports car", position = 8)
    private String hasSportsCar;
    @ExcelValue(name = "dream destination", position = 9)
    private String dreamDestination;

}


