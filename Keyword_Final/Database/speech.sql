-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2020 at 09:33 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `speech`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `uname` varchar(30) DEFAULT NULL,
  `pwd` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`uname`, `pwd`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `files`
--

CREATE TABLE `files` (
  `f_id` int(11) NOT NULL,
  `filedata` text DEFAULT NULL,
  `filename` varchar(30) DEFAULT NULL,
  `rank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `files`
--

INSERT INTO `files` (`f_id`, `filedata`, `filename`, `rank`) VALUES
(3, 'Hello Java Is Object Oriented Programming Langues its very usedful programming language to developed application', 'Oops_Concept.txt', 6),
(7, 'java object language variable class method pointer inheritance polymorphism static garbagCollection collection exception\r\n', 'java.txt', 0),
(8, 'java object language variable class method pointer inheritance polymorphism static garbagCollection collection exception\r\n', 'java.txt', 1);

-- --------------------------------------------------------

--
-- Table structure for table `idf_details`
--

CREATE TABLE `idf_details` (
  `idf_id` int(11) NOT NULL,
  `u_id` varchar(30) DEFAULT NULL,
  `idf` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `idf_details`
--

INSERT INTO `idf_details` (`idf_id`, `u_id`, `idf`) VALUES
(0, 'ritesh', '0.13513513513513514'),
(1, 'shruti', '0.6');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `r_id` int(11) NOT NULL,
  `fl_id` varchar(30) DEFAULT NULL,
  `filename` varchar(30) DEFAULT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `tf` varchar(30) DEFAULT NULL,
  `idf` varchar(30) DEFAULT NULL,
  `rank` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `search_record`
--

CREATE TABLE `search_record` (
  `s_id` int(11) NOT NULL,
  `f_id` varchar(30) DEFAULT NULL,
  `filedata` text DEFAULT NULL,
  `search_data` text DEFAULT NULL,
  `tfcount` varchar(30) DEFAULT NULL,
  `uname` varchar(30) DEFAULT NULL,
  `m_count` varchar(30) DEFAULT NULL,
  `w_count` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `search_record`
--

INSERT INTO `search_record` (`s_id`, `f_id`, `filedata`, `search_data`, `tfcount`, `uname`, `m_count`, `w_count`) VALUES
(348, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'java', '0.06666666666666667', 'shruti', '1', '15'),
(349, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'java', '0.06666666666666667', 'shruti', '1', '15'),
(350, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'object', '0.06666666666666667', 'shruti', '1', '15'),
(351, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'oriented', '0.06666666666666667', 'shruti', '1', '15'),
(352, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'programming', '0.13333333333333333', 'shruti', '2', '15'),
(353, '3', 'hello java is object oriented programming langues its very usedful programming language to developed application', 'language', '0.06666666666666667', 'shruti', '1', '15'),
(354, '7', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'java', '0.07692307692307693', 'shruti', '1', '13'),
(355, '7', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'java', '0.07692307692307693', 'shruti', '1', '13'),
(356, '7', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'object', '0.07692307692307693', 'shruti', '1', '13'),
(357, '7', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'language', '0.07692307692307693', 'shruti', '1', '13'),
(358, '8', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'java', '0.07692307692307693', 'shruti', '1', '13'),
(359, '8', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'java', '0.07692307692307693', 'shruti', '1', '13'),
(360, '8', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'object', '0.07692307692307693', 'shruti', '1', '13'),
(361, '8', 'java object language variable class method pointer inheritance polymorphism static garbagcollection collection exception\r\n', 'language', '0.07692307692307693', 'shruti', '1', '13');

-- --------------------------------------------------------

--
-- Table structure for table `speechdata`
--

CREATE TABLE `speechdata` (
  `id` int(33) NOT NULL,
  `Name` varchar(33) DEFAULT NULL,
  `Password` varchar(33) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Mobile` varchar(20) DEFAULT NULL,
  `speech` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `speechdata`
--

INSERT INTO `speechdata` (`id`, `Name`, `Password`, `Email`, `Mobile`, `speech`) VALUES
(2, 'shekhar', '123', 'shgosavi@gmail.com', '234567', 'hello how are you what are you do'),
(9, 'shruti', '1234', 'shruti123@gmail.com', '9876543210', 'hello guys today we are going to learn Java so basically Java is object oriented programming language');

-- --------------------------------------------------------

--
-- Table structure for table `user_result`
--

CREATE TABLE `user_result` (
  `rd_id` int(11) NOT NULL,
  `file_id` varchar(30) DEFAULT NULL,
  `uname` varchar(30) DEFAULT NULL,
  `tf` varchar(30) DEFAULT NULL,
  `idf` varchar(30) DEFAULT NULL,
  `matches_word` varchar(30) DEFAULT NULL,
  `total_word` varchar(30) DEFAULT NULL,
  `rank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_result`
--

INSERT INTO `user_result` (`rd_id`, `file_id`, `uname`, `tf`, `idf`, `matches_word`, `total_word`, `rank`) VALUES
(85, '1', 'ritesh', '0.07407407407407407', '0.07692307692307693', '2', '27', 7),
(87, '3', 'ritesh', '0.06666666666666667', '0.07692307692307693', '1', '15', 6),
(120, '3', 'shruti', '0.4666666666666667', '0.5121951219512195', '7', '15', 6),
(121, '7', 'shruti', '0.3076923076923077', '0.5121951219512195', '4', '13', 0),
(122, '8', 'shruti', '0.3076923076923077', '0.5121951219512195', '4', '13', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`f_id`);

--
-- Indexes for table `idf_details`
--
ALTER TABLE `idf_details`
  ADD PRIMARY KEY (`idf_id`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`r_id`);

--
-- Indexes for table `search_record`
--
ALTER TABLE `search_record`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `speechdata`
--
ALTER TABLE `speechdata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_result`
--
ALTER TABLE `user_result`
  ADD PRIMARY KEY (`rd_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `files`
--
ALTER TABLE `files`
  MODIFY `f_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `idf_details`
--
ALTER TABLE `idf_details`
  MODIFY `idf_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `search_record`
--
ALTER TABLE `search_record`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=362;

--
-- AUTO_INCREMENT for table `speechdata`
--
ALTER TABLE `speechdata`
  MODIFY `id` int(33) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user_result`
--
ALTER TABLE `user_result`
  MODIFY `rd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
