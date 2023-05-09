<template>
  <div id="admin_popup" class="admin-auth-popup" >
      <form v-on:submit.prevent="authenticateAdmin">
        <button @click="closePopup" class="closing_popup">X</button>
        <input type="text" v-model="username" placeholder="Admin username" required>
        <input type="password" v-model="password" placeholder="Admin password" required>
        <button type="submit" id="admin_auth">Authenticate</button>
        <span v-if="showError" class="error-message">{{ errorMessage }}</span>
        </form>
  </div>
</template>
<script >
import Router from "../router.ts";
import axios from "axios";

export default {
  name: 'AdminAuthPopup',
  data() {
    return {
      username: '',
      password: '',
      showError: false,
      message: '',
      errorMessage: 'Something went wrong',
      closethis: false,
    };
  },
  methods: {
    authenticateAdmin(e) {
      //this.$emit('authenticated');
      // Check admin credentials here
      e.preventDefault()
      const body = {
        username: this.username,
        password: this.password
      }
      axios.post('http://localhost:8080/api/auth/signin', body, {
      })
          .then(response => {
            if (response.status === 200) {
              this.showError = false;
              this.message = 'Signup accepted';
              this.username = "";
              this.password = "";
              Router.push('/admin_panel');
              this.$nextTick(() => {
                this.closePopupAndNavigate();
              });
            } else {
              this.message = this.errorMessage;
              this.showError = true;
              this.username = "";
              this.password = "";
            }
          })
          .catch(error => {
            console.error('Error:', error);
            this.message = this.errorMessage;
            this.showError = true;
          });
    },
    closePopup() {
      Router.back()
    },
    closePopupAndNavigate() {
      const popup = document.getElementById('admin_popup');
      popup.style.display = 'none';
      Router.push('/admin_panel');
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

#admin_auth {
  margin: 10px;
  padding: 10px;
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
#admin_auth:hover {
  background: rgba(25, 91, 6, 0.76);
}

.closing_popup {
  align-self: flex-end;
  background-color: #003566;
  color: #dddddd;
}
</style>