
CREATE TABLE `iot_model` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_entity` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
  `model_id` varchar(32),
  `namespace` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_model_point` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
  `data_type` varchar(32),
  `model_id` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_entity_point` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
  `data_type` varchar(3) ,
  `entity_id` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_model_point_config` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(128),
  `config_key` varchar(128),
  `config_value` text,
  `model_point_code` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_entity_point_config` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(128) ,
  `config_key` varchar(128),
  `config_value` text,
  `entity_point_code` varchar(32),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `iot_namespace` (
  `id` varchar(100) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- CREATE TABLE `sys_seq` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `code` varchar(128) DEFAULT NULL,
--   `name` varchar(128) DEFAULT NULL,
--   `value` long DEFAULT NULL,
--    `version` int(11),
--    create_time datetime,
--    update_time datetime,
--    create_by varchar(32),
--    update_by varchar(32),
--    deleted int(1)  DEFAULT 0,
--    status int(2) DEFAULT 0,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- CREATE TABLE `sys_dictionary` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `code` varchar(100) DEFAULT NULL,
--   `name` varchar(100) DEFAULT NULL,
--    description text,
--    `version` int(11),
--    create_time datetime,
--    update_time datetime,
--    create_by varchar(32),
--    update_by varchar(32),
--    deleted int(1)  DEFAULT 0,
--    status int(2) DEFAULT 0,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- CREATE TABLE `sys_dictionary_option` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   dictionary_id VARCHAR(32) not null ,
--   `code` varchar(100) DEFAULT NULL,
--   `label` varchar(256) NOT NULL,
--    description text,
--    `version` int(11),
--    create_time datetime,
--    update_time datetime,
--    create_by varchar(32),
--    update_by varchar(32),
--    deleted int(1)  DEFAULT 0,
--    status int(2) DEFAULT 0,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

