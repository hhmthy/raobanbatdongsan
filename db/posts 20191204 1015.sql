﻿--
-- Script was generated by Devart dbForge Studio for MySQL, Version 8.0.124.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 04/12/2019 10:15:59 SA
-- Server version: 8.0.17
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

DROP DATABASE IF EXISTS posts;

CREATE DATABASE posts
CHARACTER SET utf8mb4
COLLATE utf8mb4_vietnamese_ci;

--
-- Set default database
--
USE posts;

--
-- Create table `posts1`
--
CREATE TABLE posts1 (
  post_id bigint(20) NOT NULL AUTO_INCREMENT,
  area int(11) NOT NULL,
  catalog varchar(255) DEFAULT NULL,
  certification varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  content varchar(255) DEFAULT NULL,
  district varchar(255) DEFAULT NULL,
  house_id int(11) NOT NULL,
  land_id int(11) NOT NULL,
  location varchar(255) DEFAULT NULL,
  price int(11) NOT NULL,
  rating int(11) NOT NULL,
  status varchar(255) DEFAULT NULL,
  thumbnail varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  user_id varchar(255) DEFAULT NULL,
  create_at varchar(255) DEFAULT NULL,
  PRIMARY KEY (post_id)
)
ENGINE = MYISAM,
AUTO_INCREMENT = 6,
AVG_ROW_LENGTH = 188,
CHARACTER SET utf8mb4,
CHECKSUM = 0,
COLLATE utf8mb4_vietnamese_ci;

--
-- Create table `posts`
--
CREATE TABLE posts (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(255) NOT NULL,
  catalog varchar(255) NOT NULL,
  title varchar(255) NOT NULL,
  content varchar(500) NOT NULL,
  price int(11) NOT NULL,
  area int(11) DEFAULT NULL,
  image_url varchar(1000) DEFAULT NULL,
  city varchar(255) NOT NULL,
  district varchar(255) NOT NULL,
  address varchar(500) DEFAULT NULL,
  location varchar(500) DEFAULT NULL,
  certification varchar(255) DEFAULT NULL,
  direction varchar(255) DEFAULT NULL,
  rating int(11) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  create_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (post_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 12,
AVG_ROW_LENGTH = 1638,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_vietnamese_ci;

-- 
-- Dumping data for table posts1
--
INSERT INTO posts1 VALUES
(1, 200, 'house', 'Có sổ hồng', 'Hồ Chí Minh', 'Nhà mặt tiền Quận 7', 'Quận 7', 2, 0, 'check-in', 100000000, 3, 'inactive', 'checkin', 'Nhà bán', '1', NULL),
(2, 150, 'house', 'Có sổ hồng', 'Hồ Chí Minh', 'Nhà mặt tiền Quận 1', 'Quận 1', 3, 0, 'check-in', 130000000, 3, 'inactive', 'checkin', 'Bán nhà 3/2', '1', NULL),
(3, 210, 'house', 'Sổ đỏ', 'Cần Thơ', 'Cần bán nhà mặt tiền đường Trần Hưng Đạo.\r\nNhà trệt, thích hợp cho việc mở văn phòng hoặc mua bán.', 'Ninh Kiều', 4, 0, '2', 36000000, 0, 'inactive', NULL, 'Nhà mặt tiền Trần Hưng Đạo', '1', NULL),
(4, 250, 'house', 'Sổ đỏ', 'Cần Thơ', 'Gần siêu thị, bệnh viện, trung tâm vui chơi giải trí.\r\nThuận tiện đi lại.\r\ngiá cả thương lượng.', 'Ninh Kiều', 5, 0, '1', 50000000, 0, 'inactive', NULL, 'Bán nhà 500', '1', NULL),
(5, 800, 'house', 'có', 'Hồ Chí Minh', 'Nhà gần siêu thị Metro cũ, đường đông dân, mặt tiền\r\nGiá thương lượng', 'Quận 1', 6, 0, '1', 50000000, 0, 'inactive', NULL, 'Nhà Metro', '1', NULL);

-- 
-- Dumping data for table posts
--
INSERT INTO posts VALUES
(2, '1', 'house', 'Cần bán nhà mặt tiền Nguyễn Văn Linh', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut corporis dicta esse facilis iure nihil repellat tempora ullam veritatis voluptatum! Ab autem delectus error modi mollitia ratione similique suscipit vel.', 200000, 2, 'http://google.com.vn', 'Cần Thơ', 'Ninh Kiều', '154/3 Nguyễn Văn Linh', 'khong biet', 'Sổ đỏ', 'Đông Bắc', 5, NULL, '2019-11-11 08:54:43', '2019-11-11 08:54:43'),
(3, '1', 'Ban', 'nha mat tien NVL', 'can ban nha mat tien NVL', 200000, 2, 'http://google.com.vn', 'Can Tho', 'Ninh Kieu', '122 duong 3/2', 'khong biet', 'so do', 'Dong bac', 5, NULL, '2019-11-16 12:29:09', '2019-11-16 12:29:09'),
(4, '1', 'ban', '1', 's', 12, 12, 'hh', 'Bà Rịa Vũng Tàu', 'Nhà Bè', 'd', 'k', 'd', 'g', 0, NULL, '2019-11-16 12:56:17', '2019-11-16 12:56:17'),
(5, '1', 'ban', 'dddddddddd', 's', 1, 10, 'Screenshot from 2019-11-16 07-57-15.png', 'Hồ Chí Minh', 'Bình Tân', 'd', '3', 'f', 'g', 0, NULL, '2019-11-16 14:02:02', '2019-11-16 14:02:02'),
(6, '1', 'ban', 'dddddddddd', 's', 1, 10, 'Screenshot from 2019-11-16 07-57-15.png', 'Hải Phòng', 'Kiến Thụy', 'd', '2', 'f', 'g', 0, NULL, '2019-11-16 14:04:28', '2019-11-16 14:04:28'),
(7, '1', 'ban', 'Tuan Anh', 's', 1, 10, 'Screenshot from 2019-11-16 07-57-15.png', 'Cần Thơ', 'Ninh Kiều', 'd', '2', 'f', 'gdssssssss', 0, NULL, '2019-11-16 14:59:11', '2019-11-16 14:59:11'),
(8, '1', 'house', 'Bán nhà đường 3/2', 'aljdlakjdglkajdg\r\nkjglakjsdglkasdjg', 500000, 620, 'slide-01.jpg', 'Cần Thơ', 'Ninh Kiều', '158 Đường 3/2', '1', 'Sổ đỏ', 'Đông Nam', 0, NULL, '2019-11-16 15:10:03', '2019-11-16 15:10:03'),
(9, '1', 'house', 'Test user', 'd', 12, 12, 'Screenshot from 2019-11-16 07-57-15.png', 'Hải Phòng', 'Thủy Nguyên', 'àd', '2', 's', 'gdssssssss', 0, NULL, '2019-11-17 01:16:46', '2019-11-17 01:16:46'),
(10, '1', 'house', 'Bán nhà đường Trần Ngọc Quế', 'kjglksajdlgkj,\r\nkdjglakdsjg,\r\nkdjglaksdjg,j \r\ndslgjlkdjsg', 4200000, 500, 'slide-01.jpg', 'Cần Thơ', 'Ninh Kiều', '111 Trần Ngọc Quế', '1', 'Sổ đỏ', 'Đông Bắc', 0, NULL, '2019-11-17 07:44:34', '2019-11-17 07:44:34'),
(11, '1', 'house', 'Nhà gần chợ ', 'nhà gần chợ, thuận lợi buôn bán', 900000000, 1000, '3d-cube-icon-symbol-7.png', 'Cần Thơ', 'Cái Răng', '987 Trần Kinh Thương', '2', 'có ', 'Tây Nam', 0, NULL, '2019-11-28 17:00:52', '2019-11-28 17:00:52');

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;