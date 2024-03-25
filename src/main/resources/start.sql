CREATE KEYSPACE spring cloud
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };
USE spring cloud;