package com.backend.collab_backend.student.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/admin/skill_types")
public class SkillController {
  private final SkillService skillService;
  @GetMapping("/all")
  public ResponseEntity<List<String>> getAllSkillTypes() {
    List<String> allSkills = skillService.getAllSkills();
    return ResponseEntity.ok(allSkills);
  }

  @GetMapping("/all/search")
  public ResponseEntity<List<String>> searchSkill(@RequestBody String skillType) {
    List<String> foundMatching = skillService.searchSkill(skillType);
    return ResponseEntity.ok(foundMatching);
  }

  @DeleteMapping("/delete/{skillName}")
  public ResponseEntity<HttpStatus> deleteSkill(@PathVariable("skillName") String skillName) {
    skillService.deleteSkill(skillName);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/{skillName}")
  public ResponseEntity<String> updateSkill(@PathVariable("skillName") String skillName, @RequestBody String newName) {
    return ResponseEntity.ok(skillService.updateSkill(skillName, newName));
  }

}
