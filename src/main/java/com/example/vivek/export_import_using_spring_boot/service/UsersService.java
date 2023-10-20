package com.example.vivek.export_import_using_spring_boot.service;

import java.util.List;

import com.example.vivek.export_import_using_spring_boot.model.UsersDTO;

public interface UsersService {
    public int saveUser(UsersDTO usersDTO);
    public List<Integer> saveDummyUsers(int numOfDummyUsers);
    public UsersDTO getUser(int id);
    public List<UsersDTO> getAllUsers();
    public void delete(int id);
    public String export_data();
    public String exportUsersDataAsync();
}
