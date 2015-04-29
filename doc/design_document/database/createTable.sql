-- James 2015-04-29 create
CREATE TABLE t_owner
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  nickname VARCHAR(255),
  password VARCHAR(255),
  mobile VARCHAR(255),
  birthday VARCHAR(255),
  wechat_id VARCHAR(255),
  device_code VARCHAR(255),
  address VARCHAR(500),
  gender VARCHAR(10),
  community_uuid VARCHAR(38),
  salt VARCHAR(50)
);

CREATE TABLE t_city
(
  uuid VARCHAR(38) NOT null PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  city_name VARCHAR(50),
  longitude VARCHAR(50),
  latitude VARCHAR(50)
);

CREATE TABLE t_community
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  name VARCHAR(255),
  address VARCHAR(500),
  is_important VARCHAR(10),
  longitude VARCHAR(50),
  latitude VARCHAR(50),
  city_uuid VARCHAR(38),
  company_uuid VARCHAR(38)
);

CREATE TABLE t_compaint
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  title VARCHAR(255),
  content TEXT,
  address VARCHAR(500),
  longitude VARCHAR(50),
  latitude VARCHAR(50),
  status int,
  deadline DATE,
  result TEXT,
  rate VARCHAR(50),
  comment VARCHAR(255),
  create_user VARCHAR(38),
  responsibility VARCHAR(38)
);

CREATE TABLE t_companit_pic
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  companit_uuid VARCHAR(38)
);

CREATE TABLE t_merchant
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  name VARCHAR(255),
  password VARCHAR(255),
  contact_mobile VARCHAR(255),
  manager VARCHAR(255),
  manager_mobile VARCHAR(255),
  sell_type VARCHAR(500),
  company_type VARCHAR(500),
  scale_of_operation VARCHAR(255),
  sel_no VARCHAR(50),
  owner VARCHAR(50),
  address VARCHAR(500),
  longitude VARCHAR(50),
  latitude VARCHAR(50)
);

CREATE TABLE t_property_company
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  description VARCHAR(500),
  contact VARCHAR(500),
  address VARCHAR(500),
  manager VARCHAR(500)
);

CREATE TABLE t_property
(
  uuid VARCHAR(38) NOT NULL PRIMARY KEY,
  create_date DATETIME,
  modify_date DATETIME,
  user_name VARCHAR(50),
  password VARCHAR(255),
  mobile VARCHAR(255),
  work_serial_no VARCHAR(255),
  level_name VARCHAR(255),
  brithday VARCHAR(255),
  level_core VARCHAR(255),
  gender VARCHAR(50),
  id_card VARCHAR(50)
);


CREATE TABLE t_community_merchant
(
  community_uuid VARCHAR(38),
  merchant_uuid VARCHAR(38)
);





