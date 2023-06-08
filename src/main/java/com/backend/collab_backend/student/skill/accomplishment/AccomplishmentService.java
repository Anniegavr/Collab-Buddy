package com.backend.collab_backend.student.skill.accomplishment;

import java.util.List;

public interface AccomplishmentService {
  List<Accomplishment> findByStudent(Long id);
  String addAccomplishment(Long studentId, String accomplishment, String skillType);
  String editAccomplishment(Long studentId, String accomplishment, String newDescr);
  void deleteAccomplishment(Long studentId, String accomplishment);
}
