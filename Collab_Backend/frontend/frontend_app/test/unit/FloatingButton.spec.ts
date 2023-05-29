import { shallowMount } from '@vue/test-utils'
import FloatingMenuButton from '../../src/components/FloatingMenuButton.vue'

describe('FloatingMenuButton', () => {
    it('should toggle menuActive value when circle button is clicked', async () => {
        const wrapper = shallowMount(FloatingMenuButton)
        const circleButton = wrapper.find('.circle')
        expect(wrapper.vm.menuActive).toBe(false)
        await circleButton.trigger('click')
        expect(wrapper.vm.menuActive).toBe(true)
        await circleButton.trigger('click')
        expect(wrapper.vm.menuActive).toBe(false)
    })

    it('should fetch data when a menu item is clicked', async () => {
        const wrapper = shallowMount(FloatingMenuButton)
        const fetchDataSpy = jest.spyOn(wrapper.vm, 'fetchData')
        const assignmentTypesLink = wrapper.findAll('li').at(1).find('a')
        await assignmentTypesLink.trigger('click')
        expect(fetchDataSpy).toHaveBeenCalled()
    })
})