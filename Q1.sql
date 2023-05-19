
create table BRANCH(
BRANCH_ID int primary key,
ADDRESS Nvarchar(50),
CITY Nvarchar(30),
NAME Nvarchar(50) not null UNIQUE,
STATE Nvarchar(10),
ZIP_CODE Nvarchar(10),

)
create table EMPLOYEE(
Emp_ID int primary key,
First_Name Nvarchar(30) not null,
Last_Name Nvarchar(30) not null,
Start_Date DATE CHECK (Start_Date <= GETDATE()),
Title Nvarchar(50),
Assigned_Branch_ID int,
foreign key(Assigned_Branch_ID) references BRANCH(BRANCH_ID)
)

create table CUSTOMER(
CUST_ID int primary key,
ADDRESS Nvarchar(50),
CITY Nvarchar(30),
CUST_TYPE_CD char(1) not null,
FED_ID Nvarchar(20),
POSTAL_CODE Nvarchar(10),
STATE Nvarchar(10),
)
alter table CUSTOMER
ADD CONSTRAINT cust_type_constraint CHECK(CUST_TYPE_CD='I' OR CUST_TYPE_CD='D');

create table ACCOUNT(
Account_ID int primary key,
Balance float check(Balance>=0),
Open_Date Date CHECK (Open_Date <= GETDATE()),
Cust_ID int,
Open_Branch_ID int,
Open_Emp_ID int,
foreign key(Cust_ID) references CUSTOMER(CUST_ID),
foreign key(Open_Branch_ID) references BRANCH(BRANCH_ID),
foreign key(Open_Emp_ID) references EMPLOYEE(Emp_ID)

)