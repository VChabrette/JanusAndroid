#!/bin/sh

mkdir -p app/src/main/{java,resources}/fr/janusproject/janusandroid/janus
cp -R ../janusproject/io.janusproject.kernel/src/main/java/io/janusproject/* app/src/main/java/fr/janusproject/janusandroid/janus
cp -R ../janusproject/io.janusproject.kernel/src/main/resources/io/janusproject/* app/src/main/resources/fr/janusproject/janusandroid/janus
cd app/src
find . -type f -print0 | xargs -0 sed -i '' 's/io\.janusproject/fr\.janusproject\.janusandroid\.janus/g'
