CREATE TABLE IF NOT EXISTS tbl_progress
(id_progress int  GENERATED BY DEFAULT AS IDENTITY NOT NULL,
Login varchar(255) NOT NULL,  id_assignment int NOT NULL, progress int);