<template>
  <div class="task-list-frame">
    <div class="task-list-frame-title">Tasks</div>
    <div class="task-list-container">
      <div class="task-list-pages">
        <ul v-for="(page, index) in pages" :key="index" v-show="index === currentPageIndex">
          <li v-for="(task, taskIndex) in page" :key="taskIndex">
            <input type="checkbox" class="inputCheck"/>
            <p style="font-weight: bold; margin-left: 0.2vw; display: inline-flex">{{ task.taskName }}:</p>
            <div class="task-progress-bar" :style="{ width: task.progress + '%' }">
              {{ task.progress }}%
            </div>
          </li>
        </ul>
      </div>
      <div class="task-list-page-buttons">
        <button @click="changePage(-1)" :disabled="currentPageIndex === 0" style="font-weight: bolder; font-size: larger">&lt;</button>
        <button @click="changePage(1)" :disabled="currentPageIndex === pages.length - 1" style="font-weight: bolder; font-size: larger">&gt;</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'HorizontalChart',
  data() {
    return {
      tasks: [],
      pages: [],
      tasksPerPage: 4,
      currentPageIndex: 0
    }
  },
  methods: {
    generatePages() {
      this.pages = [];
      let currentPage = [];
      for (let i = 0; i < this.tasks.length; i++) {
        currentPage.push(this.tasks[i]);
        if (currentPage.length === this.tasksPerPage) {
          this.pages.push(currentPage);
          currentPage = [];
        }
      }
      if (currentPage.length > 0) {
        this.pages.push(currentPage);
      }
    },
    changePage(offset) {
      this.currentPageIndex += offset;
    }
  },
  mounted() {
    axios.get('http://localhost:8080/students/'+5+'/progress')
        .then(response => {
          const progressData = response.data;
          for (let i = 0; i < progressData.length; i++) {
            const task = {
              taskName: progressData[i].taskName,
              progress: progressData[i].progress
            };
            this.tasks.push(task);
          }
          this.generatePages();
        })
        .catch(error => {
          console.error(error);
        });
  }
}
</script>

<style>
.task-list-frame {
  border: 1px solid rgba(19, 39, 103, 0.25);
  padding: 2vw;
  white-space: nowrap;
  width: 50%;
  float: left;
  margin-top: 1vh;
  box-shadow: -9px 20px 28px 17px rgba(0, 0, 0, 0.25);
  margin-bottom: 12vh;
}

.task-list-frame-title {
  font-size: 20px;
  font-weight: bold;
  text-align: center;
}

.task-list-container {
  display: flex;
  flex-direction: column;
  align-items: center;

}

.task-list-pages {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

.task-list-pages > ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: inherit;
  line-height: 4vh;
}

.task-list-page-buttons {
  display: flex;
  justify-content: space-between;
  width: 6vw;
}

.task-progress-bar {
  height: fit-content;
  background-color: #0582ca;
  border-radius: 10px;
  box-shadow: 0 0 10px blue;
  color: white;
  text-align: right;
  padding-right: 0;
}
</style>
