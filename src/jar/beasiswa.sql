-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2017 at 03:40 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `beasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `d_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `d_mahasiswa` (
  `id` int(100) NOT NULL,
  `nama` text NOT NULL,
  `nim` int(10) NOT NULL,
  `jurusan` text NOT NULL,
`gaji` bigint(20) unsigned NOT NULL,
  `kk` text NOT NULL,
  `ipk` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12000001 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `d_mahasiswa`
--

INSERT INTO `d_mahasiswa` (`id`, `nama`, `nim`, `jurusan`, `gaji`, `kk`, `ipk`) VALUES
(1, 'M. Adam', 11214313, 'Teknik Informatika', 10145000, '3', '2.74'),
(2, 'Muh Setiadi', 11214250, 'Teknik Informatika', 4920000, '3', '2.99'),
(3, 'Azhar Fahrurazi Raka Praja', 11214063, 'Teknik Informatika', 3173200, '1', '3.40'),
(4, 'Deni Hermawan', 11214103, 'Teknik Informatika', 12000000, '4', '3.01'),
(5, 'Reni Mutiari', 11214153, 'Teknik Informatika', 4612800, '2', '3.06'),
(6, 'Toufik', 11214297, 'Teknik Informatika', 2104000, '1', '3.36'),
(7, 'Shela Cesar Prastika', 11214142, 'Teknik Informatika', 5098100, '1', '3.51'),
(8, 'Maulidia Reni Wardani', 11214357, 'Teknik Informatika', 4212045, '8', '3.79'),
(9, 'Yoti Marelita', 11214164, 'Teknik Informatika', 2700000, '2', '3.89');

-- --------------------------------------------------------

--
-- Table structure for table `rekap`
--

CREATE TABLE IF NOT EXISTS `rekap` (
`id` int(100) NOT NULL,
  `nama` text NOT NULL,
  `nim` int(100) NOT NULL,
  `jurusan` text NOT NULL,
  `ipk` text NOT NULL,
  `icukup` text NOT NULL,
  `inormal` text NOT NULL,
  `itinggi` text NOT NULL,
  `gaji` text NOT NULL,
  `gcukup` text NOT NULL,
  `gnormal` text NOT NULL,
  `gtinggi` text NOT NULL,
  `tanggungan` text NOT NULL,
  `tcukup` text NOT NULL,
  `tnormal` text NOT NULL,
  `ttinggi` text NOT NULL,
  `min1` text NOT NULL,
  `min2` text NOT NULL,
  `min3` text NOT NULL,
  `min4` text NOT NULL,
  `min5` text NOT NULL,
  `min6` text NOT NULL,
  `min7` text NOT NULL,
  `min8` text NOT NULL,
  `max1` text NOT NULL,
  `max2` text NOT NULL,
  `defuzzy` text NOT NULL,
  `keputusan` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekap`
--

INSERT INTO `rekap` (`id`, `nama`, `nim`, `jurusan`, `ipk`, `icukup`, `inormal`, `itinggi`, `gaji`, `gcukup`, `gnormal`, `gtinggi`, `tanggungan`, `tcukup`, `tnormal`, `ttinggi`, `min1`, `min2`, `min3`, `min4`, `min5`, `min6`, `min7`, `min8`, `max1`, `max2`, `defuzzy`, `keputusan`) VALUES
(1, 'M. Adam', 11214313, 'Teknik Informatika', '2.74', '1.0', '0.03', '0.0', '10145000', '0.02', '0.4', '0.0', '3', '0.04', '0.99', '0.0', '0.02', '0.04', '0.02', '0.03', '0.02', '0.4', '0.02', '0.03', '0.4', '0.02', '9,63', 'LULUS'),
(2, 'M. Adam', 11214313, 'Teknik Informatika', '2.74', '1.0', '0.03', '0.0', '10145000', '0.02', '0.4', '0.0', '3', '0.04', '0.99', '0.0', '0.02', '0.04', '0.02', '0.03', '0.02', '0.4', '0.02', '0.03', '0.4', '0.02', '9,63', 'LULUS'),
(3, 'Muh Setiadi', 11214250, 'Teknik Informatika', '2.99', '0.13', '0.03', '0.0', '4920000', '0.02', '0.4', '0.0', '3', '0.04', '0.99', '0.0', '0.02', '0.04', '0.02', '0.03', '0.02', '0.13', '0.02', '0.03', '0.13', '0.02', '3,32', 'LULUS'),
(4, 'Azhar Fahrurazi Raka Praja', 11214063, 'Teknik Informatika', '3.40', '0.11', '0.03', '0.0', '3173200', '0.3', '0.4', '0.0', '1', '1.0', '0.99', '0.0', '0.11', '0.11', '0.03', '0.03', '0.11', '0.11', '0.03', '0.03', '0.11', '0.03', '2,99', 'LULUS'),
(5, 'Deni Hermawan', 11214103, 'Teknik Informatika', '3.01', '0.12', '0.03', '0.0', '12000000', '0.02', '0.4', '1.0', '4', '0.04', '0.99', '0.0', '0.02', '0.04', '0.02', '0.03', '0.02', '0.12', '0.02', '0.03', '0.12', '0.02', '3,09', 'LULUS'),
(6, 'Reni Mutiari', 11214153, 'Teknik Informatika', '3.06', '0.1', '0.03', '0.0', '4612800', '0.02', '0.4', '0.0', '2', '0.5', '0.99', '0.0', '0.02', '0.1', '0.02', '0.03', '0.02', '0.1', '0.02', '0.03', '0.1', '0.02', '2,66', 'TIDAK LULUS'),
(7, 'Toufik', 11214297, 'Teknik Informatika', '3.36', '0.11', '0.03', '0.0', '2104000', '0.61', '0.4', '0.0', '1', '1.0', '0.99', '0.0', '0.11', '0.11', '0.03', '0.03', '0.11', '0.11', '0.03', '0.03', '0.11', '0.03', '2,99', 'LULUS'),
(8, 'Shela Cesar Prastika', 11214142, 'Teknik Informatika', '3.51', '0.11', '0.03', '0.0', '5098100', '0.02', '0.4', '0.0', '1', '1.0', '0.99', '0.0', '0.02', '0.11', '0.02', '0.03', '0.02', '0.11', '0.02', '0.03', '0.11', '0.02', '2,88', 'TIDAK LULUS'),
(9, 'Maulidia Reni Wardani', 11214357, 'Teknik Informatika', '3.79', '0.11', '0.03', '0.04', '4212045', '0.02', '0.4', '0.0', '8', '0.04', '0.99', '1.0', '0.02', '0.04', '0.02', '0.03', '0.02', '0.11', '0.02', '0.03', '0.11', '0.02', '2,88', 'TIDAK LULUS'),
(10, 'Yoti Marelita', 11214164, 'Teknik Informatika', '3.89', '0.11', '0.03', '1.0', '2700000', '0.44', '0.4', '0.0', '2', '0.5', '0.99', '0.0', '0.11', '0.11', '0.03', '0.03', '0.11', '0.11', '0.03', '0.03', '0.11', '0.03', '2,99', 'LULUS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(100) NOT NULL,
  `namleng` text NOT NULL,
  `nid` int(10) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `namleng`, `nid`, `username`, `password`) VALUES
(1, 'Rodhiyalloh Salma Nadziroh', 11214035, 'salma', '1924'),
(2, 'Azhar Fahrurazi Raka Praja', 11214063, 'azhar', '2424'),
(3, 'Putri Andalusia', 1111111, 'putri', '0303'),
(4, 'mohamad edo maulana', 11214282, 'edo', 'maulana'),
(5, 'muhammad adam kahfiansyah', 11214313, 'adam', '11214313'),
(6, 'Azhar Fahrurazi Raka Praja', 11214063, 'azharunyu', 'bhp11111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `d_mahasiswa`
--
ALTER TABLE `d_mahasiswa`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `gaji` (`gaji`);

--
-- Indexes for table `rekap`
--
ALTER TABLE `rekap`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `d_mahasiswa`
--
ALTER TABLE `d_mahasiswa`
MODIFY `gaji` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12000001;
--
-- AUTO_INCREMENT for table `rekap`
--
ALTER TABLE `rekap`
MODIFY `id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
