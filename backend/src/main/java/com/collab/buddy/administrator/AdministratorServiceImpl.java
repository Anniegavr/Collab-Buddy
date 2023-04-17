package com.collab.buddy.administrator;
import com.collab.buddy.config.role.ERole;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministratorServiceImpl implements AdministratorService{
    private final AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public AdministratorDTO getAdministratorByAdministratorId(Long id) {
        Administrator administrator = new Administrator();
        Optional<Administrator> administratorToFind = administratorRepository.findById(id);
        if (administratorToFind.isPresent()){
            administrator = administratorToFind.get();
        }
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.name = administrator.getFirstName()+' '+administrator.getLastName();
        administratorDTO.specialty = administrator.getSpecialty();
        administratorDTO.email = administrator.getEmail();
        administratorDTO.eRole = ERole.ADMIN;
        return administratorDTO;
    }

    @Override
    public AdministratorDTO createAdministrator(Administrator administrator) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        Administrator administrator1 = administratorRepository.save(administrator);
        administratorDTO.name = administrator1.getFirstName() + administrator1.getLastName();
        administratorDTO.eRole = ERole.ADMIN;
        administratorDTO.email = administrator1.getEmail();
        administratorDTO.specialty = administrator1.getSpecialty();
        return administratorDTO;
    }

    public AdministratorDTO updateAdministrator(Administrator administratorToUpd) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        Optional<Administrator> administrator = administratorRepository.findAdministratorById(administratorToUpd.getId());
        if (administrator.isPresent()){
            administratorRepository.updateAdministrator(
                    administratorToUpd.getId(),
                    administratorToUpd.getUsername(),
                    administratorToUpd.getEmail(),
                    administratorToUpd.getPassword()
            );
            Optional<Administrator> administrator1 = administratorRepository.findAdministratorById(administratorToUpd.getId());
            if (administrator1.isPresent()){
                administratorDTO.name = administrator1.get().getUsername();
                administratorDTO.email = administrator1.get().getEmail();
                administratorDTO.specialty = administrator1.get().getSpecialty();
                administratorDTO.eRole = ERole.ADMIN;

                return administratorDTO;
            }
        }
        return administratorDTO;
    }

    @Override
    public ResponseEntity.BodyBuilder deleteAdministrator(Long id) {
        Optional<Administrator> administrator = administratorRepository.findAdministratorById(id);
        administrator.ifPresent(administratorRepository::delete);
        return ResponseEntity.ok();
    }
}
