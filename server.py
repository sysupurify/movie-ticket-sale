#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os

os.system("mvn clean")
os.system("mvn compile")
os.system("mvn tomcat7:run")
