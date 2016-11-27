#!/usr/bin/env bash
## Это в TEST
# Подсчет количества ошибочных тестов, обратите внимание на RUN.sh
result=0 # number of failed tests

test () {
    arr=($1)
    ./RUN.sh ${arr[*]}
    status=$?
    if [[ $status -ne $2 ]]; then
        echo TESTING FAIL [$1] $status "!=" $2
        ((result+=1))
    else
        echo TESTING OK [$1] $status "==" $2
    fi
    return $status
}

./BUILD.sh

echo 1.0
test " " 0
test "-h" 0 

echo 2.0
test "-l QQQQ -p QQQQ" 1
test "-l jdoe -p QQQQ" 2
test "-l jdoe -p sup3rpaZZ" 0

echo 3.0
test "-l jdoe -p sup3rpaZZ -ro READ -re a" 0
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b" 0
test "-l jdoe -p sup3rpaZZ -ro QQQQ -re a.b" 3
test "-l jdoe -p sup3rpaZZ -ro READ -re QQQQ" 4
test "-l jdoe -p sup3rpaZZ -ro WRITE -re a" 4
test "-l jdoe -p sup3rpaZZ -ro WRITE -re a.bc" 4

echo 4.0
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol 100" 0
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 01-01-2015 -de 2015-12-31 -vol 100" 5
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol QQQQ" 5

echo 5.0
test "-l QQQQ -p QQQQ -ro READ -re QQQQ -ds 2015-01-01 -de 2015-12-31 -vol QQQQ" 1
test "-l QQQQ -p QQQQ -ro READ -re QQQQ" 1

echo
if [[ $result -gt 0 ]]; then
    echo $result tests failed
else
    echo ALL TESTS PASSED
fi
exit ${result}