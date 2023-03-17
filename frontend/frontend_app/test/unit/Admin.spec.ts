// Import the necessary functions and objects
import { mount } from '@vue/test-utils'
import router from '../../src/router'
import AdminPanel from '../../src/components/AdminPanel.vue'
import MainPage from '../../src/components/MainPage.vue'

// Create a mock user object for testing
const mockUser = {
    isAdmin: true
}

describe('AdminPanel.vue', () => {
    // Test when the user is an admin and is allowed to access the admin panel
    test('renders the admin panel when the user is an admin', async () => {
        // Mock the checkIfUserIsAdmin function to return true
        jest.mock('@/utils/auth', () => ({
            checkIfUserIsAdmin: jest.fn(() => true)
        }))

        // Mount the AdminPanel component with the mock user and router
        const wrapper = mount(AdminPanel, {
            global: {
                mocks: {
                    $route: {
                        path: '/admin'
                    },
                    $router: router,
                    $store: {
                        state: {
                            currentUser: mockUser
                        }
                    }
                }
            }
        })

        // Expect the component to be visible
        expect(wrapper.find('.admin-panel').isVisible()).toBe(true)
    })

    // Test when the user is not an admin and is not allowed to access the admin panel
    test('redirects to the main page when the user is not an admin', async () => {
        // Mock the checkIfUserIsAdmin function to return false
        jest.mock('@/utils/auth', () => ({
            checkIfUserIsAdmin: jest.fn(() => false)
        }))

        // Mount the AdminPanel component with the mock user and router
        const wrapper = mount(AdminPanel, {
            global: {
                mocks: {
                    $route: {
                        path: '/admin'
                    },
                    $router: router,
                    $store: {
                        state: {
                            currentUser: mockUser
                        }
                    }
                }
            }
        })

        // Expect the component to redirect to the main page
        expect(wrapper.findComponent(MainPage).exists()).toBe(true)
    })
})