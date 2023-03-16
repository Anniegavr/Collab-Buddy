<template>
  <div class="admin-panel">
    <div class="admin-panel-grid">
      <router-link to="/users" class="admin-panel-item">
        <h2>All Users</h2>
      </router-link>
      <router-link to="/students" class="admin-panel-item">
        <h2>All Students</h2>
      </router-link>
      <router-link to="/teachers" class="admin-panel-item">
        <h2>All Teachers</h2>
      </router-link>
      <router-link to="/skill-types" class="admin-panel-item">
        <h2>All Skill Types</h2>
      </router-link>
      <router-link to="/admin/assignment-types" class="admin-panel-item">
        <h2>All Assignment Types</h2>
      </router-link>
      <router-link to="/groups" class="admin-panel-item">
        <h2>All Groups</h2>
      </router-link>
      <router-link to="/admin/negotiations" class="admin-panel-item">
        <h2>Assignment Negotiations</h2>
      </router-link>
      <router-link to="/admin/schedule-config" class="admin-panel-item">
        <h2>Student Schedule Config</h2>
      </router-link>

    </div>
  </div>
</template>

<script>
export default {
  name: 'AdminPanel',
};
</script>

<style>
.admin-panel {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f1f1f1;
}

.admin-panel-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 20px;
}

.admin-panel-item {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  border-radius: 10px;
  padding: 20px;
  text-align: center;
  transition: transform 0.3s;
}

.admin-panel-item:hover {
  transform: translateY(-5px);
  box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
}
</style>