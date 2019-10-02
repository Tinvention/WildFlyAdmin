
-- Think well what are you doing here

-- Connect as admin/root/postgres ( superuser ) to execute these instructions

-- Webapp db and user
CREATE USER "mainDbUsername" WITH PASSWORD 'mainDbPwd';
CREATE DATABASE "mainAppDB" WITH ENCODING='UTF8' OWNER="mainDbUsername";

