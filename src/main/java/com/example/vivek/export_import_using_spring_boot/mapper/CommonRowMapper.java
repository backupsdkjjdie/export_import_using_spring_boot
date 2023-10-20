package com.example.vivek.export_import_using_spring_boot.mapper;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public interface CommonRowMapper<T> extends RowMapper<T> {
    List<T> getList();
}
