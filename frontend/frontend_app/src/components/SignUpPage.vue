<template >
  <div id="app" data-theme="light">
    <div id="Signup">
      <h1>Enter the Details</h1>
      <form id='form-post'>
        <input type="text" v-model="state.name" placeholder="username" id="name"/>
        <input type="email" v-model="state.email" placeholder="email" id="email"/>
        <span v-if="v$.email.$error"> {{ v$.email.$errors[0].$message }} </span>
        <input type="password" v-model="state.password.password" placeholder="password" id="password"/>
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
        <input type="submit" value="Create Profile" v-on:click="submitForm"/>
        <input type="submit" id="guestButton" value="Enter as guest" v-on:click="enterAsGuest"/>
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
export default {
  setup() {
    const state = reactive({
      name:'',
      email: '',
      password: {
        password: '',
        confirm: '',
      },
    })
    const mustBe = (value) => value.sameAs
    const rules = computed(() => {
      return {
        name: {required,
                },
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
      name: '',
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
    // if(this.input_name.toUpperCase() === "ADM" && this.input_password.toUpperCase() === "ADM"){
    // Router.push('/home')
    submitForm(e){
      e.preventDefault();
      this.v$.$validate() // checks all inputs
      if (!this.v$.$error) {
        alert('Success!')
        const body = {
          username: this.name,
          email: this.email,
          password: this.password
        }
        fetch('/api/auth/login', {
          method: 'POST',
          body: JSON.stringify(body),
          headers: {
            'Content-Type': 'application/json'
          }
        })
            .then(response => {
              if (response.ok) {
                this.showError = false;
                this.message = 'Login accepted';
                this.name = "";
                this.email = "";
                this.password = "";
                this.password.confirm= "";
                Router.push('/home');
              } else {
                this.message = "";
                this.message = 'Login accepted';
                this.name = "";
                this.email = "";
                this.password = "";
                this.password.confirm= "";
              }
            })
            .catch(error => {
              console.error('Error:', error);
            });
      } else {
        alert('Sorry, we couldn\'t process your data. Make sure it is correct.')
      }

    },
    created() {
      const darkTheme = window.matchMedia('(prefers-color-scheme: dark)').matches;
      document.documentElement.setAttribute('data-theme', darkTheme ? 'dark' : 'light');
    }
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

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 0%;
}

button {
  background: none;
  border: solid 1px;
  border-radius: 2em;
  font: inherit;
//padding: 0.75em 2em;
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
  margin-bottom: 20%;
}
#name, #password, #confirm_password, #email{
  cursor: pointer;
  box-sizing: border-box;
  /* Auto layout */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 10px 15px;
  width: fit-content;
  margin-top: 10px;
  position: center;
  background: #FFFFFF;
  border: 1px solid #432C80;
  border-radius: 15px;
  color: #1a1a1a;
}
input[type='submit']{
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px 15px;

  position: center;
  width: fit-content;
  height: 10%;
  left: 10%;
  top: 40%;

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

#guestButton {
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px 15px;

  position: center;
  width: fit-content;
  height: 43px;
  left: 503px;
  margin-top: 1rem;
  top: 640px;

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
