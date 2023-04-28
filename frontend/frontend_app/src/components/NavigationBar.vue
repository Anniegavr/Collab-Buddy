<template>
<div >
    <nav id="menu">
      <router-link to="/" class="home-link">
        <img class="menu_icon" src="./icons/homeIcon.png" alt="Home">
      </router-link>

      <p id="menu-title">{{title}}</p>

      <div class="right_icons">
        <router-link to="/">
          <icon-home class="home_icon"></icon-home>
        </router-link>
        <input class="search_field">
        <img src="./assets/nav/search.svg" alt="search_icon" class="search_icon">
        <router-link to="/login"><button style="height: 5vh; justify-content: center; padding: 0.5vh"><img src="./icons/login.png" style="max-height: 4vh"  alt="Auth"></button></router-link>

      </div>
    </nav>
</div>

</template>

<script setup lang="ts">
import { defineProps } from 'vue'
import IconHome from "./icons/IconHome.vue";
import ProgressIcon from "./icons/ProgressIcon.vue";
import SearchField from "./SearchField.vue";
const props = defineProps({
  title: {
    type: String,
    required: true
  }
})
</script>

<style scoped>
@import "style/general_styles.css";
#menu {
  position: fixed;
  top: 0;
  width: 100vw;
  height: 10vh;
  left: 0;
  right: 0;
  background: linear-gradient(180deg, #0582ca 3.9%, #006494 87.46%);
  box-shadow: 0 13px 4px rgba(0, 0, 0, 0.18);
  border-radius: 0;
  display: inline-flex; /* add display flex */
}

#menu-title {
  font-family: 'Open Sans',sans-serif;
  font-style: normal;
  font-weight: 700;
  font-size: 4vh;
  line-height: 50%;
  color: #FFFFFF;
}


.right_icons {
  display: flex; /* add display flex */
  align-items: center; /* add align-items center */
  gap: 1vw;

}

.home-link {
  display: flex; /* add display flex */
  align-items: center; /* add align-items center */
}

.search_icon {
  width: fit-content;
  height: fit-content;
  max-height: 4vh;
  cursor: pointer;
}
.home_icon {
  z-index: 1;
  color: #ffffff;
  cursor: pointer;
}

.menu_icon {
  max-height: 100%;
  height: 5vh;
  color: #ffffff;
  cursor: pointer;
  z-index: 2;
  margin-left: 2vw;
}
</style>