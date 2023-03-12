<template>
  <nav id="menu">
    <SlideMenu id="ham-menu"/>
    <p id="menu-title">{{ title }}</p>

  </nav>
</template>

<script>
export default {
  name: "NavigationBar",
  props: {
    title: {
      type: String,
      required: true
    }
  },
  methods: {
    toggleMenu() {
      // emit an event to toggle the visibility of the slide menu
      this.$emit('showSlideMenu');
    }
  }
}
</script>

<style>
#ham-menu{
  position: absolute;
  max-width: 62px;
  left: 4%;
  top: 10%;
  color: #ffffff;
  cursor: pointer;
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