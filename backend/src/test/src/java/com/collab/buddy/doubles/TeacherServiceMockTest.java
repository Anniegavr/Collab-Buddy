package com.collab.buddy.doubles;

import com.collab.buddy.teacher.Teacher;
import com.collab.buddy.teacher.TeacherRepository;
import com.collab.buddy.teacher.TeacherService;
import com.collab.buddy.teacher.TeacherServiceImpl;
import com.collab.buddy.teacher.TeacherRepository;
import com.collab.buddy.teacher.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;

class TeacherServiceMockTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherServiceImpl teacherService;

    @Test
    void testUpdateTeacher() {
        // Create a mock TeacherRepository
        TeacherRepository teacherRepositoryMock = mock(TeacherRepository.class);

        // Create a TeacherService with the mock repository
        teacherService = new TeacherServiceImpl(teacherRepositoryMock);

        // Define the behavior of the mock repository's findById method
        Teacher teacher = new Teacher();
        when(teacherRepositoryMock.findById(1L)).thenReturn(Optional.of(teacher));

        // Call the updateTeacher method on the TeacherService
        Teacher updatedTeacher = new Teacher();
        teacherService.updateTeacher(1L, updatedTeacher);

        // Verify that the findById and save methods were called with the expected arguments
        verify(teacherRepositoryMock).findById(1L);
        verify(teacherRepositoryMock).save(teacher);
    }

}