CREATE TABLE postme.User (
	USER_ID SERIAL NOT NULL,
	USER_NICKNAME VARCHAR(100) NOT NULL,
	FIRST_NAME VARCHAR(100) NOT NULL,
	LAST_NAME VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	USER_PASSWORD VARCHAR(50),
	CONSTRAINT PK_USER_ID PRIMARY KEY (USER_ID)
);

CREATE TABLE postme.Post (
	POST_ID SERIAL NOT NULL,
	POST_CONTENT VARCHAR(1000),
	POST_DATE DATE,
	USER_ID SERIAL NOT NULL,
	CONSTRAINT PK_POST_ID PRIMARY KEY (POST_ID),
	CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES postme.User (USER_ID)
);

CREATE TABLE postme.Comment (
	COMMENT_ID SERIAL NOT NULL,
	USER_ID SERIAL NOT NULL,
	POST_ID SERIAL NOT NULL,
	COMMENT_CONTENT VARCHAR(250),
	COMMENT_DATE DATE,
	CONSTRAINT PK_COMMENT_ID PRIMARY KEY (COMMENT_ID),
	CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES postme.User (USER_ID),
	CONSTRAINT FK_POST_ID FOREIGN KEY (POST_ID) REFERENCES postme.Post (POST_ID)
);

CREATE TABLE postme.Like (
	LIKE_ID SERIAL NOT NULL,
	USER_ID SERIAL NOT NULL,
	POST_ID SERIAL NOT NULL,
	CONSTRAINT PK_LIKE_ID PRIMARY KEY (LIKE_ID),
	CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES postme.User (USER_ID),
	CONSTRAINT FK_POST_ID FOREIGN KEY (POST_ID) REFERENCES postme.Post (POST_ID)
);
