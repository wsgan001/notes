#!/usr/bin/python
# -*- coding: UTF-8 -*-
import sys,datetime,MySQLdb
reload(sys)
sys.setdefaultencoding("UTF-8")


def print_subject_cs_ware_map(csware_prefer, start, end, file):
    subject_map = {}
    sql_forge = "SELECT ls_tmp.les_subject, s_tmp.stu_grade FROM lessons ls_tmp" \
                " left join students s_tmp on ls_tmp.stu_id = s_tmp.id" \
                " where ls_tmp.id =  "
    sql_tr = "SELECT lesson_id FROM `tr`.`lesson_summary` WHERE " \
             "created_at between '%s' AND '%s' AND csware_prefer = %s" % (start, end, csware_prefer)

    try:
        conn_forge = MySQLdb.connect(host="", user="zmforge_sa",
                                     passwd="", db='forge', charset="utf8")
        conn_tr = MySQLdb.connect(host="", user="tr_sa",
                                  passwd="", db="tr", charset="utf8")

        cursor_forge = conn_forge.cursor()
        cursor_tr = conn_tr.cursor()
        n_tr = cursor_tr.execute(sql_tr)
        print >> file, "%s count: %s " % (csware_map[csware_prefer], str(n_tr))

        lesson_id_set = cursor_tr.fetchall()
        for lessonId in lesson_id_set:
            cursor_forge.execute(sql_forge + str(lessonId[0]))
            subject_grade_tuple = cursor_forge.fetchall();
            grade_subject = "%s|%s" % (str(subject_grade_tuple[0][1]), subject_grade_tuple[0][0])
            subject_count = subject_map.get(grade_subject)
            if subject_count is not None:
                subject_count = int(subject_count) + 1
                subject_map[grade_subject] = subject_count
            else:
                subject_map[grade_subject] = 0
    except MySQLdb.Error, e:
        print "MySQLdb Operational Error! %s" % str(e)

    finally:
        try:
            cursor_forge.close()
            conn_forge.commit()
            conn_forge.close()
        except IOError:
            print "conn_forge close error!"
        try:
            cursor_tr.close()
            conn_tr.commit()
            conn_tr.close()
        except IOError:
            print "conn_tr close error!"
    return subject_map

now = datetime.datetime.now()
a_week_ago = now - datetime.timedelta(7)
start = a_week_ago.strftime("%Y-%m-%d %H:%M:%S")
end = now.strftime("%Y-%m-%d %H:%M:%S")

file_path = "/home/william/tmp/cs_ware.txt"
file = open(file_path, "w+")
print >> file, "\n %s 至 %s 的课件统计信息: \n" % (start, end)

csware_map = {"1": "掌门秋季课件", "2": "掌门其他课件资料", "3": "自制课件", "4": "讲试卷、错题或其他"}
for key in csware_map.keys():
    for subject_str, count in print_subject_cs_ware_map(key, start, end, file).items():
        subject_count_str = "%s %s" % (subject_str, str(count))
        print >> file, subject_count_str

try:
    file.close()
except IOError:
    print "file close error!"

print "\n %s 至 %s 的课件信息统计完成! ---- 输出路径: %s" % (start, end, file_path)

# 需要更改的变量:
# file_path: 输出文件路径
# forge数据库连接参数: host,user,passwd
# tr数据库连接参数:    host,user,passwd