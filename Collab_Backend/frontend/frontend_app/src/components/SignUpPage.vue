<template >
  <div id="app" data-theme="light">
    <div id="Signup" onload="loadContent()">
      <h1>Enter the Details</h1>
      <form id='form-post'>
        <input type="text" v-model="state.firstName" placeholder="first name" id="first_name" class="name_input"/>
        <input type="text" v-model="state.lastName" placeholder="last name" id="last_name" class="name_input"/>
        <input type="email" v-model="state.email" placeholder="email" id="signup_email" class="email_input"/>
        <span v-if="v$.email.$error"> {{ v$.email.$errors[0].$message }} </span>
        <input type="password" v-model="state.password.password" placeholder="password" id="signup_password" class="password_input"/>
        <span v-if="v$.password.password.$error">
        {{ v$.password.password.$errors[0].$message }}
      </span>
        <input required spellcheck="false" type="password" v-model="state.password.confirm" placeholder="confirm password" name="confirm_password" id="confirm_password"/>
        <span v-if="v$.password.confirm.$error">
        {{ v$.password.confirm.$errors[0].$message }}
          </span>
        <div id="bars">
          <div></div>
        </div>
        <div id="strength"></div>
        <input type="submit" class="submit_button" value="Submit Information"  v-on:click="submitForm"/>
        <router-link to="/home" class="guest_button">Enter as guest</router-link>
      </form>
    </div>
  </div>
</template>

<script>
import Router from "../router.ts";
import useValidate from '@vuelidate/core'
import { required, email, minLength, sameAs, helpers } from '@vuelidate/validators'
import {computed, reactive} from "vue";
import * as state from "@vuelidate/validators";
import axios from "axios";
export default {
  setup() {
    const state = reactive({
      firstName:'',
      lastName:'',
      email: '',
      password: {
        password: '',
        confirm: '',
      },
    })
    const mustBe = (value) => value.sameAs
    const rules = computed(() => {
      return {
        firstName: {required,
                },
        lastName: {required,},
        email: { required,
                  email,},
        password: {
          password: { required, minLength: minLength(6) },
          confirm: { required, sameAs: sameAs(state.password.password), mustBe: helpers.withMessage("Passwords don\'t match.", mustBe) },
        }
      }
    })
    const v$ = useValidate(rules, state)
    return {state, v$}
  },
  data() {
    return {
      v$: useValidate(),
      firstName: '',
      lastName: '',
      email: '',
      password: {
        password: '',
        confirm: '',
      },
    }
  },
  methods: {
    enterAsGuest(e){
      e.preventDefault();
      Router.push('/home');
    },

    submitForm(e){
      e.preventDefault();
      this.v$.$validate() // checks all inputs
      // if (!this.v$.$error) {
        //   alert('Success!')
      const body = {
        username: this.name,
        email: this.email,
        password: this.password
      }
      axios.post('http://localhost:8081/api/auth/signup', body, {
      })
          .then(response => {
            if (response.status === 200) {
              this.showError = false;
              this.message = 'Signup accepted';
              this.name = "";
              this.email = "";
              this.password = "";
              this.password= "";
              Router.push('/home');
            } else {
              this.message = "";
              this.message = 'Signup not accepted';
              this.name = "";
              this.email = "";
              this.password = "";
              this.password= "";
            }
          })
          .catch(error => {
            console.error('Error:', error);
          });
      // this.v$.$validate() // checks all inputs
      // if (!this.v$.$error) {
      //   alert('Success!')
      //   const body = {
      //     username: this.name,
      //     email: this.email,
      //     password: this.password
      //   }
      //   fetch('http://10.2.2.2:8080/api/auth/signup', {
      //     hod: 'POST',
      //     body: JSON.stringify(body),
      //     headers: {
      //       'Content-Type': 'application/json'
      //     }
      //   })
      //       .then(response => {
      //         if (response.ok) {
      //           this.showError = false;
      //           this.message = 'Signup accepted';
      //           this.name = "";
      //           this.email = "";
      //           this.password = "";
      //           this.password.confirm= "";
      //           Router.push('/home');
      //         } else {
      //           this.message = "";
      //           this.message = 'Signup not accepted';
      //           this.name = "";
      //           this.email = "";
      //           this.password = "";
      //           this.password.confirm= "";
      //         }
      //       })
      //       .catch(error => {
      //         console.error('Error:', error);
      //       });
      // } else {
      //   alert('Sorry, we couldn\'t process your data. Make sure it is correct.')
      // }

    },
  },
  validations() {
    return {
      name: {required},
      email: {required},
      password: {
        password: {required},
        confirm: {required},
      },
    }
  },
}
</script>

<!-- Use preprocessors via the lang attribute! e.g. <style lang="scss"> -->
<style>
@import "./style/general_styles.css";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 13vh;
}

/* Dark theme */
[data-theme="dark"] body {
  background-color: #333;
  color: white;
}

/* Light theme */
[data-theme="light"] body {
  background-color: #ffffff;
  color: black;
}

#form-post{
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20vh;
}
#first_name, #last_name, .password_input, #confirm_password, #email{
  cursor: pointer;
  box-sizing: border-box;
  /* Auto layout */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 10px 15px;
  width: 20vw;
  margin-top: 1vh;
  position: center;
  background: #FFFFFF;
  border: 1px solid #432C80;
  border-radius: 15px;
  color: #1a1a1a;
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

#bars {
  margin:5px auto;
  width:200px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  height: 6px;
  border-radius: 3px;
  background: rgba(255, 255, 255, 0.1);
}

#bars div {
  width: 100%;
  height: inherit;
  border-radius: inherit;
  transition: 0.4s;
}

#bars.weak div {
  background: #bc2b38;
  width: 33.33%;
}

#bars.medium div {
  background: #d36f30;
  width: 66.66%;
}

#bars.strong div {
  background: #1eb965;
  width: 100%;
}


#bars {
  margin:5px auto;
  width:200px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  height: 6px;
  border-radius: 3px;
  background: rgba(255, 255, 255, 0.1);
}

#bars div {
  width: 100%;
  height: inherit;
  border-radius: inherit;
  transition: 0.4s;
}

</style>
