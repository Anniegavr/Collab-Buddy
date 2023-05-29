<template>
  <div id="app">
    <div class="admin-panel">
        <SearchField :search-term.sync="searchTerm"></SearchField>
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

<script lang="ts">
import SearchField from "./SearchField.vue";
import SearchIcon from "./SearchIcon.vue";

export default {
  name: "AllCourses",
  components: {SearchField, SearchIcon},
  data() {
    return {
      searchTerm: '',
      courses: [
        {id: 1, name: 'Maths', teacher: 'Dan Defoe'},
        {id: 2, name: 'Survival', teacher: 'Robin Crusoe'},
        {id: 3, name: 'Nutrition', teacher: 'Robin Crusoe'}
      ],
      course: '',
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
@import "./style/common_table.css";

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