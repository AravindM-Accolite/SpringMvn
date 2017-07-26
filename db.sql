
create schema cs;
set schema 'cs';

-- Round table
create table Rounds(round_id integer primary key,round_type character varying(20),description character varying(500));

insert into Rounds values (51,'Written test','Writtem test for 30 mins');
insert into Rounds values (52,'MCQ test','Online MCQ test for 30 mins');
insert into Rounds values (53,'Coding test','Coding test for 60 mins');
insert into Rounds values (54,'Technical Interview','Technical Interview for 90 mins');
insert into Rounds values(55,'HR Interview','HR interview for 20 mins');


-- workflow table
create table workflow(workflow_id integer primary key ,workflow_name character varying(40),description character varying(300));

 INSERT INTO workflow(workflow_id, workflow_name,description)
	VALUES (71,'startingtime','This is the first workflow'),
			(72,'testdata','Thos is the second workflow'),
			(73,'latest','Thos is the third workflow');
   
-- create table Workflow(workflow_id integer primary key ,rid integer[]);


-- employee table 
create table employe(employe_id integer primary key,name character varying(50),role character varying(20),email character varying(20),contact_number character varying(13));

INSERT INTO employe(employe_id, name, role, email, contact_number)
	VALUES (40,'Gen','HR','gen@accolite.com',9192631770),
			(41,'Parul','SU','parul@accolite.com',9192631772),
			(42,'gaurav','Sponsor','gaurav@accolite.com',9192631773),
			(43,'sudhir','Interviewer','gen@accolite.com',9192631774);
			
-- status table
create table status(status_id integer  primary key,status character varying(40));

INSERT INTO status(
	status_id, status)
	VALUES (61,'Open'),(62,'Started'),(63,'Inprogress'),(64,'Closed'),(65,'Ready'),(66,'Eligible'),(67,'promote'),(68,'assigned'),(69,'selected');
	
-- college table

create table college(college_id integer primary key,name character varying(50),address character varying(500),contact_person_name character varying(50),contact_person_number character varying(13),contact_email character varying(40),longitude character varying(15),latitude character varying(15));

 INSERT INTO college(
	college_id, name, address, contact_person_name, contact_person_number,contact_email, longitude, latitude)
	VALUES (31,'DAV','Delhi','Sudhir','9192631780','dav_delhi@gmail.com','40.96','78.98'),
			(32,'SJM','New Delhi','Harry','9192631782','sjm_del@gmail.com','42.96','80.98'),
			(33,'JNV','Pune','Lokesh','9192631784','jnv.pune@gmail.com','75.96','78.98');



-- campus_year table	

create table campus_Year(campus_year integer primary  key ,curr_workflow_id integer REFERENCES Workflow(workflow_id),source_workflow_id integer REFERENCES Workflow(workflow_id),campusOwner integer REFERENCES employe(employe_id));

INSERT INTO campus_year(
	campus_year, curr_workflow_id,source_workflow_id, campusowner)
	VALUES (2015,71,73,40),(2016,73,71,42),(2017,72,72,40);

--campus drive table

create table campus(drive_id  integer primary key,campus_year integer,workflow_id integer REFERENCES Workflow(workflow_id),drive_status integer REFERENCES status(status_id),start_date date ,end_date date,hr_id integer references employe(employe_id));

INSERT INTO campus(
	drive_id, campus_year,  workflow_id, drive_status, start_date, end_date, hr_id)
	VALUES (11, 2015 , 71, 61, '30-04-2015', '30-04-2015', 40),
    (12, 2016, 73, 64, '30-04-2016', '5-05-2016', 41),
    (13, 2016, 72, 63, '15-07-2016', '15-06-2016', 40);

-- candidate table

create table candidate(candidate_id integer primary key ,Name character varying(40),college_id integer REFERENCES college(college_id),email character varying(50),contact_number character varying(13),cgpa decimal(3,2),drive_id integer REFERENCES campus(drive_id),isReg boolean,Branch character varying(20));

    INSERT INTO candidate(
	candidate_id, name, college_id, email, contact_number, cgpa, drive_id, isreg,Branch)
	VALUES (21,'Aravind',31, 'aravind@dav.com','7373738484','8.9',11,true,'comp'),
    (22,'Aravind',31, 'aravind@dav.com','7373738485','8.9',11,true,'comp'),
    (23,'Mahi',31, 'mahi@dav.com','7373738485','9.8',11,true,'it'),
    (24,'lokesh',32, 'lokesh@sjm.com','7373738489','8.8',12,false,'it'),
    (25,'Shivangi',32, 'shivangi@sjm.com','7373738494','9.2',12,true,'comp'),
    (26,'Arav',32, 'arav@sjm.com','9373638484','7.9',12,true,'entc'),
    (27,'sujay',33, 'sujay@dav.com','7373738464','7.9',13,false,'comp'),
    (28,'vinod',33, 'vinod@dav.com','7373738494','6.9',13,true,'it'),
    (29,'akshay',33, 'akshay@dav.com','7373738404','8.9',13,true,'entc');


-- workflow round mapping table

   create table workflow_round(workflow_id integer REFERENCES Workflow(workflow_id), round_id integer REFERENCES Rounds(round_id),order_value integer);
   
   insert into workflow_round(workflow_id,round_id,order_value)
   values (71,51,1),(71,52,2),(71,53,3),(72,51,1),(72,52,2),(72,54,3),(73,52,1),(73,53,2),(73,54,3);


-- candidate round map table
	create table candidate_round(candidate_id integer REFERENCES candidate(candidate_id),round_id integer REFERENCES rounds(round_id),student_status integer REFERENCES status(status_id),feedback character varying(500));

	insert into candidate_round(candidate_id,round_id,student_status,feedback)
		values(21,51,67,'written clear'),
				(21,52,68,'mcq clear'),
				(21,53,63,'waitnig for result'),
				(22,52,67,'stage clear'),
				(22,53,68,'good java technical'),
				(22,54,63,'waitnig for result'),
				(23,53,67,'coding clear'),
				(23,54,68,'good .net technical'),
				(23,55,69,'congrats');
/*
  INSERT INTO Workflow(
	workflow_id, rid)
	VALUES (71,'{51,52,53}'),(72,'{51,52,54}'),(73,'{52,53,54}');

*/
	-- get year by ids
	-- select year from cs.year;
	
	-- get workflow of years
	-- select * from year,workflow where year.workflow_id=workflow.id; 
	
	-- get year info
	-- select yr.year,yr.workflow_id,yr.campusowner,emp.name,emp.email,emp.contact_number,wf.rid from cs.year as yr,cs.employe as emp,cs.workflow as wf where yr.campusowner=emp.id and yr.workflow_id=wf.id;

    -- get workflow of year Note:in query ? is to be replaced by year 
   -- select yr.year,wf.id,wf.rid from cs.year as yr,cs.workflow as wf where yr.year=?,yr.workflow_id=wf.id;
	
	-- get latest year from years
	-- select year from cs.year order by year desc limit 1;
	
	-- get all HRs from table employe
	-- select * from cs.employe where cs.employe.role='HR';
    
-- drop table rounds;

-- drop table year;
-- drop table candi;
-- drop table college;
-- drop table campus;
-- drop table employe;



   
   
   
   
   