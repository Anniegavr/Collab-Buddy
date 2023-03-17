<template>
  <div>
    <h2>Total Requests</h2>
    <div>{{ totalRequests }}</div>
  </div>
</template>

<script>
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
    axios.get('/api/requests/total')
        .then(response => {
          this.totalRequests = response.data;
        })
        .catch(error => {
          console.error(error);
        });
  },
};
</script>
