<script setup lang="ts">
const props = defineProps<{
  icon: string
}>()
</script>

<template>
  <img :src="`src/assets/icons/${props.icon}.png`" alt="Icon" />
</template>
