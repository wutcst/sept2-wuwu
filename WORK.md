# 前端开发人员 -林日奋

## 技术要求
- Vue 2
- Element UI
- Vue CLI

## 主要任务

### 登录界面开发

- 创建登录页面的Vue组件。
- 使用Vue Router管理路由，并设置登录页面的路由。
- 使用Element UI组件库设计和构建登录表单。
- 实现登录表单的输入验证逻辑。
- 发起与后端的登录请求，并处理登录结果。
- 根据登录结果进行页面跳转或显示错误提示信息。

### 注册界面开发

- 创建注册页面的Vue组件。
- 使用Vue Router管理路由，并设置注册页面的路由。
- 使用Element UI组件库设计和构建注册表单。
- 实现注册表单的输入验证逻辑。
- 发起与后端的注册请求，并处理注册结果。
- 根据注册结果进行页面跳转或显示错误提示信息。

### 聊天界面开发

- 创建聊天页面的Vue组件。
- 使用Vue Router管理路由，并设置聊天页面的路由。
- 使用Element UI组件库设计和构建聊天界面的布局。
- 实现与后端的数据交互，包括发送和接收聊天消息。
- 显示聊天消息的历史记录和实时消息。
- 实现发送消息的功能，并处理发送消息的逻辑。
- 添加样式和动画效果，以提升用户体验。




# 王金宇 -后端开发人员1

技术要求：Java、Spring Boot、Maven、数据库（如MySQL等）

## 主要任务

### 实现"go"功能

- 设计并实现与移动命令相关的API接口，接收玩家的移动指令并进行相应的处理。
- 根据玩家的当前位置和目标位置，更新玩家的位置信息，并返回相应的结果。

### 实现"look"功能

- 设计并实现与查看命令相关的API接口，接收玩家的查看指令并进行相应的处理。
- 根据玩家的当前位置，返回当前房间的描述信息、可见物品等相关信息。

### 实现"items"功能

- 设计并实现与查看物品命令相关的API接口，接收玩家的查看物品指令并进行相应的处理。
- 根据玩家的当前位置，返回当前房间中的可见物品列表。

### 实现"take"功能

- 设计并实现与捡起命令相关的API接口，接收玩家的捡起指令并进行相应的处理。
- 根据玩家的当前位置和指定的物品，更新玩家的物品列表和房间的物品列表。

### 实现"drop"功能

- 设计并实现与放下命令相关的API接口，接收玩家的放下指令并进行相应的处理。
- 根据玩家的当前位置和指定的物品，更新玩家的物品列表和房间的物品列表。

# 王煜泽 -后端开发人员2

技术要求：Java、Spring Boot、Maven、数据库（如MySQL等）

## 主要任务

### 实现"help"功能

- 设计并实现与帮助命令相关的API接口，接收玩家的帮助指令并进行相应的处理。
- 返回游戏的帮助信息，包括命令列表、操作说明等。

### 实现"quit"功能

- 设计并实现与退出命令相关的API接口，接收玩家的退出指令并进行相应的处理。
- 处理玩家的退出逻辑，保存游戏进度并关闭游戏。

### 实现"eatCookie"功能

- 设计并实现与食用命令相关的API接口，接收玩家的食用指令并进行相应的处理。
- 根据玩家的当前位置和指定的食物，更新玩家的状态和房间的状态。

### 实现"back"功能

- 设计并实现与回退命令相关的API接口，接收玩家的回退指令并进行相应的处理。
- 实现玩家回退到上一个房间的功能。

### 实现"高级back"功能

- 设计并实现与高级回退命令相关的API接口，接收玩家的高级回退指令并进行相应的处理。
- 实现玩家回退到指定房间的功能。


# 王宇轩 -前后端联调和测试人员

## 主要任务

### 前端测试

- 使用Yapi进行前端接口测试，验证前端与后端API的交互是否正常。
- 模拟各种场景，包括正常操作、异常操作等，确保前端功能的稳定性和一致性。
- 检查前端界面的布局、样式和交互，确保用户体验良好。

### 后端测试

- 使用Postman进行后端接口测试，验证后端API的功能是否正确。
- 模拟各种请求，包括正确请求、错误请求等，确保后端的接口逻辑和数据处理的准确性。
- 检查后端返回的数据是否符合预期，确保数据传输的准确性和完整性。

### 联调和问题修复

- 协调前端和后端开发人员进行接口联调，解决接口调用的问题和错误。
- 跟踪和解决前后端交互过程中的数据传输问题。
- 收集反馈和bug报告，并与开发人员协作解决问题。

### 完成controller层设计和实现

#### LoginController

- 设计并实现`LoginController`，处理登录相关的请求。
- 创建与登录功能相关的API接口，接收用户的登录请求并进行相应的处理。
- 验证用户提交的登录信息，包括用户名和密码的合法性。
- 调用相应的服务层方法，验证用户身份信息，并返回登录结果。
- 处理登录成功或失败的情况，返回相应的响应结果给前端。

#### RegisterController

- 设计并实现`RegisterController`，处理注册相关的请求。
- 创建与注册功能相关的API接口，接收用户的注册请求并进行相应的处理。
- 验证用户提交的注册信息，包括用户名、密码和其他必填字段的合法性。
- 调用相应的服务层方法，创建新用户并保存注册信息。
- 处理注册成功或失败的情况，返回相应的响应结果给前端。

#### ChatController

- 设计并实现`ChatController`，处理聊天相关的请求。
- 创建与聊天功能相关的API接口，接收用户的聊天请求并进行相应的处理。
- 处理用户发送的聊天消息，包括保存消息、发送给其他用户等操作。
- 根据需要实现消息的广播、群聊、私聊等功能。
- 处理聊天消息的接收和展示，包括获取历史消息、实时接收新消息等。
- 处理聊天相关的业务逻辑，如消息过滤、敏感词处理等。


**注意：**

- 在开始开发之前，请仔细阅读：
  - 分支管理规范文档
  - 提交规范文档
  - 前后端接口规范文档
  - 任务分工文档
  - issue说明。

- 如果有问题，请及时联系组长。