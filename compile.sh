#!/bin/bash
# Compilation Script for the Snake Game Desktop.

# Options:
# clean - clean the build project by deleting all previously compiled class files
# package - package the project and create a .jar file

packages=('snake/files' 'snake/game' 'snake/gui' 'snake')
export CLASSPATH=$CLASSPATH:classes/:lib/*:src/

# clean option
if [[ "$*" == *clean* ]]
then
    echo 'Clean Build'
    rm -rf classes
fi

# compilation
mkdir classes
echo 'Compiling Program'
for packageName in "${packages[@]}"; do
    javac -d classes "src/$packageName/"*.java
done

# create .jar
if [[ "$*" == *package* ]]
then
    echo 'Building .jar File'
    name="Snake-""$( date +%F_%H%M )"
    cd classes
    jar cfe $name.jar snake.GUI *
    mv $name.jar ..
    cd ..
    echo 'Saved As '$name'.jar'
fi