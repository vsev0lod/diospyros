# diospyros
Collabothon 2023 - Diospyros


Local DB:
docker pull postgres:15.4
#docker run --name diospyros_local -e POSTGRES_PASSWORD=diospyros -d postgres
docker run -d --name diospyros_local -p 5432:5432 -e POSTGRES_PASSWORD=diospyros postgres:15.4
docker exec -it diospyros_local /bin/bash
psql -U postgres

# different user:
CREATE USER diospyros;
ALTER USER diospyros WITH PASSWORD 'diospyros';
CREATE DATABASE diospyros;
GRANT ALL PRIVILEGES ON DATABASE diospyros TO diospyros;
GRANT CREATE ON SCHEMA public TO diospyros;
ALTER DATABASE diospyros OWNER TO diospyros;

#using postgres:
GRANT ALL PRIVILEGES ON DATABASE diospyros TO postgres;

migration loc:
/Users/andrey/IdeaProjects/diospyros/backend/src/main/resources/db/migration