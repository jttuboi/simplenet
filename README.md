Simplenet Application
==========================

Packages
--------
- simplenet-core
- simplenet-models
- simplenet-repositories
- simplenet-services

Requirements
------------
- JSF2
- Spring
- Maven
- JPA

Testing
-------
- JUnit
- Mockito


Compile
===============
    mvn compile

Running Tests
===============
    mvn clean test


Artifact Generate
=================
    mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DgroupId=br.com.simplenet \
    -DartifactId=simplenet-repositories \
    -Dversion=1.0-SNAPSHOT

    mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DgroupId=br.com.simplenet \
    -DartifactId=simplenet-models \
    -Dversion=1.0-SNAPSHOT

    mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DgroupId=br.com.simplenet \
    -DartifactId=simplenet-core \
    -Dversion=1.0-SNAPSHOT

    mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DgroupId=br.com.simplenet \
    -DartifactId=simplenet-services \
    -Dversion=1.0-SNAPSHOT