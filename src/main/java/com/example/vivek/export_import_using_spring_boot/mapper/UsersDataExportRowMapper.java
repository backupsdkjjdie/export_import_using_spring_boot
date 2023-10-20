package com.example.vivek.export_import_using_spring_boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vivek.export_import_using_spring_boot.model.UsersExportDTO;

public class UsersDataExportRowMapper implements CommonRowMapper<UsersExportDTO>{
    List<UsersExportDTO> list = new ArrayList<>();
    @Override
    public UsersExportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersExportDTO dto = bundleUsersData(rs,rowNum);
        list.add(dto);
        return dto;
    }

    private UsersExportDTO bundleUsersData(ResultSet rs, int rowNum) throws SQLException {
        UsersExportDTO dto = new UsersExportDTO();
        dto.setId(rs.getInt("id"));
        dto.setFavFood(rs.getString("fav_food"));
        dto.setDreamDestination(rs.getString("dream_destination"));
        dto.setFavSong(rs.getString("fav_song"));
        dto.setFavSports(rs.getString("fav_sports"));
        // dto.setHasSportsCar(rs.getBoolean("has_sports_car"));
        dto.setHasSportsCar(rs.getString("has_sports_car"));
        dto.setIsGraduated(rs.getString("is_graduated"));
        dto.setName(rs.getString("name"));
        dto.setNickname(rs.getString("nickname"));
        dto.setPassingGraduationYear(rs.getDate("passing_graduation_year"));
        return dto;
    }

    @Override
    public List<UsersExportDTO> getList() {
        return list;
    }
    
}
