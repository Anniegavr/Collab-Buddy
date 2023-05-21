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
        path: '/todo',
        component: () => import('./components/ToDoPage.vue'),
    },
    {
        path: '/login',
        component: () => import('./components/LoginPage.vue'),
    },
    {
        path: '/admin',
        component: () => import('./components/AdminAuthPopup.vue')
    },
    {
        path: '/admin_panel',
        component: () => import('./components/AdminPanel.vue')
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
        path: '/schedule_chart',
        component: () => import('./components/HorizontalChart.vue'),
    },
    {
        path: '/teacher_panel_proxy',
        component: () => import('./components/AdminAuthPopup.vue'),
    },
    {
        path: '/teacher_panel',
        component: () => import('./components/TeacherPanel.vue'),
    },
    {
        path: '/admin/student_groups',
        component: () => import('./components/StudentsGroup.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/teacher/student_groups',
        component: () => import('./components/StudentsGroup.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/add_skill_types',
        component: () => import('./components/MainPage.vue')
    },
    {
        path: '/admin/skill_types',
        component: () => import('./components/SkillTypesConfigPage.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/assignment_progress',
        component: () => import('./components/AssignmentsProgress.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
    {
        path: '/admin/teachers',
        component: () => import('./components/AllTeachersPage.vue')
    },
    {
        path: '/admin/assignment-types',
        component: () => import('./components/AssignmentTypesPage.vue')
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

    {
        path: '/admin/all_admins',
        component: () => import('./components/AllAdmins.vue'),
        meta: { requiresAdmin: true } // add meta field to mark the route as requiring admin privileges
    },
]

export default routes