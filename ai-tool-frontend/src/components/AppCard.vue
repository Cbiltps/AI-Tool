<template>
  <a-card class="appCard" @click="doCardClick" :title="app.appName" hoverable>
    <a-avatar
      :style="{ marginRight: '8px', backgroundColor: '#165DFF' }"
      :size="35"
      :imageUrl="app.appIcon"
    >
    </a-avatar>
    <template #extra>
      <a-link :href="props.app.appLink" @click="handleClick">点击体验</a-link>
    </template>
    {{ app.appDesc }}
  </a-card>
  <ShareModal :link="shareLink" title="应用分享" ref="shareModalRef" />
</template>

<script setup lang="ts">
import API from "@/api";
import { defineProps, ref, withDefaults } from "vue";
import { useRouter } from "vue-router";
import ShareModal from "@/components/ShareModal.vue";

interface Props {
  app: API.AppVO;
}

const props = withDefaults(defineProps<Props>(), {
  app: () => {
    return {};
  },
});

const router = useRouter();
const doCardClick = () => {
  router.push(`/app/detail/${props.app.id}`);
};

// 分享弹窗的引用
const shareModalRef = ref();

// 分享链接
const shareLink = `${window.location.protocol}//${window.location.host}/app/detail/${props.app.id}`;

// 分享
// const doShare = (e: Event) => {
//   if (shareModalRef.value) {
//     shareModalRef.value.openModal();
//   }
//   // 阻止冒泡，防止跳转到详情页
//   e.stopPropagation();
// };

const handleClick = (e: Event) => {
  // 阻止冒泡，防止跳转到详情页
  e.stopPropagation();
};
</script>
<style scoped>
.appCard {
  width: 270px;
  cursor: pointer;
  transition-property: all;
}

.appCard:hover {
  transform: translateY(-4px);
}

.appCard .arco-card-head-title {
  transition: color 0.3s; /* 添加颜色变化过渡效果 */
}
</style>
