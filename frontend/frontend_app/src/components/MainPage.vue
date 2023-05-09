<template>
<div id="home_content" class="grid" onload="loadContent()">
  <div id="left_part">
    <h1 style="margin-top: 14vh">Today's Schedule</h1>
    <DonutChart class="schedule_graph"></DonutChart>
    <router-link to="/todo" class="common_link">
        To Do
    </router-link>
    <router-link to="/assignment_progress" class="common_link">
        Active Assignments
    </router-link>
    <router-link to="/profile" class="common_link">
        My Profile
    </router-link>
  </div>
  <div id="right_part" class="course-list">
    <div v-for="(course, index) in courses" :key="index" class="course-item">
      <div class="course_image">
        <img alt="Course Image" :src="course.image" class="course_image">
      </div>
      <router-link to="/" class="course_name" style="font-size: large">{{course.name}}</router-link>
    </div>
  </div>
</div>

</template>
<script>
import DonutGraph from "./DonutGraph.vue";
import DonutChart from "./DonutChart.vue";
import axios from "axios";

export default {
  components: {DonutChart, DonutGraph},
  data() {
    return {
      courses: []
    }
  },
  mounted() {
    this.fetchStudentCourses(5)
  },
  methods: {
    fetchStudentCourses(studentId) {
      axios.get("http://localhost:8080/students/".concat(studentId).concat('/courses'))
          .then(response => {
            this.courses = response.data;
            console.log(studentId)
          })
          .catch(error => {
            console.log(error);
          });
    }
  }
}
</script>
<style>
@import "style/general_styles.css";
.grid {
  display: grid;
  grid-template-columns: minmax(0, 1fr);
  justify-content: center;
}

@media (min-width: 768px) {
  .grid {
    grid-template-columns: 1fr 1fr;
  }
}

router-link {
  font-size: large;
  position: relative;
  justify-self: center;
}

@media (min-width: 1024px) {
  .schedule_graph {
    height: 60vh;
    margin-top: 2vh;
    margin-right: 5vw;
    margin-bottom: 1rem;
    mix-blend-mode: initial;

  }

  #right_part {
    width: 100%;
    display: -webkit-flex;
    flex-direction: column;
    gap: 3vh;
    align-items: center;
    margin-top: 14vh;
  }
  .course-item {
    z-index: -1;
  }

  .course_image {
    width: 15vw;
    height: 25vh;
    margin-bottom: 2vh;
    max-height: 30rem;
    mix-blend-mode: normal;
    border-radius: 12px;
    filter: drop-shadow(-11px 15px 4px rgba(0, 0, 0, 0.25));
  }
  .common_link {
    position: relative;
    display: inline-flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-sizing: border-box;

    border-color: #2c3e50;
    width: 14vw;
    height: 4svh;
    border-radius: 12px;
    margin-right: 1vw;
    text-align: center;
    color: #dddddd;
    font-weight: bold;
    font-size: large;
    background: linear-gradient(180deg, #003566 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
    box-shadow: 0 13px 6px rgba(0, 0, 0, 0.18);
  }
}

@media (max-width: 1024px) {
  #left_part {
    max-width: 100%;
    display: flow;
    //alignment: center;
    justify-self: center;
    margin-top: 4vh;
    margin-bottom: 2vh;
  }
  #right_part {
    max-width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
  }
  .schedule_graph {
    min-height: 10%;
    margin-top: 2vh;
    height: 10vh;
    width: fit-content;
    margin-bottom: 30vh;
  }
  .course-item {
    min-height: 20%;
    justify-items: left;
  }

  .course_name {
    margin-top: 10%;
    margin-right: 23%;
  }

  .course_image {
    width: fit-content;
    margin-bottom: 1vh;
    max-height: 10rem;
    mix-blend-mode: normal;
    filter: drop-shadow(-11px 15px 4px rgba(0, 0, 0, 0.25));
  }
  .common_link{
    position: relative;
    display: inline-table;
    list-style: none;
    justify-content: center;
    //align-items: center;
    box-sizing: border-box;

    border-color: #2c3e50;
    width: 35vw;
    height: 2.8svh;
    border-radius: 12px;
    margin-right: 1vw;
    margin-top: 2vh;
    margin-bottom: 0;
    text-align: center;
    color: #dddddd;
    font-weight: bold;
    font-size: large;
    background: linear-gradient(180deg, #003566 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
    box-shadow: 0 13px 6px rgba(0, 0, 0, 0.18);
  }
}


</style>