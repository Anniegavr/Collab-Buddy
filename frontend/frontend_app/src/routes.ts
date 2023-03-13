import {RouteRecordRaw} from "vue-router";

const routes: RouteRecordRaw[] =  [
    {
        path: '/',
        component: import('@/components/LoginPage.vue'),
    },
    {
        path: '/home',
        component: () => import('@/components/MainPage.vue'),
    },
    {
        path: '/login',
        component: () => import('@/components/LoginPage.vue'),
    },
    {
        path: '/all_courses',
        component: () => import('@/components/AllCourses.vue'),
    },
    {
        path: '/release_assignment',
        component: () => import('@/components/ReleaseAssignment.vue'),
    },
    {
        path: '/course_overview',
        component: () => import('@/components/CourseOverview.vue'),
    },
    {
        path: '/profile',
        component: () => import('@/components/ProfilePage.vue'),
    },
    {
        path: '/menu',
        component: () => import('@/components/SlideMenu.vue'),
    },
    {
        path: '/assignment_progress',
        component: () => import('@/components/AssignmentsProgress.vue'),
    },
]
export default routes