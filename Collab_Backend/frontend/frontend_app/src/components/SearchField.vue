<template>
  <div>
    <button class="table_search" @click="showSearchField">
      <SearchIcon class="table_search_icon"></SearchIcon>
    </button>
    <div v-if="showSearch" id="search_field_container" @click.self="hideSearchField">
      <div id="search_field_popup">
        <input type="text" id="search_field" placeholder="Search..." v-model="searchTerm">
        <button id="search_field_close" @click="hideSearchField">X</button>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, watch } from 'vue';
import SearchIcon from "./SearchIcon.vue";

export default {
  name: 'SearchField',
  components: {SearchIcon},
  props: {
    searchTerm: {
      type: String,
      required: true,
      default: ''
    }
  },
  setup(props, { emit }) {
    const showSearch = ref(false);
    const searchTerm = ref(props.searchTerm);

    const showSearchField = () => {
      showSearch.value = true;
    };

    const hideSearchField = () => {
      showSearch.value = false;
    };

    watch(searchTerm, (value) => {
      emit('update:searchTerm', value);
    });

    return {
      showSearch,
      searchTerm,
      showSearchField,
      hideSearchField,
    };
  },
};
</script>

<style scoped>

</style>