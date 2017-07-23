


\l ;
\connect ezhire;

create schema kk;

set schema 'kk';

create table Rounds(id integer primary key,type character varying(20),description character varying(500));

create table Workflow(id integer primary key ,rid integer[]);

create table employe(id integer primary key,name character varying(50),role character varying(20),email character varying(20),contact_number character varying(13));

create table Year(year integer primary  key ,workflow_id integer REFERENCES Workflow(id),campusOwner integer REFERENCES employe(id));

create table status(id integer  primary key,status character varying(40));

create table college(id integer primary key,name character varying(50),address character varying(500),contact_person_name character varying(50),contact_person_number character varying(13),longitude character varying(15),latitude character varying(15));

create table campus(drive_id  integer primary key,year integer,college_id integer REFERENCES college(id),workflow_id integer REFERENCES Workflow(id),drive_status integer REFERENCES status(id),start_date date ,end_date date,hr_id integer references employe(id));

create table candidate(id integer primary key ,Name character varying(40),college_id integer REFERENCES college(id),email character varying(50),contact_number character varying(13),cgpa decimal(3,2),drive_id integer REFERENCES campus(drive_id),isReg boolean,Branch character varying(20),status integer references status(id));








insert into Rounds values (51,'Written kk','Writtem kk for 30 mins');
insert into Rounds values (52,'MCQ kk','Online MCQ kk for 30 mins');
insert into Rounds values (53,'Coding kk','Coding kk for 60 mins');
insert into Rounds values (54,'Technical Interview','Technical Interview for 90 mins');
insert into Rounds values(55,'HR Interview','HR interview for 20 mins');


INSERT INTO kk.employe(
	id, name, role, email, contact_number)
	VALUES (40,'Gen','HR','gen@accolite.com',9192631770),
    (41,'Parul','SU','parul@accolite.com',9192631772),
    (42,'gaurav','Sponsor','gaurav@accolite.com',9192631773),
    (43,'sudhir','Interviewer','gen@accolite.com',9192631774);



  INSERT INTO kk.workflow(
	id, rid)
	VALUES (71,'{51,52,53}'),(72,'{51,52,54}'),(73,'{52,53,54}');

INSERT INTO kk.year(
	year, workflow_id, campusowner)
	VALUES (2015,71,40),(2016,73,42),(2017,72,40);

  

INSERT INTO kk.status(
	id, status)
	VALUES (61,'Open'),(62,'Started'),(63,'Inprogress'),(64,'Closed'),(65,'Ready'),(66,'Eligible');


    INSERT INTO kk.college(
	id, name, address, contact_person_name, contact_person_number, longitude, latitude)
	VALUES (31,'DAV','Delhi','Sudhir','9192631780','40.96','78.98'),
    (32,'SJM','New Delhi','Harry','9192631782','42.96','80.98'),
    (33,'JNV','Pune','Lokesh','9192631784','75.96','78.98');

    
    INSERT INTO kk.campus(
	drive_id, year, college_id, workflow_id, drive_status, start_date, end_date, hr_id)
	VALUES (11, 2015,31 , 71, 61, '30-04-2015', '30-04-2015', 40),
    (12, 2016,32, 73, 64, '30-04-2016', '5-05-2016', 41),
    (13, 2016,33, 72, 63, '15-07-2016', '15-06-2016', 40);
    


    INSERT INTO kk.candidate(
	id, name, college_id, email, contact_number, cgpa, drive_id, isreg,Branch,status)
	VALUES (21,'Aravind',31, 'aravind@dav.com','7373738484','8.9',11,true,'comp',65),
    (22,'Aravind',31, 'aravind@dav.com','7373738485','8.9',11,true,'comp',65),
    (23,'Mahi',31, 'mahi@dav.com','7373738485','9.8',11,true,'it',66),
    (24,'lokesh',32, 'lokesh@sjm.com','7373738489','8.8',12,false,'it',66),
    (25,'Shivangi',32, 'shivangi@sjm.com','7373738494','9.2',12,true,'comp',65),
    (26,'Arav',32, 'arav@sjm.com','9373638484','7.9',12,true,'entc',66),
    (27,'sujay',33, 'sujay@dav.com','7373738464','7.9',13,false,'comp',66),
    (28,'vinod',33, 'vinod@dav.com','7373738494','6.9',13,true,'it',66),
    (29,'akshay',33, 'akshay@dav.com','7373738404','8.9',13,true,'entc',66);
    
-- drop table rounds;

-- drop table year;
-- drop table candi;
-- drop table college;
-- drop table campus;
-- drop table employe;

