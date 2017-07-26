
-- create schema cs;
-- table name cs_tablename
-- Round table
create table cs_rounds(round_id integer primary key,round_type character varying(20),round_description character varying(500));

insert into cs_rounds values (1,'Written test','Writtem test for 30 mins'),
					 (2,'MCQ test','Online MCQ test for 30 mins'),
                    (3,'Coding test','Coding test for 60 mins'),
                    (4,'Technical Interview','Technical Interview for 90 mins'),
                    (5,'HR Interview','HR interview for 20 mins');
-- workflow table
create table cs_workflow(workflow_id integer primary key ,workflow_name character varying(40),workflow_description character varying(300));

 INSERT INTO cs_workflow(workflow_id, workflow_name,workflow_description)
	VALUES (1,'General','This workflow have 4 rounds.'),
			(2,'IITs','This is used in IITs.'),
			(3,'NITs','This is contain more technical rounds.'),
			(4,'Freshers','This is used in IITs.'),
			(5,'Coders','This is used in IITs.');



   
-- create table Workflow(workflow_id integer primary key ,rid integer[]);


-- employee table 
-- need to maintain role in different table

create table cs_employee(employee_id integer primary key,first_name character varying(50),role character varying(20),work_email character varying(20),mobile character varying(13));

INSERT INTO cs_employee(employee_id, first_name, role, work_email, mobile)
	VALUES (1,'Gen','HR','gen@accolite.com',9192631770),
			(2,'Parul','SU','parul@accolite.com',9192631772),
			(3,'Gaurav','Sponsor','gaurav@accolite.com',9192631773),
			(4,'Sudhir','Interviewer','sudhir@accolite.com',9192631774),
            (5,'Sandeep','HR','sandeep@accolite.com',9188831770),
			(6,'Amit','SU','amit@accolite.com',9192636662),
			(7,'Mayank','Sponsor','mayank@accolite.com',9192655573),
			(8,'Varun','Interviewer','varun@accolite.com',8882631774);



-- status table
create table cs_status(status_id integer  primary key,status character varying(40),abbreviation character varying(5));

INSERT INTO cs_status(
	status_id, status,abbreviation)
	VALUES (1,'Open','OPN'),(2,'Started','STR'),(3,'Inprogress','PRG'),(4,'Closed','CLS'),(5,'Ready','RDY'),(6,'Eligible','ELG'),(7,'Promote','PRMT'),(8,'Assigned','ASN'),(9,'Selected','SEL'),(10,'Reject','RJT'),(11,'Completed','COM');
	
-- college table

create table cs_college(college_id integer primary key,college_name character varying(50),address character varying(500),contact_person_name character varying(50),contact_person_number character varying(13),contact_email character varying(40),longitude character varying(15),latitude character varying(15),abbreviation character varying(10));

 INSERT INTO cs_college(
	college_id, college_name, address, contact_person_name, contact_person_number,contact_email, longitude, latitude,abbreviation)
	VALUES (1,'Delhi university','Delhi','Moksha','9192631780','du_delhi@gmail.com','40.96','78.98','DU'),
			(2,'National Institutes of Technology','Jalandhar','Harry','9192631782','nit_j@gmail.com','42.96','80.98','NITJ'),
			(3,'College Of Engineering','Pune','Sujit','9192631784','coe_pune@gmail.com','75.96','78.98','COEP'),
            (4,'Birla Institue Of Technology','Hyderabad','Aman','9192631234','bithyd@gmail.com','40.96','78.98','BITS'),
			(5,'National Institutes of Technology','Jamshedpur','TPO','9192677782','nit_jam@gmail.com','42.96','80.98','NITJM'),
			(6,'Anna University','Bengaluru','Rahul','9192666784','anna_uni@gmail.com','75.96','78.98','AU'),
            (7,'Veermata Jijabai Technological Institute','Mumbai','Tejas','0332631784','vjti@gmail.com','75.96','78.98','VJTI'),
            (8,'Indian Institutes of Information Technology','Kota','Megha','9192634321','iiit@gmail.com','40.96','78.98','IIIT'),
			(9,'Indian Institutes of Technology','Hyderabad','PlacementCell','0402677782','placement@iith.ac.in','42.96','80.98','IITH'),
			(10,'Chaitanya Bharathi Institute of Technology','Hyderabad','office','0402666784','cbittpo@gmail.com','75.96','78.98','CBIT');



-- campus_year table	

create table cs_campus_Year(campus_year integer primary  key ,curr_workflow_id integer REFERENCES cs_workflow(workflow_id),source_workflow_id integer REFERENCES cs_workflow(workflow_id),campusOwner integer REFERENCES cs_employee(employee_id));

INSERT INTO cs_campus_year(
	campus_year, curr_workflow_id,source_workflow_id, campusowner)
	VALUES (2015,1,3,1),
            (2016,3,1,3);

-- campus drive table	

create table cs_campus(campus_id  integer primary key,campus_name character varying(100),campus_year integer,workflow_id integer REFERENCES cs_workflow(workflow_id),campus_status integer REFERENCES cs_status(status_id),start_date date ,end_date date,hr_id integer references cs_employee(employee_id), is_uploded boolean);

INSERT INTO cs_campus(
	campus_id, campus_name,campus_year,  workflow_id, campus_status, start_date, end_date, hr_id,is_uploded)
	VALUES (1,'DU', 2015 , 1, 4, '24-08-2015', '24-08-2015', 1,true),
            (2,'NITJ', 2015, 3, 4, '02-02-2015', '5-02-2015', 2,true),
            (3,'NITJAM', 2015, 2, 4, '10-07-2015', '10-07-2015', 5,true),
            (4,'VJTI', 2016, 3, 4, '30-11-2016', '01-12-2016', 6,true),
            (5,'BITS', 2016, 2, 4, '11-11-2016', '11-11-2016', 1,true),
            (6, 'IIIT',2016, 3, 4, '13-09-2016', '14-09-2016', 2,true),
            (7, 'CBIT',2016, 2, 4, '15-07-2016', '16-07-2016', 5,true),
            (8,'COEP', 2016, 3, 4, '30-09-2016', '05-10-2016', 6,true),
            (9, 'DU',2016, 1, 4, '24-08-2016', '24-08-2016', 1,true),
            (10, 'AU',2016, 3, 4, '04-08-2016', '04-08-2016', 5,true),
            (11,'IITH', 2016, 2, 4, '03-12-2016', '03-12-2016', 1,true),
            (12,'NITJ', 2016, 3, 4, '02-02-2016', '5-02-2016', 2,true),
            (13,'NITJM', 2016, 2, 4, '10-07-2015', '10-07-2015', 5,true);
            
			
			
-- candidate table

create table cs_candidate(candidate_id integer primary key ,candidate_name character varying(40),college_id integer REFERENCES cs_college(college_id),email character varying(50),contact_number character varying(13),cgpa decimal(3,2),campus_id integer REFERENCES cs_campus(campus_id),isReg boolean,Branch character varying(20));

    INSERT INTO cs_candidate(
	candidate_id, candidate_name, college_id, email, contact_number, cgpa, campus_id, isreg,branch)
	VALUES (1,'Aravind',  10, 'aravind@cbit.com',	'7373738484',	'8.9',8,true,'comp'),
            (2,'Mahi',  	10, 'mahi@cbit.com',	'7373738485',	'8.9',8,true,'comp'),
            (3,'vivek',		10, 'vivek@cbit.com',	'7373738485',	'9.8',8,true,'it'),
            (4,'lokesh',	9, 'lokesh@iith.com',	'7373738489',	'8.8',11,true,'comp'),
            (5,'shashank',  9, 'shashank@iith.com',	'7373738494',	'9.2',11,true,'comp'),
            (6,'suresh',	9, 'suresh@iith.com',	'9373638484',	'7.9',11,true,'it'),
            (7,'payal',		6, 'payal@au.com',		'7373738464',	'7.9',7,true,'comp'),
            (8,'poorva',	6, 'poorva@au.com',		'7373738494',	'6.9',7,true,'it'),
            (9,'ambika',	6, 'ambika@au.com',		'7373738404',	'8.9',7,true,'entc'),
            (10,'chinnah',  6, 'chinnah@au.com',	'7373738484',	'8.9',7,true,'comp'),
            (11,'ankit',	6, 'ankit@au.com',		'7373738464',	'7.9',7,false,'comp'),
            (12,'arjun',	6, 'arjun@au.com',		'7373738494',	'6.9',7,true,'it'),
            (13,'venktesh',	6, 'venktesh@au.com',	'7373738404',	'8.9',7,true,'entc'),
            (14,'sarthak',  6, 'sarthak@au.com',	'7373738484',	'8.9',7,true,'comp');


-- workflow round mapping table

   create table cs_workflow_round(workflow_id integer REFERENCES cs_workflow(workflow_id), round_id integer REFERENCES cs_rounds(round_id),order_value integer);
   
   insert into cs_workflow_round(workflow_id,round_id,order_value)
   values (1,1,1),
		   (1,3,2),
		   (1,4,3),
		   (1,4,4),
		   (1,5,5),
		   (2,2,1),
		   (2,4,2),
		   (2,4,3),
		   (2,5,4),
		   (3,2,1),
		   (3,3,2),
		   (3,4,3),
		   (3,4,4),
		   (3,5,5),
		   (4,1,1),
		   (4,2,2),
		   (4,3,3),
		   (4,4,4),
		   (4,5,5),
		   (5,3,1),
		   (5,3,2),
		   (5,3,3),
		   (5,4,4),
		   (5,5,5);


-- candidate round map table
	create table cs_candidate_round(candidate_id integer REFERENCES cs_candidate(candidate_id),round_id integer REFERENCES cs_rounds(round_id),student_status integer REFERENCES cs_status(status_id),feedback character varying(500),round_time timestamp,venue character varying(50),message character varying(300));

	insert into cs_candidate_round(candidate_id,round_id,student_status,feedback, round_time, venue, message)
		values (1,2,11,'written clear','2016-07-15 07:10:25-07','HALL-1','written test start'),
				(1,3,11,'code clear','2016-07-15 09:10:25-07','HALL-1','90 min code test'),
				(1,4,11,'tech clear','2016-07-15 11:10:25-07','room-32','technical interview'),
				(1,4,11,'tech clear','2016-07-15 12:50:25-07','room-31','technical interview'),
				(1,5,9,'congrats','2016-07-15 11:10:25-07','Cabin-3','HR interview'),
                (2,2,11,'written clear','2016-07-15 07:10:25-07','HALL-1','written test start'),
				(2,3,11,'code clear','2016-07-15 09:10:25-07','HALL-1','90 min code test'),
				(2,4,11,'tech clear','2016-07-15 11:10:25-07','room-32','technical interview'),
				(2,4,11,'tech clear','2016-07-15 15:55:25-07','room-32','technical interview'),
				(2,5,9,'congrats','2016-07-15 11:10:25-07','cabin-3','HR interview'),
                (3,2,11,'written clear','2016-07-15 07:10:25-07','HALL-1','written test start'),
				(3,3,11,'code clear','2016-07-15 09:10:25-07','HALL-1','90 min code test'),
				(3,4,11,'not good','2016-07-15 11:10:25-07','room-32','technical interview'),
				(3,4,10,'rejected','2016-07-15 11:10:25-07','room-31','technical interview'),
                (4,2,11,'code clear','2016-12-03 07:10:25-07','LH1','coding'),
				(4,4,11,'tech clear','2016-12-03 09:10:25-07','room-612','technical interview'),
				(4,4,11,'tech clear','2016-12-03 11:10:25-07','room-613','technical interview'),
				(4,5,9,'cngrats','2016-12-03 12:10:25-07','room-611','HR interview'),
				(5,2,11,'code clear','2016-12-03 07:10:25-07','LH1','coding'),
				(5,4,11,'tech clear','2016-12-03 09:10:25-07','room-612','technical interview'),
				(5,4,11,'tech clear','2016-12-03 11:10:25-07','room-613','technical interview'),
				(5,5,10,'rejected','2016-12-03 12:10:25-07','room-611','HR interview'),
                (6,2,11,'code clear','2016-12-03 07:10:25-07','LH1','coding'),
				(6,4,10,'rejected','2016-12-03 09:10:25-07','room-612','technical interview'),
                (7,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(7,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(7,4,11,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(7,4,11,'tech clear','2016-08-04 01:10:25-07','31','interview'),
				(7,5,9,'congrats','2016-08-04 04:10:25-07','placementHall','HR'),
				(8,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(8,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(8,4,11,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(8,4,11,'tech clear','2016-08-04 01:10:25-07','31','interview'),
				(8,5,9,'congrats','2016-08-04 04:10:25-07','placementHall','HR'),
				(9,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(9,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(9,4,11,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(9,4,11,'tech clear','2016-08-04 01:10:25-07','31','interview'),
				(9,5,9,'congrats','2016-08-04 04:10:25-07','placementHall','HR'),
                (10,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(10,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(10,4,10,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(12,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(12,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(12,4,11,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(12,4,11,'tech clear','2016-08-04 01:10:25-07','31','interview'),
				(12,5,9,'congrats','2016-08-04 04:10:25-07','placementHall','HR'),
				(13,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(13,3,10,'code not clear','2016-08-04 10:10:25-07','LH1','coding'),
                (14,1,11,'written clear','2016-08-04 09:10:25-07','LH1','mcq'),
				(14,3,11,'code clear','2016-08-04 10:10:25-07','LH1','coding'),
				(14,4,11,'tech clear','2016-08-04 11:10:25-07','32','interview'),
				(14,4,11,'tech clear','2016-08-04 01:10:25-07','31','interview'),
				(14,5,9,'congrats','2016-08-04 04:10:25-07','placementHall','HR');
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

set schema 'cs';
/*
   
Select campus_year as year, curr_workflow_id as workflow_id, wr.round_id as round_id,campusowner,e.name as campusowner_name,e.role,e.email,e.contact_number
	from campus_year c join workflow_round wr on c.curr_workflow_id = wr.workflow_id 
    	join rounds r on r.round_id = wr.round_id join employe e on e.employe_id=c.campusowner
    where c.campus_year = 2016;
	
	-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 



--// select the selected student from drive_id
select campus.drive_id, candidate.candidate_id, name, round_id, student_status, status.status
from campus, candidate, candidate_round, status 
where campus.drive_id = candidate.drive_id 
AND candidate.candidate_id = candidate_round.candidate_id
AND candidate_round.student_status = status.status_id
AND status = 'selected' AND drive_id = ;
*/