<script setup lang="ts">
import { useConfirmDialog } from '@vueuse/core'
import Button from './Button.vue'
import TextField from './TextField.vue'
import SelectPicture from './SelectPicture.vue'
import { inject, ref } from 'vue'
import { createNewContact, updateContact, type Contact } from '@/API/ContactAPI'

const { isRevealed, reveal, confirm, cancel } = useConfirmDialog()

defineExpose({
  reveal
})

const props = withDefaults(
  defineProps<{
    contact?: Contact
  }>(),
  {
    contact: {
      name: '',
      phone_number: '',
      email: '',
      picture: ''
    }
  }
)

const refreshContactList = inject('refreshContactList')
const attempt = ref<boolean>(false)

const contactRef = ref<Contact>({ ...props.contact })

async function handleSubmit() {
  if (contactRef.value.name == '' || contactRef.value.picture == '') {
    attempt.value = true
  } else if (contactRef.value.id) {
    await updateContact(contactRef.value).then(() => {
      refreshContactList()
      confirm()
    })
  } else if (!contactRef.value.id) {
    await createNewContact(contactRef.value).then(() => {
      refreshContactList()
      confirm()
    })
  }
}

function handleCancel() {
  contactRef.value = props.contact
  attempt.value = false
  cancel()
}
</script>

<template>
  <Teleport to="#app">
    <div v-if="isRevealed" class="contact-modal-bg">
      <div class="contact-details-container">
        <h2 class="contact-details-title">{{ contact ? 'Edit Contact' : 'Create Contact' }}</h2>

        <SelectPicture
          :warning="attempt && !contactRef.picture ? 'Required!' : null"
          v-model="contactRef.picture"
        />

        <TextField
          :warning="attempt && !contactRef.name ? 'Required!' : null"
          v-model="contactRef.name"
          label="Name"
          type="text"
          placeholder="Jamie Wright"
        ></TextField>
        <TextField
          v-model="contactRef.phone_number"
          type="phone"
          label="Phone number"
          placeholder="+01 234 5678"
        ></TextField>
        <TextField
          v-model="contactRef.email"
          type="email"
          label="Email address"
          placeholder="jamie.wright@mail.com"
        ></TextField>
        <div class="footer-navigation">
          <Button type="secoundary" text="Cancel" @click="handleCancel" />
          <Button type="primary" text="Done" @click="handleSubmit" />
        </div>
      </div>
    </div>
  </Teleport>
</template>

<style>
.footer-navigation {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}

.contact-details-container {
  display: flex;
  flex-direction: column;
  max-width: 80%;

  padding: 24px;
  gap: 16px;

  opacity: 1;
  background-color: var(--G100);
}
.contact-details-title {
  margin: 0;
}
.contact-modal-bg {
  z-index: 1000;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);

  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
