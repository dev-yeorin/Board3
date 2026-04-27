Microsoft Windows [Version 10.0.19045.6466]
(c) Microsoft Corporation. All rights reserved.

C:\Users\GG>sqlplus /nolog

SQL*Plus: Release 21.0.0.0.0 - Production on 수 4월 22 16:08:54 2026
Version 21.3.0.0.0

Copyright (c) 1982, 2021, Oracle.  All rights reserved.

SQL> conn /as sysdba
연결되었습니다.

SQL> alter session set "_ORACLE_SCRIPT"=true;
세션이 변경되었습니다.

SQL> create user spring identified by 1234;
사용자가 생성되었습니다.

SQL> grant connect, resource to spring;
권한이 부여되었습니다.

SQL> alter user spring default tablespace
  2  users quota unlimited on users;
사용자가 변경되었습니다.

SQL> conn spring/1234
연결되었습니다.

SQL> select * from tab;

선택된 레코드가 없습니다.

SQL>

---------------------------------------
-- 메뉴 목록
drop table menus;
CREATE TABLE  MENUS (
    MENU_ID     VARCHAR2(6)    PRIMARY KEY
  , MENU_NAME   VARCHAR2(100)
  , MENU_SEQ    NUMBER(5)
);

INSERT INTO  MENUS VALUES ('MENU01','JAVA', 1);
INSERT INTO  MENUS VALUES ('MENU02','SPRING', 2);
INSERT INTO  MENUS VALUES ('MENU03','ORACLE', 3);
COMMIT;

select * from menus;












































