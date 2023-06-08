package com.backend.collab_backend.student.skill;

import com.backend.collab_backend.student.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
  private final SkillRepository skillRepository;
  private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);

  @Override
  public List<String> getAllSkills() {
    List<String> skills = new ArrayList<>();
    for (Skill skill : skillRepository.findAll()) {
      skills.add(skill.getSkillType());
    }
    logger.info("Get all skills returned [{}] results.", skills.size());
    if (skills.isEmpty()) {
      skills.add("PUBLIC_SPEAKING");
      skills.add("PUBLIC_RELATIONS");
      skills.add("CODING");
      skills.add("CODE_ENGINEERING");
      skills.add("SYSTEM_ENGINEERING");
      skills.add("QA_AND_TESTING");
      skills.add("PROJECT_MANAGEMENT");
    }
    return skills;
  }

  public List<String> searchSkill(String searchStr) {
    List<String> searchResults = new ArrayList<>();
    for (Skill skill : skillRepository.findAllBySkillTypeContainingIgnoreCase(searchStr)) {
      searchResults.add(skill.getSkillType());
    }
    logger.info("Search for skill substring [{}] returned [{}] results.", searchStr, searchResults.size());
    return searchResults;
  }

  public String addSkill(String skill) {
    Skill newSkill = new Skill();
    newSkill.setSkillType(skill);
    skillRepository.save(newSkill);
    logger.info("Saved new skill [{}]", newSkill.getSkillType());
    return skill;
  }

  public void deleteSkill(String skill) {
    Optional<Skill> skillToDelete = skillRepository.findSkillBySkillType(skill);
    skillToDelete.ifPresent(skillRepository::delete);
    logger.info("Deleted skill[{}]", skillToDelete);
  }

  public String updateSkill(String skill, String newName) {
    Optional<Skill> skillToUpdate = skillRepository.findSkillBySkillType(skill);
    if (skillToUpdate.isPresent()) {
      Skill updated = skillToUpdate.get();
      logger.info("Updating skill [{}]...", updated);
      updated.setSkillType(newName);
      skillRepository.save(updated);
      logger.info("Updated to new skill name [{}]", updated.getSkillType());
    }
    return newName;
  }
}
