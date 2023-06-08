package com.backend.collab_backend.student.skill;

import java.util.List;

public interface SkillService {
  List<String> getAllSkills();
  List<String> searchSkill(String searchStr);
  String addSkill(String skill);
  void deleteSkill(String skill);
  String updateSkill(String skill, String newName);

}
