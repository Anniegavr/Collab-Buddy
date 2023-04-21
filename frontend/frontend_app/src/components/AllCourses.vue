<template>
  <div class="admin-panel">
    <div class="user-management">
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Teacher</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="course in courses" :key="course.id">
          <td>{{ course.id }}</td>
          <td>{{ course.name }}</td>
          <td>{{ course.teacher }}</td>
          <td>
            <button class="edit-btn" @click="editCourse(course)">Edit</button>
            <button class="delete-btn" @click="deleteCourse(course)">Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "AllCourses",
  data() {
    return {
      courses: [
        {id: 1, name: 'Maths', teacher: 'Dan Defoe'},
        {id: 2, name: 'Survival', email: 'Robin Crusoe'},
        {id: 3, name: 'Nutrition', email: 'Robin Crusoe'}
      ]
    }
  },
  methods: {
    editCourse(course) {
      // Handle edit user action
    },
    deleteCourse(course) {
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