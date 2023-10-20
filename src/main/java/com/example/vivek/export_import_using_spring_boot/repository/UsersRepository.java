package com.example.vivek.export_import_using_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vivek.export_import_using_spring_boot.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, UsersBaseRepository{

    
}
