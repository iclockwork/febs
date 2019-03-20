package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "BD_BUILDING_CUSTOMER_RP")
public class BuildingCustomerRp implements Serializable {
    @Id
    @Column(name = "BUILDING_CUSTOMER_RP_ID")
    private Long buildingCustomerRpId;

    private String dsRegionId;

    @ExportConfig(value = "地市")
    private String dsRegionName;

    @Column(name = "REGION_ID")
    private String regionId;

    @ExportConfig(value = "区县")
    private String regionName;

    @Column(name = "BUILDING_NO")
    @ExportConfig(value = "楼宇编码")
    private String buildingNo;

    @ExportConfig(value = "楼宇名称")
    private String buildingName;

    @Column(name = "SEGM_ID")
    private String segmId;

    @ExportConfig(value = "九级地址名称")
    private String standName;

    @Column(name = "CUSTOMER_NO")
    @ExportConfig(value = "客户编码")
    private String customerNo;

    @ExportConfig(value = "客户名称")
    private String customerName;

    @ExportConfig(value = "客户联系人")
    private String keyPerson;

    @ExportConfig(value = "客户联系电话")
    private String keyPersonContact;

    @ExportConfig(value = "月费")
    private BigDecimal monthFee;

    @ExportConfig(value = "备注")
    private String remark;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Long createStaffId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Long modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;

    /**
     * @return BUILDING_CUSTOMER_RP_ID
     */
    public Long getBuildingCustomerRpId() {
        return buildingCustomerRpId;
    }

    /**
     * @param buildingCustomerRpId
     */
    public void setBuildingCustomerRpId(Long buildingCustomerRpId) {
        this.buildingCustomerRpId = buildingCustomerRpId;
    }

    /**
     * @return BUILDING_NO
     */
    public String getBuildingNo() {
        return buildingNo;
    }

    /**
     * @param buildingNo
     */
    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo == null ? null : buildingNo.trim();
    }

    /**
     * @return SEGM_ID
     */
    public String getSegmId() {
        return segmId;
    }

    /**
     * @param segmId
     */
    public void setSegmId(String segmId) {
        this.segmId = segmId == null ? null : segmId.trim();
    }

    /**
     * @return CUSTOMER_NO
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    /**
     * @return DELETE_FLAG
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * @return CREATE_STAFF_ID
     */
    public Long getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId
     */
    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
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
     * @return MODIFY_STAFF_ID
     */
    public Long getModifyStaffId() {
        return modifyStaffId;
    }

    /**
     * @param modifyStaffId
     */
    public void setModifyStaffId(Long modifyStaffId) {
        this.modifyStaffId = modifyStaffId;
    }

    /**
     * @return MODIFY_DATE
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return MODIFY_OP
     */
    public String getModifyOp() {
        return modifyOp;
    }

    /**
     * @param modifyOp
     */
    public void setModifyOp(String modifyOp) {
        this.modifyOp = modifyOp == null ? null : modifyOp.trim();
    }

    public String getDsRegionId() {
        return dsRegionId;
    }

    public void setDsRegionId(String dsRegionId) {
        this.dsRegionId = dsRegionId;
    }

    public String getDsRegionName() {
        return dsRegionName;
    }

    public void setDsRegionName(String dsRegionName) {
        this.dsRegionName = dsRegionName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStandName() {
        return standName;
    }

    public void setStandName(String standName) {
        this.standName = standName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getKeyPersonContact() {
        return keyPersonContact;
    }

    public void setKeyPersonContact(String keyPersonContact) {
        this.keyPersonContact = keyPersonContact;
    }

    public BigDecimal getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(BigDecimal monthFee) {
        this.monthFee = monthFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}