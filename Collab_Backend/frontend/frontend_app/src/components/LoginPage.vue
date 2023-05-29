<template>
  <div id="app" data-theme="light">
    <div id="login" onload="window.location.reload()">
      <h1>Welcome</h1>
      <div id="post">
        <form id='form-post'>
          <input type="text" v-model="email" placeholder="email" name="email" id="email" class="email_input"/>
          <input spellcheck="false" type="password" v-model="password" placeholder="password" name="password" id="password" class="password_input"/>
          <input type="submit" class="submit_button" value="Enter" v-on:click="submitForm"/>
          <router-link to="/home" class="guest_button">Enter as guest</router-link>
          <RouterLink to="/signup" style="margin-top: 1vh; font-size: 2vh">Create Account</RouterLink>
        </form>
        <p>{{ message }}</p>
      </div>
    </div>

  </div>
</template>

<script >
import Router from "../router.ts";
import axios from "axios";
import {email} from "@vuelidate/validators";

export default {
  name: "SignUpPage",
  email: '',
  password: '',
  userId: '',
  methods: {
    createAccount() {
      this.message = "";
      this.email = "";
      this.password = "";
      Router.push('/signup')
    },
    enterAsGuest() {
      Router.push('/')
    },
    submitForm(e){
      e.preventDefault()
      const body = {
        email: this.email,
        password: this.password
      }
      axios.post('http://localhost:8081/admin/auth/signin', body, {
      })
          .then(response => {
            if (response.status === 200) {
              this.showError = false;
              this.message = 'Login accepted';
              this.email = "";
              this.password = "";
              localStorage.setItem(this.userId, 5)
              Router.push('/home');
            } else {
              this.message = "";
              this.message = 'Signup not accepted';
              this.email = "";
              this.password = "";
            }
          })
          .catch(error => {
            Router.push('/home');
            console.error('Error:', error);
          });
    }
  }
}
</script>

<style>
@import "./style/general_styles.css";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 13vh;
  font-size: 90%;
}

/* Dark theme */
body.dark-theme {
  background-color: #5b2a2a;
  color: white;
}

/* Light theme */
body.light-theme {
  background-color: white;
  color: black;
}

/* Dark theme */
body.dark-theme {
  background-color: #333;
  color: whitesmoke;
}

/* Light theme */
body.light-theme {
  background-color: white;
  color: #1a1a1a;
}
/* Dark theme */
[data-theme="dark"] body {
  background-color: #333;
  color: white;
}

/* Light theme */
[data-theme="light"] body {
  background-color: white;
  color: black;
}

#form-post{
  display: flex;
  flex-direction: column;
  align-items: center;
}

textarea{
  width:fit-content;
  margin:5px auto;
  resize:none;
  padding:0.4rem;
  border-radius: 6px;
  box-shadow: 5px 5px 15px #ffffff;
}
:placeholder{
  font-family:arial, sans-serif;
}

</style>