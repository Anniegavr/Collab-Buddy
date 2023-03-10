<template>
  <nav id="menu">
    <p id="menu-title">Courses</p>
  </nav>
</template>

<script>
export default {
  name: "NavigationBar"
}
</script>

<style>
#menu {
  position: absolute;
  width: 100%;
  height: 5rem;
  left: 0;
  top: -2px;

  background: linear-gradient(180deg, rgba(18, 32, 46, 0.95) 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
  box-shadow: 0 13px 4px rgba(0, 0, 0, 0.18);
  border-radius: 0;

  text-align: center; /* center the menu-title */
}

#menu-title {
  position: relative;
  z-index: 1;
  display: inline-block; /* display as inline-block to center */
  width: 343px;
  height: available;

  font-family: 'Open Sans',sans-serif;
  font-style: normal;
  font-weight: 700;
  font-size: 33px;
  line-height: 50%;
  /* identical to box height */

  color: #FFFFFF;
}
</style>