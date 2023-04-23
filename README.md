birthday-reminder

This application will send a message to all your friends on their birthdays and also a reminder of this friend's birthday to the rest of your friends.

#Requirements *Java version: openjdk-11 or higher

#Steps

    Access the file "friendsBirthdays.txt" located in "../src/main/resources/friendsBirthdays.txt" and edit it to contain your personal list of friends

You can do this from the command console navigating to the file's path and runing either one of this commands

    'nano friendsBirthdays.txt' //if you want to edit it directly in the command console, in this case you should press Ctrl+O, then press Enter to confirm. To exit Nano, press Ctrl+X, so your changes are saved.

    'notepad friendsBirthdays.txt' //if you want to get a text editor opened to edit the file

You can run 'cat friendsBirthdays.txt' to check if the file is correctly updated.

    Compile the program using 'javac' Go to the project's folder and execute the following:

javac src/main/java/Main.java

    Execute the program using java

java src/main/java/Main
