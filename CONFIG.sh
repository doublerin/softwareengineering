#Главный класс
MAIN="com.example.softwareengineering.Main"
#Папка с результатами
OUT="out"
#Путь к библиотеке
LIB="lib/commons-cli-1.3.1.jar"
#Исходники
SRC="src/"

OUT_JAR="$OUT/soft.jar"
OUT_CLS="$OUT/classes/"
OUT_LIB="$OUT/lib/"

# Подстановка : или ; в зависимости от операционной системы
LIB="lib/*"
OUT_JAR="out/soft.jar"
if [ "$(uname)" == "Darwin" ]; then
    # Do something under Mac OS X platform
    CP="$LIB:$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    # Do something under GNU/Linux platform
    CP="$LIB:$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ]; then
    # Do something under Windows NT platform
    CP="$LIB;$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
    # Do something under Windows NT platform
    CP="$LIB;$OUT_JAR"
fi
echo !!! $CP