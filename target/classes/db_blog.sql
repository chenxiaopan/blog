CREATE TABLE t_blogger(
  id number(11,0) NOT NULL primary key,  --博主id
  username VARCHAR2(50) NOT NULL,    --博主姓名
  password VARCHAR2(100) NOT NULL, --博主密码
  profile  VARCHAR2(100),--博主信息
  nickname VARCHAR2(50),  --博主昵称
  sign VARCHAR2(100),  --博主签名 
  imagename VARCHAR2(100)  --博主头像路径
);

CREATE TABLE t_link (
  id number(11,0) NOT NULL  primary key, --友情链接表id
  linkname VARCHAR(100) DEFAULT NULL,  --友情链接名
  linkurl VARCHAR(200) DEFAULT NULL,  --友情链接url
  orderNum number(11,0) DEFAULT NULL  --链接排序
);

CREATE TABLE t_blogtype (
  id number(11,0) NOT NULL primary key, --博客类型id
  typeName VARCHAR(30) DEFAULT NULL, --博客类别
  orderNum number(11,0) DEFAULT NULL --博客排序
); 

CREATE TABLE t_blog (
  id number(11,0) NOT NULL primary key, --博客id
  title VARCHAR2(200) NOT NULL, --博客题目
  summary VARCHAR2(400) DEFAULT NULL, --博客摘要
  releaseDate DATE DEFAULT sysdate , --发布日期
  clickHit number(11,0) DEFAULT NULL, --评论次数
  replyHit number(11,0) DEFAULT NULL, --回复次数
  content VARCHAR2(800), --博客内容
  keyWord VARCHAR2(200) DEFAULT NULL, --关键字
  type_id number(11,0) DEFAULT NULL references t_blogtype(id) --外键关联博客类别
); 

CREATE TABLE t_comment(
  id number(11,0) NOT NULL primary key, --评论表id
  userIp VARCHAR2(50) DEFAULT NULL, --评论者的ip
  content VARCHAR2(1000) DEFAULT NULL, --评论内容
  commentDate DATE DEFAULT sysdate, --评论日期
  state number(11,0) DEFAULT NULL, --审核状态
  blog_id number(11,0) DEFAULT NULL references t_blog(id) --外键关联具体博客
);


select* from t_blogger;
select* from t_link;
select* from t_blogtype;
select* from t_blog;
select* from t_comment;


--创建序列
create sequence seq_t1 start with 1000;
create sequence seq_t2 start with 1000;
create sequence seq_t3 start with 1000;
create sequence seq_t4 start with 1000;
create sequence seq_t5 start with 1000;

--插入测试数据
insert into t_blogger values(seq_t1.nextval,'chenxiaopan','cxp123','高富帅，有车有房，三岁习武，四岁从文，五岁打遍天下无敌手，至此归隐江湖，不问世事，编不下去了','cxp','知道做不到，等于不知道','myhead');

insert into t_blogtype values(seq_t3.nextval,'原创',1);
insert into t_blogtype values(seq_t3.nextval,'转载',2);


insert into t_blog values(seq_t4.nextval,'git上传项目','1如何使用Git上传项目代码到github 2Git新手入门与上传项目到远路仓库GitHub 3github常见操作和常见错误！错误提示fatal remote origin already exists','02-1月-2017',51,0,
'1先进入你要上传项目的根目录下2初始化创建了一个名为git的文件夹3将改动添加到暂存区 4在你的github账户下新建一个repository注意这是在网页上进行不是在本地进行 5千万记得下面说的你的github用户名是你github账户上显示的用户名'
,'git github',1001);
insert into t_blog values(seq_t4.nextval,'SSM框架整合','本文是博主对上述文章的整合时遇到的问题的汇总，首先给出最终的主要xml文件 ', to_date ( '2016-12-31 18:36:34' , 'YYYY-MM-DD HH24:MI:SS' ),40,0,
'1.先在cmd下运行（-Dfile后面的值写你oracle安装目录下的ojdbc包，因为下载oracle会提供ojdbc驱动程序包，所以可以不用在重新下载），2.然后在pom.xml文件中添加，最后一点是单元测试的时候，你不能直接run单元测试。 1.首先你要先把mapping文件复制到target\classes…文件夹下，如 F:\Workspaces\springmvc Maven Webapp\target\classes\net\cxp，因为此文件夹下没有映射xml文件。2.然后右键项目名–>run as–>maven test，之后在进行单元测试。不进行这步的话（F:\Workspaces\springmvc Maven Webapp\target\test-classes），你的test-classes文件夹下没有编译好的测试类class文件，自然会报类没有发现的异常。参考maven中运行junit4报测试类class not found错误——maven test命令 '
,'spring 框架 spring mvcmybatis',1001);
insert into t_blog values(seq_t4.nextval,' ssh框架整合','配置环境spring4+hibernate4+struts2，首先在web.xml文件中加下面这行，默认会在applicationContext.xml文件中加载配置。applicationContext.xml要放在WEB-INF下。主要是配置applicationContext.xml里的东西，struts.xml里的基本不用改，唯一需要改的是下面这行：将全限定类名net.cxp.action.Login改为@Controller(“loginAction”)里写的名字。@Controller注解放在Action上。注意要添加@Scope注', to_date ( '2016-12-05 19:47:21' , 'YYYY-MM-DD HH24:MI:SS' ),61,1,
'配置环境spring4+hibernate4+struts2首先在web.xml文件中加下面这行，默认会在applicationContext.xml文件中加载配置。applicationContext.xml要放在WEB-INF下。主要是配置applicationContext.xml里的东西，struts.xml里的基本不用改，唯一需要改的是下面这行：将全限定类名net.cxp.action.Login改为@Controller(“loginAction”)里写的名字。@Controller注解放在Action上。注意要添加@Scope注解@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)，因为每个请求一个action，而spring生成的bean默认为单例，这句将其改为原型bean，即多实例的bean。'
,' hibernate struts spring ssh struts2.0',1001);
insert into t_blog values(seq_t4.nextval,' 解决ssm环境下配置log4j打印mybatis的sql语句无效的问题','首先附上官网的说明文档：[mybatis Logging](http://www.mybatis.org/mybatis-3/zh/logging.html)*环境spring4.3.0+springmvc4.3.0+mybatis3.4.0*', to_date ( '2016-12-05 19:47:21' , 'YYYY-MM-DD HH24:MI:SS' ),23,1,
'首先附上官网的说明文档：<br/><p>按官方文档的说明，mybatis会使用最先找到的（按上文列举的顺序查找），不少应用服务器的classpath中已经包含Commons Logging，如Tomcat和WebShpere， 所以MyBatis会把它作为具体的日志实现。所以我们首先得指定要使用哪个日志框架，因为是在ssm环境中配置，所以没有mybatis-config.xml文件，就不能在里面配置下面几行</p>'
,'ssm log4j',1001);
insert into t_blog values(seq_t4.nextval,' 解决ssm环境下配置log4j打印mybatis的sql语句无效的问题','首先附上官网的说明文档：[mybatis Logging](http://www.mybatis.org/mybatis-3/zh/logging.html)*环境spring4.3.0+springmvc4.3.0+mybatis3.4.0*', to_date ( '2016-12-05 19:47:21' , 'YYYY-MM-DD HH24:MI:SS' ),23,1,
'首先附上官网的说明文档：<br/><p>按官方文档的说明，mybatis会使用最先找到的（按上文列举的顺序查找），不少应用服务器的classpath中已经包含Commons Logging，如Tomcat和WebShpere， 所以MyBatis会把它作为具体的日志实现。所以我们首先得指定要使用哪个日志框架，因为是在ssm环境中配置，所以没有mybatis-config.xml文件，就不能在里面配置下面几行</p>'
,'ssm log4j',1001);
insert into t_blog values(seq_t4.nextval,'github在readme.md里添加图片 ','基本上按上文操作就没问题。不过博主在这里记录一下遇到的问题，就是添加文件的问题。运行 Git add screenshots这句后，一定要提交，而且提交时要有注释才行，标准格式如下 ', to_date ( '2017-1-06 15:55:22' , 'YYYY-MM-DD HH24:MI:SS' ),6,1,
'基本上按上文操作就没问题。不过博主在这里记录一下遇到的问题，就是添加文件的问题。运行 <br/>Git add screenshots<br/>这句后，一定要提交，而且提交时要有注释才行，标准格式如下 <br/>git commit -m "add screenshots"<br/>其中双引号里的内容是注释，写什么都可以，它会显示在你所提交文件夹后作为注释内容。如下：<br/>screenshots   add screenshots   13 minutes ago'
,'git github',1001);




select * from t_blog where id=(select max(id) from t_blog where id<1019);
select ee.* FROM  (select e.* ,rownum r FROM  (SELECT * FROM t_blog  ORDER BY releaseDate DESC) e WHERE rownum <= 2 ) ee  WHERE r >= 0;
  		select releaseDateStr,COUNT(1) AS blogCount from
  		  (SELECT 
		    to_char(releaseDate,'yyyy-mm') As releaseDateStr,
		    COUNT(1) AS blogCount
		  FROM
		    t_blog GROUP by releaseDate) ee
		  GROUP by releaseDateStr
		  ORDER BY releaseDateStr DESC

		  select * from t_comment where blog_id=1012

SELECT 
to_char(releaseDate,'yyyy-mm') As releaseDateStr,
		    COUNT(1) AS blogCount
		  FROM
		    t_blog GROUP by to_char(releaseDate,'yyyy-mm');	  
		  
	select * from t_blogger where username like 'chenxiaopan' 	  
		  