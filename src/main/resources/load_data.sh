#!/bin/bash

# Declare the SQLite file to store the friends list
SQLITE_FILE='friends_list.sqlite'

# Create the SQLite file
sqlite3 $SQLITE_FILE << EOF
CREATE TABLE friends (
    last_name TEXT NOT NULL,
    first_name TEXT NOT NULL,
    date_of_birth TEXT NOT NULL,
    email TEXT NOT NULL
);
EOF

# Load the flat file into the SQLite file
sqlite3 $SQLITE_FILE << EOF
.mode txt
.import 'friendsBirthdays.txt' friends
EOF