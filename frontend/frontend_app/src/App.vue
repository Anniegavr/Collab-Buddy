<template>
  <div>
    <NavigationBar :title="pageTitle"/>
    <router-view />
  </div>
</template>

<script>
import NavigationBar from "@/components/NavigationBar.vue";

export default {
  name: 'App',
  components: {
    NavigationBar
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
