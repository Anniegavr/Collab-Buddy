<template>
  <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 20px;">
    <h2>Edit User</h2>
    <form>
      <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}">
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}">
      </div>
      <div style="text-align: center; margin-top: 10px;">
        <button type="button" onclick="updateUser()">Save</button>
        <button type="button" onclick="cancelEdit()">Cancel</button>
      </div>
    </form>
  </div>
  <div style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5); z-index: 999;"></div>

</template>

<script lang="ts">
export default {
  name: "EditForm"
}
</script>

<style scoped>

</style>