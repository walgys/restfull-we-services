insert into user_details (id,birth_date,name) values (10001, current_date(), 'Adam');
insert into user_details (id,birth_date,name) values (10002, current_date(), 'William');
insert into user_details (id,birth_date,name) values (10003, current_date(), 'Samuel');
insert into user_details (id,birth_date,name) values (10004, current_date(), 'Kate');

insert into post (id,description,user_id) values (2001, 'I want to learn AWS', 10001);
insert into post (id,description,user_id) values (2002, 'I want to learn DevOps', 10002);
insert into post (id,description,user_id) values (2003, 'I want to learn Frontend', 10003);
insert into post (id,description,user_id) values (2004, 'I want to learn Backend', 10004);