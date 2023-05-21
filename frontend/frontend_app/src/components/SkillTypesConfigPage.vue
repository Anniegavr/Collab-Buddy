<template>
  <div class="skill_types">
    <button class="table_search">
      <SearchIcon></SearchIcon>
    </button>
    <table class="common_table">
      <thead>
      <tr>
        <th>Skill Type</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="type in skillTypes" :key="type">
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
import SearchIcon from "./SearchIcon.vue";
import axios from "axios";

export default {
  name: "SkillTypesConfigPage",
  components: {SearchIcon},
  skillTypes: '',
  data() {
    return {
      skillTypes: this.getAllSkillTypes()
    }
  },
  methods: {
    getAllSkillTypes() {
      axios.get('http://localhost:8080/admin/skill_types/all')
          .then(response => {
            this.skillTypes = response.data;
            console.log(response)
          })
          .catch(error => {
            console.log(error);
          });
    },
    editType(type){
      const index = this.skillTypes.indexOf(type)
      if (index !== -1) {
        const newType = prompt('Enter the new type:', type);
        const editSkillBody = {"type": type, "newType": newType}
        axios.put("http://localhost:8080/admin/skill_types/edit/", editSkillBody)
            .then(response => {
              this.skillTypes = this.getAllSkillTypes();
              console.log("Modified types: ".concat(response.data))
            })
            .catch(error => {
              this.skillTypes[index] = newType
              alert("Success")
              console.log(error)
            })
      } else {
        alert("Problem")
      }

    },
    deleteType(type) {
      const index = this.skillTypes.indexOf(type)
      if (index !== -1) {
        const confirmed = confirm(`Are you sure you want to delete ${type} ?`);
        // If the user confirms the deletion
        if (confirmed) {
          axios.delete("http://localhost:8080/admin/skill_types/delete/", type)
              .then(response => {
                this.skillTypes = this.getAllSkillTypes()
                console.log("Modified types: ".concat(response.data))
              })
              .catch(error => {
                this.skillTypes.splice(index, 1)
                alert("Success")
                console.log(error)
              })
        }

      }

    },
    addType() {
      const newType = prompt('Enter the new type:');
      axios.post("http://localhost:8080/admin/skill_types/add", newType)
          .then(response => {
            this.skillTypes = this.getAllSkillTypes()
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            this.skillTypes.push(newType.toUpperCase())
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