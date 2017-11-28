package com.bah.reinvent.model;

import java.io.Serializable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "student")
public class Student implements Serializable {


    private String studentId;
    private String studentFirst;
    private String studentLast;
    private String studentToken;
    private String studentDob;
    private String studentEmail;
    private String studentGender;


    public Student() {
    }

    @DynamoDBHashKey(attributeName = "student_id")
    @DynamoDBAutoGeneratedKey
    public String getStudentId() {
        return studentId;
    }
    @DynamoDBAttribute(attributeName = "student_first")
    public String getStudentFirst() {
        return studentFirst;
    }
    @DynamoDBAttribute(attributeName = "student_last")
    public String getStudentLast() {
        return studentLast;
    }
    @DynamoDBAttribute(attributeName = "student_token")
    public String getStudentToken() {
        return studentToken;
    }
    @DynamoDBAttribute(attributeName = "student_dob")
    public String getStudentDob() {
        return studentDob;
    }
    @DynamoDBAttribute(attributeName = "student_email")
    public String getStudentEmail() {
        return studentEmail;
    }
    @DynamoDBAttribute(attributeName = "student_gender")
    public String getStudentGender() {
        return studentGender;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentFirst(String studentFirst) {
        this.studentFirst = studentFirst;
    }

    public void setStudentLast(String studentLast) {
        this.studentLast = studentLast;
    }

    public void setStudentToken(String studentToken) {
        this.studentToken = studentToken;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }
}