-- ttms-system-XEDPB1
CREATE USER it_moisesmoreno IDENTIFIED BY secretpassword;
GRANT CONNECT TO it_moisesmoreno;
GRANT CREATE SESSION TO it_moisesmoreno;
GRANT CREATE TABLE TO it_moisesmoreno;
GRANT UNLIMITED TABLESPACE TO it_moisesmoreno;
GRANT CREATE ANY SEQUENCE TO it_moisesmoreno;


SELECT * FROM DESTINATIONS;

SHOW USER;
SHOW con_name;
SHOW pdbs;
SELECT name, open_mode FROM v$pdbs;