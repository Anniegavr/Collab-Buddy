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
import SearchIcon from "./SearchIcon.vue";

export default {
  name: "AssignmentTypesPage",
  components: {SearchIcon},
  assignmentType: '',
  data() {
    return {
      assignmentTypes: this.getAllAssignmentTypes()
    }
  },
  methods: {
    getAllAssignmentTypes() {
      axios.get('http://localhost:8081/admin/assignment_types')
          .then(response => {
            this.assignmentTypes = response.data;
            console.log(response)
          })
          .catch(error => {
            console.log(error);
          });
    },
    editType(type){
      const newType = prompt('Enter the new type:');
      const editType = {
        "oldType": type,
        "newType": newType,
      }
      axios.put("http://localhost:8081/admin/assignment_types/edit/", editType)
          .then(response => {
            this.assignmentTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            const index = this.assignmentTypes.indexOf(type)
            this.assignmentTypes[index] = newType.toUpperCase()
            alert("Success")
            console.log(error)
          })
    },
    deleteType(type) {
      const index = this.assignmentTypes.indexOf(type);
      const confirmed = confirm(`Are you sure you want to delete ${type} ?`);

      if (confirmed) {
        axios.delete("http://localhost:8081/admin/assignment_types/delete/", type)
            .then(response => {
              this.assignmentTypes = response.data;
              console.log("Modified types: ".concat(response.data))
            })
            .catch(error => {
              this.assignmentTypes.splice(index, 1)
              alert("Success")
              console.log(error)
            })
      }

    },
    addType() {
      const newType = prompt('Enter the new type:').toUpperCase();
      axios.post("http://localhost:8081/admin/assignment_types/add", newType)
          .then(response => {
            this.assignmentTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            this.assignmentTypes.push(newType)
            alert("Success")
            console.log(error)
          })
    },
  }
}
</script>

<style scoped>
@import "style/common_table.css";

</style>