@echo off
echo 1.0
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -h > NUL
echo !!! 0 %errorlevel%

echo 2.0
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l QQQQ -p QQQQ > NUL
echo !!! 1 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p QQQQ > NUL
echo !!! 2 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ > NUL
echo !!! 0 %errorlevel%

echo 3.0
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro QQQQ -re a.b > NUL
echo !!! 3 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re QQQQ > NUL
echo !!! 4 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a > NUL
echo !!! 4 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a.bc > NUL
echo !!! 4 %errorlevel%

echo 4.0
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol 100 > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 01-01-2015 -de 2015-12-31 -vol 100 > NUL
echo !!! 5 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol QQQQ > NUL
echo !!! 5 %errorlevel%

echo 5.0
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l QQQQ -p QQQQ -ro READ -re QQQQ -ds 2015-01-01 -de 2015-12-31 -vol QQQQ > NUL
echo !!! 1 %errorlevel%
java -cp "out\artifacts\soft\soft.jar;lib\*" com.example.softwareengineering.Main -l QQQQ -p QQQQ -ro READ -re QQQQ > NUL
echo !!! 1 %errorlevel%