# world of zuul 接口文档-V1.0

## 1. 登录界面

### 1.1 基本信息

> 请求路径：/login
>
> 请求方式：POST
>
> 接口描述：该接口用于用户登录


error
### 1.2 请求参数

格式：application/json

参数说明：

| 参数名      | 类型   | 是否必须 | 备注   |
|----------| ------ | -------- |------|
| username | string | 必须     | 用户名称 |
| password | string | 必须     | 用户密码 |



### 1.3 响应数据

参数格式：application/json

参数说明：

| 参数名     | 类型      | 是否必须 | 备注                |
|---------| --------- | ------ |-------------------|
| code    | number    | 必须   | 响应码，1 代表成功，0 代表失败 |
| message | string    | 必须  | 提示信息              |
| data    | object[ ] | 必须  | 返回的数据             |


响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": "success login"
}
```
```json
{
  "code": 0,
  "msg": "error",
  "data": "error login"
}
```


## 2. 注册界面

### 2.1 基本信息

> 请求路径：/register
>
> 请求方式：POST
>
> 接口描述：该接口用于用户注册



### 2.2 请求参数

格式：application/json

参数说明：

| 参数名      | 类型   | 是否必须 | 备注   |
|----------| ------ | -------- |------|
| username | string | 必须     | 用户名称 |
| password | string | 必须     | 用户密码 |
| confirm  | string | 必须     | 验证密码 |



### 2.3 响应数据

参数格式：application/json

参数说明：

| 参数名     | 类型      | 是否必须 | 备注                |
|---------| --------- | ------ |-------------------|
| code    | number    | 必须   | 响应码，1 代表成功，0 代表失败 |
| message | string    | 必须  | 提示信息              |
| data    | object[ ] | 必须  | 返回的数据             |


响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": "success register"
}
```
```json
{
  "code": 0,
  "msg": "error",
  "data": "error register"
}
```



### 3 主界面

#### 3.1 基本信息

> 请求路径：/main
>
> 请求方式：POST
>
> 接口描述：该接口用于主界面聊天玩游戏




#### 3.2 请求参数

格式：application/json

参数说明：

| 参数名     | 类型   | 是否必须 | 备注   |
|---------| ------ | -------- |------|
| command | string | 必须     | 输入命令 |

请求参数样例：

```json
{
	"command": "go east"
}
```



#### 3.3 响应数据

参数格式：application/json

参数说明：

| 参数名     | 类型   | 是否必须 | 备注                           |
|---------| ------ | ------ | ------------------------------ |
| code    | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| message | string | 必须  | 提示信息                       |
| data    | object | 必须  | 返回的数据                     |

响应数据样例：

```json
{
    "code":1,
    "message":"success",
    "data":"you are in the office."
}
```
```json
{
    "code":1,
    "message":"success",
    "data":"I am sorry, I do not understand."
}
```
```json
{
    "code":0,
    "message":"error",
    "data":null
}
```


