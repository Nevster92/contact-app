<script setup lang="ts">
const props = defineProps<{
  type: 'primary' | 'secoundary' | 'special'
  text: string
}>()
const emit = defineEmits(['onClick'])
</script>

<template>
  <button :class="'button button-' + props.type" @click="emit('onClick')">
    <slot name="prefix"></slot>
    {{ text }}
    <slot name="suffix"></slot>
  </button>
</template>

<style>
.button {
  all: unset;

  height: 40px;

  color: #ffff;
  padding: 8px 16px 8px 16px;
  gap: 8px;
  border-radius: 8px;
  opacity: 0px;
  cursor: pointer;

  display: flex;
  align-items: center;
  justify-content: center;
}
.button-primary {
  background: var(--G60);
}
.button-primary:hover {
  background: var(--G50);
}
.button-primary:active {
  background: var(--G40);
}

.button-secoundary {
  background: none;
}
.button-secoundary:hover {
  background: var(--G90);
}
.button-secoundary:active {
  background: var(--G80);
}

.button-special {
  border-radius: 1000px;
  border: 1px solid transparent;

  background:
    linear-gradient(180deg, rgba(40, 40, 40, 0.7) 0%, #282828 100%) padding-box,
    linear-gradient(180deg, #3c3c3c 0%, rgba(60, 60, 60, 0) 100%) border-box;
}

.button-special:hover {
  background:
    linear-gradient(0deg, rgba(255, 255, 255, 0.04), rgba(255, 255, 255, 0.04)) padding-box,
    linear-gradient(180deg, #3c3c3c 0%, rgba(60, 60, 60, 0) 100%) border-box;
}
</style>
