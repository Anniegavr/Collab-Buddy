<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <div id="login">
      <h1>Welcome!</h1>
      <form id="form-test">
        <input type="text" v-model="input_name" placeholder="username" name="name" id="name"/>
        <input spellcheck="false" type="password" v-model="input_password" placeholder="password" name="password" id="password"/>
        <div id="bars">
          <div></div>
        </div>
        <div id="strength"></div>
        <input type="submit" value="Enter Profile" v-on:click="submitForm"/>
        <input type="submit" id="guestButton" value="Enter as guest" v-on:click="enterAsGuest">
      </form>
      <p>{{ message }}</p>
    </div>
    <div id="post">
      <h1>Post</h1>
      <form id='form-post'>
        <textarea v-model="input_author" placeholder="Digite seu nome" name="author" id="author"/>
        <textarea v-model="input_text" placeholder="Digite seu comentário" name="comentario" id="comentario" rows="5"/>
        <input type="submit" value="Enter" v-on:click="submitPost"/>
        <input type="submit" value="Sair" v-on:click="submitSair"/>
      </form>
    </div>
  </div>
</template>

<script>
import Router from "@/router";

export default {
  data() {
    return {
      message: '',
      input_name: "",
      input_password: "",
    };
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
      const body = {
        username: this.input_name,
        password: this.input_password
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
              this.input_name = "";
              this.input_password = "";
              Router.push('/home');
            } else {
              this.showError = true;
              this.message = "";
              this.input_name = "";
              this.input_password = "";
            }
          })
          .catch(error => {
            console.error('Error:', error);
          });
    },
    submitPost(e){
      e.preventDefault();
      // handle post submission
    },
    submitSair(e){
      e.preventDefault();
      // handle sair submission
    }
  }
};
</script>

<!-- Use preprocessors via the lang attribute! e.g. <style lang="scss"> -->
<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 12%;
}

a,
button {
  color: #4fc08d;
}

button {
  background: none;
  border: solid 1px;
  border-radius: 2em;
  font: inherit;
  //padding: 0.75em 2em;
}
#form-test{
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}
input{
  cursor: pointer;
  box-sizing: border-box;
  /* Auto layout */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 10px 15px;
  width: 410px;
  margin-top: 10px;
  position: center;
  background: #FFFFFF;
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

  position: center;
  width: 410px;
  height: 43px;
  left: 503px;
  top: 640px;

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
  width:300px;
  margin:5px auto;
  resize:none;
  padding:0.4rem;
  border-radius: 6px;
  box-shadow: 5px 5px 15px #cecece;
}
:placeholder{
  font-family:arial, sans-serif;
}

#form-post>input[type="submit"]:last-child{
  background-color:red;
}
#post{
  display:none;
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