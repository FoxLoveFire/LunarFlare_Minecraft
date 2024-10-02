# LunarFlare in Minecraft
Based on Minecraft Forge 1.12.2. 


# Installation
Install [IntelliJ Idea](https://www.jetbrains.com/idea/download/?section=windows) Recommended version - 2021.1

Set up Java and JDK 8 in IntelliJ Idea. Don't update your Gradle version, it may cause errors!

The IDE must compile the project itself. Just wait. Then open the project directory in a terminal. Via cd command (works on Linux/Windows)

In terminal in the dir of project run: 

Windows:
```
gradlew.bat genIntellijRuns
```
Linux:

```
./gradlew.bat genIntellijRuns
```

In IntelliJ Idea. Open "Application" button. Choose "runClient".
Also in the runClient configuration you can provide arguments
```
--uuid "UUIDWITHOUTDASHES"
--accessToken "TOKEN"
--username "USERNAME"
--userType "mojan"
```
Copyright of cheats created by the user: [bush1root](https://github.com/bush1root)