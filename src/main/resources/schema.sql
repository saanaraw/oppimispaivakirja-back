create table if not exists paivakirja (
id SERIAL PRIMARY KEY,
title VARCHAR (255),
description VARCHAR,
additionalSource VARCHAR (255),
complete boolean,
creationDate timestamp,
completionDate timestamp
)