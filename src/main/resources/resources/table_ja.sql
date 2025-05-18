
CREATE DATABASE table_ja;
\c table_ja

CREATE TABLE IF NOT EXISTS railway_admins (
  code_ja      INTEGER  PRIMARY KEY,
  full_name_ja TEXT     NOT NULL,
  abbr_ja      CHAR(10) NOT NULL
);

\copy railway_admins(code_ja, full_name_ja, abbr_ja) FROM '/home/perepe1ka/Загрузки/table_ja.csv' CSV HEADER DELIMITER ',' QUOTE '"';



psql -U postgres -p 5432 -h localhost -f /home/perepe1ka/Загрузки/table_ja.sql
