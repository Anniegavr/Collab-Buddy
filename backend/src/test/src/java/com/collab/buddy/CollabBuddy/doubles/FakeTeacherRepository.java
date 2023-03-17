package com.collab.buddy.CollabBuddy.doubles;

import com.collab.buddy.CollabBuddy.teacher.Teacher;
import com.collab.buddy.CollabBuddy.teacher.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeTeacherRepository implements TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    @Override
    public <S extends Teacher> S save(S entity) {
        teachers.add(entity);
        return entity;
    }

    @Override
    public List<Teacher> findAll() {
        return teachers;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    // other methods not shown for brevity
}