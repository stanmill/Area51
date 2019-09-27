create table material_list (
  id int(200) NOT NULL AUTO_INCREMENT,
  number_of_items int(30) DEFAULT NULL,
  material_name  varchar(30) DEFAULT NULL,
  picture varchar(1000) NOT NULL , 
  cost varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
);