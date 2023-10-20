package com.example.vivek.export_import_using_spring_boot.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.vivek.export_import_using_spring_boot.mapper.CommonResultListExtractor;
import com.example.vivek.export_import_using_spring_boot.mapper.UsersDataExportRowMapper;
import com.example.vivek.export_import_using_spring_boot.model.UsersExportDTO;
import com.example.vivek.export_import_using_spring_boot.repository.UsersBaseRepository;

public class UsersRepositoryImpl implements UsersBaseRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    @Override
    public List<UsersExportDTO> getUsersDataExportDTO(int limit, int offset) {
        StringBuilder query = new StringBuilder("select u.id, u.name, u.nickName, u.fav_food, u.is_graduated, " +
                "u.passing_graduation_year, u.fav_song, u.fav_sports, u.has_sports_car, u.dream_destination from users u  limit ");
        query.append(limit);
        query.append(" offset ");
        query.append(offset);
        try {
            UsersDataExportRowMapper rowMapper = new UsersDataExportRowMapper();
            return template.query(query.toString(), new CommonResultListExtractor<>(rowMapper));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return java.util.Arrays.asList();
    }

}
