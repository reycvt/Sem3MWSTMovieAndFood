/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.4.22-MariaDB : Database - mwstbioskop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mwstbioskop` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mwstbioskop`;

/*Table structure for table `tb_bioskop` */

DROP TABLE IF EXISTS `tb_bioskop`;

CREATE TABLE `tb_bioskop` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_bioskop` */

insert  into `tb_bioskop`(`id`,`nama`,`status`,`alamat`) values 
(6,'CGV ilmy','Up To Date','Kota Gede');

/*Table structure for table `tb_makanan` */

DROP TABLE IF EXISTS `tb_makanan`;

CREATE TABLE `tb_makanan` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL,
  `harga` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_makanan` */

insert  into `tb_makanan`(`id`,`nama`,`status`,`harga`) values 
(2,'Jeruk Bakar120','Masih Ada',20000);

/*Table structure for table `tb_movies` */

DROP TABLE IF EXISTS `tb_movies`;

CREATE TABLE `tb_movies` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `judul` varchar(255) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `date` varchar(30) NOT NULL,
  `durasi` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_movies` */

insert  into `tb_movies`(`id`,`judul`,`genre`,`date`,`durasi`) values 
(2,'spidermen','Romance','14,Jan,2022','60');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
