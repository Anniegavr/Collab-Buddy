<template>
  <div>
    <h2>Total Requests</h2>
    <div class="result">{{ totalRequests }}</div>
  </div>
</template>

<script >
import axios from "axios";

export default {
  name: 'TotalRequests',
  data() {
    return {
      totalRequests: 0,
    }
  },
  created() {
    // make an API call to get the total number of requests
    // replace the API endpoint with your own
    axios.get('http://localhost:8081/admin/requests/total')
        .then(response => {
          this.totalRequests = response.data;
        })
        .catch(error => {
          console.error(error);
        });
  },
};
</script>

<style>
.result {
  font-size: large;
  color: #fefeff;
  font-weight: bold;
  border-radius: 15px;
  background: #9b9bd6;
}
</style>
