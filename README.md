# crud-sample [![Build Status](https://travis-ci.com/camroga/crud-sample.svg?branch=master)](https://travis-ci.com/camroga/crud-sample)

Example about how to make a CRUD with Java EE

Requirements
------------
- [Java Virtual Machine](https://www.java.com/es/download/)
- [Maven](https://maven.apache.org/)
- [Postgresql](https://www.postgresql.org/)

Quick Start
-----------

To run crud-sample, you must have created the customer and location tables. For this, the file [query](https://github.com/camroga/crud-sample/blob/master/config/query.txt)  is available which contains the necessary queries to be able to consume the web service correctamente.

In the path [config](https://github.com/camroga/crud-sample/blob/master/crud-sample-persistence/src/main/resources/config.properties) you can modify the access data to the database if necessary.
The war file is generated in the path [war](https://github.com/camroga/crud-sample/blob/master/config/crud-sample-ws.war). This will have the configuration described in the repository. 


Building
--------
- Make the war file <code> mvn clean install -U </code> into folder <code> crud-sample-ws </code>
- Deploy the war file in [JBoss](http://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.zip) with Intellij or manually

## Development server

Deployed in `http://localhost:8080/` in order to make use of the client [crud-sample-client](https://github.com/camroga/crud-sample-client).

Ws Service
----------

Once the `war` is deployed on the server, this `API` is available in the following services:

- [Get Customer](http://localhost:8080/customer/get)

Table Example
-------------

Customer is a table which contain the following data:

| id | firstName | surName |
|----|-----------|---------|
| 1  | Emmie     | Jones   |
| 2  | Kenneth   | Jones   |
| 3  | Jim       | Evans   |

Location is a table which have a relation with customer and contain the following data:

| id | streetAddress | city | postCode | customerid |
|----|-------------------|-----------------|----------|------------|
| 1 | 82 Grey Street | PLANTATIONS | 6701 | 1 |
| 2 | 67 Passage Avenue | THURSDAY ISLAND | 4875 | 2 |
| 3 | 98 Daly Terrace | CARABOODA | 6033 | 3 |

