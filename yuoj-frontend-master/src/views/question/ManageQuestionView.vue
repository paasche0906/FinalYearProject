<template>
  <div id="manageQuestionView">
    <a-table
      :ref="tableRef"
      :columns="columns"
      :data="dataList"
      :pagination="{
        showTotal: true,
        pageSize: searchParams.pageSize,
        current: searchParams.current,
        total,
      }"
      @page-change="onPageChange"
    >
      <template #optional="{ record }">
        <a-space>
          <a-button type="primary" @click="doUpdate(record)">Modify</a-button>
          <a-button status="danger" @click="doDelete(record)">Delete</a-button>
        </a-space>
      </template>
    </a-table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watchEffect } from "vue";
import {
  Page_Question_,
  Question,
  QuestionControllerService,
} from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import * as querystring from "querystring";
import { useRouter } from "vue-router";

const tableRef = ref();

const dataList = ref([]);
const total = ref(0);
const searchParams = ref({
  pageSize: 10,
  current: 1,
});

const loadData = async () => {
  const res = await QuestionControllerService.listQuestionByPageUsingPost(
    searchParams.value
  );
  if (res.code === 0) {
    dataList.value = res.data.records;
    total.value = res.data.total;
  } else {
    message.error("Failed to load." + res.message);
  }
};

/**
 * Listens to the searchParams variable and triggers a page reload when it changes.
 */
watchEffect(() => {
  loadData();
});

/**
 * Requesting data when the page loads
 */
onMounted(() => {
  loadData();
});

const columns = [
  {
    title: "id",
    dataIndex: "id",
  },
  {
    title: "title",
    dataIndex: "title",
  },
  {
    title: "content",
    dataIndex: "content",
  },
  {
    title: "tag(s)",
    dataIndex: "tags",
  },
  {
    title: "answer",
    dataIndex: "answer",
  },
  {
    title: "submitNum",
    dataIndex: "submitNum",
  },
  {
    title: "acceptedNum",
    dataIndex: "acceptedNum",
  },
  {
    title: "judgeConfig",
    dataIndex: "judgeConfig",
  },
  {
    title: "judgeCase",
    dataIndex: "judgeCase",
  },
  {
    title: "userId",
    dataIndex: "userId",
  },
  {
    title: "createTime",
    dataIndex: "createTime",
  },
  {
    title: "optional",
    slotName: "optional",
  },
];

const onPageChange = (page: number) => {
  searchParams.value = {
    ...searchParams.value,
    current: page,
  };
};

const doDelete = async (question: Question) => {
  const res = await QuestionControllerService.deleteQuestionUsingPost({
    id: question.id,
  });
  if (res.code === 0) {
    message.success("Deleted successfully");
    loadData();
  } else {
    message.error("Deletion failed.");
  }
};

const router = useRouter();

const doUpdate = (question: Question) => {
  router.push({
    path: "/update/question",
    query: {
      id: question.id,
    },
  });
};
</script>

<style scoped>
#manageQuestionView {
}
</style>
