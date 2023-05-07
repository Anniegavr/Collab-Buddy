<template>
  <div id="app">
    <div class="admin-panel" onload="window.location.reload()">
      <SearchField :search-term.sync="searchTerm"></SearchField>
      <table class="common_table">
        <thead>
        <tr>
          <th><span>ID</span></th>
          <th><span>Name</span></th>
          <th><span>Year</span></th>
          <th><span>Email</span></th>
          <th><span>Specialty</span></th>
          <th><span>Action</span></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="studentGroup in filteredStudentGroups" :key="studentGroup.id">
          <td>{{ studentGroup.id }}</td>
          <td>{{studentGroup.name}}</td>
          <td>{{studentGroup.year}}</td>
          <td>{{studentGroup.email}}</td>
          <td>{{studentGroup.specialty}}</td>
          <td>
            <button class="edit-btn" @click="editStudentGroup(studentGroup)">Edit</button>
            <button class="delete-btn" @click="deleteStudentGroup(studentGroup)">Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
      <button class="addRecord" @click="addStudentGroup">+</button>
    </div>
  </div>
</template>

<script>
import SearchField from "./SearchField.vue";
import SearchIcon from "./SearchIcon.vue";
import axios from "axios";
import {Group} from "../models/Group.ts";

export default {
  name: "AddGroup",
  components: {SearchField, SearchIcon},
  studentGroups: [],
  data() {
    return {
      studentGroups: this.fetchStudentGroups(),
      searchTerm: ''
    }
  },
  computed: {
    filteredStudentGroups() {
      if (this.searchTerm) {
        console.log(this.studentGroups.filter((studentGroup) =>
            studentGroup.name.toLowerCase()));
        const index = this.studentGroups.indexOf((studentGroup) =>
            studentGroup.name.toLowerCase().includes(this.searchTerm.toLowerCase())
        )
        return this.studentGroups[index]
      } else {
        return this.studentGroups
      }
    }
  },
  methods: {
    fetchStudentGroups() {
      axios.get('http://localhost:8080/student_groups/all')
          .then(response => {
            this.studentGroups = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    },
    editStudentGroup(studentGroup) {
      // Find the index of the user to edit
      const index = this.studentGroups.indexOf(studentGroup);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to enter the new name and email
        const newName = prompt('Enter the new name:', studentGroup.name);
        const newEmail = prompt('Enter the new email:', studentGroup.email);
        const newYear = prompt('Enter the new year:', studentGroup.year);
        const newSpecialty = prompt('Enter the new specialty:', studentGroup.specialty);
        // If the user entered a new name and email
        if (newName || newEmail || newYear || newSpecialty) {
          const newStudentGroup = new Group(studentGroup.id, newName, newYear, newEmail, newSpecialty)
          axios.put("http://localhost:8080/admin/student_groups/edit", newStudentGroup)
              .then(response => {
                this.studentGroups[index] = this.fetchStudentGroups();
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                this.studentGroups[index] = newStudentGroup
                alert("Success")
                console.log(error)
              })

        }
      }
    },
    deleteStudentGroup(studentGroup) {
      // Find the index of the user to delete
      const index = this.studentGroups.findIndex(u => u.id === studentGroup.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to confirm the deletion
        const confirmed = confirm(`Are you sure you want to delete ${studentGroup.name}?`);
        // If the user confirms the deletion
        if (confirmed) {
          axios.delete("http://localhost:8080/admin/studentGroups/delete/"+ studentGroup.id)
              .then(response => {
                this.studentGroups = this.fetchStudentGroups()
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                this.studentGroups.splice(index, 1)
                alert("Success")
                console.log(error)
              })

        }
      }
    },
  }
}
</script>

<style scoped>
@import './style/common_table.css';
</style>