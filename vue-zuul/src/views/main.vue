<!-- eslint-disable vue/multi-word-component-names -->

<!-- 简易版本1 -->
<!-- <template>
  <div class="chat-container">
    <div class="chat-messages">
      <div v-for="(message, index) in messages" :key="index">
        <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
        <div v-else class="user-message">{{ message.text }}</div>
      </div>
    </div>
    <form class="chat-input" @submit.prevent="sendMessage">
      <input type="text" v-model="inputText" placeholder="Type your message here" />
      <button type="submit">Send</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputText: '',
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
    }
  },
  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        this.inputText = ''
        setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000)
      }
    }
  }
}
</script>

<style>
.chat-container {
  display: flex;
  flex-direction: column;
}

.chat-messages {
  height: 300px;
  overflow-y: scroll;
  margin-bottom: 10px;
}

.bot-message {
  background-color: #f1f0f0;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-start;
}

.user-message {
  background-color: #e2f0d9;
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
  border: none;
}

.chat-input button {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  border: none;
  margin-left: 10px;
  cursor: pointer;
}
</style> -->



<!-- 版本2 -->
<!-- <template>
  <div class="chat-container">
    <el-row>
      <el-col :span="16">
        <div class="chat-messages">
          <div v-for="(message, index) in messages" :key="index">
            <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
            <div v-else class="user-message">{{ message.text }}</div>
          </div>
        </div>
        <form class="chat-input" @submit.prevent="sendMessage">
          <el-input v-model="inputText" placeholder="Type your message here" />
          <el-button type="primary" @click="sendMessage">Send</el-button>
        </form>
      </el-col>
      <el-col :span="8">
        <el-table :data="userData" style="width: 100%" border>
          <el-table-column prop="name" label="Name"></el-table-column>
          <el-table-column prop="age" label="Age"></el-table-column>
          <el-table-column prop="gender" label="Gender"></el-table-column>
        </el-table>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputText: '',
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
      userData: [
        { name: 'Alice', age: 25, gender: 'Female' },
        { name: 'Bob', age: 30, gender: 'Male' },
        { name: 'Charlie', age: 35, gender: 'Male' },
      ],
    }
  },
  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        this.inputText = ''
        setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000)
      }
    }
  }
}
</script>

<style>
.chat-container {
  margin: 20px;
}

.chat-messages {
  height: 300px;
  overflow-y: scroll;
  margin-bottom: 10px;
}

.bot-message {
  background-color: #f1f0f0;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-start;
}

.user-message {
  background-color: #e2f0d9;
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
  border: none;
}

.chat-input button {
  margin-left: 10px;
}
</style> -->



<!-- 版本3 -->
<!-- <template>
  <div class="chat-container">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <el-table :data="userData" style="width: 100%" border>
            <el-table-column prop="name" label="Name"></el-table-column>
            <el-table-column prop="age" label="Age"></el-table-column>
            <el-table-column prop="gender" label="Gender"></el-table-column>
          </el-table>
        </el-aside>
        <el-main>
          <div class="chat-messages">
            <div v-for="(message, index) in messages" :key="index">
              <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
              <div v-else class="user-message">{{ message.text }}</div>
            </div>
          </div>
          <form class="chat-input" @submit.prevent="sendMessage">
            <el-input v-model="inputText" placeholder="Type your message here" />
            <el-button type="primary" @click="sendMessage">Send</el-button>
          </form>
        </el-main>
      </el-container>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputText: '',
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
      userData: [
        { name: 'Alice', age: 25, gender: 'Female' },
        { name: 'Bob', age: 30, gender: 'Male' },
        { name: 'Charlie', age: 35, gender: 'Male' },
      ],
    }
  },
  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        this.inputText = ''
        setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000)
      }
    }
  }
}
</script>

<style>
.chat-container {
  height: 100vh;
}

.chat-messages {
  height: 300px;
  overflow-y: scroll;
  margin-bottom: 10px;
}

.bot-message {
  background-color: #f1f0f0;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-start;
}

.user-message {
  background-color: #e2f0d9;
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
  border: none;
}

.chat-input button {
  margin-left: 10px;
}
</style> -->




<!-- 版本1 -->
<!-- <template>
  <div class="chat-container">
    <el-container>
      <el-header class="header">World of Zuul 文字冒险游戏</el-header>
      <el-container>
        <el-aside>
        
          <el-table :data="userData" style="width: 100%" border>
            <el-table-column prop="name" label="Name"></el-table-column>
            <el-table-column prop="age" label="Age"></el-table-column>
          </el-table>
        </el-aside>

        <el-main>
          <div class="chat-messages">
            <div v-for="(message, index) in messages" :key="index">
              <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
              <div v-else class="user-message">{{ message.text }}</div>
            </div>
          </div>
          <form class="chat-input" @submit.prevent="sendMessage">
            <el-input v-model="inputText" placeholder="Type your message here" />
            <el-button type="primary" @click="sendMessage">Send</el-button>
          </form>
        </el-main>

      </el-container>
      <el-footer class="footer">武汉理工大学2024@copyright</el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputText: '',
      messages: [
        { text: 'Hello! How can I help you?', isBot: true },
      ],
      userData: [
        { name: 'Alice', age: 25 },
        { name: 'Bob', age: 30 },
        { name: 'Charlie', age: 35 },
        { name: 'David', age: 40 },
        { name: 'Emma', age: 45 },
        { name: 'Frank', age: 50 },
        { name: 'Grace', age: 55 },
        { name: 'Henry', age: 60 },
        { name: 'Ivy', age: 65 },
        { name: 'Jack', age: 70 },
      ],
    }
  },
  methods: {
    sendMessage() {
      if (this.inputText) {
        this.messages.push({ text: this.inputText, isBot: false })
        this.inputText = ''
        setTimeout(() => {
          this.messages.push({ text: 'I am sorry, I do not understand.', isBot: true })
        }, 1000)
      }
    }
  }
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

.chat-messages {
  /* height: 300px; */
  height: 500px;
  overflow-y: scroll;
  margin-bottom: 10px;

}

.bot-message {
  /* background-color: #f1f0f0; */
  background-color: #C4FCEF;
  color: #333;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  align-self: flex-start;
}

.user-message {
  /* background-color: #e2f0d9; */
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
  /* border: none; */
  border-width: 3px;
  border-color: #333;
}

.chat-input button {
  margin-left: 10px;
}
</style> -->



<template>
  <div class="chat-container">
    <el-container>
      <el-header class="header" style="height: 20px;">World of Zuul 文字冒险游戏</el-header>
      <el-container>
        <el-aside>
          <div class="additional-text">{{ additionalText }}</div>
          
          <el-table :data="tableData" style="width: 100%" border>
            <el-table-column prop="command" label="操作"></el-table-column>
            <el-table-column prop="description" label="说明"></el-table-column>
          </el-table>

        </el-aside>

        <el-main>
          <div class="chat-messages">
            <div v-for="(message, index) in messages" :key="index">
              <div v-if="message.isBot" class="bot-message">{{ message.text }}</div>
              <div v-else class="user-message">{{ message.text }}</div>
            </div>
          </div>
          <form class="chat-input" @submit.prevent="sendMessage">
            <el-input v-model="inputText" placeholder="Type your message here" />
            <el-button type="primary" @click="sendMessage">Send</el-button>
          </form>
        </el-main>

      </el-container>
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
          this.messages.push({text: botMessage, isBot: true})
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
