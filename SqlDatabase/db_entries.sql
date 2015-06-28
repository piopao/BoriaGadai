use db;
insert into users values(null, "Gustav", "Vano", "Tkemaladze", "4181eecbd7a755d19fdf73887c54837cbecf63fd",  "itkem12@freeuni.edu.ge", '1994-03-14', "Male", "download.jpg", "i luv pankaces");
insert into users values(null, "plopao", "Elene", "Kiknadze", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "ekikn12@freeuni.edu.ge", '1994-07-29', "Female", "download.png", "i luv pankaces");
insert into users values(null, "Meri Pepanashvili", "Meri", "Pepanashvili", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "mpepa13@freeuni.edu.ge", '1995-02-23', "Female", "download.png", "i luv pankaces");
insert into users values(null, "nino", "Nino", "Basilaia", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "nbasi13@freeuni.edu.ge", '1995-06-03', "Female", "download.png", "i luv pankaces");

insert into admin values ("itkem12@freeuni.edu.ge");
insert into admin values ("ekikn12@freeuni.edu.ge");
insert into admin values ("mpepa13@freeuni.edu.ge");
insert into admin values ("nbasi13@freeuni.edu.ge");

insert into weather_table values ("300", "test", null);
insert into weather_table values ("301", "testb", null);
insert into weather_table values ("302", "testa", null);
select * from users;
select * from new_chat_messages where init_user_email="initUser";
insert into new_chat_messages values ("initUser", "receiverUser", "somebullshittext");
select * from new_chat_messages where init_user_email="initUser"





