package com.bah.reinvent.model;

import java.io.Serializable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "student_attrib")
public class StudentAttrib implements Serializable {

    private String student_attrib_id;
    private String student_attribdate_created;
    private String student_attrib_height_feet;
    private String student_attrib_weight_pounds;
    private String student_attrib_bhi;
    private String student_attrib_tricep_skinfold;
    private String student_attrib_calk_skinfold;
    private String student_attrib_percent_bodyfat_entered;
    private String student_attrib_percent_bodyfat_calculated;
    private String student_attrib_student_class_ID;

    public StudentAttrib(){}

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getStudent_attrib_id() {
        return student_attrib_id;
    }
    @DynamoDBAttribute
    public String getStudent_attribdate_created() {
        return student_attribdate_created;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_height_feet() {
        return student_attrib_height_feet;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_weight_pounds() {
        return student_attrib_weight_pounds;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_bhi() {
        return student_attrib_bhi;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_tricep_skinfold() {
        return student_attrib_tricep_skinfold;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_calk_skinfold() {
        return student_attrib_calk_skinfold;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_percent_bodyfat_entered() {
        return student_attrib_percent_bodyfat_entered;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_percent_bodyfat_calculated() {
        return student_attrib_percent_bodyfat_calculated;
    }
    @DynamoDBAttribute
    public String getStudent_attrib_student_class_ID() {
        return student_attrib_student_class_ID;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_id(String student_attrib_id) {
        this.student_attrib_id = student_attrib_id;
    }
    @DynamoDBAttribute
    public void setStudent_attribdate_created(String student_attribdate_created) {
        this.student_attribdate_created = student_attribdate_created;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_height_feet(String student_attrib_height_feet) {
        this.student_attrib_height_feet = student_attrib_height_feet;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_weight_pounds(String student_attrib_weight_pounds) {
        this.student_attrib_weight_pounds = student_attrib_weight_pounds;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_bhi(String student_attrib_bhi) {
        this.student_attrib_bhi = student_attrib_bhi;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_tricep_skinfold(String student_attrib_tricep_skinfold) {
        this.student_attrib_tricep_skinfold = student_attrib_tricep_skinfold;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_calk_skinfold(String student_attrib_calk_skinfold) {
        this.student_attrib_calk_skinfold = student_attrib_calk_skinfold;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_percent_bodyfat_entered(String student_attrib_percent_bodyfat_entered) {
        this.student_attrib_percent_bodyfat_entered = student_attrib_percent_bodyfat_entered;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_percent_bodyfat_calculated(String student_attrib_percent_bodyfat_calculated) {
        this.student_attrib_percent_bodyfat_calculated = student_attrib_percent_bodyfat_calculated;
    }
    @DynamoDBAttribute
    public void setStudent_attrib_student_class_ID(String student_attrib_student_class_ID) {
        this.student_attrib_student_class_ID = student_attrib_student_class_ID;
    }
}
