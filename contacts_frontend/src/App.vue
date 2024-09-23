<script setup lang="ts">
import ContactView from '@/views/ContactView.vue'
import '@/assets/styles/font.css'
import '@/assets/styles/main.css'
</script>

<template>
  <main class="main">
    <div id="pages" class="pages">
      <ContactView />
    </div>
  </main>
</template>
<style>
.pages {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
