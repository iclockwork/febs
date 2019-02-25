package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BD_CUSTOMER_EXPIRATION")
public class CustomerExpiration {
    @Id
    @Column(name = "CUSTOMER_EXPIRATION_ID")
    private Integer customerExpirationId;

    @Column(name = "BUILDING_NO")
    @ExportConfig(value = "楼宇编码")
    private String buildingNo;

    @Column(name = "BUILDING_NAME")
    @ExportConfig(value = "楼宇名称")
    private String buildingName;

    @Column(name = "BUILDING_ID")
    private Integer buildingId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "REMIND_DATE")
    private String  remindDate;

    @Column(name = "DELETE_FLAG")
    private Short deleteFlag;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "REMIND_FLAG")
    private Short remindFlag;


    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * @return CUSTOMER_EXPIRATION_ID
     */
    public Integer getCustomerExpirationId() {
        return customerExpirationId;
    }

    /**
     * @param customerExpirationId
     */
    public void setCustomerExpirationId(Integer customerExpirationId) {
        this.customerExpirationId = customerExpirationId;
    }

    /**
     * @return BUILDING_ID
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * @param buildingId
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * @return CUSTOMER_NAME
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }

    /**
     * @return DELETE_FLAG
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return REMIND_FLAG
     */
    public Short getRemindFlag() {
        return remindFlag;
    }

    /**
     * @param remindFlag
     */
    public void setRemindFlag(Short remindFlag) {
        this.remindFlag = remindFlag;
    }
}