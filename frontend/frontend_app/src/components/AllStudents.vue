<template>
  <div class="admin-panel">
    <div class="user-management">
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Year</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="student in students" :key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.name }}</td>
          <td>{{ student.email }}</td>
          <td>{{student.year}}</td>
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
export default {
  name: "AllStudents",
  data() {
    return {
      students: [
        {id: 1, name: 'John Doe', email: 'john.doe@example.com', year: 2},
        {id: 2, name: 'Jane Doe', email: 'jane.doe@example.com', year: 4},
        {id: 3, name: 'Bob Smith', email: 'bob.smith@example.com', year: 2}
      ]
    }
  },
  methods: {
    editStudent(student) {
      // Handle edit user action
    },
    deleteStudent(student) {
      // Handle delete user action
    }
  }
}

</script>

<style scoped>
.admin-panel {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.user-management {
  margin-top: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
}

th, td {
  padding: 10px;
  text-align: left;
}

th {
  background-color: #eee;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

.edit-btn, .delete-btn {
  padding: 5px 10px;
  margin-right: 10px;
  border: none;
  background-color: #eee;
  cursor: pointer;
}

.edit-btn:hover, .delete-btn:hover {
  background-color: #ddd;
}
</style>