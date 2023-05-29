package com.backend.collab_backend.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("admin/skill_types")
public class SkillController {
  @GetMapping("/all")
  public ResponseEntity<List<ESkillType>> getAllSkillTypes() {
    return ResponseEntity.ok(getSkillTypesList());
  }

  @GetMapping("/all/find")
  public ResponseEntity<List<ESkillType>> findAllSkillTypes(@RequestBody String skillType) {
    List<ESkillType> foundMatching = getSkillTypesList()
            .stream()
            .filter(skillType1 -> skillType1.name().contains(skillType))
            .collect(Collectors.toList());
    System.out.println("Received search request for string: "+skillType);
    return ResponseEntity.ok(foundMatching);
  }

  private static List<ESkillType> getSkillTypesList() {
    List<ESkillType> skillTypes = new ArrayList<>();
    skillTypes.add(ESkillType.SOFT_SKILL);
    skillTypes.add(ESkillType.TECHNICAL_SKILL);
    skillTypes.add(ESkillType.BUSINESS_LOGIC);

    System.out.println("Received request to see all skill types");
    return skillTypes;
  }

}
