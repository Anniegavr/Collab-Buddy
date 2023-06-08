<template>
  <div class="form-container">
    <div class="form-assign" >

        <h2>Enter Details</h2>
        <div class="warning-message" v-if="showWarning">
          <p>Please fill in all fields before submitting.</p>
        </div>
        <div class="form-group">
          <label for="assignment-title" class="rel_label">Title:</label>
          <br>
          <input type="text" id="assignment-title" class="assign_inp_title" v-model="assignment.title" />
        </div>
        <div class="form-group">
          <label for="assignment-description" class="rel_label">Description:</label>
          <br>
          <textarea id="assignment-description" v-model="assignment.description" class="assign_descr"></textarea>
        </div>
        <div class="form-group">
          <label for="assignment-group" class="rel_label">Group:</label>
          <select id="assignment-group" v-model="assignment.group">
            <option value="" class="option">Choose group</option>
            <option v-for="group in groups" :value="group" class="option">{{ group }}</option>
          </select>
          <button class="refresh-button" @click="refreshGroups">Refresh</button>
        </div>
        <div class="form-group">
          <label for="assignment-type" class="rel_label">Type:</label>
          <select id="assignment-type" v-model="assignment.type">
            <option value="" class="option">Choose type</option>
            <option v-for="type in types" :value="type" class="option">{{ type }}</option>
          </select>
          <button class="refresh-button" @click="refreshType">Refresh</button>
        </div>
        <div class="form-group">
          <label for="assignment-time" class="rel_label" >Estimated Time:</label>
          <input type="text" id="assignment-time" v-model="assignment.time" :placeholder="timeHint" class="est_time" />
        </div>
        <div class="form-group">
          <label for="assignment-date" class="rel_label">Release Date:</label>
          <div class="current-time">{{assignment.date ? setDate : currentTime }}</div>
        </div>
        <button @click="submit" class="submit_button" style="justify-self: center">Submit</button>
    </div>
    <div class="calendar-container" id="calendar_assign">
      <div class="calendar">
        <VDatePicker v-model="date" @change="setDate"/>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import { Calendar } from 'v-calendar';
import 'v-calendar/style.css';

export default {
  name: "ReleaseAssignment",
  components: {
    Calendar
  },
  data() {
    return {
      date: new Date(),
    }
  },
  setup() {
    const assignment = ref({
      title: '',
      description: '',
      group: '',
      type: '',
      time: '',
      date: '',
    });

    const groups = ref(['FAF-191', 'FAF-192', 'FAF-193']);
    const types = ref(['LAB', 'PROJECT', 'READING']);

    const timeHint = computed(() => 'e.g. 2h 30m');

    const currentTime = new Date().toLocaleString();

    const showWarning = ref(false);

    function refreshGroups() {
      assignment.value.group = ''
    }

    function refreshType() {
      assignment.value.type = ''
    }

    function submit() {
      if (
          assignment.value.title &&
          assignment.value.description &&
          assignment.value.group &&
          assignment.value.type &&
          assignment.value.time &&
          assignment.value.date
      ) {
        // Your code to submit assignment
      } else {
        showWarning.value = true;
      }
    }

    return {
      assignment,
      groups,
      types,
      timeHint,
      currentTime,
      showWarning,
      refreshGroups,
      refreshType,
      submit,
      date: '',
      setDate: function (value) {
        this.assignment.value.date = value
      },
    };
  },
};
</script>

<style>
@import "./style/general_styles.css";
.form-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  horiz-align: center;
  width: 90%;
  height: 90%;
}
.form-group {
  flex-direction: column ;
}
.assign_inp_title {
  border-radius: 12px;
  height: 4vh;
  width: 15vw;
}
.form-assign {
  width: 50vw;
}
.rel_label {
  font-size: 2.6vh;
  font-weight: bold;
  top: 0;
}
.assign_descr {
  min-height: 22vh;
  border-radius: 12px;
  width: 15vw;
  padding: 1vh;
}
.est_time {
  border-radius: 12px;
  height: 4vh;
  width: 7vw;
  margin-left: 1svw;
  padding-left: 5px;
}
#calendar_assign {
  top: 8rem;
}
.submit_button {
  margin-left: 20vw;
}
select {
  margin-left: 1vw;
  height: 2.7vh;
  outline: #2c3e50;
  border-radius: 3vw;
  padding: 1px;
}
</style>