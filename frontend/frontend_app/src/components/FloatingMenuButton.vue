<template>
  <div class="all_menu">
    <div class="circle" @click="toggleMenu">
      <div class="plus">+</div>
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
        <li><router-link @click="fetchData" to="/admin/add_groups">Add group</router-link></li>
        <li><router-link @click="fetchData" to="/admin/all_config">View All Configurations</router-link></li>
        <li><router-link @click="fetchData" to="/admin">Admin Panel</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script >
import { defineComponent} from "vue";
import Api from "../Api.ts";
export default {
    data() {
      return {
        menuActive: false
      };
    },
    methods: {
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
  bottom: 30px;
  right: 30px;
  background: radial-gradient(
      50% 50% at 50% 50%,
      #705CA6 0%,
      rgba(92, 66, 162, 0.98) 100%
  );
  width: 8em;
  height: 8em;
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
  position: fixed;
  bottom: 11em;
  right: 8%;
  background-color: rgba(255, 255, 255, 0.95);
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