-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 23, 2020 at 12:02 PM
-- Server version: 5.7.31-0ubuntu0.18.04.1
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ws_poc`
--

-- --------------------------------------------------------

--
-- Table structure for table `fruits`
--

CREATE TABLE `fruits` (
  `Id` tinyint(4) NOT NULL,
  `Name` char(50) NOT NULL,
  `Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fruits`
--

INSERT INTO `fruits` (`Id`, `Name`, `Description`) VALUES
(1, 'strawberry', 'a soft red fruit with very small yellow seeds on the surface, that grows on a low plant'),
(2, 'apple', 'a soft red fruit with very small yellow seeds on the surface, that grows on a low plant'),
(3, 'pear', 'a yellow or green fruit that is narrow at the top and wide at the bottom'),
(4, 'pineapple', 'a large tropical fruit with thick rough skin and stiff leaves on top, that is sweet and yellow inside with a lot of juice '),
(5, 'apricot', 'a round fruit with yellow or orange skin and a large hard seed inside'),
(6, 'grape', 'a small green or purple fruit that grows in bunches on a climbing plant (called a vine). Wine is made from grapes.'),
(7, 'orange', 'a round citrus fruit with thick skin of a colour between red and yellow and a lot of sweet juice'),
(8, 'coconut', 'the large nut of a tropical tree called a coconut palm. It grows inside a hard shell and contains a soft white substance that can be eaten and juice that can be drunk.'),
(9, 'banana', 'a long curved fruit with a thick yellow skin and that is soft inside, which grows on trees in hot countries'),
(10, 'peach', 'a round fruit with soft red and yellow skin, that is yellow inside with a large rough seed');

-- --------------------------------------------------------

--
-- Table structure for table `meats`
--

CREATE TABLE `meats` (
  `Id` tinyint(4) NOT NULL,
  `Name` char(50) NOT NULL,
  `Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meats`
--

INSERT INTO `meats` (`Id`, `Name`, `Description`) VALUES
(1, 'sirloin', 'good quality beef that is cut from a cow’s back'),
(2, 'bacon', 'meat from the back or sides of a pig that has been cured (= preserved using salt or smoke), usually served in thin slices'),
(3, 'prime rib', 'a piece of beef that is cut from the rib section of the animal'),
(4, 'sausage', 'a mixture of meat, fat, bread, etc. cut into small pieces, put into a long tube of skin, cooked and eaten whole or served cold in thin slices'),
(5, 'meat loaf', 'meat, onions, etc. that are cut into very small pieces, mixed together and shaped like a loaf of bread and then baked'),
(6, 'chicken', 'a large bird that is often kept for its eggs or meat'),
(7, 'salami', 'a type of large spicy sausage served cold in thin slices'),
(8, 'steak', 'a thick slice of good quality beef fillet/rump/sirloin steak'),
(9, 'pork', 'meat from a pig that has not been cured (= preserved using salt or smoke)'),
(10, 't-bone steak', 'a thick slice of beef containing a bone in the shape of a T');

-- --------------------------------------------------------

--
-- Table structure for table `vegetables`
--

CREATE TABLE `vegetables` (
  `Id` tinyint(4) NOT NULL,
  `Name` char(50) NOT NULL,
  `Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vegetables`
--

INSERT INTO `vegetables` (`Id`, `Name`, `Description`) VALUES
(1, 'cucumber', 'a long vegetable with dark green skin that is light green inside, usually eaten raw'),
(2, 'onion', 'a round vegetable with many layers inside each other and a brown, red or white skin. Onions have a strong smell and taste.'),
(3, 'carrot', 'a long pointed orange root vegetable'),
(4, 'mushroom', 'a fungus with a round flat head and short stem. Many mushrooms can be eaten.'),
(5, 'cabbage', 'a round vegetable with large green, purplish-red or white leaves that can be eaten raw or cooked'),
(6, 'pepper', 'a powder made from dried berries (called peppercorns), used to give a hot, spicy taste to food'),
(7, 'corn', 'any plant that is grown for its grain, such as wheat; the grain of these plants'),
(8, 'cauliflower', 'a vegetable with green leaves around a large hard white head of flowers'),
(9, 'lettuce', 'a plant with large green leaves that are eaten raw, especially in salad. There are many types of lettuce.'),
(10, 'asparagus', 'a plant whose young green or white stems are cooked and eaten as a vegetable');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fruits`
--
ALTER TABLE `fruits`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `meats`
--
ALTER TABLE `meats`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `vegetables`
--
ALTER TABLE `vegetables`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fruits`
--
ALTER TABLE `fruits`
  MODIFY `Id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `meats`
--
ALTER TABLE `meats`
  MODIFY `Id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `vegetables`
--
ALTER TABLE `vegetables`
  MODIFY `Id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
