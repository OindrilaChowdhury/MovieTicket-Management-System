-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2019 at 12:41 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customId` varchar(50) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  `customerMail` varchar(50) NOT NULL,
  `customerPhoneNo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customId`, `customerName`, `customerMail`, `customerPhoneNo`) VALUES
('1', 'oindrila', 'anika@.aiub', '166666'),
('12', 'anik', 'anik@aiub.com', '19999999'),
('121', 'aaaaa', 'wdf', '1122435'),
('123', 'rrrr', 'asds', '12345'),
('17-35431-3', 'oindrila', 'oindrila@gmil.com', '1626'),
('a12', 'anik', 'anik@aiub.com', '1999998'),
('a13', 'aaa', 'aaaaa', '11234'),
('er12', 'aaaa', 'xxxx', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('e00001', 'emp1', 'manager', 300000.00),
('e00002', 'Employee2', 'salesman', 220000.00),
('e00003', 'emp3', 'salesman', 10000.00),
('e00006', 'e6', 'cashier', 10000.00),
('e013', 'Employee13', 'manager', 5345.00),
('e08', 'Emp08', 'cashier', 12000.00),
('e11', 'mp11', 'cashier', 10000.00),
('e12', 'E12', 'assdd', 1234.00),
('e15', 'Emp015', 'manager', 1234.00),
('e16', 'asdgg', 'cashier', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('1', '1234', 2),
('121', '121', 2),
('a', '123', 1),
('e00001', '1234', 0),
('e00002', '17404044', 1),
('e00003', '13695425', 1),
('e00006', '10415479', 1),
('e013', '14487762', 0),
('e08', '12121238', 1),
('e11', '10956941', 1),
('e12', '17588323', 1),
('e15', '15501192', 0),
('e16', '18587052', 1),
('er12', '12', 2),
('null', 'null', 0);

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `movieName` varchar(50) NOT NULL,
  `movieType` varchar(50) NOT NULL,
  `movieQuality` varchar(50) NOT NULL,
  `movieHall` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`movieName`, `movieType`, `movieQuality`, `movieHall`) VALUES
('Bhahubali', 'action', 'HD', 'Star Cineplex'),
('Debi', 'thriller', 'HD', 'Balaka'),
('End Game', 'avengers', '3D', 'BlockBuster'),
('Koli 2.0', 'Action', '720p', 'Balaka');

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `ticketCounter` varchar(50) NOT NULL,
  `ticketQuality` varchar(50) NOT NULL,
  `ticketQuantity` varchar(50) NOT NULL,
  `ticketPrice` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`ticketCounter`, `ticketQuality`, `ticketQuantity`, `ticketPrice`) VALUES
('Balaka', 'Regular', '200', '250.0'),
('Blockbuster', 'Premium', '10', '1500.0'),
('Boshundhora', 'Vip', '20', '1000.0'),
('Star Cineplex', 'Premium', '100', '1300.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`movieName`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`ticketCounter`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
