<template>
  <div class="admin-panel">
    <div class="user-management">
      <table>
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

<script>
export default {
  name: "UsersPage",
  data() {
    return {
      users: [
        {id: 1, name: 'John Doe', email: 'john.doe@example.com'},
        {id: 2, name: 'Jane Doe', email: 'jane.doe@example.com'},
        {id: 3, name: 'Bob Smith', email: 'bob.smith@example.com'}
      ]
    }
  },
  methods: {
    editUser(user) {
      // Handle edit user action
    },
    deleteUser(user) {
      // Handle delete user action
    }
  }
}
</script>

<style>
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