package com.example.vivek.export_import_using_spring_boot.io.writter;

import java.util.List;

public interface ExportWritter<T> {
    void exportToExcel(List<T> t);
}
