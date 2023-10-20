package com.example.vivek.export_import_using_spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vivek.export_import_using_spring_boot.model.UsersDTO;
import com.example.vivek.export_import_using_spring_boot.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UsersDTO usersDTO) {
        int id = usersService.saveUser(usersDTO);
        return new ResponseEntity<>("user created successfully with id : " + id, HttpStatus.CREATED);
    }

    @PostMapping("/create-dummy")
    public ResponseEntity<List<Integer>> createDummyUsers(@RequestParam int numOfDummyUsers){
        List<Integer> ids = usersService.saveDummyUsers(numOfDummyUsers);
        return new ResponseEntity<>(ids,HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> usersDTOs = usersService.getAllUsers();
        return new ResponseEntity<>(usersDTOs, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UsersDTO> getById(@PathVariable Integer id) {
        UsersDTO usersDTO = usersService.getUser(id);
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        usersService.delete(id);
        return new ResponseEntity<>("user with id = " + id + " is deleted successfully.", HttpStatus.OK);
    }

    @PostMapping("/export_data")
    public ResponseEntity<?> exportData(){
        String responsemsg = usersService.export_data();
        return new ResponseEntity<>(responsemsg,HttpStatus.OK);
    }
}
