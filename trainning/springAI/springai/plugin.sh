#!/bin/sh

clear
echo --------------------------------------------------------------------
echo Starting springai-rest using $SPRING_PROFILE profile
echo --------------------------------------------------------------------
cd springai-rest && mvn spring-boot:run