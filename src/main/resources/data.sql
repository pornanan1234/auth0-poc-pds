DROP TABLE IF EXISTS PDS;

CREATE TABLE PDS (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  customergroup varchar(50),
  plant varchar(4),
  product varchar(20),
  price varchar(20)
);

insert into PDS(id,customergroup,plant,product,price) VALUES
(1001,'F0','0Z01','123456','100'),
(10092,'F0','0Z01','123457','500'),
(1003,'F0','0Z01','123458','500'),
(1004,'F0','0Z01','123459','500'),
(1005,'F0','0Z01','123460','500'),
(1006,'F0','0Z01','123461','500'),
(1007,'F0','0Z02','123462','500'),
(1008,'F0','0Z02','123463','500'),
(1009,'F0','0Z02','123464','500'),
(10010,'F1','0Z02','123465','500'),
(10011,'F1','0Z02','123466','500'),
(10012,'F2','0Z02','123467','500'),
(10013,'F2','0Z03','123468','500'),
(10014,'F2','0Z03','123469','500'),
(10015,'F2','0Z03','123470','500'),
(10016,'D0','0Z01','123471','500'),
(10017,'D0','0Z01','123472','500'),
(10018,'D0','0Z01','123473','500'),
(10019,'D0','0Z01','123474','500'),
(10020,'D0','0Z01','123475','500'),
(10021,'D0','0Z01','123476','500'),
(10022,'D0','0Z02','123477','500'),
(10023,'D1','0Z02','123478','500'),
(10024,'D1','0Z02','123479','500'),
(10025,'D2','0Z02','123480','500'),
(10026,'D2','0Z02','123481','500'),
(10027,'D3','0Z02','123482','500'),
(10028,'D3','0Z03','123483','500'),
(10029,'D4','0Z03','123484','500'),
(10030,'D0','0Z03','123485','500'),
(10031,'E0','0Z01','123486','500'),
(10032,'E0','0Z01','123487','500'),
(10033,'E0','0Z01','123488','500'),
(10034,'E0','0Z01','123489','500'),
(10035,'E0','0Z01','123490','500'),
(31006,'E0','0Z01','123491','500'),
(10037,'E0','0Z02','123492','500'),
(10038,'E0','0Z02','123493','500'),
(10039,'E0','0Z02','123494','500'),
(10040,'FW','0Z02','123495','500'),
(10041,'FW','0Z02','123496','500'),
(10042,'FW','0Z02','123497','500'),
(10043,'FW','0Z03','123498','500'),
(10044,'FW','0Z03','123499','500'),
(10045,'F2','0Z03','123500','500')
;