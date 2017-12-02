# Training-and-Placement
Training and placement Project built on Netbeans platform using mysql database management system as backend and java swing for front end. It can handle details of Students,Training and placement officers of various departments,Companies visiting the college and the schedule those companies will follow. All details can be updated through the front end and new users can be added any time. Students can check which Companies are appearing for their placement and IF they fulfill the criteria mentioned in the company's schedule,they can apply to appear for the interview.It also holds details of alumnis, where they have been placed, in what year and the package they were offered.
# ER Diagram
![ER Diagram](https://github.com/aliasgar521/Training-and-Placement/blob/master/Screenshots/ER1.png)
# Table descriptions:
1)TPO:
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| tpo_id      | int(11)     | NO   | PRI | NULL    | auto_increment |
| designation | varchar(30) | YES  |     | NULL    |                |
| salary      | int(11)     | YES  |     | NULL    |                |
| join_date   | date        | YES  |     | NULL    |                |
| p_id        | int(11)     | YES  | MUL | NULL    |                |
| d_id        | int(11)     | YES  | MUL | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
2)appearing
+----------------+---------+------+-----+---------+-------+
| Field          | Type    | Null | Key | Default | Extra |
+----------------+---------+------+-----+---------+-------+
| stu_id         | int(11) | NO   | PRI | NULL    |       |
| sch_id         | int(11) | NO   | PRI | NULL    |       |
| appearing_date | date    | YES  |     | NULL    |       |
+----------------+---------+------+-----+---------+-------+
3)candidate
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| cand_id     | int(11)     | NO   | PRI | NULL    | auto_increment |
| designation | varchar(30) | YES  |     | NULL    |                |
| package     | varchar(20) | YES  |     | NULL    |                |
| sch_id      | int(11)     | NO   | PRI | NULL    |                |
| stu_id      | int(11)     | NO   | PRI | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
4)company
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| comp_id      | int(11)     | NO   | PRI | NULL    | auto_increment |
| co_name      | varchar(20) | YES  |     | NULL    |                |
| type         | varchar(20) | YES  |     | NULL    |                |
| HR_personnel | varchar(20) | YES  |     | NULL    |                |
| email        | varchar(30) | YES  |     | NULL    |                |
| phone        | varchar(20) | YES  |     | NULL    |                |
| street       | varchar(20) | YES  |     | NULL    |                |
| city         | varchar(20) | YES  |     | NULL    |                |
| pincode      | int(11)     | YES  |     | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
5)department
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| d_id     | int(11)     | NO   | PRI | NULL    |       |
| dep_name | varchar(20) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
6)login
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| username | varchar(20) | NO   | PRI | NULL    |       |
| password | varchar(20) | YES  |     | NULL    |       |
| id       | int(11)     | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
7)schedule
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| sch_id     | int(11)     | NO   | PRI | NULL    | auto_increment |
| sch_date   | date        | YES  |     | NULL    |                |
| criteria   | int(11)     | YES  |     | NULL    |                |
| acad_year  | varchar(20) | YES  |     | NULL    |                |
| min_salary | int(11)     | YES  |     | NULL    |                |
| comp_id    | int(11)     | YES  | MUL | NULL    |                |
| tpo_id     | int(11)     | YES  | MUL | NULL    |                |
| active     | int(11)     | YES  |     | 1       |                |
+------------+-------------+------+-----+---------+----------------+
8)person
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| p_id     | int(11)     | NO   | PRI | NULL    | auto_increment |
| fname    | varchar(20) | YES  |     | NULL    |                |
| lname    | varchar(20) | YES  |     | NULL    |                |
| email    | varchar(40) | YES  |     | NULL    |                |
| phone    | varchar(20) | YES  |     | NULL    |                |
| city     | varchar(20) | YES  |     | NULL    |                |
| street   | varchar(20) | YES  |     | NULL    |                |
| flat     | varchar(20) | YES  |     | NULL    |                |
| pincode  | int(11)     | YES  |     | NULL    |                |
| gender   | varchar(20) | YES  |     | NULL    |                |
| dob      | date        | YES  |     | NULL    |                |
| username | varchar(20) | YES  | MUL | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
9)student
+---------------+---------+------+-----+---------+----------------+
| Field         | Type    | Null | Key | Default | Extra          |
+---------------+---------+------+-----+---------+----------------+
| stu_id        | int(11) | NO   | PRI | NULL    | auto_increment |
| academic_year | date    | YES  |     | NULL    |                |
| FE            | int(11) | YES  |     | NULL    |                |
| SE            | int(11) | YES  |     | NULL    |                |
| TE            | int(11) | YES  |     | NULL    |                |
| d_id          | int(11) | YES  | MUL | NULL    |                |
| p_id          | int(11) | YES  | MUL | NULL    |                |
| active        | int(11) | YES  |     | 1       |                |
+---------------+---------+------+-----+---------+----------------+

# Graphical User Interface
Login Page
![Login Page](https://github.com/aliasgar521/Training-and-Placement/blob/master/Screenshots/1.png)
