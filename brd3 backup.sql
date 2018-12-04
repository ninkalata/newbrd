--------------------------------------------------------
--  File created - Tuesday-December-04-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table NINMASTERCUSTOMER1
--------------------------------------------------------

  CREATE TABLE "HR"."NINMASTERCUSTOMER1" 
   (	"CUSTOMERID" NUMBER(10,0), 
	"CUSTOMERCODE" VARCHAR2(10 BYTE), 
	"CUSTOMERNAME" VARCHAR2(30 BYTE), 
	"CUSTOMERADDRESS1" VARCHAR2(100 BYTE), 
	"CUSTOMERADDRESS2" VARCHAR2(100 BYTE), 
	"CUSTOMERPINCODE" NUMBER(6,0), 
	"EMAILADDRESS" VARCHAR2(100 BYTE), 
	"CONTACTNUMBER" NUMBER(20,0), 
	"PRIMARYCONTACTPERSON" VARCHAR2(100 BYTE), 
	"RECORDSTATUS" VARCHAR2(1 BYTE), 
	"ACTIVEINACTIVEFLAG" VARCHAR2(1 BYTE), 
	"CREATEDATE" DATE, 
	"CREATEDBY" VARCHAR2(30 BYTE), 
	"MODIFIEDDATE" DATE, 
	"MODIFIEDBY" VARCHAR2(30 BYTE), 
	"AUTHORIZEDDATE" DATE, 
	"AUTHORIZEDBY" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table NINMASTERCUSTOMER1
--------------------------------------------------------

  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CREATEDBY" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CREATEDATE" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("ACTIVEINACTIVEFLAG" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("RECORDSTATUS" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("PRIMARYCONTACTPERSON" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("EMAILADDRESS" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CUSTOMERPINCODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CUSTOMERADDRESS1" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CUSTOMERNAME" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CUSTOMERCODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."NINMASTERCUSTOMER1" MODIFY ("CUSTOMERID" NOT NULL ENABLE);
