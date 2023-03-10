<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <div id="login">
      <h1>Login</h1>
      <form id="form-test">
        <input type="text" v-model="input_name" placeholder="username" name="name" id="name"/>
        <input spellcheck="false" type="password" v-model="input_password" placeholder="password" name="password" id="password"/>
        <div id="bars">
          <div></div>
        </div>
        <div id="strength"></div>
        <input type="submit" value="Enter" v-on:click="submitForm"/>
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
export default {
  data() {
    return {
      message: 'Welcome to Vue!',
      input_name: "",
      input_password: "",
    };
  },
  computed: {
    passwordStrength() {
      // calculate the password strength and return a number between 0 and 100
      const password = this.input_password;
      let strength = 0;
      if (password.length >= 8) {
        strength += 30;
      }
      if (password.match(/[a-z]/)) {
        strength += 10;
      }
      if (password.match(/[A-Z]/)) {
        strength += 20;
      }
      if (password.match(/\d/)) {
        strength += 20;
      }
      if (password.match(/[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]/)) {
        strength += 20;
      }
      return strength;
    },
    passwordStrengthText() {
      const strength = this.passwordStrength;
      const bars = document.querySelector("#bars");
      const strengthDiv = document.querySelector("#strength");
      const passwordInput = document.querySelector("#password");

      if (strength >= 70) {
        bars.className = "strong";
        strengthDiv.innerHTML = "Strong";
      } else if (strength >= 40) {
        bars.className = "medium";
        strengthDiv.innerHTML = "Medium";
      } else {
        bars.className = "weak";
        strengthDiv.innerHTML = "Weak";
      }

      // append bars and strengthDiv to DOM
      passwordInput.parentNode.insertBefore(bars, passwordInput.nextSibling);
      passwordInput.parentNode.insertBefore(strengthDiv, passwordInput.nextSibling);

      return "";
    },
    bars() {
      // get the bars element
      return document.querySelector("#bars");
    },
    strengthDiv() {
      // get the strength element
      return document.querySelector("#strength");
    },
  },
  watch: {
    passwordStrength() {
      // update the styles of the bars and strength elements when the password strength changes
      this.bars.classList.remove("weak", "medium", "strong");
      this.bars.classList.add(this.passwordStrengthText.toLowerCase());
      this.strengthDiv.textContent = this.passwordStrengthText;
    },
  },
  methods: {
    submitForm(e){
      e.preventDefault();
      if(this.input_name.toUpperCase() == "ADM" && this.input_password.toUpperCase() == "ADM"){
        this.message = 'Login accepted!!';
        this.input_name = "";
        this.input_password = "";
        // reset password strength bar and text
        const bars = document.querySelector("#bars");
        const strengthDiv = document.querySelector("#strength");
        // const passwordInput = document.querySelector("#password");
        bars.className = "";
        bars.querySelector("div").style.width = "0%";
        strengthDiv.innerText = "";

      }else{
        this.message = "wrong password try again";
        this.input_name = "";
        this.input_password = "";
      }
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
  padding: 0.75em 2em;
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
  font-weight: 400;
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
</style>