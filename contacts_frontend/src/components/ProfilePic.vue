<script setup lang="ts">
const props = defineProps<{
  variant: 'big' | 'small'
  source?: string
}>()

const defaultSource = 'src/assets/Default.png'
</script>

<template>
  <img
    :class="'profile-pic-' + variant"
    :src="source ? props.source : defaultSource"
    alt="Contact Picture"
  />
</template>

<style>
.profile-pic-big {
  height: 88px;
  width: 88px;
  border-radius: 9999px;
}
.profile-pic-small {
  height: 40px;
  width: 40px;
  border-radius: 9999px;
}
</style>
