#!/bin/bash

NAME=$1
#NAMEPARAM="-DartifactId=${NAME}" 
#mvn archetype:generate "-DgroupId=com.gabimunt.advent2021" "${NAMEPARAM}" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"

#mkdir $1
cp -r ./archetype/. ./$1
