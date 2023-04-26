<template>
<div id="home_content" class="grid">
  <div id="left_part">
    <img src="./assets/mock_graph.png" id="mock_graph">
    <router-link to="/todo">
      <div class="common_link">
        To Do
      </div>
    </router-link>
  </div>
  <div id="right_part" class="course-list">
    <div v-for="(course, index) in courses" :key="index" class="course-item">
      <div class="course_image">
        <img alt="Course Image" src="./assets/computer_science.png" class="course_image">
      </div>
      <router-link to="/" class="course_name" style="font-size: large">{{course.name}}</router-link>
    </div>
  </div>
</div>
</template>
<script lang="ts">
export default {
  data() {
    return {
      courses: [
        {
          name: 'Computer Science',
          image: './assets/computer_science.png'
        },
        {
          name: 'Math',
          image: './assets/math.png'
        },
        {
          name: 'History',
          image: './assets/history.png'
        }
        // {
        //   name: 'History',
        //   image: './assets/history.png'
        // }
      ]
    }
  }
}
</script>

<style>
.grid {
  display: grid;
  grid-template-columns: minmax(0, 1fr);
}

@media (min-width: 768px) {
  .grid {
    grid-template-columns: 1.3fr 0.7fr;
  }
}

router-link {
  font-size: large;
}

@media (min-width: 1024px) {
  #mock_graph {
    min-height: 25%;
    max-height: 50%;
    margin-top: 5%;
    right: 5em;
    margin-bottom: 1rem;
    mix-blend-mode: initial;
  }
  #left_part {
    margin-right: 1rem; /* margin between the two columns */
    max-width: 100%;
    flex-direction: column;
    display: table-row;
    align-items: center;
  }
  #right_part {
    max-width: 100%;
    display: -webkit-flex;
    flex-direction: column;
    align-items: flex-start;
    margin-top: 4rem;
  }
  .course-item {
    min-height: 20%;
  }

  .course_name {
    margin-top: 10%;
    margin-right: 23%;
  }

  .course_image {
    width: 80%;
    max-height: 30rem;
    mix-blend-mode: normal;
    filter: drop-shadow(-11px 15px 4px rgba(0, 0, 0, 0.25));
  }
}

@media (max-width: 1024px) {
  #left_part {
    max-width: 100%;
    display: block;
  }
  #right_part {
    max-width: 100%;
    display: -webkit-flex;
    flex-direction: column;
    align-items: flex-start;
  }
  #mock_graph {
    min-height: 10%;
    max-height: 15%;
    margin-top: 25%;
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
    width: 80%;
    max-height: 10rem;
    mix-blend-mode: normal;
    filter: drop-shadow(-11px 15px 4px rgba(0, 0, 0, 0.25));
  }
}
.common_link {
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-sizing: border-box;

  border-color: #2c3e50;
  width: auto;
  min-width: 9rem;
  max-width: 9rem;
  height: fit-content;
  border-radius: 15px;
  text-align: center;
  color: #dddddd;
  font-weight: bold;
  font-size: large;
  background: linear-gradient(180deg, #003566 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
  box-shadow: 0 13px 6px rgba(0, 0, 0, 0.18);
}

</style>