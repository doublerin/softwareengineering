source ./CONFIG.sh

echo !!!! $CP
java -classpath "$CP" $MAIN $*
