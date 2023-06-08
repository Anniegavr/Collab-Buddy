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
          <th><span>Specialty</span></th>
          <th><span>Action</span></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="admin in filteredAdmins" :key="admin.id">
          <td>{{admin.id.toString()}}</td>
          <td>{{admin.firstName}}</td>
          <td>{{admin.lastName}}</td>
          <td>{{ admin.email }}</td>
          <td>{{admin.specialty}}</td>
          <td>
            <button class="edit-btn" @click="editAdmin(admin)">Edit</button>
            <button class="delete-btn" @click="deleteAdmin(admin)">Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
      <button class="addRecord" @click="addAdmin">+</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import SearchIcon from "./SearchIcon.vue";
import SearchField from "./SearchField.vue";
export default {
  name: "AllAdmins",
  components: {SearchField, SearchIcon},
  admins: [],
  data() {
    return {
      admins: this.fetchAdmins(),
      searchTerm: ''
    }
  },
  computed: {
    filteredAdmins() {
      if (this.searchTerm) {
        console.log(this.admins.filter((admin) =>
            admin.firstName.toLowerCase()));
        return this.admins.filter((admin) =>
            admin.firstName.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      } else {
        return this.admins;
      }
    }
  },
  methods: {
    fetchAdmins() {
      axios.get('http://localhost:8081/admin/all_admins')
          .then(response => {
            this.admins = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    },
    editAdmin(admin) {
      // Find the index of the user to edit
      const index = this.admins.findIndex(u => u.id === admin.id);
      // If the user is found
      if (index !== -1) {
        const newFirstName = prompt('Enter the new firstname:', admin.firstName);
        const newLastName = prompt('Enter the new lastname:', admin.lastName);
        const newEmail = prompt('Enter the new email:', admin.email);
        const newSpecialty = prompt('Enter the new email:', admin.specialty);
        // If the user entered a new name and email
        if (newFirstName || newLastName || newEmail || newSpecialty) {
          // Update the user object with the new name and email
          this.admins[index].firstName = newFirstName;
          this.admins[index].lastName = newLastName;
          this.admins[index].email = newEmail;
          this.admins[index].specialty = newSpecialty;
          const adminToEdit = {
            "id": admin.id,
            "firstName": newFirstName,
            "lastName": newLastName,
            "email": newEmail,
            "specialty": newSpecialty,
          }
          axios.put('http://localhost:8081/admin/'+adminToEdit.id, adminToEdit)
              .then(response => {
                this.admins = this.fetchAdmins()
                console.log(response.status+"\n "+response.data)
              })
              .catch(error => {
                console.log(error);
              });
        }
      }
    },
    deleteAdmin(admin) {
      const index = this.admins.indexOf(admin);
      if (index !== -1) {
        const confirmed = confirm(`Are you sure you want to delete ${admin.firstName} ${admin.lastName} ?`);
        if (confirmed) {
          axios.delete('http://localhost:8081/admin/'+ admin.id)
              .then(response => {
                this.admins = this.fetchAdmins()
                console.log(response.status+"\n "+response.data)
              })
              .catch(error => {
                this.admins.splice(index, 1);
                alert("Success")
                console.log(error);
              });
        }
      }
    },
    addAdmin() {
      const firstName = prompt('Enter the firstname:');
      const lastName = prompt('Enter the lastname:');
      const email = prompt('Enter the email:');
      const specialty = prompt('Enter the specialty:');
      const username = prompt('Enter the username:', firstName.toLowerCase().charAt(0)+lastName.toLowerCase());
      const newAdmin = {
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "specialty": specialty,
        "username": username,
      }
      console.log(newAdmin)
      axios.post("http://localhost:8081/admin/add_admin", newAdmin)
          .then(response => {
            this.admins.push(response.data);

            console.log("Added admin: ".concat(response.data))
          })
          .catch(error => {
            this.admins.push(newAdmin)
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