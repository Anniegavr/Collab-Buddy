<template>
  <div id="app">
    <div class="course_image_box">
      <img src="./assets/mascot/hawk.svg" alt="Course Image">
    </div>
    <div class="course_info">
      <p>Taught by {{teacher}}</p>
      <p>Year: {{year}}</p>
      <p>Group(s): {{groups}}</p>
      <p>Skills gained: {{skills}}</p>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: "CourseOverview",
  data() {
    return {
      teacher: '',
      year: '',
      groups: '',
      skills: '',
    }
  },
  methods: {
    fetchCourseInfo() {

    }
  }
}
</script>

<style scoped>
.course_image_box {
  position: absolute;
  width: 432px;
  height: 444px;
  left: 139px;
  top: 148px;

  mix-blend-mode: normal;
  box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
}

</style>