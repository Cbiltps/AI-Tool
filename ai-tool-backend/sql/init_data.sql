-- 切换库
use ai_tool;

-- 用户表初始数据
INSERT INTO user (id, userAccount, userPassword, unionId, mpOpenId, userName, userAvatar, userProfile, userRole,
                  createTime, updateTime, isDelete)
VALUES (1, 'lcx123', 'b0dd3697a192885d7c055db46155b26a', null, null, '',
        'https://k.sinaimg.cn/n/sinakd20110/560/w1080h1080/20230930/915d-f3d7b580c33632b191e19afa0a858d31.jpg/w700d1q75cms.jpg',
        '欢迎来编程导航学习', 'admin', '2024-05-09 11:13:13', '2024-05-09 15:07:48', 0);

-- 应用表初始数据
INSERT INTO app (id, appName, appDesc, appIcon, appType, appLink, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (1, '自定义MBTI性格测试', '测试性格', '11', 1, '123', 1, null, null, null, 1, '2024-04-24 15:58:05',
        '2024-05-09 15:09:53', 0);

INSERT INTO app (id, appName, appDesc, appIcon, appType, appLink, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (2, '自定义得分测试', '测试得分', '22', 0, '123', 1, null, null, null, 1, '2024-04-25 11:39:30',
        '2024-05-09 15:09:53', 0);

INSERT INTO app (id, appName, appDesc, appIcon, appType, appLink, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (3, 'AI MBTI 性格测试', '快来测测你的 MBTI', '11', 1, '123', 1, null, null, null, 1, '2024-04-26 16:38:12',
        '2024-05-09 15:09:53', 0);

INSERT INTO app (id, appName, appDesc, appIcon, appType, appLink, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (4, 'AI 得分测试', '看看你熟悉多少首都', '22', 0, '123', 1, null, null, null, 1, '2024-04-26 16:38:56',
        '2024-05-09 15:09:53', 0);
