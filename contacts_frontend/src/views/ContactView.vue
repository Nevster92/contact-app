<script setup lang="ts">
import { provide, ref } from 'vue'
import { getContacts } from '@/API/ContactAPI'
import type { Contact } from '@/API/ContactAPI'
import NavBar from '@/components/NavBar.vue'
import ContactListItem from '@/components/ContactListItem.vue'

const contacts = ref<Contact[] | null>(null)

function refreshContactList() {
  ;(async () => {
    contacts.value = await getContacts()
  })()
}

refreshContactList()

provide('refreshContactList', refreshContactList)
</script>

<template>
  <NavBar />
  <div class="contact-list-container">
    <ContactListItem v-for="contact in contacts" :contact="contact" />
  </div>
</template>

<style>
.contact-list-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  min-width: 60%;
}
</style>
