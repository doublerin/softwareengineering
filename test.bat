@echo off
echo 1.0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main > NUL
echo !!! %errorlevel% 0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -h > NUL
echo !!! %errorlevel% 0

echo 2.0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l QQQQ -p QQQQ > NUL
echo !!! %errorlevel% 1
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p QQQQ > NUL
echo !!! %errorlevel% 2
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ > NUL
echo !!! %errorlevel% 0

echo 3.0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a > NUL
echo !!! %errorlevel% 0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b > NUL
echo !!! %errorlevel% 0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro QQQQ -re a.b > NUL
echo !!! %errorlevel% 3
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re QQQQ > NUL
echo !!! %errorlevel% 4
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a > NUL
echo !!! %errorlevel% 4
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a.bc > NUL
echo !!! %errorlevel% 4

echo 4.0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol 100 > NUL
echo !!! %errorlevel% 0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 01-01-2015 -de 2015-12-31 -vol 100 > NUL
echo !!! %errorlevel% 5
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol QQQQ > NUL
echo !!! %errorlevel% 5

echo 5.0
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l QQQQ -p QQQQ -ro READ -re QQQQ -ds 2015-01-01 -de 2015-12-31 -vol QQQQ > NUL
echo !!! %errorlevel% 1
java -cp "out\artifacts\softwareengineering\soft.jar" com.example.softwareengineering.Main -l QQQQ -p QQQQ -ro READ -re QQQQ > NUL
echo !!! %errorlevel% 1
