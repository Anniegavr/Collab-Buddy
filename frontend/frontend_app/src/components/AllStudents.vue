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
            <th><span>Specialt</span>y</th>
            <th><span>Action</span></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="student in filteredStudents" :key="student.id">
            <td>{{ student.id }}</td>
            <td>{{student.firstName}}</td>
            <td>{{student.lastName}}</td>
            <td>{{ student.email }}</td>
            <td>{{student.year}}</td>
            <td>{{student.specialty}}</td>
            <td>
              <button class="edit-btn" @click="editStudent(student)">Edit</button>
              <button class="delete-btn" @click="deleteStudent(student)">Delete</button>
            </td>
          </tr>
          </tbody>
        </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import SearchIcon from "./SearchIcon.vue";
import { ref } from 'vue';
import SearchField from "./SearchField.vue";
import searchField from "./SearchField.vue";
export default {
  name: "AllStudents",
  components: {SearchField, SearchIcon},
  students: [],
  data() {
    return {
      students: this.fetchStudents(),
      searchTerm: ''
    }
  },
  computed: {
    filteredStudents() {
      if (this.searchTerm) {
        console.log(this.students.filter((student) =>
            student.firstName.toLowerCase()));
        return this.students.filter((student) =>
            student.firstName.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      } else {
        return this.students;
      }
    }
  },
  methods: {
    fetchStudents() {
      axios.get('http://localhost:8080/students')
          .then(response => {
            this.students = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    },
    editStudent(student) {
      // Find the index of the user to edit
      const index = this.students.findIndex(u => u.id === student.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to enter the new name and email
        const newFirstName = prompt('Enter the new firstname:', student.firstName);
        const newLastName = prompt('Enter the new lastname:', student.lastName);
        const newEmail = prompt('Enter the new email:', student.email);
        // If the user entered a new name and email
        if (newFirstName && newLastName && newEmail) {
          // Update the user object with the new name and email
          this.students[index].firstName = newFirstName;
          this.students[index].lastName = newLastName;
          this.students[index].email = newEmail;
        }
      }
    },
    deleteStudent(student) {
      // Find the index of the user to delete
      const index = this.students.findIndex(u => u.id === student.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to confirm the deletion
        const confirmed = confirm(`Are you sure you want to delete ${student.firstName} ${student.lastName} ?`);
        // If the user confirms the deletion
        if (confirmed) {
          // Remove the user object from the users array
          this.students.splice(index, 1);
        }
      }
    },
  },
}
</script>

<style scoped>
@import './style/common_table.css';

</style>