package com.collab.buddy.CollabBuddy.doubles;

import com.collab.buddy.CollabBuddy.teacher.Teacher;
import com.collab.buddy.CollabBuddy.teacher.TeacherService;

import java.util.List;

public class DummyTeacherService implements TeacherService {
    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public Teacher getTeacherByTeacherId(Long id) {
        return null;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
    }
}
