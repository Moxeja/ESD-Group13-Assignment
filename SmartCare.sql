create table users(
	uname varchar(20) primary key,
	passwd varchar(20),
	role varchar(10)
);

create table clients(
	cID int not null primary key
            generated always as identity (start with 1, increment by 1), 
	cName varchar(50),
	cAddress varchar(100),
	cType varchar(10),
	uName varchar(20) references users(uname)
);

create table employee(
	eID int not null primary key
            generated always as identity (start with 1, increment by 1), 
	eName varchar(50),
	eAddress varchar(100),
	uName varchar(20) references users(uname)
);

create table operations(
    oID int not null primary key
            generated always as identity (start with 1, increment by 1), 
    eID int references employee(eID),
    cID int references clients(cID),
    oDate date,
    oTime time,
    nSlot int,
    charge float
);

create table invoices(
	iID int not null primary key
            generated always as identity (start with 1, increment by 1),
	cID int references clients(cID),
	oID int references operations(oID),
	iPaid boolean
);

create table prices(
	pID int not null primary key
            generated always as identity (start with 1, increment by 1),
	pDuration int,
	pPrice float
);

create table booking_slots(
    sID int not null primary key
            generated always as identity (start with 1, increment by 1),
    eID int references employee(eID),
    cID int references clients(cID),
    sDate date,
    sTime time
);

ALTER TABLE booking_slots ADD COLUMN description VARCHAR(100);

create table medicines(
	mID int not null primary key
            generated always as identity (start with 1, increment by 1),
	mName varchar(40),
	mType varchar(20),
	mCost float
);

create table prescriptions(
    ppID int not null primary key
            generated always as identity (start with 1, increment by 1), 
    cID int references clients(cID),
    mID int references medicines(mID)
);

INSERT INTO USERS (UNAME, PASSWD, "ROLE") VALUES ('meaydin', 'aydinme', 'doctor');
INSERT INTO USERS (UNAME, PASSWD, "ROLE") VALUES ('eaydin', '12345me', 'nurse');
INSERT INTO USERS (UNAME, PASSWD, "ROLE") VALUES ('caidan', '5432@10', 'client');
INSERT INTO USERS (UNAME, PASSWD, "ROLE") VALUES ('princehassan', 'prince_passwd', 'client');
INSERT INTO USERS (UNAME, PASSWD, "ROLE") VALUES ('admin', 'admin_passwd', 'admin');

INSERT INTO EMPLOYEE (ENAME, EADDRESS, UNAME) VALUES ('Mehmet Aydin', 'Mehmets Address, London, NW4 0BH', 'meaydin');
INSERT INTO EMPLOYEE (ENAME, EADDRESS, UNAME) VALUES ('Emin Aydin', 'Emiin''s Address, Bristol, BS16', 'eaydin');

INSERT INTO CLIENTS (CNAME, CADDRESS, CTYPE, UNAME) VALUES ('Charly Aidan', '14 King Street, Aberdeen, AB24 1BR', 'NHS', 'caidan');
INSERT INTO CLIENTS (CNAME, CADDRESS, CTYPE, UNAME) VALUES ('Prince Hassan', 'Non-UK street, Non-UK Town, Non_UK', 'private', 'princehassan');

INSERT INTO PRICES (PDURATION, PPRICE) VALUES (10, 20);

INSERT INTO MEDICINES (MNAME, MTYPE, MCOST) VALUES ('FLUOXETINE','ANTIDEPRESSANT', 10);
INSERT INTO MEDICINES (MNAME, MTYPE, MCOST) VALUES ('COLCHICINE','ANTIFLAMMATORY', 14);
INSERT INTO MEDICINES (MNAME, MTYPE, MCOST) VALUES ('CODEINE','PAINKILLER', 8);
