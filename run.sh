#!/usr/bin/env bash

DIR=`pwd`
cd java-federates/TripleReceiveFederation/target
java -jar \
-Djava.library.path=nar/processid-0.3.0-SNAPSHOT-amd64-Linux-gpp-jni/lib/amd64-Linux-gpp/jni/ \
-Djava.net.preferIPv4Stack=true \
interaction-injection-0.0.1-SNAPSHOT.jar \
TripleSend \
InjectionFederate \
NORMAL
cd $DIR