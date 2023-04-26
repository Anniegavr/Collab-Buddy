<template>
  <div class="assignment_types">
    <button class="table_search">
      <SearchIcon></SearchIcon>
    </button>
    <table class="common_table">
      <thead>
      <tr>
        <th>Assignment Type</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="type in assignmentTypes" :key="type">
        <td>{{ type }}</td>
        <td>
          <button class="edit-btn" @click="editType(type)">Edit</button>
          <button class="delete-btn" @click="deleteType(type)">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>
    <button class="addRecord" @click="addType">+</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "AssignmentTypesPage",
  assignmentType: '',
  data() {
    return {
      assignmentTypes: this.getAllAssignmentTypes()
    }
  },
  methods: {
    getAllAssignmentTypes() {
      axios.get('http://localhost:8080/admin/assignment_types')
          .then(response => {
            this.assignmentTypes = response.data;
            console.log(response)
          })
          .catch(error => {
            console.log(error);
          });
    },
    editType(){
      const newType = prompt('Enter the new type:', name);
      axios.put("http://localhost:8080/admin/assignment_types/edit", newType)
          .then(response => {
            this.assignmentTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            console.log(error)
          })
    },
    deleteType() {
      axios.delete("http://localhost:8080/admin/assignment_types/delete", newType)
          .then(response => {
            this.assignmentTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            console.log(error)
          })
    },
    addType() {
      const newType = prompt('Enter the new type:', name);
      axios.post("http://localhost:8080/admin/assignment_types/add", newType)
          .then(response => {
            this.assignmentTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            console.log(error)
          })
    },
  }
}
</script>

<style scoped>
@import "style/common_table.css";

</style>