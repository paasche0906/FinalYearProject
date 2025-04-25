<template>
  <div id="questionSubmitView">
    <a-form :model="searchParams" layout="inline">
      <a-form-item
        field="questionId"
        label="questionId"
        style="min-width: 240px"
      >
        <a-input v-model="searchParams.questionId" placeholder="Please enter" />
      </a-form-item>
      <a-form-item field="language" label="language" style="min-width: 240px">
        <a-select
          v-model="searchParams.language"
          :style="{ width: '320px' }"
          placeholder="Select Programming Language"
        >
          <a-option>java</a-option>
          <a-option>cpp</a-option>
          <a-option>go</a-option>
          <a-option>html</a-option>
        </a-select>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" @click="doSubmit">Search</a-button>
      </a-form-item>
    </a-form>
    <a-divider size="0" />
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
      <template #judgeInfo="{ record }">
        {{ JSON.stringify(record.judgeInfo) }}
      </template>
      <template #createTime="{ record }">
        {{ moment(record.createTime).format("YYYY-MM-DD") }}
      </template>
    </a-table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watchEffect } from "vue";
import {
  Question,
  QuestionControllerService,
  QuestionSubmitQueryRequest,
} from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import moment from "moment";

const tableRef = ref();

const dataList = ref([]);
const total = ref(0);
const searchParams = ref<QuestionSubmitQueryRequest>({
  questionId: undefined,
  language: undefined,
  pageSize: 10,
  current: 1,
});

const loadData = async () => {
  const res = await QuestionControllerService.listQuestionSubmitByPageUsingPost(
    {
      ...searchParams.value,
      sortField: "createTime",
      sortOrder: "descend",
    }
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
    title: "language",
    dataIndex: "language",
  },
  {
    title: "judgeInfo",
    slotName: "judgeInfo",
  },
  {
    title: "status",
    dataIndex: "status",
  },
  {
    title: "questionId",
    dataIndex: "questionId",
  },
  {
    title: "userId",
    dataIndex: "userId",
  },
  {
    title: "createTime",
    slotName: "createTime",
  },
];

const onPageChange = (page: number) => {
  searchParams.value = {
    ...searchParams.value,
    current: page,
  };
};

const router = useRouter();

/**
 * Jump to the question page
 * @param question
 */
const toQuestionPage = (question: Question) => {
  router.push({
    path: `/view/question/${question.id}`,
  });
};

/**
 * Confirm search, reload data
 */
const doSubmit = () => {
  // Here you need to reset the search page number
  searchParams.value = {
    ...searchParams.value,
    current: 1,
  };
};
</script>

<style scoped>
#questionSubmitView {
  max-width: 1280px;
  margin: 0 auto;
}
</style>
