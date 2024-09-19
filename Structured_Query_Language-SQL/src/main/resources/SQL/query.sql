        drop database if exists customer_manage;
        create database if not exists customer_manage;

        use customer_manage;

        create table customers(
                                  c_id int auto_increment primary key,
                                  name varchar(25) not null ,
--                                   address varchar(50) not null ,
                                  tel varchar(10) not null ,
                                  email varchar(50) not null
        );



        insert into customers (name, tel, email)
        values
            ("Dinidu","0741255458","dinidu@gmail.com"),
            ("sanki","0741255558","sanki@gmail.com"),
            ("amali","0741255778","amali@gmail.com"),
            ("kasun","0741244458","kasun@gmail.com"),
            ("damith","0746655558","damith@gmail.com");

        create table addresses(
                                  a_id int auto_increment primary key,
                                  house_number varchar(25) not null ,
                                  street_name varchar(25) not null ,
                                  city varchar(25) not null,
                                  c_id int ,
                                  foreign key (c_id) references customers(c_id)  on update cascade on delete cascade
        );

        insert into addresses (house_number, street_name, city, c_id)
        values
            ("34","Yatawara Junction","Horana",1),
            ("45","Walana ","Panadura",1),
            ("41","Dediyawala Junction","Mathugama",2),
            ("38","Katukurunda Junction","Kaluthara",3),
            ("97","Malwana Junction","kandy",4);

