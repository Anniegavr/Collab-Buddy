<template>
  <svg-icon type="mdi" :path="path"></svg-icon>
</template>

<script>
import SvgIcon from '@jamescoyle/vue-icon';
import { mdiTableSearch } from '@mdi/js';

export default {
  name: "SearchIcon",
  components: {
    SvgIcon
  },
  data() {
    return {
      path: mdiTableSearch,
    }
  }
}
</script>