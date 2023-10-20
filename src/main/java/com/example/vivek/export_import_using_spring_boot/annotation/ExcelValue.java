package com.example.vivek.export_import_using_spring_boot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelValue {

	/**
	 * Header name associated with this field name.
	 */
	String name() default "";

	/**
	 * column position to write to excel.
	 */
	int position();
}