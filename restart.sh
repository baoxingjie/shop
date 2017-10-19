#0、check user  
TIME_STAMP=`date +%Y%m%d%H%M`  
WHO=`whoami`  
if [ "$WHO" != 'root' ]; then  
        echo 'current user is not root'  
        echo 'exit'  
        exit  
fi  
CODE_HOME=/usr/dev 
PROJECTNAME=shop  
cd $CODE_HOME/$PROJECTNAME  
pid=`ps -ef |grep $PROJECTNAME |grep -v "grep" |awk '{print $2}' `   
if [ $pid ]; then  
    echo "App  is  running  and pid=$pid"  
    kill -9 $pid  
fi  
nohup java -jar $CODE_HOME/$PROJECTNAME/target/$PROJECTNAME-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 & 