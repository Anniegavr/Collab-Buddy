<template>
  <div id="app">
    <div class="admin-panel">
        <SearchField :search-term.sync="searchTerm"></SearchField>
        <table class="common_table">
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="user in users" :key="user.id">
            <td>{{ user.id }}</td>
            <td>{{ user.name }}</td>
            <td>{{ user.email }}</td>
            <td>
              <button class="edit-btn" @click="editUser(user)">Edit</button>
              <button class="delete-btn" @click="deleteUser(user)">Delete</button>
            </td>
          </tr>
          </tbody>
        </table>
    </div>
  </div>

</template>

<script >
import axios from "axios";
import EditForm from "./EditForm.vue";
import SearchField from "./SearchField.vue";
import SearchIcon from "./SearchIcon.vue";

export default {
  name: "UsersPage",
  id: '',
  email: '',
  password: '',
  components: {SearchField, SearchIcon},
  data() {
    return {
      users: this.getAllUsers(),
      searchTerm: '',
    }
  },
  methods: {
    getAllUsers(e){
      axios.get('http://localhost:8080/admin/users/all')
          .then(response => {
            this.users = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    },
    editUser(user) {
      // Find the index of the user to edit
      const index = this.users.findIndex(u => u.id === user.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to enter the new name and email
        const newName = prompt('Enter the new name:', user.name);
        const newEmail = prompt('Enter the new email:', user.email);
        // If the user entered a new name and email
        if (newName && newEmail) {
          // Update the user object with the new name and email
          this.users[index].name = newName;
          this.users[index].email = newEmail;
        }
      }
    },
    deleteUser(user) {
      // Find the index of the user to delete
      const index = this.users.findIndex(u => u.id === user.id);
      // If the user is found
      if (index !== -1) {
        // Prompt the user to confirm the deletion
        const confirmed = confirm(`Are you sure you want to delete ${user.name}?`);
        // If the user confirms the deletion
        if (confirmed) {
          // Remove the user object from the users array
          this.users.splice(index, 1);
        }
      }
    }
  }
}
</script>

<style>
@import 'style/common_table.css';

</style>