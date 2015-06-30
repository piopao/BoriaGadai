use db;
insert into users values(null, "Gustav", "Vano", "Tkemaladze", "4181eecbd7a755d19fdf73887c54837cbecf63fd",  "itkem12@freeuni.edu.ge", '1994-03-14', "Male", "download.jpg", "i luv pankaces");
insert into users values(null, "plopao", "Elene", "Kiknadze", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "ekikn12@freeuni.edu.ge", '1994-07-29', "Female", "download.png", "i luv pankaces");
insert into users values(null, "Meri Pepanashvili", "Meri", "Pepanashvili", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "mpepa13@freeuni.edu.ge", '1995-02-23', "Female", "download.png", "i luv pankaces");
insert into users values(null, "nino", "Nino", "Basilaia", "4181eecbd7a755d19fdf73887c54837cbecf63fd", "nbasi13@freeuni.edu.ge", '1995-06-03', "Female", "download.png", "i luv pankaces");

insert into admin values ("itkem12@freeuni.edu.ge");
insert into admin values ("ekikn12@freeuni.edu.ge");
insert into admin values ("mpepa13@freeuni.edu.ge");
insert into admin values ("nbasi13@freeuni.edu.ge");

insert into image_table(image_dir) values( "tarot-icon.png");
insert into image_table (image_dir) values( "lottery-icon.png");
insert into image_table  (image_dir)values("weather-icon.png");
insert into image_table (image_dir) values("yesno-icon.png");
insert into image_table (image_dir) values("cookie-icon.png");
select * from image_table;

insert into game_table values(null , "ამინდი", "გაინტერესებს, გარეთ გასვლისას ქოლგის წაღება დაგჭირდება თუ არა? გაღელვებს, რომ ღია ცის ქვეშ დაგეგმილი კონცერტი შეიძლება ამინდმა ჩაშალოს? გინდა გაიგო, საღამოს შეძლებ თუ არა წვიმის ყურებით დატკბობას? მაშინ გადადი და გაიგე რას გიმზადებს ცა უახლოეს მომავალში.", 3, "Weather.html");
insert into game_table values(null , "ლატარია", "მოგაკლდა ფული? გინდა იღლბლიანი ლატარიის ბილეთის ნომრები გაიგო? მაშინ თამაში ლატარია ზუსტად შენთვისაა შექმნილი", 2, "Lottery.html");
insert into game_table values(null , "კი თუ არა", "გაქვს კითხვები და გაინტერესებს მარტივი პასუხები? კი? თუ.. არა?.. თუ კი, გადადი თამაშზე.", 4, "YesNo.jsp");
insert into game_table values(null , "იღბლიანი ნამცხვარი", "ნამცხარი ასეთი იღბლიანი და თან ასეთი გემრიელი არასდროს ყოფილა", 5 , "FortuneCookie.jsp");
insert into game_table values(null , "ტარო", "არაჩვეულებრივი მკითხავი ტარო, ტარო ტატარო.. ", 1, "Tarot.html"); 
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



