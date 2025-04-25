<template>
  <div id="addQuestionView">
    <h2>Create a question</h2>
    <a-form :model="form" label-align="left">
      <a-form-item field="title" label="title">
        <a-input v-model="form.title" placeholder="Please enter a title" />
      </a-form-item>
      <a-form-item field="tags" label="label">
        <a-input-tag
          v-model="form.tags"
          placeholder="Please select a label"
          allow-clear
        />
      </a-form-item>
      <a-form-item field="content" label="Question content">
        <MdEditor :value="form.content" :handle-change="onContentChange" />
      </a-form-item>
      <a-form-item field="answer" label="answer">
        <MdEditor :value="form.answer" :handle-change="onAnswerChange" />
      </a-form-item>
      <a-form-item
        label="Judgement configuration"
        :content-flex="false"
        :merge-props="false"
      >
        <a-space direction="vertical" style="min-width: 480px">
          <a-form-item field="judgeConfig.timeLimit" label="timeLimit">
            <a-input-number
              v-model="form.judgeConfig.timeLimit"
              placeholder="Please enter a time limit"
              mode="button"
              min="'0'"
              size="large"
            />
          </a-form-item>
          <a-form-item field="judgeConfig.memoryLimit" label="memoryLimit">
            <a-input-number
              v-model="form.judgeConfig.memoryLimit"
              placeholder="Please enter the memory limit"
              mode="button"
              min="'0'"
              size="large"
            />
          </a-form-item>
          <a-form-item field="judgeConfig.stackLimit" label="stackLimit">
            <a-input-number
              v-model="form.judgeConfig.stackLimit"
              placeholder="Please enter the stack limit"
              mode="button"
              min="'0'"
              size="large"
            />
          </a-form-item>
        </a-space>
      </a-form-item>
      <a-form-item
        label="Test Case Configuration"
        :content-flex="false"
        :merge-props="false"
      >
        <a-form-item
          v-for="(judgeCaseItem, index) of form.judgeCase"
          :key="index"
          no-style
        >
          <a-space direction="vertical" style="min-width: 640px">
            <a-form-item
              :field="`form.judgeCase[${index}].input`"
              :label="`Input Use Cases-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.input"
                placeholder="Please enter a test input case"
              />
            </a-form-item>
            <a-form-item
              :field="`form.judgeCase[${index}].output`"
              :label="`Output use case-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.output"
                placeholder="Please enter a test output case"
              />
            </a-form-item>
            <a-button status="danger" @click="handleDelete(index)">
              Delete
            </a-button>
          </a-space>
        </a-form-item>
        <div style="margin-top: 32px">
          <a-button @click="handleAdd" type="outline" status="success"
            >Add test cases
          </a-button>
        </div>
      </a-form-item>
      <div style="margin-top: 16px" />
      <a-form-item>
        <a-button type="primary" style="min-width: 200px" @click="doSubmit"
          >Submit
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import { QuestionControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRoute } from "vue-router";

const route = useRoute();
// If the page address contains update, the page is considered updated
const updatePage = route.path.includes("update");

let form = ref({
  title: "",
  tags: [],
  answer: "",
  content: "",
  judgeConfig: {
    memoryLimit: 1000,
    stackLimit: 1000,
    timeLimit: 1000,
  },
  judgeCase: [
    {
      input: "",
      output: "",
    },
  ],
});

/**
 * Get old data by topic id
 */
const loadData = async () => {
  const id = route.query.id;
  if (!id) {
    return;
  }
  const res = await QuestionControllerService.getQuestionByIdUsingGet(
    id as any
  );
  if (res.code === 0) {
    form.value = res.data as any;
    // json to js object
    if (!form.value.judgeCase) {
      form.value.judgeCase = [
        {
          input: "",
          output: "",
        },
      ];
    } else {
      form.value.judgeCase = JSON.parse(form.value.judgeCase as any);
    }
    if (!form.value.judgeConfig) {
      form.value.judgeConfig = {
        memoryLimit: 1000,
        stackLimit: 1000,
        timeLimit: 1000,
      };
    } else {
      form.value.judgeConfig = JSON.parse(form.value.judgeConfig as any);
    }
    if (!form.value.tags) {
      form.value.tags = [];
    } else {
      form.value.tags = JSON.parse(form.value.tags as any);
    }
  } else {
    message.error("Failed to load." + res.message);
  }
};

onMounted(() => {
  loadData();
});

const doSubmit = async () => {
  console.log(form.value);
  // Distinguish between updating and creating
  if (updatePage) {
    const res = await QuestionControllerService.updateQuestionUsingPost(
      form.value
    );
    if (res.code === 0) {
      message.success("Successful update");
    } else {
      message.error("Update failure，" + res.message);
    }
  } else {
    const res = await QuestionControllerService.addQuestionUsingPost(
      form.value
    );
    if (res.code === 0) {
      message.success("Created successfully");
    } else {
      message.error("Creation failed." + res.message);
    }
  }
};

/**
 * Add a new example of problem solving
 */
const handleAdd = () => {
  form.value.judgeCase.push({
    input: "",
    output: "",
  });
};

/**
 * Deletion of Judgement Cases
 */
const handleDelete = (index: number) => {
  form.value.judgeCase.splice(index, 1);
};

const onContentChange = (value: string) => {
  form.value.content = value;
};

const onAnswerChange = (value: string) => {
  form.value.answer = value;
};
</script>

<style scoped>
#addQuestionView {
}
</style>
