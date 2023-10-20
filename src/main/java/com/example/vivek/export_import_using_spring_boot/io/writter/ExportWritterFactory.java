package com.example.vivek.export_import_using_spring_boot.io.writter;

public class ExportWritterFactory<T> {

	public static final int EXPORT_TYPE_USERS_DATA = 1;

	public ExportWritter<?> getExportFile(int exportType, String fileName) {

		switch (exportType) {

			case EXPORT_TYPE_USERS_DATA:
				return new UsersDataExportWritter(fileName);
			default:
				throw new RuntimeException("Invalid export type");
		}

	}
}