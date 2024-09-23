<script setup lang="ts">
import { useFileDialog } from '@vueuse/core'
import ProfilePic from './ProfilePic.vue'
import Button from './Button.vue'
import Icon from './Icon.vue'
import convertToBase64 from '@/utils/Base64Converter'

const props = defineProps<{
  warning?: string | null
}>()

const { files, open, onChange } = useFileDialog({
  accept: 'image/*'
})

onChange((file) => {
  if (file[0]) {
    convertToBase64(file[0])
      .then((resoult) => {
        imageSource.value = resoult
      })
      .catch((error) => {
        console.error('Error converting file to base64:', error)
      })
  }
})

const imageSource = defineModel<string | null>()
</script>

<template>
  <div class="select-picture">
    <ProfilePic variant="big" :source="imageSource || ''" />
    <span v-if="warning" style="color: red">{{ warning }}</span>
    <Button v-if="imageSource == ''" type="primary" text="Add picture" :onClick="open">
      <template #prefix>
        <Icon icon="Add" />
      </template>
    </Button>
    <Button v-else type="primary" text="Change picture" :onClick="open">
      <template #prefix>
        <Icon icon="Change" />
      </template>
    </Button>

    <Button v-if="imageSource" type="primary" text="" :onclick="() => (imageSource = null)">
      <template v-slot:prefix>
        <Icon icon="Delete"></Icon>
      </template>
    </Button>
  </div>
</template>

<style>
.select-picture {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 24px;
}
</style>
