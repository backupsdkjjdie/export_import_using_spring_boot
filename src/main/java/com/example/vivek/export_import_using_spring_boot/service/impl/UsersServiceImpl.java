package com.example.vivek.export_import_using_spring_boot.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.vivek.export_import_using_spring_boot.entity.Users;
import com.example.vivek.export_import_using_spring_boot.event.ExportDataEvent;
import com.example.vivek.export_import_using_spring_boot.io.writter.ExportWritterFactory;
import com.example.vivek.export_import_using_spring_boot.io.writter.UsersDataExportWritter;
import com.example.vivek.export_import_using_spring_boot.model.UsersDTO;
import com.example.vivek.export_import_using_spring_boot.model.UsersExportDTO;
import com.example.vivek.export_import_using_spring_boot.repository.UsersRepository;
import com.example.vivek.export_import_using_spring_boot.service.UsersService;
import com.example.vivek.export_import_using_spring_boot.util.FileUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
	private ApplicationEventPublisher eventPublisher;

    @Override
    public int saveUser(UsersDTO usersDTO) {
        Users user = new Users();
        BeanUtils.copyProperties(usersDTO, user);
        usersRepository.save(user);
        return user.getId();
    }

    @Override
    public List<Integer> saveDummyUsers(int numOfDummyUsers) {
        if (numOfDummyUsers <= 0)
            return new ArrayList<>();
        List<Integer> idsCreated = new ArrayList<>();
        for (int i = 0; i < numOfDummyUsers; i++) {
            Users users = Users.builder()
                    .name("User " + i)
                    .nickname("Nickname" + (i % 5))
                    .favFood(i % 2 == 0 ? "Pizza" : "Sushi")
                    .isGraduated(i % 3 == 0 ? "Yes" : "No")
                    .passingGraduationYear(new Date())
                    .favSong("Song " + (i + 10))
                    .favSports("Sports " + (i % 3 == 0 ? "Football" : "Basketball"))
                    .hasSportsCar(i % 2 == 0)
                    .dreamDestination("Destination " + (i * 2))
                    .build();

            usersRepository.save(users);
            idsCreated.add(users.getId());

        }
        return idsCreated;
    }

    @Override
    public UsersDTO getUser(int id) {
        Optional<Users> userOptional = usersRepository.findById(id);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            UsersDTO usersDTO = new UsersDTO();
            BeanUtils.copyProperties(user, usersDTO);
            return usersDTO;
        } else {
            return new UsersDTO();
        }
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> listOfUsers = usersRepository.findAll();
        List<UsersDTO> listOfUsersDTO = listOfUsers
                .stream()
                .map(users -> UsersDTO.builder()
                        .id(users.getId())
                        .name(users.getName())
                        .nickname(users.getNickname())
                        .favFood(users.getFavFood())
                        .isGraduated(users.getIsGraduated())
                        .passingGraduationYear(users.getPassingGraduationYear())
                        .favSong(users.getFavSong())
                        .favSports(users.getFavSports())
                        .hasSportsCar(users.isHasSportsCar())
                        .dreamDestination(users.getDreamDestination())
                        .build())
                .collect(Collectors.toList());
        return listOfUsersDTO;

    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById(id);
    }

    @Override
    public String export_data() {
        ExportDataEvent event = new ExportDataEvent();
        eventPublisher.publishEvent(event);
        return "export has been started";
    }
    

    @Override
    public String exportUsersDataAsync() {
        String fileName = null;
        int pageId = 0;
        int limit = 100;
        boolean isFullyExport = false;
		try {
			fileName = FileUtil.createTempFile("xls");
		} catch (IOException e1) {
			return null;
		}
        UsersDataExportWritter writter = (UsersDataExportWritter)new ExportWritterFactory<UsersExportDTO>().getExportFile(ExportWritterFactory.EXPORT_TYPE_USERS_DATA, fileName);
        log.info("export_users_data_started");
        do {
            List<UsersExportDTO> exportDTOList = getUsersDataExport(limit, pageId*limit);
            if(exportDTOList.size() == 0) break;
            if(exportDTOList == null || exportDTOList.isEmpty() || exportDTOList.size() < limit){
                isFullyExport = true;
            }
            log.info("pageId::::"+pageId+" , size:::"+limit);
            writter.exportToExcel(exportDTOList);
            pageId+=1;
        } while (!isFullyExport);
        log.info("export_users_data_ended");
        if (writter != null) {
			writter.close();
		}

		return (fileName);
    }

    private List<UsersExportDTO> getUsersDataExport(int limit, int offset) {
        return usersRepository.getUsersDataExportDTO(limit, offset);
    }
}
