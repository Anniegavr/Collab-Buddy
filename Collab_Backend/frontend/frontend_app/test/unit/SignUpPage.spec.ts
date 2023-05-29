import { mount, VueWrapper } from '@vue/test-utils'
import SignUpPage from '../../src/components/SignUpPage.vue'
import { ComponentPublicInstance } from 'vue'

describe('SignUpPage', () => {
    let wrapper: VueWrapper<ComponentPublicInstance<typeof SignUpPage>>

    beforeEach(() => {
        wrapper = mount(SignUpPage)
    })

    afterEach(() => {
        wrapper.unmount()
    })

    it('displays an error message when input fields are empty', async () => {
        const submitButton = wrapper.find('[data-testid="submit-button"]')
        await submitButton.trigger('click')
        const errorMessage = wrapper.find('[data-testid="error-message"]').text()
        expect(errorMessage).toContain('Please fill out all fields.')
    })

    it('displays an error message when passwords do not match', async () => {
        const passwordInput = wrapper.find('[data-testid="password-input"]')
        const confirmPasswordInput = wrapper.find('[data-testid="confirm-password-input"]')
        await passwordInput.setValue('password1')
        await confirmPasswordInput.setValue('password2')
        const submitButton = wrapper.find('[data-testid="submit-button"]')
        await submitButton.trigger('click')
        const errorMessage = wrapper.find('[data-testid="error-message"]').text()
        expect(errorMessage).toContain('Passwords do not match.')
    })
})
