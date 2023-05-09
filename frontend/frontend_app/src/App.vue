<template>
  <NavigationBar :title="pageTitle"/>
  <FloatingMenuButton/>
  <router-view />
</template>

<script lang="ts">
import NavigationBar from "./components/NavigationBar.vue";
import FloatingMenuButton from "./components/FloatingMenuButton.vue";
import "vue-router/dist/vue-router";

export default {
  name: 'App',
  components: {
    NavigationBar,
    FloatingMenuButton,

  },
  data() {
  },
  computed: {
    pageTitle() {
      switch (this.$route.path) {
        case '/':
          return 'Home';
        case '/login':
          return 'Login';
        case '/admin_panel':
          return 'Admin Panel';
        case '/signup':
          return 'Sign Up';
        case '/home':
          return 'Home';
        case '/todo':
          return 'My To Do List'
        case '/users':
          return "All Users"
        case '/admin/teachers':
          return "All Teachers";
        case '/admin':
          return 'Admin Panel';
        case '/teacher/release_assignment':
          return 'Release Assignment';
        case '/profile':
          return 'Profile';
        case '/admin/skill_types':
          return 'Skill Types';
        case '/admin/add_skill_types':
          return 'Add Skill Types';
        case '/admin/assignment-types':
          return "Assignment Types";
        case '/admin/all_courses':
          return 'All Courses';
        case '/schedule_chart':
          return 'Schedule Overview'
        case '/course_overview':
          return 'Course Overview';
        case '/admin/schedule-config':
          return 'Schedule Configuration';
        case '/admin/all_config':
          return 'All Configurations';
        case '/assignment_progress':
          return 'Assignments Progress';
        case '/admin/student_groups':
          return 'Students Group';
        case '/admin/add_student':
          return 'Add Student';
        case '/menu':
          return 'Slide Menu';
        case '/admin/all_students':
          return 'All Students';
        case '/groups':
          return 'All Groups';
        case '/admin/negotiations':
          return 'Pending Negotiations';
        case '/admin/schedule_config':
          return 'Schedule Configuration';
        case '/students':
          return 'All Students'
        default:
          return 'Not a course';
      }
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>