# 1、分支管理规范文档

## 分支列表
- main
- debug
- dev
- linrifen
- wangyuxuan
- wangyuze
- wangjingyu

## 分支说明

1. dev分支由组长创建，dev分支由main分支切出，组长将dev分支clone到本地，添加阅读分支管理规范文档、提交规范文档、前后端接口规范文档、任务分工文档、issue说明后提交。
2. 每个人名字的为每个人自己的开发分支，四个人在自己分支下完成代码开发，提交若干次commit，-m提交规范见《提交规范文档》
3. 若感觉自己需要新建分支，可新建每个人名字后加序号的分支，注意从各自的个人分支切出即可，如从linrifen分支可切出linrifen1,linrifen2，同时联系组长确认无误。
4. 通过提交pr的方式合并分支，解决合并冲突，提交pr请联系组长。
5. 待所有人完成代码后，四个个人分支会先合并到dev分支，此时dev分支中应含有整个项目代码。
6. 四个人均可将dev分支pull到本地，在本次尝试运行项目，若四个人都成功运行，可将dev分支合并到main分支，至此完成任务。
7. 若dev分支的全项目代码四个人pull到本地后均不能成功运行，利用debugger分支进行前端、后端、数据库联调
8. debug分支在后期综合测试时由组长创建，开发阶段不涉及到。

**注意：**

- 在开始开发之前，请仔细阅读：
  - 分支管理规范文档
  - 提交规范文档
  - 前后端接口规范文档
  - 任务分工文档
  - issue说明。

- 如果有问题，请及时联系组长。
