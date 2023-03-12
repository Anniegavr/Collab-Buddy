<template>
  <div id="app">
    <div id="burger"
         :class="{ 'active' : isBurgerActive }"
         @click.prevent="toggle">
      <slot>
        <button type="button" class="burger-button" title="Menu">
          <span class="burger-bar burger-bar--1"></span>
          <span class="burger-bar burger-bar--2"></span>
          <span class="burger-bar burger-bar--3"></span>
        </button>
      </slot>
    </div>
  </div>

</template>

<script>
export default {
  name: "SlideMenu",
  data: () => ({
    isBurgerActive: false
  }),
  methods: {
    toggle() {
      this.isBurgerActive = !this.isBurgerActive
    }
  }
}
</script>
<style>
.hidden {
  visibility: hidden;
}

button {
  cursor: pointer;
}

/* remove blue outline */
button:focus {
  outline: 0;
}
#burger {
  position: absolute;
  top: 2%;
  height: 15%;
}
.burger-button {
  position: absolute;
  height: 100%;
  display: block;
  z-index: 999;
  border: 0;
  border-radius: 0;
  background-color: transparent;
  pointer-events: all;
  transition: transform .6s cubic-bezier(.165,.84,.44,1);
  transform-origin: left center;
}

.burger-bar {
  background-color: #d2c4c4;
  position: absolute;

  height: 7%;
  margin-left: 20%;
  width: 500%;
  margin-top: -1px;
  transition: transform .6s cubic-bezier(.165,.84,.44,1),opacity .3s cubic-bezier(.165,.84,.44,1),background-color .6s cubic-bezier(.165,.84,.44,1);
}

.burger-bar--1 {
  -webkit-transform: translateY(-9px);
  transform: translateY(-10px);
}

.burger-bar--2 {
  transform-origin: 100% 50%;
  transform: scaleX(.95);
}

.burger-button:hover .burger-bar--2 {
  transform: scaleX(1);
}

.no-touchevents .burger-bar--2:hover {
  transform: scaleX(1);
}

.burger-bar--3 {
  transform: translateY(9px);
}

#burger.active .burger-button {
  transform: rotate(-360deg);
}

#burger.active .burger-bar {
  background-color: #fff;
}

#burger.active .burger-bar--1 {
  transform: rotate(-45deg)
}

#burger.active .burger-bar--2 {
  opacity: 0;
}

#burger.active .burger-bar--3 {
  transform: rotate(45deg)
}
</style>