<!-- eslint-disable vue/multi-word-component-names -->
<!-- 在这里禁用了名为vue/multi-word-component-names的ESLint规则 -->

<template>
  <!-- 模板部分 -->
  <div class="chat-container">
    <!-- 聊天容器 -->
    <el-container>
      <!-- header区域 -->
      <el-header class="header" style="height: 20px;">World of Zuul 文字冒险游戏</el-header>
      <el-container>
        <!-- aside区域 -->
        <el-aside>
          <!-- 文本框显示介绍 -->
          <div class="additional-text">{{ additionalText }}</div>
          <!-- 表格显示指令 -->
          <el-table :data="tableData" style="width: 100%" border>
            <el-table-column prop="command" label="操作"></el-table-column>
            <el-table-column prop="description" label="说明"></el-table-column>
          </el-table>
        </el-aside>
        <!-- main区域 -->
        <el-main>
          <!-- 聊天消息 -->
          <div class="chat-messages">
            <div v-for="(message, index) in messages" :key="index">
              <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
              <div v-else class="user-message">{{ message.text }}</div>
            </div>
          </div>
          <!-- 聊天输入表单 -->
          <form class="chat-input" @submit.prevent="sendMessage">
            <!-- 文字输入框 -->
            <el-input v-model="inputText" placeholder="Type your message here" />
            <!-- 发送按钮 -->
            <el-button type="primary" @click="sendMessage">Send</el-button>
          </form>
        </el-main>
      </el-container>
      <!-- footer区域 -->
      <el-footer class="footer">武汉理工大学2024@copyright</el-footer>
    </el-container>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      inputText: '',
      additionalText: 'world-of-zull是由will Crowther在20世纪70年代开发、并经过Don woods扩充的一个探险游戏。原版的游戏有时候也叫作巨洞探险(Colossal Cave Adventure）。在那个时代可是一个精彩的、充满想象力的复杂游戏，包括要在一个复杂的洞穴系统中找到出路、寻找隐藏的财宝、使用暗语和其他一些神秘的工具，最终的目的是获得高分。', // 添加的文本框的文字内容
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
      tableData: [
        { command: 'go', description: '移动' },
        { command: 'back', description: '回到上一个房间' },
        { command: 'back over', description: '回到初始房间' },
        { command: 'look', description: '查看物品' },
        { command: 'take', description: '捡起物品' },
        { command: 'eat', description: '食用物品' },
        { command: 'help', description: '查看帮助' },
      ],
    }
  },

  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        this.inputText = ''

        axios.get('http://yapi.smart-xwork.cn/mock/264710/yapi/test01').then((result) => {
          const botMessage = result.data.data;
          this.messages.push({ text: botMessage, isBot: true })
        }).catch((err) => {
          console.log(err);
        });

        /* setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000) */
      }
    }
  },
}
</script>

<style>
.chat-container {
  height: 100vh;
}


.header,
.footer {
  text-align: center;
}

.el-aside {
  height: calc(100vh - 100px);
  overflow-y: auto;
}

.additional-text {
  margin-bottom: 10px;
  padding: 10px;
  background-color: #f1f0f0;
  color: #333;
  border-radius: 5px;
}

.chat-messages {
  height: 520px;
  overflow-y: scroll;
  margin-bottom: 10px;
}

.bot-message {
  background-color: #C4FCEF;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-start;
}

.user-message {
  background-color: #FEFEDF;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-end;
}

.chat-input {
  display: flex;
  margin-top: 10px;
}

.chat-input input {
  flex: 1;
  padding: 10px;
  border-radius: 5px;
  border-width: 3px;
  border-color: #333;
}

.chat-input button {
  margin-left: 10px;
}
</style>
