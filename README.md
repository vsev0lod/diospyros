# diospyros
Collabothon 2023 - Diospyros

## Our pipeline schema
![Architecture](https://github.com/vsev0lod/diospyros/blob/main/flow%20chart.png)

## Our DB structure
![DBschema](https://github.com/vsev0lod/diospyros/blob/main/diospyrosDB.png)

# Authors:
* Andrei Temnikov
* Alexey Gurov
* Mira Khanina 
* Vsevolod Khanin
* Andrei Makarenko
* Nadezhda Leonova



# Local DB run:
```
docker pull postgres:15.4  
//docker run --name diospyros_local -e POSTGRES_PASSWORD=diospyros -d postgres  
docker run -d --name diospyros_local -p 5432:5432 -e POSTGRES_PASSWORD=diospyros postgres:15.4  
docker exec -it diospyros_local /bin/bash  
psql -U postgres  
  
CREATE DATABASE diospyros;  
GRANT ALL PRIVILEGES ON DATABASE diospyros TO postgres;
```
migration location:
`.../diospyros/backend/src/main/resources/db/migration`  
You can run them with flyway. See below.

# flyway:
setup a clean db (psql v15.4 from docker) and run:  
`gradle flywayClean flywayMigrate`