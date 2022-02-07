## 一、前言

### 1.项目背景

此项目并非原创，项目原型是李仁密老师的作品，具体的教学视频来自b站https://www.bilibili.com/video/BV1nE411r7TF，不过up主貌似也是搬运的。
此个人博客前端是模仿李仁密老师的，其中，我根据自身需求做出了部分修改。
因为我是主后端的，想借此机会来锻炼自己，所以后端数据的增删改查这部分是换成mybatis语句（不过异常的控制器和博客内容转html这部分是借鉴了李仁密老师的）。

### 2.部分效果图参考

部分效果图在blog-picture文件夹里面，仅供参考。

## 二、项目总述

### 1.项目描述

此项目为个人博客系统，分为前台和后台两部分。前台负责展示你所写的博客，且页面适配移动端（也是参考李仁密老师的项目）。管理员可以登录后台来对博客、分类、评论等进行管理。

### 2.技术栈介绍
前端：Semantic UI、Thymeleaf
后端：SpringBoot、Spring、SpringMVC、Mybatis
数据库：MySQL

### 3.环境介绍
数据库：mysql8.0.27；
前端框架：Semantic UI、Thymeleaf模板引擎；
后端框架：SpringBoot、Spring+SpringMVC+MyBatis；
语言：Java；
JDK版本：11；
编译器IDE：IDEA 2020.2.2；
插件引用：
LomBok（简化部分代码插件）、Animate.css-master（动画效果）、editor.md-master（markdown插件）、tocbot-master（目录生成）、typo.css-master（网页排版）、pageHelper（分页插件）
