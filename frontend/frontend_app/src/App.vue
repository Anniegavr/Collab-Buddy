<template>
  <div>
    <NavigationBar :title="pageTitle"/>
    <FloatingMenuButton/>
    <router-view />
<!--    <Total-->
  </div>
</template>

<script>
import NavigationBar from "./components/NavigationBar.vue";
import FloatingMenuButton from "./components/FloatingMenuButton.vue";

export default {
  name: 'App',
  components: {
    NavigationBar,
    FloatingMenuButton,

  },
  data() {
  //   showSlideMenu: false
  },
  computed: {
    pageTitle() {
      switch (this.$route.path) {
        case '/':
          return 'Home';
        case '/login':
          return 'Login';
        case '/admin_proxy':
          return 'Admin Panel';
        case '/signup':
          return 'Sign Up';
        case '/home':
          return 'Home';
        case '/users':
          return "All Users"
        case '/teachers':
          return "All Teachers";
        case '/admin':
          return 'Administration Authentication First';
        case '/teacher/release_assignment':
          return 'Release Assignment';
        case '/profile':
          return 'Profile';
        case '/admin/skill-types':
          return 'Skill Types';
        case '/admin/assignment-types':
          return "Assignment Types";
        case '/admin/all_courses':
          return 'All Courses';
        case '/course_overview':
          return 'Course Overview';
        case '/admin/assignment_progress':
          return 'Assignments Progress';
        case '/admin/add_groups':
          return 'Add Group';
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