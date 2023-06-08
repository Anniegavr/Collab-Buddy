package com.backend.collab_backend.student.skill.accomplishment;

import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccomplishmentServiceImpl implements AccomplishmentService {
  private final AccomplishmentRepository accomplishmentRepository;

  public List<Accomplishment> findByStudent(Long id) {
    return accomplishmentRepository.findAllByStudentId(id);
  }

  public String addAccomplishment(Long studentId, String accomplishment, String skillType) {
    Accomplishment newAcc = new Accomplishment();
    newAcc.setStudentId(studentId);
    newAcc.setSkillType(skillType);
    newAcc.setStudentAccomplishment(accomplishment);
    accomplishmentRepository.save(newAcc);
    return newAcc.getStudentAccomplishment();
  }

  @Override
  public String editAccomplishment(Long studentId, String accomplishment, String newDescr) {
    Optional<Accomplishment> newAcc = accomplishmentRepository.findAccomplishmentByStudentIdAndStudentAccomplishment(studentId, accomplishment);
    if (newAcc.isPresent()) {
      Accomplishment found = newAcc.get();
      found.setStudentId(studentId);
      found.setSkillType(newDescr);
      found.setStudentAccomplishment(accomplishment);
      accomplishmentRepository.save(found);
    }
    return newDescr;
  }
  public void deleteAccomplishment(Long studentId, String accomplishment) {
    Optional<Accomplishment> newAcc = accomplishmentRepository.findAccomplishmentByStudentIdAndStudentAccomplishment(studentId, accomplishment);
    if (newAcc.isPresent()) {
      Accomplishment found = newAcc.get();
      accomplishmentRepository.delete(found);
    }
  }
}
