#!/usr/bin/python
# -*- coding: UTF-8 -*-
import redis, os

source_key = "course-hour-rank-key:teacher-month"
redis_conn = redis.Redis(host="",
                         password="", port=6379, db=0)
tuple_values = redis_conn.zrange(source_key, 0, -1)

counter = 0
for tuple_value in tuple_values:
    cmd_format = 'curl --data "teaId=%s" '
    output = os.system(cmd_format % str(tuple_value))
    print(output)
    counter = (counter + 1)

print "copy count: %d" % counter
