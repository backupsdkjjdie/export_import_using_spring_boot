package com.example.vivek.export_import_using_spring_boot.event;

import org.springframework.context.ApplicationEvent;

public class ExportDataEvent extends ApplicationEvent{

    public ExportDataEvent() {
        super(new Object());
    }
    
}
