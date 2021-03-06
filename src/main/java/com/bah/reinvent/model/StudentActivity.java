package com.bah.reinvent.model;

import java.io.Serializable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "student_test")
public class StudentActivity implements Serializable {

    private String studentId;
    private String studentTestActivity1FieldTotal;
    private String studentTestActivity2FieldMinutes;
    private String studentTestActivity2FieldSeconds;
    private String studentTestId;
    private String testId;

    public StudentActivity() {
    }

    @DynamoDBAttribute(attributeName="student_id")
    public String getStudentId() {
        return studentId;
    }
    @DynamoDBAttribute(attributeName = "student_test_activity_1_field_total")
    public String getStudentTestActivity1FieldTotal() {
        return studentTestActivity1FieldTotal;
    }
    @DynamoDBAttribute(attributeName = "student_test_activity_2_field_minutes")
    public String getStudentTestActivity2FieldMinutes() {
        return studentTestActivity2FieldMinutes;
    }
    @DynamoDBAttribute(attributeName = "student_test_activity_2_field_seconds")
    public String getStudentTestActivity2FieldSeconds() {
        return studentTestActivity2FieldSeconds;
    }
    @DynamoDBAttribute(attributeName = "student_test_id")
    public String getStudentTestId() {
        return studentTestId;
    }

    @DynamoDBHashKey(attributeName = "test_id")
    @DynamoDBAutoGeneratedKey
    public String getTestId() {
        return testId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentTestActivity1FieldTotal(String studentTestActivity1FieldTotal) {
        this.studentTestActivity1FieldTotal = studentTestActivity1FieldTotal;
    }

    public void setStudentTestActivity2FieldMinutes(String studentTestActivity2FieldMinutes) {
        this.studentTestActivity2FieldMinutes = studentTestActivity2FieldMinutes;
    }

    public void setStudentTestActivity2FieldSeconds(String studentTestActivity2FieldSeconds) {
        this.studentTestActivity2FieldSeconds = studentTestActivity2FieldSeconds;
    }

    public void setStudentTestId(String studentTestId) {
        this.studentTestId = studentTestId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
}
