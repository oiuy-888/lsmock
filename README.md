# lsmock_git
mock工具

使用前需要先添加数据库表，其内容如下

CREATE TABLE `zmock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `method` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `respond` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

这里添加一条示例

INSERT INTO `qa_test`.`zmock` (`id`, `method`, `time`, `url`, `keyword`, `respond`) VALUES ('6', 'get', '0', '/Studentstatus/test', 'name=王家齐', '{\\\"seqNum\\\":\\\"7118112700000566\\\",\\\"message\\\":\\\"TokenKey验证失败\\\",\\\"status\\\":5}');

那么在请求处，只需要使用请求（下面的XXX...name=王家齐...XXX代表请求参数中包含‘name=王家齐’关键字即可）
http://IP:PORT/Studentstatus/test?XXX...name=王家齐...XXX

即可获得json格式响应数据
{\"seqNum\":\"7118112700000566\",\"message\":\"TokenKey验证失败\",\"status\":5}
