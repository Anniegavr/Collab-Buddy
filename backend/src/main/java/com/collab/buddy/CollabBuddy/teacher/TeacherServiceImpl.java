package com.collab.buddy.CollabBuddy.teacher;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherByTeacherId(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id : " + id));
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher teacherToUpdate = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id : " + id));

        teacherToUpdate.setName(teacher.getName());
        teacherToUpdate.setAge(teacher.getAge());
        teacherToUpdate.setEmail(teacher.getEmail());
        teacherToUpdate.setCourses(teacher.getCourses());

        return teacherRepository.save(teacherToUpdate);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}

