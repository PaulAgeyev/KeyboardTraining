CREATE TABLE tbl_assignments
(id_assignment int NOT NULL PRIMARY KEY  IDENTITY , 
 time int NOT NULL,
 errors int NOT NULL,
 text VARCHAR (1024) NOT NULL);
