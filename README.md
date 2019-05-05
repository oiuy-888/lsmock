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

关键字段解释：
Id         序列号，无实际用途
Method    请发方式（支持get、post）
Time       延迟响应时间（以秒为单位）
Url        请求地址路径
Keyword   请求中携带的参数关键字（请求中包含该字段内容即算命中）
Response   响应内容（包括但不限于json格式数据--实际以字符串形式返回预置的响应）

这里添加一条示例

INSERT INTO `qa_test`.`zmock` (`id`, `method`, `time`, `url`, `keyword`, `respond`) VALUES ('6', 'get', '0', '/Studentstatus/test', 'name=王家齐', '{\\\"seqNum\\\":\\\"7118112700000566\\\",\\\"message\\\":\\\"TokenKey验证失败\\\",\\\"status\\\":5}');

那么在请求处，只需要使用请求（下面的XXX...name=王家齐...XXX代表请求参数中包含‘name=王家齐’关键字即可）
http://IP:PORT/Studentstatus/test?XXX...name=王家齐...XXX

即可获得json格式响应数据
{\"seqNum\":\"7118112700000566\",\"message\":\"TokenKey验证失败\",\"status\":5}
