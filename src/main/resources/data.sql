DROP TABLE if exists APP_CLIENT_ID;
CREATE TABLE IF NOT EXISTS APP_CLIENT_ID
(
    client_id     VARCHAR(255) NOT NULL PRIMARY KEY,
    client_secret VARCHAR(255) NOT NULL
);

INSERT INTO APP_CLIENT_ID (client_id, client_secret)
values ('app-client-id', 'app-client-secret');
