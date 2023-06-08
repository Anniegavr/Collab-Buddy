package com.backend.collab_backend.student.skill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
  List<Skill> findAllBySkillTypeContainingIgnoreCase(String skillLiteral);
  Optional<Skill> findSkillBySkillType(String skillName);
}
