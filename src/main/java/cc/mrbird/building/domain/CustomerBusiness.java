package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "BD_CUSTOMER_BUSINESS")
public class CustomerBusiness {
    /**
     * 序列
     */
    public static final String SEQ = "SEQ_BD_CUSTOMER_BUSINESS";

    @Id
    @Column(name = "CUSTOMER_BUSINESS_ID")
    private Long customerBusinessId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Transient
    @ExportConfig(value = "客户编码")
    private String customerNo;

    @Transient
    @ExportConfig(value = "客户名称")
    private String customerName;

    @Column(name = "BUSINESS_TYPE")
    private Integer businessType;

    @Transient
    @ExportConfig(value = "业务类型")
    private String businessTypeName;

    @Column(name = "BUSINESS_PHONE")
    @ExportConfig(value = "业务号码")
    private String businessPhone;

    @Column(name = "MONTH_FEE")
    @ExportConfig(value = "月费")
    private BigDecimal monthFee;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Long createStaffId;

    @Transient
    @ExportConfig(value = "创建人")
    private String createStaffName;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "创建时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Long modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Transient
    private Long count;

    /**
     * @return CUSTOMER_BUSINESS_ID
     */
    public Long getCustomerBusinessId() {
        return customerBusinessId;
    }

    /**
     * @param customerBusinessId
     */
    public void setCustomerBusinessId(Long customerBusinessId) {
        this.customerBusinessId = customerBusinessId;
    }

    /**
     * @return CUSTOMER_ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return BUSINESS_TYPE
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * @param businessType
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * @return BUSINESS_PHONE
     */
    public String getBusinessPhone() {
        return businessPhone;
    }

    /**
     * @param businessPhone
     */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone == null ? null : businessPhone.trim();
    }

    /**
     * @return MONTH_FEE
     */
    public BigDecimal getMonthFee() {
        return monthFee;
    }

    /**
     * @param monthFee
     */
    public void setMonthFee(BigDecimal monthFee) {
        this.monthFee = monthFee;
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

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public String getCreateStaffName() {
        return createStaffName;
    }

    public void setCreateStaffName(String createStaffName) {
        this.createStaffName = createStaffName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}