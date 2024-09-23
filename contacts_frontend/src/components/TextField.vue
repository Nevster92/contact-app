<script setup lang="ts">
const props = defineProps<{
  label: string
  placeholder?: string
  warning?: string | null
  type: 'text' | 'email' | 'phone'
}>()
const inputText = defineModel<string | null>()

function validateInput(event: Event) {
  const input = event.target as HTMLInputElement
  const value = input.value

  if (props.type == 'phone') {
    const validValue = value.replace(/[^0-9 +]/g, '')
    if (validValue !== value) {
      input.value = validValue
    }
  }
  if (props.type == 'email') {
    const validValue = value.replace(/[^a-zA-Z0-9._%+-@]/g, '')
    if (validValue !== value) {
      input.value = validValue
    }
  }
}
</script>

<template>
  <div class="texfield-container">
    <label class="message"
      >{{ label }} <span v-if="warning" style="color: red">{{ warning }}</span></label
    >
    <input
      @input="validateInput"
      v-model="inputText"
      class="input"
      type="text"
      :placeholder="placeholder"
    />
  </div>
</template>

<style>
.texfield-container {
  display: flex;
  flex-direction: column;
  gap: 4px;
}
.input {
  all: unset;

  width: 390px px;
  height: 40px px;
  padding: 8px 12px 8px 12px;
  gap: 8px;
  border-radius: 8px;
  border: 1px solid;
  border-color: var(--G60);

  background-color: var(--G70);
}
.input:hover {
  border-color: var(--G30);
}
.input:focus {
  border-color: var(--G30);
  background-color: var(--G60);
}
</style>
