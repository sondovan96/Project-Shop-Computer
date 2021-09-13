-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 06, 2021 at 07:11 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `linhkienjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id` varchar(50) NOT NULL,
  `u_id` int NOT NULL,
  `buyDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cart_user_idx` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `u_id`, `buyDate`) VALUES
('0d5f7645-b43a-4b89-9641-b00904c824a7', 1, '2021-06-03'),
('2298b07d-da1b-47eb-8d28-7090710158b0', 3, '2021-06-03'),
('376f5e06-6e5d-4add-ba1c-6444902b9847', 5, '2021-06-04'),
('388ff000-fed2-46e5-81cd-e44d0c313a8f', 6, '2021-06-07'),
('4', 1, '2020-01-01'),
('5', 1, '2020-02-02'),
('6', 1, '2020-03-03'),
('620bd821-0e00-4bab-805b-a0744da53cf5', 6, '2021-06-04'),
('68bbb432-5e1b-47b0-ae4a-e40883e6b179', 5, '2021-06-04'),
('7747e016-2731-4293-b0e0-79f098a8cf47', 5, '2021-06-04'),
('7c590246-420f-414a-9c3b-4a860605719a', 3, '2021-06-03'),
('b296a48e-f292-49b4-9a31-0a916592c0f7', 1, '2021-06-03'),
('cae7bc05-dbb9-4dc4-96bc-99eb16760954', 3, '2021-06-03'),
('fc685cea-2fb4-46e6-93b0-297a6884df4b', 1, '2021-06-04');

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE IF NOT EXISTS `cart_item` (
  `id` varchar(50) NOT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `pro_id` int NOT NULL,
  `cat_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cartitem_product_idx` (`pro_id`),
  KEY `fk_cartitem_cart_idx` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart_item`
--

INSERT INTO `cart_item` (`id`, `quantity`, `unit_price`, `pro_id`, `cat_id`) VALUES
('030c0fb9-9908-4ba9-bb5c-6faf6a126ad8', 3, 3099000, 5, '388ff000-fed2-46e5-81cd-e44d0c313a8f'),
('09d37fad-c0e1-4a3a-8bbe-202874558ef2', 1, 154545, 26, '388ff000-fed2-46e5-81cd-e44d0c313a8f'),
('0d6b2350-3417-4a4f-bbc2-7c4eabcd9c12', 1, 33599000, 6, '7747e016-2731-4293-b0e0-79f098a8cf47'),
('21bdc0a6-9112-49a1-a2cb-e22a7554a0c1', 2, 33599000, 6, 'fc685cea-2fb4-46e6-93b0-297a6884df4b'),
('67e07de9-e2d7-402d-b3d6-5b0fb590b8b5', 3, 33599000, 6, '620bd821-0e00-4bab-805b-a0744da53cf5'),
('7017d751-2857-457e-b475-5e21b680f234', 4, 33599000, 6, '376f5e06-6e5d-4add-ba1c-6444902b9847'),
('82aa6ec0-dec7-4ac2-9d06-b28711aea645', 6, 4799000, 4, '620bd821-0e00-4bab-805b-a0744da53cf5'),
('88a638d0-e95f-416e-943d-de38874699e2', 4, 3099000, 5, '376f5e06-6e5d-4add-ba1c-6444902b9847'),
('a4e48dc3-b024-423b-86c3-bf566b54c191', 5, 7409000, 7, '376f5e06-6e5d-4add-ba1c-6444902b9847');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `cate_id` int NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) NOT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cate_id`, `cate_name`) VALUES
(1, 'RAM'),
(2, 'VGA'),
(3, 'HDD'),
(4, 'SSD'),
(6, 'MOUSE'),
(7, 'SCREEN'),
(8, 'CPU'),
(15, 'KeyBoard');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `cate_id` int NOT NULL,
  `des` varchar(2000) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_cate_idx` (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `cate_id`, `des`, `image`) VALUES
(1, 'CPU Intel Core i9-10900K', 200000, 8, 'CPU Intel Core i9-10900K (3.7GHz turbo up to 5.3GHz, 10 nhân 20 lu?ng, 20MB Cache, 125W) - Socket Intel LGA 1200', '1590998039418.jpg'),
(2, 'CPU Intel Core i3-7100', 2599000, 8, 'CPU Intel Core i3-7100 (3.9GHz, 2 nhân 4 lu&#7891;ng, 3MB Cache, 51W) - Socket Intel LGA 1151', '1590999543960.jpg'),
(3, 'CPU AMD Ryzen 9 3900X', 12399000, 8, 'CPU AMD Ryzen 9 3900X (3.8GHz turbo up to 4.6GHz, 12 nhân 24 lu&#7891;ng, 64MB Cache, 105W) - Socket AMD AM4', '1590999908491.jpg'),
(4, 'Ram Desktop Corsair Vengeance PRO RGB (CMW32GX4M2E3200C16)', 4799000, 1, 'Ram Desktop Corsair Vengeance PRO RGB (CMW32GX4M2E3200C16) 32GB (2x16GB) DDR4 3200MHz', '1591000199662.jpg'),
(5, 'RAM Desktop Gskill Trident Z Neo (F4-3600C16D-16GTZNC)', 3099000, 1, 'RAM Desktop Gskill Trident Z Neo (F4-3600C16D-16GTZNC) 16GB (2x8GB) DDR4 3600MHz', '1591000276647.jpg'),
(6, 'Card màn hình MSI RTX 2080 Ti GAMING X TRIO', 33599000, 2, 'Card màn hình MSI RTX 2080 Ti GAMING X TRIO (11GB GDDR6, 352-bit, HDMI+DP+Type-C, 1x8-pin+ 1x6-pin)', '1591000377694.jpg'),
(7, '&#7892; c&#7913;ng g&#7855;n trong Seagate SkyHawk AI 8TB', 7409000, 3, '&#7892; c&#7913;ng g&#7855;n trong Seagate SkyHawk AI 8TB 7200rpm SATA 3.5 inch ( ST8000VE0004 )', '1591000465226.jpg'),
(8, '&#7892; c&#7913;ng SSD WD Green 240GB M.2', 999000, 4, '&#7892; c&#7913;ng SSD WD Green 240GB M.2 2280  (&#272;&#7885;c 545MB/s - Ghi 430MB/s) - (WDS240G2G0B', '1591000543197.jpg'),
(10, 'Chu&#7897;t ch&#417;i game ASUS Cerberus Optical Gaming Mouse', 399000, 6, 'Chu&#7897;t ch&#417;i game ASUS Cerberus Optical Gaming Mouse', '1591000750669.jpg'),
(11, 'Màn Hình Acer VG252QX', 8999000, 7, 'Màn Hình Acer VG252QX (25 inch/FHD/IPS/240Hz/0.5 ms/400 nits/DP+HDMI/G-Sync)', '1591000827861.png'),
(12, 'do van son', 400000, 15, '', 'image'),
(18, 'KeyBo123122222', 123, 1, '', 'hoa-cuc-8-800x483.jpg'),
(26, 'Bàn phím c&#417; AKKO 3098 World Tour Tokyo (Akko switch v2)', 154545, 1, '<p>Model: 3068 (68 keys) &ndash; LED n&#7873;n RGB<br />\r\nK&#7871;t n&#7889;i: Bluetooth 5.0 ho&#7863;c USB Type-C to Type-A, c&oacute; th&#7875; th&aacute;o r&#7901;i<br />\r\nK&#7871;t n&#7889;i 4 thi&#7871;t b&#7883; (4 profiles)<br />\r\n&nbsp;</p>\r\n\r\n<div class=\"ddict_btn\" style=\"top: 93px; left: 678.038px;\"><img src=\"chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/16.png\" /></div>\r\n', 'ban-phim-co-akko-3068-v2-world-tour-tokyo-r2-rgb-bluetooth-5.0e.jpg'),
(27, 'Chu&#7897;t Dare-U LM115G Wireless', 50000, 6, '<table border=\"3\" cellpadding=\"3\" cellspacing=\"3\">\r\n	<tbody>\r\n		<tr>\r\n			<td>H&atilde;ng s&#7843;n xu&#7845;t:</td>\r\n			<td>Dareu</td>\r\n		</tr>\r\n		<tr>\r\n			<td>Model:</td>\r\n			<td>LM115G</td>\r\n		</tr>\r\n		<tr>\r\n			<td>Lo&#7841;i:</td>\r\n			<td>Chu&#7897;t Wireless</td>\r\n		</tr>\r\n		<tr>\r\n			<td>K&iacute;ch th&#432;&#7899;c:</td>\r\n			<td>107.5 x 59.15 x 38.29 (mm)</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n', 'gearvn-dare-u-lm115g-wireless-1_large.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(36) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `username`, `password`, `avatar`, `role_id`) VALUES
(1, '1@email', 'admin', 'admin', NULL, 1),
(3, 'son96@gmail.com', 'sondv1996', '123456', NULL, 2),
(5, 'asndasjd@gmail.com', 'nhox5121', 'yamayama97', NULL, 2),
(6, '21234234112@gmail.com', 'nguyenvana', '123456', NULL, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_cart_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `fk_cartitem_cart` FOREIGN KEY (`cat_id`) REFERENCES `cart` (`id`),
  ADD CONSTRAINT `fk_cartitem_product` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_cate` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
