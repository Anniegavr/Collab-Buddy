<template>
  <div class="teacher-panel" onload="loadContent()">
    <div class="teacher-panel-grid">
      <router-link to="/teacher_admin" class="teacher-panel-item">
        <h2>My Released Assignments</h2>
      </router-link>
      <router-link to="/users" class="teacher-panel-item">
        <h2>My Negotiations Status</h2>
      </router-link>
      <router-link to="/students" class="teacher-panel-item">
        <h2>All Students</h2>
      </router-link>
      <router-link to="/teacher/teachers" class="teacher-panel-item">
        <h2>All Teachers</h2>
      </router-link>
      <router-link to="/teacher/skill_types" class="teacher-panel-item">
        <h2>All Skill Types</h2>
      </router-link>
      <router-link to="/teacher/assignment-types" class="teacher-panel-item">
        <h2>All Assignment Types</h2>
      </router-link>
      <router-link to="/teacher/student_groups" class="teacher-panel-item">
        <h2>All Groups</h2>
      </router-link>
      <router-link to="/teacher/negotiations" class="teacher-panel-item">
        <h2>Assignment Negotiations</h2>
      </router-link>
      <router-link to="/teacher/schedule-config" class="teacher-panel-item">
        <h2>Student Schedule Config</h2>
      </router-link>

    </div>
  </div>
</template>

<script lang="ts">
import TotalRequests from "./TotalRequests.vue";
export default {

  name: 'TeacherPanel',
  components: {
    TotalRequests
  },
  methods: {
    loadContent() {
      window.location.reload()
    }
  }
};
</script>

<style>
@import "./style/common_table.css";

.teacher-panel-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 20px;
}

.teacher-panel-item {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #bfbed7;
  border: 1px solid #330b0b;
  border-radius: 10px;
  padding: 20px;
  text-align: center;
  transition: transform 0.3s;
  box-shadow: 0px 8px 11px -2px rgba(0, 0, 0, 0.5);
}

.teacher-panel-item:hover {
  transform: translateY(-5px);
  box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
}
</style>