<template>
  <nav id="menu">
    <router-link to="/" class="home-link">
      <img class="menu_icon" src="./icons/homeIcon.png" alt="Home">
    </router-link>
    <router-link to="/">
      <icon-home class="home_icon"></icon-home>
    </router-link>

    <img src="./assets/nav/search.svg" alt="search_icon" class="search_icon">
    <p id="menu-title">{{title}}</p>

  </nav>
</template>

<script setup lang="ts">
import { defineProps } from 'vue'
import IconHome from "./icons/IconHome.vue";
const props = defineProps({
  title: {
    type: String,
    required: true
  }
})
</script>

<style scoped lang="scss">
.home-link {
  display: inline-block;
}

.search_icon {
  position: absolute;
  width: fit-content;
  height: fit-content;
  max-height: 40%;
  right: 12%;
  top: 30%;
  float: right;
  cursor: pointer;
}
.home_icon {
  float: right;
  z-index: 1;
  color: #ffffff;
  top: 30%;
  right:5%;
  position: absolute;
  cursor: pointer;
}
.menu_icon {
  max-height: 100%;
  float: left; /* Add a float to move the home icon to the left */
  position: absolute;
  max-width: 62px;
  left: 4%;
  top: 30%;
  color: #ffffff;
  cursor: pointer;
  z-index: 2;
}
#menu {
  position: absolute;
  width: 100%;
  height: 5rem;
  left: 0;
  top: -2px;
  align-items: initial;

  background: linear-gradient(180deg, rgba(18, 32, 46, 0.95) 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
  box-shadow: 0 13px 4px rgba(0, 0, 0, 0.18);
  border-radius: 0;

  text-align: center; /* center the menu-title */
}

#menu-title {
  position: relative;
  z-index: 1;
  display: inline-grid; /* display as inline-block to center */
  width: fit-content;
  height: available;

  font-family: 'Open Sans',sans-serif;
  font-style: normal;
  font-weight: 700;
  font-size: 33px;
  line-height: 50%;
  color: #FFFFFF;
}
</style>