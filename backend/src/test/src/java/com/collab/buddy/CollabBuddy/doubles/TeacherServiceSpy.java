package com.collab.buddy.CollabBuddy.doubles;

import com.collab.buddy.CollabBuddy.teacher.Teacher;
import com.collab.buddy.CollabBuddy.teacher.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceSpy implements TeacherService {
    private final TeacherService teacherService;
    private final List<Long> teacherIds = new ArrayList<>();

    public TeacherServiceSpy(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Override
    public Teacher getTeacherByTeacherId(Long id) {
        teacherIds.add(id);
        return teacherService.getTeacherByTeacherId(id);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        teacherIds.add(id);
        return teacherService.updateTeacher(id, teacher);
    }

}