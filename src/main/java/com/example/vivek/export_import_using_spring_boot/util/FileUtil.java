package com.example.vivek.export_import_using_spring_boot.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static String createTempFile(String suffix) throws IOException {
		suffix = suffix.startsWith(".") ? suffix : ("." + suffix);
		String fileName = RequestIdGenerator.generate().replace("-", "");
		return (File.createTempFile(fileName, suffix).getAbsolutePath());
	}
}
