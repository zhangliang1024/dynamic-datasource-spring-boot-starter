#

### 一、基于目前的mysql 主从架构
```markdown
1. 登录主库：mysql -uroot -p123456
2. 查看主从状态：show master status;
mysql> show master status;
+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000002 |      630 |              |                  |                   |
+------------------+----------+--------------+------------------+-------------------+
1 row in set (0.00 sec)  

3. 登录从库：mysql -uroot -p123456
4. 查看主从状态： show slave status\G;
mysql> show slave status\G;
*************************** 1. row ***************************
               Slave_IO_State: Connecting to master
                  Master_Host: 192.168.228.143
                  Master_User: slave
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: mysql-bin.000001
          Read_Master_Log_Pos: 1294
               Relay_Log_File: localhost-relay-bin.000003
                Relay_Log_Pos: 4
        Relay_Master_Log_File: mysql-bin.000001
             Slave_IO_Running: Connecting
            Slave_SQL_Running: Yes
              Replicate_Do_DB: 
          Replicate_Ignore_DB: 
           Replicate_Do_Table: 
       Replicate_Ignore_Table: 
      Replicate_Wild_Do_Table: 
  Replicate_Wild_Ignore_Table: 
                   Last_Errno: 0
                   Last_Error: 
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 1294
              Relay_Log_Space: 154
              
5. 停止主从关系：stop slave;
   重置主从关系：reset slave;
6. 配置新的主从节点关系： change master to master_host='192.168.80.134',master_port=3306,master_user='root',master_password='123456',master_log_file='mysql-bin.000002',master_log_pos=630;
7. 重新主从复制：start slave;
8. 查看主从状态：
mysql> show slave status\G;
*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: 192.168.80.134
                  Master_User: root
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: mysql-bin.000002
          Read_Master_Log_Pos: 630
               Relay_Log_File: localhost-relay-bin.000002
                Relay_Log_Pos: 320
        Relay_Master_Log_File: mysql-bin.000002
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes              
```

### 三、参考文档
[mysql数据库主从配置](https://www.cnblogs.com/atcloud/p/10773855.html)
[mysql 主从复制（mysql双机热备的实现）](https://www.cnblogs.com/jianmingyuan/p/10903682.html)
★★★
[MySQL主备、主从、读写分离详解](https://blog.csdn.net/qq_40378034/article/details/91125768)
[MySQL主从结构搭建](https://blog.csdn.net/qq_21108311/article/details/82377763)
[]()
[]()