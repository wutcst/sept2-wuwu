<!-- eslint-disable vue/multi-word-component-names -->

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
axios.defaults.withCredentials=true;
export default {
  data() {
    return {
      inputText: '',
      additionalText: 'world-of-zull是由will Crowther在20世纪70年代开发、并经过Don woods扩充的一个探险游戏，原版的游戏有时候也叫作巨洞探险。现由软件工程实践小组 WHUT-Group-wuwu实现该简易游戏界面。欢迎尝试游玩！', /* 显示的文本介绍 */
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
      tableData: [
        { command: 'go', description: '移动角色' },
        { command: 'back', description: '回退移动' },
        { command: 'items', description: '查看背包' },
        { command: 'look', description: '查看房间物品' },
        { command: 'take', description: '捡起房间物品' },
        { command: 'drop', description: '丢弃背包物品' },
        { command: 'eat', description: '食用cookie' },
        { command: 'help', description: '查看帮助' },
        { command: 'quit', description: '结束游戏' },
      ],
    }
  },

  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        /* this.inputText = '' */

        /* 这里发get还是post都可以，还是选择发post */
        /* 这里目前没有写判断code值为0或1的逻辑，后端传过来的数据code值都应该为1，只需要获取data.data即可 */
        /* 但接口文档里貌似code为0失败时的data为null，后期测试时按需修改 */
        axios.post('http://localhost:8080/main', {"command": this.inputText}).then((result) => {
          const botMessage = result.data.data;
          this.messages.push({ text: botMessage, isBot: true })
        }).catch((err) => {
          console.log(err);
        });
        this.inputText = ''
        /* 超时的时候返回值 */
        /* setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000) */
      }
    }
  },
}
</script>


<!-- 样式设计 -->
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
