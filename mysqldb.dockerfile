FROM mysql/mysql-server

MAINTAINER Boris Varbanov <varbanov.b@gmail.com>

# Copy the database initialize script: 
# Contents of /docker-entrypoint-initdb.d are run on mysqld startup
ADD  mysql/ /docker-entrypoint-initdb.d/