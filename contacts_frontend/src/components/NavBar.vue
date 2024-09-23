<script setup lang="ts">
import Icon from './Icon.vue'
import Button from '@/components/Button.vue'
import ContactDetails from './ContactDetails.vue'
import { ref } from 'vue'

const contactDetailsModalRef = ref()

function openModal() {
  contactDetailsModalRef.value.reveal()
}
</script>

<template>
  <div class="nav-container">
    <div class="nav-prefix">
      <Icon icon="Backarrow" />
    </div>
    <div class="nav-content">
      <h1 style="flex-grow: 1">Contacts</h1>
      <div class="nav-buttons">
        <Icon icon="Settings" />
        <Icon icon="Profile" />

        <Button type="special" text="Add new" @onClick="openModal">
          <template #prefix>
            <Icon icon="Add" />
          </template>
        </Button>
        <ContactDetails title="Add Contact" ref="contactDetailsModalRef" />
      </div>
    </div>
    <div class="nav-suffix">
      <Icon icon="Lightmode" />
    </div>
  </div>
</template>

<style scss>
.nav-container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  gap: 24px;
  min-width: 80%;
}
.nav-content {
  display: flex;
  flex-direction: row;
  width: 60%;
  align-items: center;
}
.nav-buttons {
  display: flex;
  flex-direction: row;
  gap: 24px;
  align-items: center;
}

@media (max-width: 480px) {
  .nav-container .nav-content {
    flex-direction: column;
  }
}
</style>
