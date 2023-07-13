package com.gradle.prog4.controller.mapper;

import com.gradle.prog4.controller.Employee;
import com.gradle.prog4.model.EmployeeEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Component
public class EmployeeMapper {
    public EmployeeEntity toRest(Employee domain) throws IOException {
        MultipartFile file = domain.getImage();
        byte[] bytes = file.getBytes();
        String image = Base64.getEncoder().encodeToString(bytes);
        return EmployeeEntity.builder()
                .firstname(domain.getFirstname())
                .lastname(domain.getLastname())
                .birthDate(domain.getBirthDate())
                .matricule(domain.getMatricule())
                .image(image)
                .build();
    }

}
