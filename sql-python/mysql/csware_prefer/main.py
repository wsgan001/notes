import MySQLdb


def db_qa_sql_multi_add(sql, datas, dbName):
    conn = MySQLdb.connect(host="192.168.1.161", user="naliworld", passwd="password!", db=dbName, charset="utf8")
    cursor = conn.cursor()
    n = cursor.executemany(sql, tuple(datas))
    print sql, n
    cursor.close()
    conn.commit()
    conn.close()

sql = "SELECT lesson_id FROM `tr`.`lesson_summary` WHERE csware_prefer = 1"
print sql

conn = MySQLdb.connect(host="", user="", passwd="", db="tr", charset="utf8")
cursor = conn.cursor()
n = cursor.execute(sql)
print n

lessonIdSet = cursor.fetchall()
for lessonId in lessonIdSet:
    print lessonId


cursor.close()
conn.commit()
conn.close()