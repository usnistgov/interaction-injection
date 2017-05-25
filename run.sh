#!/usr/bin/env bash

DIR=`pwd`
cd java-federates/TripleReceiveFederation/target
java -jar \
-Djava.library.path=nar/processid-0.3.0-SNAPSHOT-amd64-Linux-gpp-jni/lib/amd64-Linux-gpp/jni/ \
-Djava.net.preferIPv4Stack=true \
<<<<<<< HEAD
interaction-injection-0.0.1-SNAPSHOT.jar \
TripleSend \
InjectionFederate \
=======
TripleReceiveFederation-0.0.1-SNAPSHOT.jar \
TripleFederation \
TripleReceive \
>>>>>>> 8930d0fc7d3fd2a181b52cd456d28b5a20820398
NORMAL
cd $DIR