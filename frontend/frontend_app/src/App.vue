<template>
  <div>
    <NavigationBar :title="pageTitle"/>
    <SlideMenu v-if="showSlideMenu" />
    <router-view />
  </div>
</template>

<script>
import NavigationBar from "@/components/NavigationBar.vue";
import SlideMenu from '@/components/SlideMenu.vue'

export default {
  name: 'App',
  components: {
    NavigationBar,
    SlideMenu
  },
  // data() {
  //   showSlideMenu: false
  // },
  computed: {
    pageTitle() {
      switch (this.$route.path) {
        case '/login':
          return 'Login';
        case '/signup':
          return 'Sign Up';
        case '/home':
          return 'Home';
        case '/release_assignment':
          return 'Release Assignment';
        case '/profile':
          return 'Profile';
        case '/all_courses':
          return 'All Courses';
        case '/course_overview':
          return 'Course Overview';
        case '/assignment_progress':
          return 'Assignments Progress';
        case '/menu':
          return 'Slide Menu';
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

<!--<style>-->
<!--#app {-->
<!--  font-family: Avenir, Helvetica, Arial, sans-serif;-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  -moz-osx-font-smoothing: grayscale;-->
<!--  text-align: center;-->
<!--  color: #2c3e50;-->
<!--  margin-top: 12%;-->
<!--}-->
<!--</style>-->
