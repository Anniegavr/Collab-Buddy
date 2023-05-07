<template>
  <div id="app">
    <div class="admin-panel" onload="window.location.reload()">
      <SearchField :search-term.sync="searchTerm"></SearchField>
      <table class="common_table">
        <thead>
        <tr>
          <th><span>ID</span></th>
          <th><span>First Name</span></th>
          <th><span>Last Name</span></th>
          <th><span>Email</span></th>
          <th><span>Year</span></th>
          <th><span>Specialty</span></th>
          <th><span>Action</span></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="teacher in filteredTeachers" :key="teacher.id">
          <td>{{ teacher.id }}</td>
          <td>{{teacher.firstName}}</td>
          <td>{{teacher.lastName}}</td>
          <td>{{ teacher.email }}</td>
          <td>{{teacher.specialty}}</td>
          <td>
            <button class="edit-btn" @click="editTeacher(teacher)">Edit</button>
            <button class="delete-btn" @click="deleteTeacher(teacher)">Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import SearchField from "./SearchField.vue";
import SearchIcon from "./SearchIcon.vue";
import axios from "axios";
import {Teacher} from "../models/Teacher.ts";

export default {
  name: "TeachersPage",
  components: {SearchField, SearchIcon},
  teachers: [],
  data() {
    return {
      teachers: this.fetchTeachers(),
      searchTerm: ''
    }
  },
  computed: {
    filteredTeachers() {
      if (this.searchTerm) {
        console.log(this.teachers.filter((teacher) =>
            teacher.firstName.toLowerCase()));
        return this.teachers.filter((teacher) =>
            teacher.firstName.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      } else {
        return this.teachers;
      }
    }
  },
  methods: {
    fetchTeachers() {
      axios.get('http://localhost:8080/teachers')
          .then(response => {
            this.teachers = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    },
    editTeacher(teacher) {
      // Find the index of the user to edit
      const index = this.teachers.findIndex(u => u.id === teacher.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to enter the new name and email
        const newFirstName = prompt('Enter the new firstname:', teacher.firstName);
        const newLastName = prompt('Enter the new lastname:', teacher.lastName);
        const newEmail = prompt('Enter the new email:', teacher.email);
        const newSpecialty = prompt('Enter the new email:', teacher.specialty);
        // If the user entered a new name and email
        if (newFirstName || newLastName || newEmail || newSpecialty) {
          const teacher = new Teacher(teacher.id, teacher.firstName, teacher.lastName, teacher.email, teacher.role, teacher.specialty)
          // Update the user object with the new name and email
          axios.put("http://localhost:8080/admin/teachers/edit", teacher)
              .then(response => {
                this.teachers[index] = response.data;
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                console.log(error)
              })
          this.fetchTeachers()
        }
      }
    },
    deleteTeacher(teacher) {
      // Find the index of the user to delete
      const index = this.teachers.findIndex(u => u.id === teacher.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to confirm the deletion
        const confirmed = confirm(`Are you sure you want to delete ${teacher.firstName} ${teacher.lastName} ?`);
        // If the user confirms the deletion
        if (confirmed) {
          axios.delete("http://localhost:8080/admin/teachers/delete", teacher.id)
              .then(response => {
                this.teachers = this.fetchTeachers()
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                console.log(error)
              })

        }
      }
    },
  },
}
</script>

<style scoped>
@import './style/common_table.css';

</style>