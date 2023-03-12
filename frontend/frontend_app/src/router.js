import { createRouter, createWebHistory } from 'vue-router'
import LoginPage from './components/LoginPage.vue'
import SignUpPage from './components/SignUpPage.vue'
import MainPage from "@/components/MainPage.vue";
import ReleaseAssignment from "@/components/ReleaseAssignment.vue";
import AllCourses from "@/components/AllCourses.vue";
import CourseOverview from "@/components/CourseOverview.vue";
import AssignmentsProgress from "@/components/AssignmentsProgress.vue";
import ProfilePage from "@/components/ProfilePage.vue";
import SlideMenu from "@/components/SlideMenu.vue";

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: LoginPage
  },
  {
    path: '/signup',
    component: SignUpPage
  },
  {
    path: '/home',
    component: MainPage
  },
  {
    path: '/release_assignment',
    component: ReleaseAssignment
  },
  {
    path: '/signup',
    component: SignUpPage
  },
  {
    path: '/profile',
    component: ProfilePage
  },
  {
    path: '/all_courses',
    component: AllCourses
  },
  {
    path: '/course_overview',
    component: CourseOverview
  },
  {
    path: '/assignment_progress',
    component: AssignmentsProgress
  },
  {
    path: '/menu',
    component: SlideMenu
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router