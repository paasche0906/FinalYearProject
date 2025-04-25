# Database initialisation

-- Creating Libraries
create database if not exists yuoj;

-- toggle library
use yuoj;

-- user table
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment 'account',
    userPassword varchar(512)                           not null comment 'password',
    unionId      varchar(256)                           null comment 'WeChat Open Platform id',
    mpOpenId     varchar(256)                           null comment 'public numberopenId',
    userName     varchar(256)                           null comment 'user nickname',
    userAvatar   varchar(1024)                          null comment 'user avatar',
    userProfile  varchar(512)                           null comment 'User Profile',
    userRole     varchar(256) default 'user'            not null comment 'user role：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'Creation time',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete     tinyint      default 0                 not null comment 'Delete or not',
    index idx_unionId (unionId)
) comment 'user' collate = utf8mb4_unicode_ci;

-- question table
create table if not exists question
(
    id          bigint auto_increment comment 'id' primary key,
    title       varchar(512)                       null comment 'title',
    content     text                               null comment 'content',
    tags        varchar(1024)                      null comment 'List of tags (json array)',
    answer      text                               null comment 'Answers to the questions',
    submitNum   int      default 0                 not null comment 'Number of topic submissions',
    acceptedNum int      default 0                 not null comment 'The title passes through the number',
    judgeCase   text                               null comment 'Problem examples (json arrays)',
    judgeConfig text                               null comment 'Judgement Configuration (json object)',
    thumbNum    int      default 0                 not null comment 'Likes',
    favourNum   int      default 0                 not null comment 'Favourites',
    userId      bigint                             not null comment 'Create user id',
    createTime  datetime default CURRENT_TIMESTAMP not null comment 'Creation time',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete    tinyint  default 0                 not null comment 'Whether to delete ',
    index idx_userId (userId)
) comment 'question' collate = utf8mb4_unicode_ci;

-- Title Submission Form
create table if not exists question_submit
(
    id         bigint auto_increment comment 'id' primary key,
    language   varchar(128)                       not null comment 'programming language',
    code       text                               not null comment 'user code',
    judgeInfo  text                               null comment 'Judgement information (json object)',
    status     int      default 0                 not null comment 'Judgement status (0 - pending judgement, 1 - judgement in progress, 2 - successful, 3 - failed)',
    questionId bigint                             not null comment 'Title id',
    userId     bigint                             not null comment 'Create user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'Creation time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete   tinyint  default 0                 not null comment 'Delete or not',
    index idx_questionId (questionId),
    index idx_userId (userId)
) comment 'Title Submission';

