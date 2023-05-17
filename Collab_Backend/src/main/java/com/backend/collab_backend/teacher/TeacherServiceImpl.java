package com.backend.collab_backend.teacher;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository teacherRepository;

  @Override
  public List<TeacherDTO> getAllTeachers() {
    List<Teacher> teacherList = teacherRepository.findAll();
    List<TeacherDTO> teacherDTOList = new ArrayList<>();
    for (Teacher teacher : teacherList){
      TeacherDTO teacherDTO = new TeacherDTO();
      teacherDTO.setFirstName(teacher.getFirstName());
      teacherDTO.setLastName(teacher.getLastName());
      teacherDTO.setEmail(teacher.getEmail());
      teacherDTO.setCourses(teacher.getCourses());
    }
    return teacherDTOList;
  }

  @Override
  public TeacherDTO getTeacherByTeacherId(Long id) {
    Teacher teacher =  teacherRepository.findById(id)
            .orElseGet(Teacher::new);
    TeacherDTO teacherDTO = new TeacherDTO();
    teacherDTO.setFirstName(teacher.getFirstName());
    teacherDTO.setLastName(teacher.getLastName());
    teacherDTO.setEmail(teacher.getEmail());
    teacherDTO.setCourses(teacher.getCourses());
    return teacherDTO;
  }

  @Override
  public ResponseEntity<String> createTeacher(TeacherDTO teacher) {
    Teacher teacherToBSaved = new Teacher();
    teacherToBSaved.setFirstName(teacher.getFirstName());
    teacherRepository.save(teacherToBSaved);
    return ResponseEntity.ok("Created teacher: "+teacher);
  }

  @Override
  public ResponseEntity<TeacherDTO> updateTeacher(Long id, TeacherDTO teacher) {
    Teacher teacherToUpdate = teacherRepository.findById(id)
            .orElseGet(Teacher::new);

    teacherToUpdate.setFirstName(teacher.getFirstName());
    teacherToUpdate.setLastName(teacher.getLastName());
    teacherToUpdate.setAge(teacher.getAge());
    teacherToUpdate.setEmail(teacher.getEmail());
    teacherToUpdate.setCourses(teacher.getCourses());
    teacherRepository.save(teacherToUpdate);
    return ResponseEntity.ok(teacher);
  }

  @Override
  public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
  }
}
