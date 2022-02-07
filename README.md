## Spring Data Envers (Hibernate Envers)

```  
The Envers project aims to enable easy auditing of persistent classes. All that you have to do is
annotate your persistent class or some of its properties, that you want to audit, with @Audited.
For each audited entity, a table will be created, which will hold the history of changes made to the
entity. You can then retrieve and query historical data without much effort.
Similarly to Subversion, the library has a concept of revisions. Basically, one transaction is one
revision (unless the transaction didn't modify any audited entities). As the revisions are global,
having a revision number, you can query for various entities at that revision, retrieving a (partial)
view of the database at that revision. You can find a revision number having
```

### Resources
- [Spring Docs](https://docs.spring.io/spring-data/envers/docs/current/reference/html/#reference)
- [Hibernate Docs](http://devdoc.net/javaweb/hibernate/Hibernate-5.1.0/userGuide/en-US/html/ch19.html)


### Usage

Try to APIs on [Postman](https://documenter.getpostman.com/view/2522238/UVeGq5xZ )


### Note
If you add Hibernate Envers to existing Hibernate Entities, you need to write a custom migration script.
```  
DO
$$
    DECLARE
        USER_TABLE_RECORD RECORD;
        HISTORY_INFO_ID   INTEGER;
    BEGIN
        FOR USER_TABLE_RECORD IN SELECT * FROM USERS

            LOOP
                HISTORY_INFO_ID := nextval('history_info_seq');

                insert into history_info(id, date)
                values (HISTORY_INFO_ID, USER_TABLE_RECORD.created_date);

                insert into users_history(id, HISTORY_INFO_ID, type, first_name, last_name)
                values (USER_TABLE_RECORD.id, HISTORY_INFO_ID, 0, USER_TABLE_RECORD.first_name,
                        USER_TABLE_RECORD.last_name);
            END LOOP;

    END
$$;
```