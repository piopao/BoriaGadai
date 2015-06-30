use db;
insert into users values(null, "Gustav", "Vano", "Tkemaladze", "4181eecbd7a755d19fdf73887c54837cbecf63fd",  "itkem12@freeuni.edu.ge", '1994-03-14', "Male", "profilePic1", "i luv pankaces", 0, 0);
insert into users values(null, "plopao", "Elene", "Kiknadze", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "ekikn12@freeuni.edu.ge", '1994-07-29', "Female", "profilePic1", "i luv pankaces" ,0, 0);
insert into users values(null, "Meri Pepanashvili", "Meri", "Pepanashvili", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "mpepa13@freeuni.edu.ge", '1995-02-23', "Female", "profilePic1", "i luv pankaces", 0, 0);
insert into users values(null, "nino", "Nino", "Basilaia", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "nbasi13@freeuni.edu.ge", '1995-06-03', "Female", "profilePic1", "i luv pankaces", 0, 0);
insert into users values(null, "rakhdakh", "Giorgi", "Giglemiani", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "ggigl11@freeuni.edu.ge", '1993-12-04', "Male", "profilePic1", "i luv doto", 0, 0);

insert into banned_accounts values ("ggigl11@freeuni.edu.ge");


insert into admin values ("itkem12@freeuni.edu.ge");
insert into admin values ("ekikn12@freeuni.edu.ge");
insert into admin values ("mpepa13@freeuni.edu.ge");
insert into admin values ("nbasi13@freeuni.edu.ge");
insert into tarot (dir_name) values ("0.jpg");
insert into tarot (dir_name) values ("1.jpg"); 
insert into tarot (dir_name) values ("2.jpg");
insert into tarot (dir_name) values ("3.jpg");
insert into tarot (dir_name) values ("4.jpg");
insert into tarot (dir_name) values ("5.jpg");
insert into tarot (dir_name) values ("6.jpg");
insert into tarot (dir_name) values ("7.jpg");
insert into tarot (dir_name) values ("8.jpg");
insert into tarot (dir_name) values ("9.jpg");
insert into tarot (dir_name) values ("10.jpg");
insert into tarot (dir_name) values ("12.jpg");
insert into tarot (dir_name) values ("13.jpg");
insert into tarot (dir_name) values ("14.jpg");
insert into tarot (dir_name) values ("15.jpg");
insert into tarot (dir_name) values ("16.jpg");
insert into tarot (dir_name) values ("17.jpg");
insert into tarot (dir_name) values ("18.jpg");
insert into tarot (dir_name) values ("19.jpg");
insert into tarot (dir_name) values ("20.jpg");
insert into tarot (dir_name) values ("21.jpg");
insert into tarot (dir_name) values ("22.jpg");
insert into tarot (dir_name) values ("23.jpg");
insert into tarot (dir_name) values ("24.jpg");
insert into tarot (dir_name) values ("25.jpg");
insert into tarot (dir_name) values ("26.jpg");
insert into tarot (dir_name) values ("27.jpg");
insert into tarot (dir_name) values ("28.jpg");
insert into tarot (dir_name) values ("29.jpg");
insert into tarot (dir_name) values ("30.jpg");
insert into tarot (dir_name) values ("31.jpg");
insert into tarot (dir_name) values ("32.jpg");
insert into tarot (dir_name) values ("33.jpg");
insert into tarot (dir_name) values ("34.jpg");
insert into tarot (dir_name) values ("35.jpg");
insert into tarot (dir_name) values ("36.jpg");
insert into tarot (dir_name) values ("37.jpg");
insert into tarot (dir_name) values ("38.jpg");
insert into tarot (dir_name) values ("39.jpg");
insert into tarot (dir_name) values ("40.jpg");
insert into tarot (dir_name) values ("41.jpg");
insert into tarot (dir_name) values ("42.jpg");
insert into tarot (dir_name) values ("43.jpg");
insert into tarot (dir_name) values ("44.jpg");
insert into tarot (dir_name) values ("45.jpg");
insert into tarot (dir_name) values ("46.jpg");
insert into tarot (dir_name) values ("47.jpg");
insert into tarot (dir_name) values ("48.jpg");
insert into tarot (dir_name) values ("49.jpg");
insert into tarot (dir_name) values ("50.jpg");
insert into tarot (dir_name) values ("51.jpg");
insert into tarot (dir_name) values ("52.jpg");
insert into tarot (dir_name) values ("53.jpg");
insert into tarot (dir_name) values ("54.jpg");
insert into tarot (dir_name) values ("55.jpg");
insert into tarot (dir_name) values ("56.jpg");
insert into tarot (dir_name) values ("57.jpg");
insert into tarot (dir_name) values ("58.jpg");
insert into tarot (dir_name) values ("59.jpg");
insert into tarot (dir_name) values ("60.jpg");
insert into tarot (dir_name) values ("61.jpg");
insert into tarot (dir_name) values ("62.jpg");
insert into tarot (dir_name) values ("63.jpg");
insert into tarot (dir_name) values ("64.jpg");
insert into tarot (dir_name) values ("65.jpg");
insert into tarot (dir_name) values ("66.jpg");
insert into tarot (dir_name) values ("67.jpg");
insert into tarot (dir_name) values ("68.jpg");
insert into tarot (dir_name) values ("69.jpg");
insert into tarot (dir_name) values ("70.jpg");
insert into tarot (dir_name) values ("71.jpg");
insert into tarot (dir_name) values ("72.jpg");
insert into tarot (dir_name) values ("73.jpg");
insert into tarot (dir_name) values ("74.jpg");
insert into tarot (dir_name) values ("75.jpg");
insert into tarot (dir_name) values ("76.jpg");
insert into tarot (dir_name) values ("77.jpg");



select * from tarot;

 

insert into image_table(image_dir) values( "tarot-icon.png");
insert into image_table (image_dir) values( "lottery-icon.png");
insert into image_table  (image_dir)values("weather-icon.png");
insert into image_table (image_dir) values("yesno-icon.png");
insert into image_table (image_dir) values("cookie-icon.png");
select * from image_table;

insert into game_table values(null , "lottery",  "გამოგელია ფული, ცადე იღბლიანი ლატარიის ბილეთი.", "lottery-icon.png", "Lottery.html", 0, 0);
insert into game_table values(null , "weather",  "არ იცი რა ჩაიცვა? ნახე იწვიმებს თუ არა ხვალ.", "weather-icon.png", "Weather.html", 0, 0);
insert into game_table values(null , "tarot",  "ტარო ტატარო ტარო ტატარო", "tarot-icon.png", "Tarot.html", 0, 0);
insert into game_table values(null , "yesno",  "კი თუ არა, თუ კი, თუ არა?", "yesno-icon.png", "YesNo.jsp", 0, 0);
insert into game_table values(null , "fortunecookie","ასეთი გემრიელი და თან იღბლიანი ნამცხვარი არასდროს ყოფილა", "cookie-icon.png", "FortuneCookie.jsp", 0, 0);
select * from game_table;

insert into weather_table values ("501504", "დაუბერავს სუსტი ქარი დასავლეთიდან", "wind.png");
insert into weather_table values ("501505", "დაუბერავს სუსტი ქარი აღმოსავლეთიდან", "wind.png");
insert into weather_table values ("501506", "დაუბერავს სუსტი ქარი ჩრდილო-დასავლეთიდან", "wind.png");
insert into weather_table values ("501507", "დაუბერავს სუსტი ქარი სამხრეთ-დასავლეთიდან", "wind.png");
insert into weather_table values ("501508", "დაუბერავს სუსტი ქარი აღმოსავლეთ-ჩრდილოეთიდან", "wind.png");
insert into weather_table values ("501509", "დაუბერავს სუსტი ქარი აღმოსავლეთ-სამხრეთიდან", "wind.png");

insert into weather_table values ("502504", "დაუბერავს საშუალო სიჩქარის ქარი დასავლეთიდან", "wind.png");
insert into weather_table values ("502505", "დაუბერავს საშუალო სიჩქარის ქარი აღმოსავლეთიდან", "wind.png");
insert into weather_table values ("502506", "დაუბერავს საშუალო სიჩქარის ქარი ჩრდილო-დასავლეთიდან", "wind.png");
insert into weather_table values ("502507", "დაუბერავს საშუალო სიჩქარის ქარი სამხრეთ-დასავლეთიდან", "wind.png");
insert into weather_table values ("502508", "დაუბერავს საშუალო სიჩქარის ქარი აღმოსავლეთ-ჩრდილოეთიდან", "wind.png");
insert into weather_table values ("502509", "დაუბერავს საშუალო სიჩქარის ქარი აღმოსავლეთ-სამხრეთიდან", "wind.png");

insert into weather_table values ("503504", "დაუბერავს ძლიერი ქარი დასავლეთიდან", "wind.png");
insert into weather_table values ("503505", "დაუბერავს ძლიერი ქარი აღმოსავლეთიდან", "wind.png");
insert into weather_table values ("503506", "დაუბერავს ძლიერი ქარი ჩრდილო-დასავლეთიდან", "wind.png");
insert into weather_table values ("503507", "დაუბერავს ძლიერი ქარი სამხრეთ-დასავლეთიდან", "wind.png");
insert into weather_table values ("503508", "დაუბერავს ძლიერი ქარი აღმოსავლეთ-ჩრდილოეთიდან", "wind.png");
insert into weather_table values ("503509", "დაუბერავს ძლიერი ქარი აღმოსავლეთ-სამხრეთიდან","wind.png");

insert into weather_table values ("3010", "მოსალოდნელია მზიანი დღე", "sun.png");
insert into weather_table values ("3020", "მოსალოდნელია ღრუბლიანი დღე", "cloud.png");
insert into weather_table values ("3030", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე.", "cloud-sun.png");

insert into weather_table values ("301510", "მოსალოდნელია მზიანი დღე მცირე წვიმით", "sun-rain.png");
insert into weather_table values ("302510", "მოსალოდნელია ღრუბლიანი დღე მცირე წვიმით", "cloud-rain.png");
insert into weather_table values ("303510", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე მცირე წვიმით", "cloud-sun-rain.png");

insert into weather_table values ("301511", "მოსალოდნელია მზიანი დღე ჟუჟუნა წვიმით", "sun-rain.png");
insert into weather_table values ("302511", "მოსალოდნელია ღრუბლიანი დღე ჟუჟუნა წვიმით", "cloud-rain.png");
insert into weather_table values ("303511", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე ჟუჟუნა წვიმით", "cloud-sun-rain.png");

insert into weather_table values ("301512", "მოსალოდნელია მზიანი დღე ძლიერი წვიმით", "sun-rain.png");
insert into weather_table values ("302512", "მოსალოდნელია ღრუბლიანი დღე ძლიერია წვიმით", "cloud-heavyrain.png");
insert into weather_table values ("303512", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე ძლიერი წვიმით", "cloud-sun-rain.png");

insert into weather_table values ("301513", "მოსალოდნელია მზიანი დღე ელჭექით", "sun-rain.png");
insert into weather_table values ("302513", "მოსალოდნელია ღრუბლიანი დღე ელჭექით", "cloud-heavyrain.png");
insert into weather_table values ("303513", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე ელჭექით", "cloud-sun-rain.png");

insert into weather_table values ("301520", "მოსალოდნელია მზიანი დღე სუსტი თოვლით", "sun-snow.png");
insert into weather_table values ("302520", "მოსალოდნელია ღრუბლიანი დღე სუსტი თოვლით", "cloud-snow.png");
insert into weather_table values ("303520", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე სუსტი თოვლით", "cloud-sun-snow.png");

insert into weather_table values ("301521", "მოსალოდნელია მზიანი დღე თოვლით", "sun-snow.png");
insert into weather_table values ("302521", "მოსალოდნელია ღრუბლიანი დღე თოვლით", "cloud-snow.png");
insert into weather_table values ("303521", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე თოვლით", "cloud-sun-snow.png");

insert into weather_table values ("301522", "მოსალოდნელია მზიანი დღე ძლიერი თოვლით", "sun-snow.png");
insert into weather_table values ("302522", "მოსალოდნელია ღრუბლიანი დღე ძლიერი თოვლით", "sun-snow.png");
insert into weather_table values ("303522", "მოსალოდნელია თან ღრუბლიანი, თან მზიანი დღე ძლიერი თოვლით", "cloud-sun-snow.png");


/*Taros Imagebi*/
insert into image_table (image_dir) values("deda.jpg");
insert into image_table (image_dir) values("mama.jpg");
insert into image_table (image_dir) values("dzma.jpg");
insert into image_table (image_dir) values("da.jpg");
insert into image_table (image_dir) values("bebia.jpg");
insert into image_table (image_dir) values("babua.jpg");
insert into image_table (image_dir) values("megobari.jpg");
insert into image_table (image_dir) values("sheyvarebuli.jpg");
insert into image_table (image_dir) values("natesavi.jpg");
insert into image_table (image_dir) values("mezobeli.jpg");
insert into image_table (image_dir) values("kurseli.jpg");
insert into image_table (image_dir) values("tanamshromeli.jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
insert into image_table (image_dir) values(".jpg");
