<script setup lang="ts">
import Icon from './Icon.vue'

const props = defineProps<{
  name: string
  text?: string
  icon?: string
}>()
const emit = defineEmits<{
  (e: 'onClick', name: string): void
}>()
</script>

<template>
  <div class="drpd-item" v-on:click="emit('onClick', name)">
    <Icon :icon="icon ? icon : ''" />
    {{ text }}
  </div>
</template>

<style>
.drpd-item {
  width: 219px;
  height: 44px;
  padding: 12px 10px 12px 10px;
  gap: 12px;
  opacity: 0px;

  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
}
.drpd-item:hover {
  background-color: var(--G70);
  cursor: pointer;
}
.drpd-item:active {
  background-color: var(--G40);
}
</style>
