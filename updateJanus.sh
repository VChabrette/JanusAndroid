#!/bin/sh

# Create directory if absent
mkdir -p app/src/main/{java,resources}/fr/janusproject/janusandroid/janus

# Copy Janus source code files
cp -R ../janusproject/io.janusproject.kernel/src/main/java/io/janusproject/* app/src/main/java/fr/janusproject/janusandroid/janus

# Copy Janus resources files
cp -R ../janusproject/io.janusproject.kernel/src/main/resources/io/janusproject/* app/src/main/resources/fr/janusproject/janusandroid/janus

# List all files in src/ and sed to replace package name if necessary
cd app/src
find . -type f -print0 | xargs -0 sed -i '' 's/io\.janusproject/fr\.janusproject\.janusandroid\.janus/g'

# /!\ The empty quotes '' above are for MacOSX sed to work properly. Remove as needed on Linux /!\
