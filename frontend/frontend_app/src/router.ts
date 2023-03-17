import { createRouter, createWebHistory, Router } from 'vue-router'
import routes from "./routes";
import { isAuthenticated } from './utils/auth';

const router: Router = createRouter({
    history: createWebHistory(),
    routes,
})

// authentication guard function
const isAdmin = () => {
    const user = isAuthenticated(); // get the authenticated user
    return user && user.isAdmin(); // check if the user has admin privileges
}

// navigation guard to restrict access to admin panel
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAdmin)) {
        if (!isAdmin()) {
            next({ path: '/login' }); // redirect to login page if not authorized
        } else {
            next();
        }
    } else {
        next();
    }
});
export default router