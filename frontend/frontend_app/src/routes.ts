import type {RouteRecordRaw} from 'vue-router'

// @ts-ignore
const routes: RouteRecordRaw[] =  [
    {
        path: '/',
        component: import('./components/MainPage.vue'),
    },
    {
        path: '/home',
        component: () => import('./components/MainPage.vue'),
    },
    {
        path: '/login',
        component: () => import('./components/LoginPage.vue'),
    },
    {
        path: '/admin',
        component: () => import('./components/AdminPanel.vue')
    },
    {
        path: '/user',
        component: () => import('./models/User.vue')
    },
    {
        path: '/users',
        component: () => import('./components/UsersPage.vue')
    },
    {
        path: '/signup',
        component: () => import('./components/SignUpPage.vue'),
    },
    {
        path: '/admin/all_courses',
        component: () => import('./components/AllCourses.vue'),
    },
    {
        path: '/admin/all_students',
        component: () => import('./components/AllStudents.vue'),
    },
    {
        path: '/teacher/release_assignment',
        component: () => import('./components/ReleaseAssignment.vue'),
    },
    {
        path: '/course_overview',
        component: () => import('./components/CourseOverview.vue'),
    },
    {
        path: '/profile',
        component: () => import('./components/ProfilePage.vue'),
    },
    {
        path: '/admin/assignment_types',
        component: () => import('./models/Assignment.vue')
    },
    {
        path: '/menu',
        component: () => import('./components/SideBarMenu.vue'),
    },
    {
        path: '/admin/add_groups',
        component: () => import('./components/AddGroup.vue')
    },
    {
        path: '/admin/add_student',
        component: () => import('./components/AddStudentsPage.vue')
    },
    {
        path: '/admin/skill_types',
        component: () => import('./components/SkillTypesConfigPage.vue'),
    },
    {
        path: '/admin/assignment_progress',
        component: () => import('./components/AssignmentsProgress.vue'),
    },
    {
        path: '/teachers',
        component: () => import('./components/TeachersPage.vue')
    },
    {
        path: '/admin/negotiations',
        component: () => import('./components/NegotiationsPage.vue')
    },
    {
        path: '/admin/schedule_config',
        component: () => import('./components/StudentScheduleConfigPage.vue')
    },
    {
        path: '/admin/ll_students',
        component: () => import('./components/AllStudents.vue')
    },
]
export default routes