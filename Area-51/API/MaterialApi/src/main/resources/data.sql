create table material_list 
(
  id int(10) NOT NULL AUTO_INCREMENT,
  material_name  varchar(30) DEFAULT NULL,
  cost varchar(30) DEFAULT NULL,
  number_of_items int(30) DEFAULT NULL,
  picture varchar(100) NOT NULL , 
  PRIMARY KEY (id)
);