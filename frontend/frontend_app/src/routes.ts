import type {RouteRecordRaw} from 'vue-router'

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
        path: '/admin_proxy',
        component: () => import('./components/AdminAuthPopup.vue')
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
        component: () => import('./components/AddGroup.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/add_student',
        component: () => import('./components/AddStudentsPage.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/skill_types',
        component: () => import('./components/SkillTypesConfigPage.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/assignment_progress',
        component: () => import('./components/AssignmentsProgress.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/teachers',
        component: () => import('./components/TeachersPage.vue')
    },
    {
        path: '/students',
        component: () => import('./components/AllStudents.vue')
    },
    {
        path: '/admin/negotiations',
        component: () => import('./components/NegotiationsPage.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/schedule_config',
        component: () => import('./components/StudentScheduleConfigPage.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/all_students',
        component: () => import('./components/AllStudents.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
]

export default routes