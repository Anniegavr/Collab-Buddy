
<template>
  <div class="ring-chart">
    <div class="chart-wrapper">
      <div class="chart-section" :style="{'--angle':uniRTTAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':sleepAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':classTimeAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':graphicsAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':calculusAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':pblAngle+'deg'}"></div>
      <div class="chart-section" :style="{'--angle':freeTimeAngle+'deg'}"></div>
    </div>
    <div class="chart-labels">
      <div class="label">Uni RTT</div>
      <div class="label">Sleep</div>
      <div class="label">Class Time</div>
      <div class="label">Computer's Graphics</div>
      <div class="label">Calculus</div>
      <div class="label">PBL</div>
      <div class="label">Free Time</div>
    </div>
  </div>
  <vc-donut :sections="sections">Basic donut</vc-donut>
</template>

<script lang="ts">
import Donut from 'vue-css-donut-chart';
import 'vue-css-donut-chart/dist/vcdonut.css';
import {placement} from "vue-css-donut-chart/src/utils/misc";
import Vue from "chartkick";
Vue.use(Donut);
export default {
  data() {
    return {
      sections: [
        { label: 'uniRTTAngle', value: 0, color: 'red' },
        { label: 'sleepAngle', value: 0, color: 'green' },
        { label: 'classTimeAngle', value: 0, color: 'blue' }
      ],
      uniRTTAngle: 0,
      sleepAngle: 0,
      classTimeAngle: 0,
      graphicsAngle: 0,
      calculusAngle: 0,
      pblAngle: 0,
      freeTimeAngle: 0,
      uniRTT: 1,
      sleep: 7,
      classTime: 3,
      graphics: 3,
      calculus: 2,
      pbl: 4,
      freeTime: 4,
    };
  },
  computed: {
    totalHours() {
      return (
          parseInt(this.uniRTT) +
          parseInt(this.sleep) +
          parseInt(this.classTime) +
          parseInt(this.graphics) +
          parseInt(this.calculus) +
          parseInt(this.pbl) +
          parseInt(this.freeTime)
      );
    },
    uniRTTPercentage() {
      return (this.uniRTT / this.totalHours) * 100;
    },
    sleepPercentage() {
      return (this.sleep / this.totalHours) * 100;
    },
    classTimePercentage() {
      return (this.classTime / this.totalHours) * 100;
    },
    graphicsPercentage() {
      return (this.graphics / this.totalHours) * 100;
    },
    calculusPercentage() {
      return (this.calculus / this.totalHours) * 100;
    },
    pblPercentage() {
      return (this.pbl / this.totalHours) * 100;
    },
    freeTimePercentage() {
      return (this.freeTime / this.totalHours) * 100;
    },
  },
  mounted() {
    this.uniRTTAngle = this.uniRTTPercentage * 3.6;
    this.sleepAngle = this.sleepPercentage * 3.6;
    this.classTimeAngle = this.classTimePercentage * 3.6;
    this.graphicsAngle = this.graphicsPercentage * 3.6;
    this.calculusAngle = this.calculusPercentage * 3.6;
    this.pblAngle = this.pblPercentage * 3.6;
    this.freeTimeAngle = this.freeTimePercentage * 3.6;
  },
  methods: {
    updateAngles() {
      this.uniRTTAngle = this.uniRTTPercentage * 3.6;
      this.sleepAngle = this.sleepPercentage * 3.6;
      this.classTimeAngle = this.classTimePercentage * 3.6;
      this.graphicsAngle = this.graphicsPercentage * 3.6;
      this.calculusAngle = this.calculusPercentage * 3.6;
      this.pblAngle = this.pblPercentage * 3.6;
      this.freeTimeAngle = this.freeTimePercentage * 3.6;
    }
  },
  watch: {
    totalHours() {
      this.updateAngles();
    }
  },
  props: {
    // diameter of the donut
    size: { type: Number, default: 250, validator: v => v > 0 },
// unit to use for `size`
    unit: { type: String, default: 'px' },
// percentage of donut ring's thickness
    thickness: {
      type: Number,
      default: 20,
      validator: v => v >= 0 && v <= 100
    },
// text in the middle of the donut, this can also be passed using the default slot
    text: { type: String, default: null },
    autoAdjustTextSize: { type: Boolean, default: true },
// color to use for the middle of the donut
// set this to `transparent` or `thickness` to 100 to make a pie chart instead
    background: { type: String, default: '#9d2020' },
// color to use for the empty ring areas
    foreground: { type: String, default: '#b91e66' },
// sections of the donut, must have a `value` property
// other valid properties are `label` and `color` (default is `dodgerblue`)
    sections: {
      type: Array,
      default: () => [],
      validator(sections) {
        for (let i = 0; i < sections.length; ++i) {
          /* istanbul ignore if - already covered by unit tests for sectionValidator */
          if (!sectionValidator(sections[i])) return false;
        }
        return true;
      }
    },
    total: { type: Number, default: 100, validator: v => v > 0 },
    hasLegend: { type: Boolean, default: false },
    legendPlacement: {
      type: String,
      default: placement.BOTTOM,
      validator: val => !!placement[val.toUpperCase()]
    },
// degree angle at which the first section begins
    startAngle: { type: Number, default: 0 }
  }
};
</script>

<style scoped>
.ring-chart {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 1.2rem;
}
.chart-wrapper {
  width: 200px;
  height: 200px;
  margin: 20px;
  position: relative;
}
.chart-section {
  position: absolute;
  width: 100%;
  height: 100%;
  clip: rect(0, 100px, 100px, 50px);
  border-radius: 50%;
  background-color: #f50057;
  transform-origin: center center;
  transform: rotate(var(--angle));
}
.chart-section:nth-child(1) {
  --angle: 0deg;
  background-color: #3f51b5;
}
.chart-section:nth-child(2) {
  --angle: 0deg;
  background-color: #009688;
}
.chart-section:nth-child(3) {
  --angle: 0deg;
  background-color: #f44336;
}
.chart-section:nth-child(4) {
  --angle: 0deg;
  background-color: #ffc107;
}
.chart-section:nth-child(5) {
  --angle: 0deg;
  background-color: #4caf50;
}
.chart-section:nth-child(6) {
  --angle: 0deg;
  background-color: #9c27b0;
}
.chart-section:nth-child(7) {
  --angle: 0deg;
  background-color: #795548;
}
.chart-labels {
  display: flex;
  justify-content: space-between;
  width: 240px;
  margin: 0 20px;
}
.label {
  font-size: 0.8rem;
  text-transform: uppercase;
}
</style>