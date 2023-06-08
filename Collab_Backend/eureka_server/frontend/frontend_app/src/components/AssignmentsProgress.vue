<template>
  <div class="mascot_message">
    <img src="./assets/mascot/ellipse.svg" alt="ellipse" class="ellipse ell1">
    <img src="./assets/mascot/ellipse.svg" alt="ellipse" class="ellipse ell2">
    <img src="./assets/mascot/hawk.svg" alt="hawk" class="mascot_img">
  </div>
  <div class="gen_message">
    <p>
      "Hey there! It looks like you have a few assignments coming up. The first one is due next week, the second is due tomorrow, and the third is due this Friday. Here's a plan to help you stay on track:
      Today, focus on the assignment that's due tomorrow. Set aside enough time to complete it, and make sure you understand all the requirements before you start.
      Tomorrow, finish up the assignment that's due tomorrow and start working on the one that's due this Friday. Break it down into smaller tasks and try to complete a few each day.
      On Thursday, review the work you've done on the Friday assignment and make any necessary changes.
    </p>
  </div>
  <div class="column_container">
    <div class="calendar-container">
      <div class="calendar">
        <VDatePicker v-model="date" @change="setDate"/>
      </div>
    </div>
    <div id="pending_assignments" style="margin-top: 3vh">
      <div class="legend">
        <span class="lab">LAB</span>
        <span class="project">PROJECT</span>
        <span class="reading">READING</span>
      </div>
      <div v-for="assignment in assignments" :key="assignment.id" class="assignments_list">
        <p :class="['one_assignment', assignment.type]">{{assignment.name}} {{assignment.description}}</p>
      </div>
    </div>
  </div>




</template>

<script >
import axios from "axios";
import Calendar from "./Calendar.vue";
import 'v-calendar/style.css';

export default {
  name: "AssignmentsProgress",
  components: {Calendar},
  data() {
    return {
      assignments: this.fetchAssignments(localStorage.getItem(this.userId)),
    }
  },
  methods: {
    fetchAssignments(studentId) {
      axios.get('http://localhost:8081/students/'.concat(studentId).concat('/assignments'))
          .then(response => {
            this.assignments = response.data;
            console.log(studentId)
          })
          .catch(error => {
            console.log(error);
          });
    }
  }
}
</script>

<style>
@import "./style/general_styles.css";
.column_container {
  flex-direction: column;
  flex-wrap: wrap;

  vertical-align: center;
  horiz-align: center;
  position: absolute;
  top: 8rem;
}
#pending_assignments {
  width: 70%;
  height: min-content;
  top: 22em;
  position: absolute;
  flex-direction: column;
  align-items: center;
}


.one_assignment {
  font-size: medium;
  font-weight: bold;
  border-radius: 5px;
  padding: 0.5em;
  margin-bottom: 10px;
}

.LAB {
  background: #588EC0;
  color: white;
}

.READING {
  background: #588EC0;
  opacity: 66%;
  color: #ffffff;
}

.PROJECT {
  background: #588EC0;
  opacity: 72%;
  color: #FFFFFFFC;
}

.legend {
  position: absolute;
  top: 7%;
  right: 120%;
  display: flex;
  flex-direction: column;
  font-size: 14px;
}

.legend span {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
  padding: 5px;
  border-radius: 5px;
  font-weight: bold;
}

.legend .lab {
  background: #588EC0;
  color: white;
}

.legend .reading {
  background: #588EC0;
  opacity: 66%;
  color: #ffffff;
}

.legend .project {
  background: #588EC0;
  opacity: 72%;
  color: #FFFFFFFC;
}

.gen_message {
  /* Rectangle 16 */
  position: absolute;
  width: 20%;
  height: 40%;
  left: 18%;
  top: 18%;
  scroll-behavior: smooth;
  scroll-padding: 1em;
  overflow-x: hidden;
  overflow-y: scroll;
  padding: 1em;
  scrollbar-width: thin;
  scroll-margin-top: 1em;
  scrollbar-gutter: stable;

  background: #FFFFFF;
  box-shadow: -9px 20px 28px 17px rgba(0, 0, 0, 0.25);
  border-radius: 15px;
}
.mascot_img {
  position: absolute;
  left: 7%;
  top: 75%;
}

.ellipse {
  /* Ellipse 3 */

  position: absolute;
  width: fit-content;
  height: fit-content;

  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 59%;
}

.ell1 {
  left: 15%;
  top: 73%;

}

.ell2 {
  left: 17%;
  top: 67%;
}

</style>