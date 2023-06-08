<template>
  <div id="app">
    <div class="page_elements">
      <div class="profile_grid">
        <div class="left_part">
          <img src="./assets/profile.jpg" class="profile_img" style="position: static;max-width: 60vh"/>
        </div>

        <div class="right_part">
          <div class="profile_info">
            <h1 style="max-font-size: 1.5svh;">Anastasia Gavrilita</h1>
            <h2>Student, job: part-time, not public</h2>
            <h2>FAF-191</h2>
            <h2>Year: 4</h2>
          </div>
        </div>
      </div>
      <div style="display: block">
      </div>
    </div>



  </div>

</template>

<script>
import AssignmentsProgress from "./AssignmentsProgress.vue";
import HorizontalChart from "./HorizontalChart.vue";

export default {
  name: "ProfilePage",
  components: {HorizontalChart, AssignmentsProgress},
  data() {
    return {
      bars: [
        { variant: 'success', value: 75 },
        { variant: 'info', value: 75 },
        { variant: 'warning', value: 75 },
        { variant: 'danger', value: 75 },
        { variant: 'primary', value: 75 },
        { variant: 'secondary', value: 75 },
        { variant: 'dark', value: 75 }
      ],
      timer: null
    }
  },
  mounted() {
    this.timer = setInterval(() => {
      this.bars.forEach(bar => (bar.value = 25 + Math.random() * 75))
    }, 2000)
  },
  beforeDestroy() {
    clearInterval(this.timer)
    this.timer = null
  }
}
</script>

<style scoped>
.page_elements {
  display: flex;
  flex-direction: column;
  z-index: -3;
  gap: 2vh;
  position: relative;
  top: 17vh;
  display: inline-flex;

}
.profile_grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 10vw;
  border-color: #2c3e50;
  position: static;
  z-index: -3;
  align-items: center;
}

.profile_img {
  border-radius: 5vh;
  border-color: #dddddd;
  box-shadow: -9px 20px 28px 17px rgba(0, 0, 0, 0.25);
  display: flow;
  position: relative;
}
</style>