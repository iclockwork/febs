package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /18
 * Features:
 */

@Table(name = "BD_BUSINESS_OPPORTUNITY")
public class BusinessOpportunityEntity implements Serializable {

    private static final long serialVersionUID = 1474069899852924800L;
    @Id
    @Column(name = "BUSINESS_OPPORTUNITY_ID")
    private Long businessOpportunityId;
    @Column(name = "BUILDING_NO")
    @ExportConfig(value = "楼宇编码")
    private String buildingNo;

    @Column(name = "BUILDING_NAME")
    @ExportConfig(value = "楼宇名称")
    private String buildingName;

    @Column(name = "BUILDING_ID")
    @ExportConfig(value = "楼宇ID")
    private Long buildingId;

    @Column(name = "CUSTOMER_NAME")
    @ExportConfig(value = "客户名称")
    private String customerName;

    @Column(name = "BUSINESS_SOURCE")
    @ExportConfig(value = "商机来源")
    private Integer businessSource;

    @Column(name = "BUSINESS_TYPE")
    @ExportConfig(value = "商机类型")
    private Integer businessType;

    @Column(name = "KEY_PERSON")
    @ExportConfig(value = "客户联系人")
    private String keyPerson;

    @Column(name = "KEY_PERSON_CONTACT")
    @ExportConfig(value = "客户联系人电话")
    private String keyPersonContact;

    @Column(name = "INTRODUCTION")
    @ExportConfig(value = "商机简介")
    private String introduction;

    @Column(name = "STATE")
    @ExportConfig(value = "商机状态")
    private Integer state;

    @Column(name = "SIGN_STAFF_NAME")
    @ExportConfig(value = "签约人")
    private String signStaffName;

    @Column(name = "SIGN_DATE")
    @ExportConfig(value = "签约时间")
    private String signDate;

    @Column(name = "DELETE_FLAG")
    @ExportConfig(value = "删除标记")
    private Integer deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    @ExportConfig(value = "创建人ID")
    private Long createStaffId;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "创建时间")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    @ExportConfig(value = "修改人ID")
    private Long modifyStaffId;

    @Column(name = "MODIFY_DATE")
    @ExportConfig(value = "修改时间")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    @ExportConfig(value = "修改说明")
    private String modifyOp;

    @Column(name = "CUSTOMER_GROWTH")
    @ExportConfig(value = "客户成长空间")
    private Integer customerGrowth;

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

    public Long getBusinessOpportunityId() {
        return businessOpportunityId;
    }

    public void setBusinessOpportunityId(Long businessOpportunityId) {
        this.businessOpportunityId = businessOpportunityId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(Integer businessSource) {
        this.businessSource = businessSource;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSignStaffName() {
        return signStaffName;
    }

    public void setSignStaffName(String signStaffName) {
        this.signStaffName = signStaffName;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifyStaffId() {
        return modifyStaffId;
    }

    public void setModifyStaffId(Long modifyStaffId) {
        this.modifyStaffId = modifyStaffId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyOp() {
        return modifyOp;
    }

    public void setModifyOp(String modifyOp) {
        this.modifyOp = modifyOp;
    }

    public Integer getCustomerGrowth() {
        return customerGrowth;
    }

    public void setCustomerGrowth(Integer customerGrowth) {
        this.customerGrowth = customerGrowth;
    }

    @Override
    public String toString() {
        return "BusinessOpportunityEntity{" +
                "buildingNo=" + buildingNo +
                ", buildingName='" + buildingName + '\'' +
                ", businessOpportunityId=" + businessOpportunityId +
                ", buildingId=" + buildingId +
                ", customerName='" + customerName + '\'' +
                ", businessSource=" + businessSource +
                ", businessType=" + businessType +
                ", keyPerson='" + keyPerson + '\'' +
                ", keyPersonContact='" + keyPersonContact + '\'' +
                ", introduction='" + introduction + '\'' +
                ", state=" + state +
                ", signStaffName='" + signStaffName + '\'' +
                ", signDate=" + signDate +
                ", deleteFlag=" + deleteFlag +
                ", createStaffId=" + createStaffId +
                ", createDate=" + createDate +
                ", modifyStaffId=" + modifyStaffId +
                ", modifyDate=" + modifyDate +
                ", modifyOp='" + modifyOp + '\'' +
                ", customerGrowth=" + customerGrowth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessOpportunityEntity that = (BusinessOpportunityEntity) o;
        return Objects.equals(buildingNo, that.buildingNo) &&
                Objects.equals(buildingName, that.buildingName) &&
                Objects.equals(businessOpportunityId, that.businessOpportunityId) &&
                Objects.equals(buildingId, that.buildingId) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(businessSource, that.businessSource) &&
                Objects.equals(businessType, that.businessType) &&
                Objects.equals(keyPerson, that.keyPerson) &&
                Objects.equals(keyPersonContact, that.keyPersonContact) &&
                Objects.equals(introduction, that.introduction) &&
                Objects.equals(state, that.state) &&
                Objects.equals(signStaffName, that.signStaffName) &&
                Objects.equals(signDate, that.signDate) &&
                Objects.equals(deleteFlag, that.deleteFlag) &&
                Objects.equals(createStaffId, that.createStaffId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyStaffId, that.modifyStaffId) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyOp, that.modifyOp) &&
                Objects.equals(customerGrowth, that.customerGrowth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingNo, buildingName, businessOpportunityId, buildingId, customerName, businessSource, businessType, keyPerson, keyPersonContact, introduction, state, signStaffName, signDate, deleteFlag, createStaffId, createDate, modifyStaffId, modifyDate, modifyOp, customerGrowth);
    }
}
