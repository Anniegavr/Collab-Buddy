<template>
  <div class="admin-panel">
    <div class="user-management">
      <table onload="fetchStudents">
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
        <tr v-for="student in students" :key="student.id">
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

export default {
  name: "AllStudents",
  students: [],
  data() {
    return {
      students: this.fetchStudents()
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
      // Handle edit user action
    },
    deleteStudent(student) {
      // Handle delete user action
    },
  }
}

</script>

<style scoped>
.admin-panel {
  vertical-align: center;
  max-width: fit-content;
  margin: 0 auto;
  padding: 20px;
}

.user-management {
  margin-top: 20px;
}

table {
  width: 100%;
  vertical-align: center;
  border-collapse: collapse;
  border-spacing: 0;
  text-align: center;
  overflow-y: scroll;
}

th, td {
  padding: 6px;
  vertical-align: middle;
  border-collapse: collapse;
  box-shadow: 0 13px 4px rgba(0, 0, 0, 0.18);
  color: #ffffff;
  font-weight: bold;
}

th {
  color: white;
  background: #c1aef5;
  background: linear-gradient(-180deg, #8d75d0 0%, rgba(121, 90, 208, 0.87) 100%);
  text-align: center;
  font-weight: bold;
  font-size: 18px;
  padding: 10px;
}

tbody td {
  text-align: center;
  padding: 10px;
  background: linear-gradient(180deg, rgba(11, 10, 26, 0.63) 9.9%, rgba(115, 124, 168, 0.89) 100.0%);
  font-size: large;
}

.edit-btn, .delete-btn {
  background: linear-gradient(90deg, #705CA6 0%, rgba(97, 68, 173, 0.98) 100%);
  color: white;
  border: none;
  border-radius: 5px;
  padding: 5px 10px;
  cursor: pointer;
  margin-right: 5px;
}

.edit-btn:hover, .delete-btn:hover {
  opacity: 0.8;
}

.edit-btn:hover, .delete-btn:hover {
  background-color: #ddd;
}
</style>