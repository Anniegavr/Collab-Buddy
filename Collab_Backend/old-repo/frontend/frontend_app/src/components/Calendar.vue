<template>
  <div class="calendar">
    <div class="header">
      <button @click="previousMonth">&lt;</button>
      <h2>{{ monthName }} {{ year }}</h2>
      <button @click="nextMonth">&gt;</button>
    </div>
    <div class="body">
      <div class="days-of-week">
        <span v-for="dayOfWeek in daysOfWeek" :key="dayOfWeek">{{ dayOfWeek }}</span>
      </div>
      <div class="days">
        <div
            v-for="(day, index) in daysInMonth"
            :key="index"
            class="day"
            :class="{ today: isToday(day), weekend: isWeekend(day) }"
        >
          <div class="number">{{ day }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Calendar",
  data() {
    return {
      currentDate: new Date(),
      daysOfWeek: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
    };
  },
  computed: {
    year() {
      return this.currentDate.getFullYear();
    },
    month() {
      return this.currentDate.getMonth();
    },
    monthName() {
      const monthNames = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
      ];
      return monthNames[this.month];
    },
    daysInMonth() {
      const daysInMonth = new Date(this.year, this.month + 1, 0).getDate();
      const days = [];
      for (let i = 1; i <= daysInMonth; i++) {
        days.push(i);
      }
      return days;
    },
  },
  methods: {
    isToday(day) {
      const today = new Date();
      return (
          day === today.getDate() &&
          this.month === today.getMonth() &&
          this.year === today.getFullYear()
      );
    },
    isWeekend(day) {
      const date = new Date(this.year, this.month, day);
      return date.getDay() === 0 || date.getDay() === 6;
    },
    previousMonth() {
      this.currentDate.setMonth(this.currentDate.getMonth() - 1);
    },
    nextMonth() {
      this.currentDate.setMonth(this.currentDate.getMonth() + 1);
    },
  },
};
</script>

<style>
.calendar {
  background-color: #ffffff;
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.2);
  border-radius: 20px;
  padding: 16px;
  display: inline-block;
  font-family: Arial, sans-serif;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.days-of-week {
  display: flex;
  justify-content: space-between;
  margin-bottom: 8px;
}

.days {
  display: flex;
  flex-wrap: wrap;
}

/* Calendar day */
.day {
  width: calc(100% / 7);
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #494C68;
  font-weight: bold;
  font-size: 14px;
  background-color: #fff;
  border: none;
  outline: none;
}

/* Calendar today's date */
.day.today {
  border: 2px solid #66a4e1;
}

/* Hover effect for calendar day */
.day:hover {
  background-color: #E9EFF6;
}

</style>