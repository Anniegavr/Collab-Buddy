<template>
  <div>
    <div class="circle" @click="toggleMenu">
      <div class="plus">+</div>
    </div>
    <div class="menu" :class="{ active: menuActive }">
      <ul>
        <li><router-link to="/students">Students</router-link></li>
        <li><router-link to="/admin/assignment-types">Assignments</router-link></li>
        <li><router-link to="/admin/add_student">Add student</router-link></li>
        <li><router-link to="/teachers">Add teacher</router-link></li>
        <li><router-link to="/admin/skill_types">Add skill</router-link></li>
        <li><router-link to="/admin/assignment-types">Add assignment type</router-link></li>
        <li><router-link to="/admin/add_groups">Add group</router-link></li>
        <li><router-link to="/admin/all_courses">View All Configurations</router-link></li>
        <li><router-link to="/admin">Admin Panel</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        menuActive: false
      };
    },
    methods: {
      toggleMenu() {
        this.menuActive = !this.menuActive;
      }
    }
  };
</script>

<style>
  .circle {
    position: fixed;
    bottom: 30px;
    right: 30px;
    background: radial-gradient(
        50% 50% at 50% 50%,
        #705CA6 0%,
        rgba(92, 66, 162, 0.98) 100%
    );
    width: 135px;
    height: 130px;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    filter: drop-shadow(-5px 8px 5px rgba(0, 0, 0, 0.25));
  }

  .plus {
    font-size: 4rem;
    color: white;
    font-weight: bold;
  }

  .menu {
    position: fixed;
    bottom: 170px;
    right: 30px;
    background-color: white;
    padding: 10px;
    border-radius: 10px;
    display: none;
    filter: drop-shadow(-5px 8px 5px rgba(0, 0, 0, 0.25));
  }

  .menu.active {
    display: block;
  }

  ul {
    list-style: none;
    padding: 0;
    margin: 0;
  }

  li {
    margin-bottom: 10px;
    cursor: pointer;
  }
</style>