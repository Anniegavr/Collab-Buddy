<template>
  <div class="admin-auth-popup">
    <form v-on:submit.prevent="authenticateAdmin">
      <input type="text" v-model="username" placeholder="Admin username" required>
      <input type="password" v-model="password" placeholder="Admin password" required>
      <button type="submit">Authenticate</button>
    </form>
  </div>
</template>
<script>
export default {
  name: 'AdminAuthPopup',
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    authenticateAdmin() {
      // Check admin credentials here
      if (this.username === 'admin' && this.password === 'admin123') {
        this.$emit('authenticated');
      } else {
        alert('Invalid admin credentials');
      }
    },
  },
};
</script>
<style>
.admin-auth-popup {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9999;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  border-radius: 10px;
  padding: 20px;
}

input {
  margin: 10px;
  padding: 10px;
  border: 1px solid #cccccc;
  border-radius: 5px;
}

button {
  margin: 10px;
  padding: 10px;
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background: rgba(25, 91, 6, 0.76);
}
</style>