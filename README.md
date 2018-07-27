# Cassandra-performance-test


#casssandra db

What is casssandra?
Apache Cassandra is a free and open-source distributed wide column store NoSQL database management system designed to handle large amounts of data across many commodity servers, providing high availability with no single point of failure. Cassandra offers robust support for clusters spanning multiple datacenters,[1] with asynchronous masterless replication allowing low latency operations for all clients[1]

Cassandra in 50 Words or Less
“Apache Cassandra is an open source, distributed, decentralized, elastically scalable, highly available, fault-tolerant, tuneably consistent, column-oriented database that bases its distribution design on Amazon’s Dynamo and its data model on Google’s Bigtable. Created at Facebook, it is now used at some of the most popular sites on the
 Web.” That’s exactly 50 words..:)[3]

Main features:
- Distributed
   Every node in the cluster has the same role. There is no single point of failure. Data is distributed across the cluster (so each node contains different data), but there is no master as every node can service any request.
- Supports replication and multi data center replication
   Replication strategies are configurable. Cassandra is designed as a distributed system, for deployment of large numbers of nodes across multiple data centers. Key features of Cassandra’s distributed architecture are specifically tailored for multiple-data center deployment, for redundancy, for failover and disaster recovery.
- Scalability
   Designed to have read and write throughput both increase linearly as new machines are added, with the aim of no downtime or interruption to applications.
- Fault-tolerant
   Data is automatically replicated to multiple nodes for fault-tolerance. Replication across multiple data centers is supported. Failed nodes can be replaced with no downtime.
- Tunable consistency
   Cassandra is typically classified as an AP system, meaning that availability and partition tolerance are generally considered to be more important than consistency in Cassandra, Writes and reads offer a tunable level of consistency, all the way from "writes never fail" to "block for all replicas to be readable", with the quorum level in the middle.
- MapReduce support
   Cassandra has Hadoop integration, with MapReduce support. There is support also for Apache Pig and Apache Hive.[18]
- Query language
   Cassandra introduced the Cassandra Query Language (CQL). CQL is a simple interface for accessing Cassandra, as an alternative to the traditional Structured Query Language (SQL).
   
   
 ***When to use Cassandra:[2]
+ Being a part of the NoSQL family, Cassandra offers a solution for problems where one of your requirements is to have a very heavy write system and you want to have a quite responsive reporting system on top of that stored data.[2.b] 
+ highly available, partition tolerant[AP of CAP]
+ replication[2.c]
   
====================================================================================================================================
#CommandsTutorial[4]
#cretaing keyspace:

cqlsh.> CREATE KEYSPACE prtk
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

cqlsh> DESCRIBE keyspaces;

system_schema  system_auth  system  system_distributed  prtk  system_traces

==============================================================

#create table:

   cqlsh> USE prtk;
   
cqlsh:prtk>; CREATE TABLE users(
   id int PRIMARY KEY,
   age varint,
   email text,
   name text

   );
   

cqlsh:prtk> show table;
Improper show command.
cqlsh:prtk> desc tables

user

cqlsh:prtk> select * from user;

 user_id | user_age | user_email | user_name
---------+----------+------------+-----------

(0 rows)
cqlsh:prtk>
==========================================================================


Referecnce:
#book: https://www.gocit.vn/files/Cassandra.The.Definitive.Guide-www.gocit.vn.pdf
1 https://en.wikipedia.org/wiki/Apache_Cassandra
2 a https://www.quora.com/What-are-advantages-and-disadvantages-of-Cassandra-database-You-know-I-need-these-parameters-Distribution-Replication-Object-Oriented-XML-and-unique-properties-of-it
 b http://blogs.shephertz.com/2015/04/22/why-cassandra-excellent-choice-for-realtime-analytics-workload/#
 c http://qr.ae/TUIGWc
3 https://www.credera.com/blog/technology-insights/java/cassandra-explained-5-minutes-less/

4 https://www.tutorialspoint.com/cassandra/cassandra_create_table.htm

5 https://dzone.com/articles/first-steps-to-spring-boot-cassandra
6 http://projects.spring.io/spring-data-cassandra/
7 http://javasampleapproach.com/spring-framework/spring-mvc/angular-4-spring-boot-cassandra-crud-example
