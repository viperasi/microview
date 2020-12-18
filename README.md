# microview

#### 介绍
基于springboot, dubbo, vue, qiankun的微前端、微服务架构

#### 软件架构

* [springboot-1.5.21.RELEASE](https://spring.io/projects/spring-boot)
* [dubbo-2.7.6](https://dubbo.apache.org/)
* [vue-2.6.11](https://vuejs.org/)
* [qiankun-2.3.3](https://qiankun.umijs.org/zh)
* [vuetify-2.2.11](https://vuetifyjs.com/zh-Hans/)
* [zookeeper-3.4.12](https://zookeeper.apache.org/)

#### 安装教程

> 开发环境

* `zookeeper 3.4.12`
* `nodejs 12.16.1`
* `jdk 1.8`

> 安装步骤 

1.  git clone
2.  使用IDEA导入maven项目
3.  各个项目的ux目录下执行: `npm install`
4.  各个项目下`resource/dubbo_provider.xml`文件内修改`dubbo:registry`为本地`zookeeper`地址
4.  各个项目`src`目录下的`*Application`为主启动类
5.  各个项目`ux`目录下执行`npm run serve` 或 `yarn serve`

#### 使用说明

1.  打开`http://localhost:8090`为主入口
2.  右上角可以切换应用

#### 项目目录

microview  
├─microview-api(业务接口包)  
├─microview-common(通用工具包)  
├─microview-main(主入口服务)  
|└ux(前端目录)  
├─microview-goods(物品管理服务)  
└microview-user(用户管理)  
