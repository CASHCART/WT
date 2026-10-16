CREATE OR REPLACE PROCEDURE insert_emp(
    p_id IN VARCHAR2,
    p_name IN VARCHAR2,
    p_dept IN VARCHAR2,
    p_sal IN FLOAT
) AS
BEGIN
    INSERT INTO emp VALUES(p_id, p_name, p_dept, p_sal);
END;
/
