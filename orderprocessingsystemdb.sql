-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Sep 10, 2023 at 07:14 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `orderprocessingsystemdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `Company_Name` varchar(30) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(30) NOT NULL,
  `GST_Number` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Company_Name`, `Address`, `City`, `GST_Number`) VALUES
('Zeal Wheels', 'Noida,Delhi', 'Noida', 24242424),
('Fix Guru', 'Kanpur,U.P', 'Kanpur', 25252525),
('Ready Continental', 'Udupi,Karnataka', 'Udupi', 26262626),
('Brew Bean', 'Dehradun,Uttarkhand', 'Dehradun', 31313131),
('Strat Security', 'Bangalore,Karnataka', 'Bangalore', 34343434),
('Vortex Solar', 'Bhopal,M.P', 'Bhopal', 45454545),
('Evergrow', 'Chennai,Tamilnadu', 'Chennai', 54545454),
('HDFC', 'Bangalore,Karnataka', 'Bangalore', 55555555),
('Gawk Beauty', 'Hyderabad,Andhra Pradesh', 'Hyderabad', 65656565),
('Sky Tours', 'Kochi,Kerala', 'Kochi', 76767676),
('ICICI', 'Indore,M.P', 'Indore', 77777777),
('Garden Glow', 'Bhopal,M.P', 'Bhopal', 98989898);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_Id` int(8) NOT NULL,
  `Customer_Name` varchar(25) NOT NULL,
  `GST_Number` bigint(20) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` bigint(20) NOT NULL,
  `Pincode` int(6) NOT NULL,
  `customer_password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_Id`, `Customer_Name`, `GST_Number`, `Address`, `City`, `Email`, `Phone`, `Pincode`, `customer_password`) VALUES
(12345676, 'Sripriya', 22222222, 'Mangalore,Karnataka', 'Mangalore', 'sripriya@gmail.com', 8888888888, 574217, 'Sripriya@12'),
(12345678, 'Apoorva', 11111111, 'Jabalpur,M.P', 'Jabalpur', 'apoorva@gmail.com', 9999999999, 574217, 'Apoorva@123'),
(13425698, 'Subramanya', 13131313, 'Bangalore,Karnataka', 'Bangalore', 'subramanya@gmail.com', 9856457864, 562134, 'Subramanya@1'),
(14256734, 'Naresh', 12121212, 'Mangalore,Karnataka', 'Mangalore', 'naresh@gmail.com', 9865421345, 576432, 'Naresh@123'),
(45678934, 'Prathijna', 88888888, 'Udupi,Karnataka', 'Udupi', 'prathijna@gmail.com', 8765432590, 574356, 'Prathijna@1'),
(65489765, 'Dhanya', 44444444, 'Kochi,Kerala', 'Kochi', 'dhanya@gmail.com', 9856784567, 574219, 'Dhanya@123'),
(76542378, 'Siddhi', 99999999, 'Solapur,Maharashtra', 'Solapur', 'siddhi@gmail.com', 9876578956, 574287, 'Siddhi@123'),
(76546754, 'Divya', 33333333, 'Indore,M.P', 'Indore', 'divya@gmail.com', 8765456789, 574218, 'Divya@1234'),
(89765435, 'Ankita', 23232323, 'Pune,Maharashtra', 'Pune', 'ankitha@gmail.com', 9854321456, 574324, 'Ankitha@123'),
(98765456, 'Yashmita', 66666666, 'Udupi,Karnataka', 'Udupi', 'yashmita@gmail.com', 8769675432, 574215, 'Yashmita@12');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_Id` int(11) NOT NULL,
  `Employee_Username` varchar(25) NOT NULL,
  `Employee_Password` varchar(200) NOT NULL,
  `Company_gst` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_Id`, `Employee_Username`, `Employee_Password`, `Company_gst`) VALUES
(15673456, 'Shruthi', 'Shruthi@123', 31313131),
(19087658, 'Arsh', 'Arsh@1234', 54545454),
(45984568, 'Sannidhi', 'Sannidhi@12', 45454545),
(54678934, 'Pranamya', 'Pranamya@12', 24242424),
(56432156, 'Vihan', 'Vihan@123', 25252525),
(56436752, 'Sakshi', 'Sakshi@123', 98989898),
(65478654, 'Ganesh', 'Ganesh@123', 65656565),
(67543216, 'Raj', 'Raj@12345', 55555555),
(76543897, 'Sandhya', 'Sandhya@123', 77777777),
(76589765, 'Bhibanshu', 'Bhibanshu@12', 26262626),
(78654389, 'Kavya', 'Kavya@123', 76767676),
(87456783, 'Abhi', 'Abhi@1234', 34343434);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `Invoice_Id` int(11) NOT NULL,
  `Invoice_Date` date NOT NULL,
  `Order_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Product_Id` int(11) NOT NULL,
  `GST_Type` enum('Inter State','Same State','','') NOT NULL,
  `Total_Invoice_Value` double NOT NULL,
  `Status` enum('Paid','Unpaid','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`Invoice_Id`, `Invoice_Date`, `Order_Id`, `Customer_Id`, `Product_Id`, `GST_Type`, `Total_Invoice_Value`, `Status`) VALUES
(100, '2023-09-11', 10023459, 12345676, 65467546, 'Inter State', 60000, 'Paid'),
(101, '2023-09-11', 76908700, 12345678, 12212212, 'Inter State', 20000, 'Paid'),
(102, '2023-09-11', 87898700, 89765435, 10010010, 'Inter State', 200000, 'Unpaid');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_Id` int(8) NOT NULL,
  `Order_Date` date NOT NULL,
  `Customer_Id` int(8) NOT NULL,
  `Customer_Shipping_Address` varchar(255) NOT NULL,
  `Product_Id` int(8) NOT NULL,
  `Total_Order_Value` double NOT NULL,
  `Shipping_Cost` int(11) NOT NULL,
  `Status` enum('Pending','Approved','Completed','Expired') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_Id`, `Order_Date`, `Customer_Id`, `Customer_Shipping_Address`, `Product_Id`, `Total_Order_Value`, `Shipping_Cost`, `Status`) VALUES
(10023459, '2023-09-10', 12345676, 'Mangalore,Karnataka', 65467546, 60000, 1800, 'Approved'),
(76569000, '2023-09-10', 65489765, 'Kochi,Kerala', 13313313, 65000, 1950, 'Pending'),
(76908700, '2023-09-10', 12345678, 'Indore,M.P', 12212212, 20000, 1000, 'Approved'),
(87898700, '2023-09-10', 89765435, 'Bangalore,Karnataka', 10010010, 200000, 0, 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_Id` int(8) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Price` double NOT NULL,
  `Product_Category` enum('Level 1','Level 2','Level 3','') NOT NULL,
  `company_gst` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_Id`, `Product_Name`, `Price`, `Product_Category`, `company_gst`) VALUES
(10010010, 'Makeup Kit', 200000, 'Level 3', 65656565),
(12212212, 'Bedsheet', 20000, 'Level 1', 98989898),
(13313313, 'Cupboard', 65000, 'Level 2', 25252525),
(14414414, 'Curtain', 60000, 'Level 2', 65656565),
(15515515, 'Dustbin', 10000, 'Level 1', 98989898),
(16616616, 'Handbag', 150000, 'Level 3', 65656565),
(17817817, 'Water Bottle', 15000, 'Level 1', 45454545),
(23323323, 'Sandals', 45000, 'Level 1', 77777777),
(23324425, 'Face Cream', 60700, 'Level 2', 34343434),
(24424424, 'Laptop Bag', 165000, 'Level 3', 55555555),
(34434434, 'Table', 170000, 'Level 3', 31313131),
(65467546, 'Mobile Phone', 60000, 'Level 2', 25252525),
(67767767, 'Moisturiser', 56000, 'Level 2', 26262626),
(78654324, 'Headphone', 23000, 'Level 1', 54545454),
(78654453, 'Laptop', 100000, 'Level 3', 31313131),
(97797797, 'Mobile Charger', 66000, 'Level 2', 24242424),
(98898898, 'Facewash', 40000, 'Level 1', 76767676);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`GST_Number`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_Id`),
  ADD UNIQUE KEY `UNIQUEGST` (`GST_Number`),
  ADD UNIQUE KEY `UNIQUEEMAIL` (`Email`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_Id`),
  ADD KEY `company_gst_FK` (`Company_gst`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`Invoice_Id`),
  ADD KEY `Order_Id_FK` (`Order_Id`),
  ADD KEY `Customer_Id_order_Fk` (`Customer_Id`),
  ADD KEY `Product_Id_order_FK` (`Product_Id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Order_Id`),
  ADD KEY `Cust_Id_FK` (`Customer_Id`),
  ADD KEY `Product_Id_FK` (`Product_Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_Id`),
  ADD KEY `company_gst_product_FK` (`company_gst`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `company_gst_FK` FOREIGN KEY (`Company_gst`) REFERENCES `company` (`GST_Number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `Customer_Id_order_Fk` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Order_Id_FK` FOREIGN KEY (`Order_Id`) REFERENCES `order` (`Order_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Product_Id_order_FK` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `Cust_Id_FK` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Product_Id_FK` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `company_gst_product_FK` FOREIGN KEY (`company_gst`) REFERENCES `company` (`GST_Number`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
