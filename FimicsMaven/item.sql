CREATE TABLE `item` (
                        `id` int(11) NOT NULL auto_increment,
                        `name` varchar(255) default NULL,
                        `price` float default NULL,
                        `createtime` datetime default NULL,
                        `detail` varchar(255) default NULL,
                        PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT into item VALUES('1','电话','4500','2019-01-10 11:30:18','phone')