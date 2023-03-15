<template>
    <div id="app">
      <!-- Add your menu content here -->
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-6">
<!--          <ScheduleRingChart />-->
        </div>
        <div class="col-md-6">
          <!-- Add your other content here -->
        </div>
      </div>
    </div>
</template>

<script>

export default {
  name: "MainPage",
  components: {
    // ScheduleRingChart,
  },
};
</script>

<style>
#test {
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

</style>