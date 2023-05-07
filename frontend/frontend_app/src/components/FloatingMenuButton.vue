<template>
  <div class="all_menu">
    <div class="circle" v-click-outside="closemenu" @click="toggleMenu">
      <div class="plus" style="justify-items: center;">
        <img src="./icons/plus_icon.svg" alt="+" style="height: 6vh; margin-top: 2vh">
      </div>
    </div>
    <div class="menu" :class="{ active: menuActive }">
      <ul>
        <li><router-link to="/students">Students</router-link></li>
        <li><router-link @click="fetchData" to="/admin/assignment-types">Assignment Types</router-link></li>
        <li><router-link @click="fetchData" to="/admin/add_student">Add student</router-link></li>
        <li><router-link @click="fetchData" to="/admin/teachers">Add teacher</router-link></li>
        <li><router-link @click="fetchData" to="/admin/skill_types">Skill Types</router-link></li>
        <li><router-link @click="fetchData" to="/admin/add_skill_types">Add Skill Type</router-link></li>
        <li><router-link @click="fetchData" to="/admin/assignment-types">Add assignment type</router-link></li>
        <li><router-link @click="fetchData" to="/admin/student_groups">Students group</router-link></li>
        <li><router-link @click="fetchData" to="/admin/all_config">View All Configurations</router-link></li>
        <li><router-link @click="fetchData" to="/admin">Admin Panel</router-link></li>
        <li><router-link @click="fetchData" to="/assignment_progress">Active Assignments</router-link></li>
        <li><router-link @click="fetchData" to="/teacher/release_assignment">Release Assignment</router-link></li>
      </ul>

    </div>
  </div>
</template>

<script >
import vClickOutside from "click-outside-vue3"
import Api from "../Api.ts";
export default {
    data() {
      return {
        menuActive: false
      };
    },
    methods: {
      closemenu() {
        this.menuActive = false;
      },
      toggleMenu() {
        this.menuActive = !this.menuActive;
      },
      async fetchData() {
        try {
          const response = await Api.get('/admin');
          console.log(response.data);
        } catch (error) {
          console.error(error);
        }
      },
    }
  };
</script>

<style>
.all_menu {
  z-index: 1;
}
.circle {
  position: fixed;
  bottom: 5vh;
  right: 5vh;
  background: radial-gradient(
      50% 50% at 50% 50%,
      #2c7da0 14%,
      #01497c 86%
  );
  width: 14vh;
  height: 14vh;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  z-index: 1;
  filter: drop-shadow(-5px 8px 5px rgba(0, 0, 0, 0.25));
}

.plus {
  font-size: xxx-large;
  color: white;
  font-weight: bold;
}

.menu {
  position: absolute;
  bottom: 17vh;
  right: 8%;
  background-color: rgba(255, 255, 255, 0.75);
  padding: 1.5%;
  border-radius: 10px;
  display: none;
  filter: drop-shadow(-5px 8px 5px rgba(0, 0, 0, 0.25));
  z-index: 1;

}

.menu.active {
  display: block;
  max-width: fit-content;
  max-height: fit-content;
}

ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

li {
  margin-bottom: 0.5rem;
  cursor: pointer;
  font-size: large;
}
</style>