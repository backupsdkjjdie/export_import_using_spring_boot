package com.example.vivek.export_import_using_spring_boot.event.listener;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.vivek.export_import_using_spring_boot.event.ExportDataEvent;
import com.example.vivek.export_import_using_spring_boot.service.UsersService;

@Component
public class AppEventListener {

    @Autowired
    private UsersService usersService;
    @Async
    @EventListener
    public void exportUsersData(ExportDataEvent exportDataEvent){
        String module = "users_data_export";
        String filepath = usersService.exportUsersDataAsync();
        if(!TextUtils.isEmpty(filepath)){
            System.out.println(filepath);
        }
        //now if file is generated then, you can take it from the firebase
    }
}
