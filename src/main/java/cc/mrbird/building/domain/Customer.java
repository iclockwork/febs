package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "BD_CUSTOMER")
public class Customer implements Serializable {
    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "CUSTOMER_NO")
    @ExportConfig(value = "客户编码")
    private String customerNo;

    @Column(name = "CUSTOMER_NAME")
    @ExportConfig(value = "客户名称")
    private String customerName;

    @Column(name = "KEY_PERSON")
    @ExportConfig(value = "客户联系人")
    private String keyPerson;

    @Column(name = "KEY_PERSON_CONTACT")
    @ExportConfig(value = "客户联系电话")
    private String keyPersonContact;

    @Column(name = "MONTH_FEE")
    @ExportConfig(value = "月费")
    private BigDecimal monthFee;

    @Column(name = "REMARK")
    @ExportConfig(value = "备注")
    private String remark;

    @Column(name = "DELETE_FLAG")
    private Short deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Integer createStaffId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Integer modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;

    /**
     * @return CUSTOMER_ID
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    /**
     * @return KEY_PERSON
     */
    public String getKeyPerson() {
        return keyPerson;
    }

    /**
     * @param keyPerson
     */
    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson == null ? null : keyPerson.trim();
    }

    /**
     * @return KEY_PERSON_CONTACT
     */
    public String getKeyPersonContact() {
        return keyPersonContact;
    }

    /**
     * @param keyPersonContact
     */
    public void setKeyPersonContact(String keyPersonContact) {
        this.keyPersonContact = keyPersonContact == null ? null : keyPersonContact.trim();
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
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * @return CREATE_STAFF_ID
     */
    public Integer getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId
     */
    public void setCreateStaffId(Integer createStaffId) {
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
    public Integer getModifyStaffId() {
        return modifyStaffId;
    }

    /**
     * @param modifyStaffId
     */
    public void setModifyStaffId(Integer modifyStaffId) {
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
}