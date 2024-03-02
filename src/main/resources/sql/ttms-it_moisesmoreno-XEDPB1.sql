-- ttms-it_moisesmoreno-XEDPB1
SELECT * FROM DESTINATIONS;
create table destinations 
    (destination_id number(10,0) generated as identity, 
    is_active number(1,0) check (is_active in (0,1)), 
    price float(53), rating float(53), description varchar2(255 char), 
    image_url varchar2(255 char), location varchar2(255 char), 
    name varchar2(255 char), 
    primary key (destination_id));

create table destinations
    (destination_id number(10,0) generated as identity);

DROP TABLE destinations;