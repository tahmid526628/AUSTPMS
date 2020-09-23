create table Person(
ID varchar(100) not null primary key,
FirstName varchar(200) not null,
LastName varchar(100) not null,
Mobile varchar(11) not null,
Profession varchar(50) not null,
Department varchar(50) not null,
Photo image
);


create table Vehicle(
VehicleNumber varchar(50) not null primary key,
VehicleType varchar(20) not null,
VehicleModel varchar(100) not null,
VehicleColor varchar(100) not null,
RegDate date not null,
ExpiryDate date not null,
ID varchar(100) not null foreign key references Person(ID),
)

create table Schedule(
ID varchar(100) not null foreign key references Person(ID),
SundayStart time,
SundayEnd time,
MondayStart time,
MondayEnd time,
TuesdayStart time,
TuesdayEnd time,
WednesdayStart time,
WednesdayEnd time,
ThursdayStart time,
ThursdayEnd time
)

create table Parking(
ParkingDate date not null,
ParkingTime time not null,
ID varchar(50) not null,
Name varchar(200) not null,
Profession varchar(20) not null,
VehicleType varchar(20) not null,
VehicleNumber varchar(20) not null,
ParkingStatus varchar(10) not null,
SlotNumber varchar(10) not null,
ExitTime time null
);

create table GuestParking(
ParkingId int not null primary key identity(1,1),
ParkingDate date not null,
Name varchar(200) not null,
Mobile varchar(11) not null,
VehicleNumber varchar(10) not null,
ParkingStatus varchar(10) not null,
EntryTime time not null,
ExitTime time null,
SlotNumber varchar(10) not null,
VehicleType varchar(20)
);

create table Payment(
TransactionId varchar(200) not null primary key,
TransactionDate date not null
)

insert into Payment values('5GTX56SD4', '2020/08/12');
insert into Payment values('5GSX3AAD3', '2020/08/15');
insert into Payment values('AG5X56SD8', '2020/09/02');

create table Driver(
Driver varchar(50) not null,
Name varchar(255) not null,
Mobile varchar(11) not null,
Photo image not null,
LicenseImage image not null,
ID varchar(100) not null foreign key references Person(ID)
);

create table Semester(
SemesterName varchar(100) not null primary key,
StartDate date not null,
EndDate date not null,
Status varchar(20) null
)

select * from Person;
select * from Vehicle;
select * from Schedule;
select * from Parking;
select * from GuestParking;
select * from Payment;
select * from Driver;
select * from Semester;

delete from Vehicle where ID='17.02.04.039'
delete from Person where ID='17.02.04.039'


