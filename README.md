# Race Simulation

[![Build Status](https://travis-ci.org/michaelruocco/race-simulation.svg?branch=master)](https://travis-ci.org/michaelruocco/race-simulation)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/race-simulation/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/race-simulation?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/db5e4e7a12ad47718874540378fb8c97)](https://www.codacy.com/app/michaelruocco/race-simulation?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/race-simulation&amp;utm_campaign=Badge_Grade)

This project is a re-work of an old university project. the project was originally
set as part of the CS223 - Introduction to Software Engineering module in the second
year of a Computer Science degree at Warwick University. It was originally done as
a group project by team "Tau 4 Now" which consisted of the following members:

* Michael Ruocco
* Edward Steel
* James Gough
* Christopher Dean
* Philip Ananin
* Mark Flintstone

Unfortunately I have not been able to get hold of a copy of the original exercise
specification but the general premise was to build an application that could load
a file containing race data and present the race details either as a report printed
to the console or a GUI application with various features. The main one being a window
that shows the race track and cars as they move around the race. The track shape needed
to be a simple oval shape that also included a pit lane.

## Race data file format

The race data file was to be a text file containing data lines, each line should
be in the following format:

time carId checkpointId queriedFlag

* The time format of the file is HH:MM:ss.SS
* The carId is an integer value
* The checkpoint is an integer value
* The queried flag is an integer value of either 1 or 0 which equates to a boolean, i.e. 1 is true, 0 is false

## Running the tests

The has been developed using test driven development so there are a number
of tests that can be run using the following command.

```
gradlew clean build
```

This will run both unit and integration tests. If you want to run only the unit
tests you can run the following command:

```
gradlew clean build -x integrationTest
```

If you want to run only the integration tests you can run the following command:

```
gradlew clean build -x test
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```

## Running the simulation

The simulation can be run in both console and gui mode, to run the simulation
in console mode you can run the following command:

```
gradlew runConsole
```

To run the simulation in GUI mode you can run the following command:

```
gradlew runGui
```

## Building the simulation standalone

To build a runnable jar of the simulation you can run the following command:

```
gradlew clean build allJar
```

This will create a jar file named race-simulation-all.jar in the build/libs
directory of the project. Once the jar has been created you can run the jar
from the project root directory by running the following commands:

```
java -jar build/libs/race-simulation-all.jar //runs the simulation in gui mode using a default race simulation file
java -jar build/libs/race-simulation-all.jar -m console //runs the simulation in console mode using the same default race simulation file
java -jar build/libs/race-simulation-all.jar -h //runs the help command to explain how to run the simulation
```

As well as the -m (mode) and -h (help) options, you can also provide the -f (file-path)
option to the jar, along with this you need to provide a path to a race data file
this will mean that the gui or console application will be run using the race file that you provide e.g:

```
java -jar build/libs/race-simulation-all.jar -f data/all-retired.dat //runs the simulation in gui mode using a race file where all cars retire
```
