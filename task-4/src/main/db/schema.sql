CREATE TABLE STUDENT (
  id SERIAL NOT NULL,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT STUDENT_PK PRIMARY KEY (id)
);

CREATE TABLE TEACHER (
  id SERIAL NOT NULL,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT TEACHER_PK PRIMARY KEY (id)
);

CREATE TABLE COURSE (
  id SERIAL NOT NULL,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(255),
  start_time timestamp without time zone NOT NULL,
  end_time timestamp without time zone NOT NULL,
  teacher_id bigint NOT NULL,
  CONSTRAINT COURSE_PK PRIMARY KEY (id)
);

alter table COURSE
   add constraint FK_COURSE_REF_TEACHER foreign key (teacher_id)
      references TEACHER (id)
      on delete restrict on update restrict;
      
CREATE TABLE COURSE_TO_STUDENT (
  student_id bigint NOT NULL,
  course_id bigint NOT NULL,
  score VARCHAR(10),
  feedback VARCHAR(255),
  CONSTRAINT COURSE_TO_STUDENT_PK PRIMARY KEY (student_id, course_id)
);

alter table COURSE_TO_STUDENT
   add constraint FK_CTS_REF_STUDENT foreign key (student_id)
      references STUDENT (id)
      on delete restrict on update restrict;
      
alter table COURSE_TO_STUDENT
   add constraint FK_CTS_REF_COURSE foreign key (course_id)
      references COURSE (id)
      on delete restrict on update restrict;


INSERT INTO TEACHER(name) VALUES ('Ivan Dulin');
INSERT INTO TEACHER(name) VALUES ('Isaak');
INSERT INTO COURSE(name, description, start_time, end_time, teacher_id) VALUES ('Фрезировщик', 'Мастер класс от Ивана Дулина', now(), now(), 1);
