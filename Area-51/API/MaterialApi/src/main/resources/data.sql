create table material_list 
(
  id int(10) NOT NULL AUTO_INCREMENT,
  number_of_items int(30) DEFAULT NULL,
  material_name  varchar(30) DEFAULT NULL,
  picture varchar(100) NOT NULL , 
  cost varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
);