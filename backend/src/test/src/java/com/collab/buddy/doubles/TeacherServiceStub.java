package com.collab.buddy.doubles;

import com.collab.buddy.teacher.Teacher;
import com.collab.buddy.teacher.TeacherService;

import java.util.List;

public class TeacherServiceStub implements TeacherService {
    private final List<Teacher> teachers;

    public TeacherServiceStub(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    @Override
    public Teacher getTeacherByTeacherId(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Teacher not found with id : " + id));
    }

    // other methods not shown for brevity
}
