CREATE DATABASE IF NOT EXISTS vitalapp;

CREATE USER IF NOT EXISTS 'custom_user'@'%' IDENTIFIED BY 'saludvitalpro';

GRANT ALL PRIVILEGES ON vitalapp.* TO 'custom_user'@'%';

FLUSH PRIVILEGES;
