<template>
  <svg-icon type="mdi" :path="path"></svg-icon>
</template>

<script>
import SvgIcon from '@jamescoyle/vue-icon';
import { mdiProgressCheck } from '@mdi/js';

export default {
  name: "ProgressIcon",
  components: {
    SvgIcon
  },
  data() {
    return {
      path: mdiProgressCheck,
    }
  }
}
</script>