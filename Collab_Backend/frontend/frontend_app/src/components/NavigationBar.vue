<template>
  <div class="menu" :class="{ active: menuActive }" style="z-index: 2">
    <ul>
      <li><button @click="closemenu" class="closeMenuB">X
      </button></li>
      <li><router-link to="/students">Students</router-link></li>
      <li><router-link to="/home">Home</router-link></li>
      <li><router-link to="/profile">Profile</router-link></li>
    </ul>
  </div>
  <div >
    <nav id="menu">
      <v-button class="home-link" @click="toggleMenu">
        <img class="menu_icon" src="./icons/homeIcon.png" alt="Home">
      </v-button>

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


<script>
import { defineProps, ref } from 'vue'
import ProgressIcon from "./icons/ProgressIcon.vue";
import SearchField from "./SearchField.vue";
import IconHome from "./icons/IconHome.vue";

export default {
  name: "NavigationBar",
  props: {
    title: {
      type: String,
      required: true
    }
  },
  computed: {

  },
  data() {
    return {
      menuActive: false,
    }
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
        // const response = await Api.get('/admin');
        // console.log(response.data);
      } catch (error) {
        console.error(error);
      }
    },
  },
  setup(props) {
    const title = ref(props.title);
    return {
      title
    }
  }
}
</script>


<style scoped>
@import "style/general_styles.css";
.closeMenuB {
  font-size: 0.7svw;
  float: right;
  border-width: 3px;
  font-weight: bolder;
  background-color: transparent;
  border-color: #486580;
  box-shadow: 0 3px 4px rgba(0, 0, 0, 0.18);
}
#menu {
  position: fixed;
  top: 0;
  width: 100vw;
  height: 8vh;
  left: 0;
  right: 0;
  //background-image: linear-gradient( 105.3deg,  rgba(30,39,107,1) 21.8%, rgba(77,118,221,1) 100.2% );
  background-image: linear-gradient( 109.6deg,  rgba(41,125,182,1) 3.6%, rgba(77,58,151,1) 51%, rgba(103,55,115,1) 92.9% );
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
  height: 3.5vh;
  color: #ffffff;
  cursor: pointer;
  z-index: 2;
  margin-left: 2vw;
}

.menu {
  position: fixed;
  top: 0;
  bottom: 0vh;
  left: 0;
  background-color: #e4f6fc;
  padding: 1.5%;
  border-radius: 0 10px;
  filter: drop-shadow(-5px 8px 5px rgba(0, 0, 0, 0.25));
  z-index: 2;

}

.menu.active {

  display: block;
  height: 100vh;
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