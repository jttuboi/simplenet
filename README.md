Simplenet Application
==========================

Packages
--------
- simplenet-repositories

Requirements
------------
- JSF2
- Spring
- Maven
- JPA

Testing
-------
- JUnit
- Mukito


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