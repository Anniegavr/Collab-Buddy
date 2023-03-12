<template>
  <div id="app">
    <div id="Signup">
      <h1>Enter Details</h1>
      <form id="form-test">
        <input type="text" v-model="input_name" placeholder="username" name="name" id="name"/>
        <input type="text" v-model="input_email" placeholder="email" name="email" id="name"/>
        <input spellcheck="false" type="password" v-model="input_password" placeholder="password" name="password" id="password"/>
        <input spellcheck="false" type="password" v-model="input_password" placeholder="confirm password" name="password" id="password"/>
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
  name: "SignUpPage"
}
</script>

<style>
#test {
  position: absolute;
  width: 100%;
  height: 5rem;
  left: 0;
  top: -2px;

  background: linear-gradient(180deg, rgba(18, 32, 46, 0.95) 9.9%, rgba(0, 5, 9, 0.95) 86.46%);
  box-shadow: 0 13px 4px rgba(0, 0, 0, 0.18);
  border-radius: 0;

  text-align: center; /* center the menu-title */
}

</style>