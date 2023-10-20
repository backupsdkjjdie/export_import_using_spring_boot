package com.example.vivek.export_import_using_spring_boot.repository;

import java.util.List;

import com.example.vivek.export_import_using_spring_boot.model.UsersExportDTO;

public interface UsersBaseRepository {
     List<UsersExportDTO> getUsersDataExportDTO(int limit, int offset);
}
