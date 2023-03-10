DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS One_Group;
DROP TABLE IF EXISTS Teachers;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS TeacherToCourse;
DROP TABLE IF EXISTS StudentToCourse;
DROP TABLE IF EXISTS Skill_List;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Assignments_Set;
DROP TABLE IF EXISTS Skill_Set;
DROP TABLE IF EXISTS One_Day_Workload;
DROP TABLE IF EXISTS Subtask;
DROP TABLE IF EXISTS Student_To_Assignment;
DROP TABLE IF EXISTS Administrator;


CREATE TABLE Students (
student_id BIGINT PRIMARY KEY  NOT NULL UNIQUE,
name VARCHAR(100) NOT NULL,
employed BOOLEAN NOT NULL DEFAULT false,
group_id BIGINT NOT NULL);

CREATE TABLE One_Group (
group_id BIGINT PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
free_time_per_day INTEGER NOT NULL);

CREATE TABLE Teachers (
teacher_id BIGINT PRIMARY KEY NOT NULL,
name VARCHAR NOT NULL,
group_id BIGINT NOT NULL);

CREATE TABLE Courses (
course_id BIGINT PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
description VARCHAR NOT NULL);

CREATE TABLE TeacherToCourse (
teacher_id BIGINT NOT NULL,
course_id BIGINT NOT NULL);

CREATE TABLE StudentToCourse (
student_id BIGINT NOT NULL,
course_id BIGINT NOT NULL);

CREATE TABLE Skill_List (
skill_id BIGINT PRIMARY KEY NOT NULL,
skil_description VARCHAR NOT NULL,
public BOOLEAN NOT NULL);

CREATE TABLE Assignments (
assignment_id BIGINT PRIMARY KEY NOT NULL,
due_date DATE NOT NULL,
description BIGINT NOT NULL,
allocated_total_time DOUBLE NOT NULL);

CREATE TABLE Assignments_Set (
group_id BIGINT NOT NULL,
assignment_id BIGINT NOT NULL,
day_id BIGINT NOT NULL);

CREATE TABLE Skill_Set (
student_id BIGINT NOT NULL,
skill_id BIGINT NOT NULL);

CREATE TABLE One_Day_Workload (
day_id BIGINT PRIMARY KEY NOT NULL,
date_of_day DATE NOT NULL,
free_time_left INTEGER NOT NULL,
group_id BIGINT NOT NULL);

CREATE TABLE Subtask (
subtask_id BIGINT PRIMARY KEY NOT NULL,
assignment_id BIGINT NOT NULL,
description VARCHAR(255) NOT NULL);

CREATE TABLE Student_To_Assignment (
student_id BIGINT NOT NULL,
assignment_id BIGINT NOT NULL,
percentage_done INTEGER NOT NULL,
subtask_id BIGINT NOT NULL,
subtask_done BOOLEAN NOT NULL);

CREATE TABLE Administrator (
id BIGINT(15) PRIMARY KEY NOT NULL,
name VARCHAR(15) NOT NULL,
age INT(5) NOT NULL,
email VARCHAR(55) NOT NULL,
specialty VARCHAR(55) NOT NULL,
role VARCHAR(25) NOT NULL);

ALTER TABLE Students ADD CONSTRAINT Students_group_id_One_Group_group_id FOREIGN KEY (group_id) REFERENCES One_Group(group_id);
ALTER TABLE Teachers ADD CONSTRAINT Teachers_group_id_One_Group_group_id FOREIGN KEY (group_id) REFERENCES One_Group(group_id);
ALTER TABLE TeacherToCourse ADD CONSTRAINT TeacherToCourse_teacher_id_Teachers_teacher_id FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id);
ALTER TABLE TeacherToCourse ADD CONSTRAINT TeacherToCourse_course_id_Courses_course_id FOREIGN KEY (course_id) REFERENCES Courses(course_id);
ALTER TABLE StudentToCourse ADD CONSTRAINT StudentToCourse_student_id_Students_student_id FOREIGN KEY (student_id) REFERENCES Students(student_id);
ALTER TABLE StudentToCourse ADD CONSTRAINT StudentToCourse_course_id_Courses_course_id FOREIGN KEY (course_id) REFERENCES Courses(course_id);
ALTER TABLE Assignments_Set ADD CONSTRAINT Assignments_Set_group_id_One_Group_group_id FOREIGN KEY (group_id) REFERENCES One_Group(group_id);
ALTER TABLE Assignments_Set ADD CONSTRAINT Assignments_Set_assignment_id_Assignments_assignment_id FOREIGN KEY (assignment_id) REFERENCES Assignments(assignment_id);
ALTER TABLE Assignments_Set ADD CONSTRAINT Assignments_Set_day_id_One_Day_Workload_day_id FOREIGN KEY (day_id) REFERENCES One_Day_Workload(day_id);
ALTER TABLE Skill_Set ADD CONSTRAINT Skill_Set_student_id_Students_student_id FOREIGN KEY (student_id) REFERENCES Students(student_id);
ALTER TABLE Skill_Set ADD CONSTRAINT Skill_Set_skill_id_Skill_List_skill_id FOREIGN KEY (skill_id) REFERENCES Skill_List(skill_id);
ALTER TABLE One_Day_Workload ADD CONSTRAINT One_Day_Workload_group_id_One_Group_group_id FOREIGN KEY (group_id) REFERENCES One_Group(group_id);
ALTER TABLE Subtask ADD CONSTRAINT Subtask_assignment_id_Assignments_assignment_id FOREIGN KEY (assignment_id) REFERENCES Assignments(assignment_id);
ALTER TABLE Student_To_Assignment ADD CONSTRAINT Student_To_Assignment_student_id_Students_student_id FOREIGN KEY (student_id) REFERENCES Students(student_id);
ALTER TABLE Student_To_Assignment ADD CONSTRAINT Student_To_Assignment_assignment_id_Assignments_assignment_id FOREIGN KEY (assignment_id) REFERENCES Assignments(assignment_id);
ALTER TABLE Student_To_Assignment ADD CONSTRAINT Student_To_Assignment_subtask_id_Subtask_subtask_id FOREIGN KEY (subtask_id) REFERENCES Subtask(subtask_id);
