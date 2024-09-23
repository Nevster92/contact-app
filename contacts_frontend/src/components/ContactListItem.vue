<script setup lang="ts">
import type { Contact } from '@/API/ContactAPI'
import { useElementHover } from '@vueuse/core'
import Button from '@/components/Button.vue'
import Icon from './Icon.vue'
import { computed, inject, ref } from 'vue'
import ProfilePic from './ProfilePic.vue'
import DropdownMenuItem from './DropdownMenuItem.vue'
import { deleteContact } from '@/API/ContactAPI'
import ContactDetails from './ContactDetails.vue'

const props = defineProps<{
  contact: Contact
}>()
const refreshContactList = inject('refreshContactList')

const editContactModal = ref()
function openModal() {
  editContactModal.value.reveal()
}

const dropdown = ref(false)
const dropdownContext = ref()
const isHoveredDropdown = useElementHover(dropdownContext)

const showDropdown = computed(() => {
  if (dropdown.value && isHoveredDropdown.value) {
    return true
  }
  if (dropdown.value && !isHoveredDropdown.value) {
    dropdown.value = false
  } else {
    return false
  }
})

const dropdownItems = [
  { name: 'edit', text: 'Edit', icon: 'Settings' },
  { name: 'addFavourite', text: 'Favourite', icon: 'Favourite' },
  { name: 'delete', text: 'Remove', icon: 'Delete' }
]

async function listItemClickHandler(selectedItem: string) {
  if (selectedItem == 'delete') {
    await deleteContact(props.contact.id).then(() => {
      refreshContactList()
    })
  }
  if (selectedItem == 'edit') {
    openModal()
  }
}

const listElementRef = ref()
const isHovered = useElementHover(listElementRef)
</script>

<template>
  <div class="list-item" ref="listElementRef">
    <div style="display: flex; gap: 16px">
      <ProfilePic variant="small" :source="props.contact.picture" />

      <div class="list-details">
        <h3 class="list-name">{{ contact.name }}</h3>
        <span class="message">{{ contact.phone_number }}</span>
      </div>
    </div>
    <div>
      <div v-if="isHovered" class="list-menu list-menu-wrapper" ref="dropdownContext">
        <Button type="secoundary" text="">
          <template v-slot:prefix>
            <Icon icon="Mute"></Icon>
          </template>
        </Button>

        <Button type="secoundary" text="">
          <template v-slot:prefix>
            <Icon icon="Call"></Icon>
          </template>
        </Button>

        <Button type="secoundary" text="" @click.stop="dropdown = !dropdown">
          <template v-slot:prefix>
            <Icon icon="More"></Icon>
          </template>
        </Button>
        <div v-if="showDropdown" class="dropdown-inner">
          <div v-for="item in dropdownItems">
            <DropdownMenuItem
              @onClick="listItemClickHandler"
              :text="item.text"
              :icon="item.icon"
              :name="item.name"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
  <ContactDetails
    :contact="props.contact"
    title="Edit Contact"
    ref="editContactModal"
  ></ContactDetails>
</template>

<style>
.list-menu-wrapper {
  position: relative;
}
.dropdown-inner {
  display: flex;
  flex-direction: column;

  background-color: var(--G50);
  padding: 0.5em;
  position: absolute;
  top: 100%;
  right: 0;
  z-index: 10;
  border-radius: 5px;
  border: 1px solid var(--vp-c-divider);
  box-shadow: 2px 2px 5px rgba(10, 10, 10, 0.1);
}
.list-menu {
  display: flex;
}
.list-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 64px;
}
.list-name {
  display: flex;
  align-self: flex-start;
  margin: 0;
}
.list-details {
  display: flex;
  flex-direction: column;
}
</style>
