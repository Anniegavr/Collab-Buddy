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
      <button class="addRecord" @click="addTeacher">+</button>
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
      const index = this.teachers.indexOf(teacher);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to enter the new name and email
        const newFirstName = prompt('Enter the new firstname:', teacher.firstName);
        const newLastName = prompt('Enter the new lastname:', teacher.lastName);
        const newEmail = prompt('Enter the new email:', teacher.email);
        const newSpecialty = prompt('Enter the new specialty:', teacher.specialty);
        // If the user entered a new name and email
        if (newFirstName || newLastName || newEmail || newSpecialty) {
          const teacherToEdit = new Teacher(teacher.firstName, teacher.lastName, teacher.email, teacher.specialty)
          // Update the user object with the new name and email
          axios.put("http://localhost:8080/admin/teachers/edit", teacherToEdit)
              .then(response => {
                this.teachers[index] = response.data;
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                this.teachers[index] = teacherToEdit
                alert("Success")
                console.log(error)
              })
          this.fetchTeachers()
        }
      }
    },
    deleteTeacher(teacher) {
      const index = this.teachers.indexOf(teacher);
      if (index !== -1) {
        const confirmed = confirm(`Are you sure you want to delete ${teacher.firstName} ${teacher.lastName} ?`);
        if (confirmed) {
          axios.delete("http://localhost:8080/admin/teachers/delete/"+ teacher.id)
              .then(response => {
                this.teachers = this.fetchTeachers()
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                const index = this.teachers.indexOf(teacher)
                this.teachers.splice(index, 1)
                alert("Success")
                console.log(error)
              })

        }
      }
    },
    addTeacher(){
      const firstName = prompt('Enter the firstname:');
      const lastName = prompt('Enter the lastname:');
      const email = prompt('Enter the email:');
      const specialty = prompt('Enter the specialty:');
      const newTeacher = new Teacher(firstName, lastName, email, specialty)
      axios.post("http://localhost:8080/admin/add_teacher", newTeacher)
          .then(response => {
            this.teachers = response.data;
            console.log("Added teacher: ".concat(response.data))
          })
          .catch(error => {
            this.teachers.push(newTeacher)
            alert("Success")
            console.log(error)
          })
    }
  },
}
</script>

<style scoped>
@import './style/common_table.css';

</style>