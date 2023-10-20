package com.example.vivek.export_import_using_spring_boot.io.writter;

import java.util.List;

import com.example.vivek.export_import_using_spring_boot.model.UsersExportDTO;

public class UsersDataExportWritter implements ExportWritter<UsersExportDTO>{

    ExportXlsView exportXls;
    UsersDataExportWritter(String fileName){
        exportXls = new ExportXlsView(fileName);
    }
    @Override
    public void exportToExcel(List<UsersExportDTO> data) {
        exportXls.writeToExcel(data);
    }

    public void close() {
        if (exportXls != null) {
            exportXls.finishWriting();
        }
    }
    
}
