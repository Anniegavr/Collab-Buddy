<template>
  <div id="app" data-theme="light">
    <div id="login">
      <h1>Welcome</h1>
      <div id="post">
        <form id='form-post'>
          <input type="text" v-model="email" placeholder="email" name="email" id="email"/>
          <input spellcheck="false" type="password" v-model="password" placeholder="password" name="password" id="password"/>
          <input type="submit" value="Enter" v-on:click="submitForm"/>
          <input type="submit" id="guestButton" value="Enter as guest" v-on:click="enterAsGuest"/>
        </form>
        <p>{{ message }}</p>
      </div>
    </div>

  </div>
</template>

<script>
import Router from "../router.ts";
import axios from "axios";
import {email} from "@vuelidate/validators";

export default {
  name: "SignUpPage",
  email: '',
  password: '',
  methods: {
    submitForm(e){
      e.preventDefault()
      const body = {
        email: this.email,
        password: this.password
      }
      axios.post('http://localhost:8080/api/auth/signin', body, {
      })
          .then(response => {
            if (response.status === 200) {
              this.showError = false;
              this.message = 'Signup accepted';
              this.email = "";
              this.password = "";
              Router.push('/home');
            } else {
              this.message = "";
              this.message = 'Signup not accepted';
              this.email = "";
              this.password = "";
            }
          })
          .catch(error => {
            console.error('Error:', error);
          });
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 0%;
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

button {
  background: none;
  border: solid 1px;
  border-radius: 2em;
  font: inherit;
  cursor: pointer;
//padding: 0.75em 2em;
}
#form-post{
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}
#email, #password{
  cursor: pointer;
  box-sizing: border-box;
  /* Auto layout */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 10px 15px;
  width: 100%;
  margin-top: 10px;
  position: center;
  background: #ffffff;
  margin-bottom: 10px;
  border: 1px solid #432C80;
  border-radius: 15px;
}
input[type='submit']{
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px 15px;
  cursor: pointer;

  position: center;
  width: 70%;
  height: fit-content;
  left: 10%;
  top: 30%;
  margin-top: 10px;

  background: #003566;
  mix-blend-mode: normal;
  border: 1px solid #003566;
  box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 15px;

  font-family: 'Open Sans',serif;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 30px;
  /* identical to box height, or 200% */

  text-align: center;

  color: #FFFFFF;
  /* Inside auto layout */
  flex: none;
  order: 0;
  flex-grow: 0;
}

#form-post{
  display:flex;
  flex-direction:column;
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
#guestButton {
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px 15px;
  background: rgb(111, 124, 126);
  mix-blend-mode: normal;
  border: 1px solid #695a66;
  box-shadow: inset 0px 4px 4px rgba(19, 39, 103, 0.25);
  border-radius: 15px;

  font-family: 'Open Sans',serif;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 30px;
  /* identical to box height, or 200% */

  text-align: center;

  color: #FFFFFF;
  /* Inside auto layout */
  flex: none;
  order: 0;
  flex-grow: 0;
}


</style>