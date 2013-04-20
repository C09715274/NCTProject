	--
	-- MySQL 5.5.24
	-- Fri, 19 Apr 2013 11:00:02 +0000
	--

	CREATE TABLE `appointment` (
	   `Appointment_ID` int(11) not null auto_increment,
	   `Customer_ID` int(11) not null,
	   `Appointment_Time` time not null,
	   `Appointment_date` date not null,
	   `Appointment_Creation` timestamp not null default CURRENT_TIMESTAMP,
	   `Appointment_Is_complete` varchar(1) not null default 'N',
	   PRIMARY KEY (`Appointment_ID`),
	   KEY `Customer_ID` (`Customer_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

	-- [Table `appointment` is empty]

	CREATE TABLE `car` (
	   `Customer_ID` int(11) not null auto_increment,
	   `Car_Id` int(11) not null,
	   `Car_reg` varchar(20) not null,
	   `Car_Vim_Num` int(11) not null,
	   `Car_Manufacturer` varchar(20) not null,
	   `Car_Model` varchar(30) not null,
	   PRIMARY KEY (`Customer_ID`,`Car_Id`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	-- [Table `car` is empty]

	CREATE TABLE `customer` (
	   `Customer_ID` int(11) not null auto_increment,
	   `Customer_First_Name` varchar(40) not null,
	   `Customer_Second_Name` varchar(40) not null,
	   `Customer_PHNumber` int(11) not null,
	   `Customer_Address1` varchar(70) not null,
	   `Customer_Address2` varchar(70),
	   `Customer_Address3` varchar(70),
	   PRIMARY KEY (`Customer_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	INSERT INTO `customer` (`Customer_ID`, `Customer_First_Name`, `Customer_Second_Name`, `Customer_PHNumber`, `Customer_Address1`, `Customer_Address2`, `Customer_Address3`) VALUES 
	('0', 'foo', 'bar', '860793123', '123190jdgkdj', '', ''),
	('1', 'kjadlf', 'lkj;flja', '9867634', 'kjsdjfsl', 'ljsdfl', 'lsjdfgls');

	CREATE TABLE `results1` (
	   `Appointment_ID` int(11) not null,
	   `REARAXLE` varchar(10) not null,
	   `FRONTAXLE` varchar(10) not null,
	   `REARAXLENEAR` varchar(10) not null,
	   `FRONTAXLENEAR` varchar(10) not null,
	   `REARAXLEOFF` varchar(10) not null,
	   `FRONTAXLEOFF` varchar(10) not null,
	   `LOWIDLE` varchar(10) not null,
	   `HIGHIDLE` varchar(10) not null,
	   PRIMARY KEY (`Appointment_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	-- [Table `results1` is empty]

	CREATE TABLE `results2` (
	   `Appointment_ID` int(11) not null,
	   `REARAXLENEAR` varchar(10) not null,
	   `FRONTAXLENEAR` varchar(10) not null,
	   `PARKBREAKNEAR` varchar(10) not null,
	   `PARKBREAKOFF` varchar(10) not null,
	   `FRONTAXLEOFF` varchar(10) not null,
	   `REARAXLEOFF` varchar(10) not null,
	   `FRONTAXLENEAROVALITY` varchar(10) not null,
	   `REARAXLENEAROVALITY` varchar(10) not null,
	   `REARAXLEOFFOVALITY` varchar(10) not null,
	   `FRONTAXLEOFFOVALITY` varchar(10) not null,
	   PRIMARY KEY (`Appointment_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	-- [Table `results2` is empty]

	CREATE TABLE `staff` (
	   `Staff_Id` int(11) not null auto_increment,
	   `Staff_Name` varchar(40) not null,
	   `Staff_Type` varchar(9),
	   `Password` varchar(32) not null,
	   PRIMARY KEY (`Staff_Id`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=4;

	INSERT INTO `staff` (`Staff_Id`, `Staff_Name`, `Staff_Type`, `Password`) VALUES 
	('1', 'Peter paul', 'Admin', '1234'),
	('2', 'neil Kenny', 'mechanic', '123'),
	('3', 'foo', 'Admin', '12345');