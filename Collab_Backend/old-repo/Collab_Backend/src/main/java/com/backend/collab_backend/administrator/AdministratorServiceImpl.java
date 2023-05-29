package com.backend.collab_backend.administrator;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministratorServiceImpl implements AdministratorService{
  private static final Logger logger = LoggerFactory.getLogger(AdministratorServiceImpl.class);
  private final AdministratorRepository administratorRepository;

  @Override
  public List<AdministratorDTO> getAllAdministrators() {
    List<Administrator> administrators = administratorRepository.findAll();
    List<AdministratorDTO> administratorDTOs = new ArrayList<>();
    for (Administrator administrator : administrators) {
      AdministratorDTO administratorDTO = convertRealToDTOAdmin(administrator);
      administratorDTOs.add(administratorDTO);
    }
    return administratorDTOs;
  }

  public AdministratorDTO convertRealToDTOAdmin(Administrator administrator) {
    AdministratorDTO adminDTO = new AdministratorDTO();
    adminDTO.firstName = administrator.getFirstName();
    adminDTO.lastName = administrator.getLastName();
    adminDTO.email = administrator.getEmail();
    adminDTO.age = administrator.getAge();
    adminDTO.role = administrator.getRole();
    adminDTO.secondRole = administrator.getSecondRole();
    adminDTO.thirdRole = administrator.getThirdRole();
    adminDTO.specialty = administrator.getSpecialty();
    return adminDTO;
  }


  @Override
  public Administrator getAdministratorByAdministratorId(Long id) {
    return administratorRepository.findById(id).get();
  }

  @Override
  public Administrator createAdministrator(AdministratorDTO administrator) {
    Administrator administrator1 = convertDTOtoRealAdmin(administrator);
    return administratorRepository.save(administrator1);
  }
  Administrator convertDTOtoRealAdmin(AdministratorDTO administratorDTO) {
    Administrator administrator = new Administrator();
    administrator.setFirstName(administratorDTO.firstName);
    administrator.setLastName(administratorDTO.lastName);
    administrator.setEmail(administratorDTO.email);
    administrator.setSpecialty(administratorDTO.specialty);
    administrator.setAge(administratorDTO.age);
    administrator.setRole(administratorDTO.role);
    administrator.setSecondRole(administratorDTO.secondRole);
    administrator.setThirdRole(administratorDTO.thirdRole);
    administrator.setUsername(administrator.getFirstName().toLowerCase().charAt(0)+administrator.getLastName().toLowerCase());
    return administrator;
  }

  public Administrator updateAdministrator(Long id, int age) {
    return administratorRepository.updateAgeBy(age);
  }

  @Override
  public ResponseEntity.BodyBuilder deleteAdministrator(Long id) {
    administratorRepository.deleteById(id);
    return ResponseEntity.ok();
  }
}
