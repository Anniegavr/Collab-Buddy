<template>
  <div>
    <NavigationBar :title="pageTitle"/>
<!--    <SlideMenu v-if="showSlideMenu" />-->
    <FloatingMenuButton/>
    <router-view />
  </div>
</template>

<script>
import NavigationBar from "./components/NavigationBar.vue";
import FloatingMenuButton from "./components/FloatingMenuButton.vue";
export default {
  name: 'App',
  components: {
    NavigationBar,
    FloatingMenuButton
  },
  data() {
  //   showSlideMenu: false
  },
  computed: {
    pageTitle() {
      switch (this.$route.path) {
        case '/login':
          return 'Login';
        case '/signup':
          return 'Sign Up';
        case '/home':
          return 'Home';
        case '/users':
          return "All Users"
        case '/teachers':
          return "All Teachers";
        case '/admin':
          return 'Administration Panel';
        case '/release_assignment':
          return 'Release Assignment';
        case '/profile':
          return 'Profile';
        case '/skill_types':
          return 'Skill Types';
        case '/assignment-types':
          return "Assignment Types";
        case '/all_courses':
          return 'All Courses';
        case '/course_overview':
          return 'Course Overview';
        case '/assignment_progress':
          return 'Assignments Progress';
        case '/add_groups':
          return 'Add Group';
        case '/add_student':
          return 'Add Student';
        case '/menu':
          return 'Slide Menu';
        case '/students':
          return 'All Students';
        case '/groups':
          return 'All Groups';
        case '/negotiations':
          return 'Pending Negotiations';
        case '/schedule_config':
          return 'Schedule Configuration';
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
  margin-top: 12%;
}
</style>