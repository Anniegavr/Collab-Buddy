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
    editType(){
      const newType = prompt('Enter the new type:', name);
      axios.put("http://localhost:8080/admin/skill_types/edit", newType)
          .then(response => {
            this.skillTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            console.log(error)
          })
    },
    deleteType() {
      axios.delete("http://localhost:8080/admin/skill_types/delete", newType)
          .then(response => {
            this.skillTypes = response.data;
            console.log("Modified types: ".concat(response.data))
          })
          .catch(error => {
            console.log(error)
          })
    },
    addType() {
      const newType = prompt('Enter the new type:', name);
      axios.post("http://localhost:8080/admin/skill_types/add", newType)
          .then(response => {
            this.skillTypes = response.data;
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