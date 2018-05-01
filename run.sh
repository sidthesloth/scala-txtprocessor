#!/usr/bin/env bash

sbt package
scala -classpath "lib/littlelogger-0.1.jar:target/scala-2.12/scala-txtprocessor_2.12-1.0.0-SNAPSHOT.jar" com.antworks.txtprocessor.UserTweetsProcessing