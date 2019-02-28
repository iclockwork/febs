package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BD_CUSTOMER_OPPORTUNITY")
public class CustomerOpportunity {
    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "BUILDING_ID")
    private Integer buildingId;

    @Column(name = "BUILDING_NO")
    private String buildingNo;

    @Column(name = "BUILDING_NAME")
    @ExportConfig(value = "楼宇名称")
    private String buildingName;

    @Column(name = "CUSTOMER_NAME")
    @ExportConfig(value = "客户名称")
    private String customerName;

    @Column(name = "FLOOR_NUMBER")
    @ExportConfig(value = "楼层")
    private Short floorNumber;

    @Column(name = "ROOM_NUMBER")
    @ExportConfig(value = "房间号")
    private Integer roomNumber;

    @Column(name = "CUSTOMER_TYPE")
    @ExportConfig(value = "客户类型")
    private String customerType;

    @Column(name = "CUSTOMER_INDUSTRY")
    @ExportConfig(value = "客户行业")
    private String customerIndustry;

    @Column(name = "COMPETITOR_NAME")
    @ExportConfig(value = "竞争对手名称")
    private String competitorName;

    @Column(name = "COMPETITOR_TYPE")
    @ExportConfig(value = "竞争对手业务类型")
    private String competitorType;

    @Column(name = "COMPETITOR_END")
    @ExportConfig(value = "竞争对手合同到期情况")
    private String competitorEnd;

    @Column(name = "KEY_PERSON")
    @ExportConfig(value = "客户联系人")
    private String keyPerson;

    @Column(name = "KEY_PERSON_CONTACT")
    @ExportConfig(value = "客户联系人电话")
    private String keyPersonContact;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "DELETE_FLAG")
    private Short deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Integer createStaffId;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "创建时间")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Integer modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;


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

    /**
     * @return FLOOR_NUMBER
     */
    public Short getFloorNumber() {
        return floorNumber;
    }

    /**
     * @param floorNumber
     */
    public void setFloorNumber(Short floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * @return ROOM_NUMBER
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return CUSTOMER_TYPE
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    /**
     * @return CUSTOMER_INDUSTRY
     */
    public String getCustomerIndustry() {
        return customerIndustry;
    }

    /**
     * @param customerIndustry
     */
    public void setCustomerIndustry(String customerIndustry) {
        this.customerIndustry = customerIndustry == null ? null : customerIndustry.trim();
    }

    /**
     * @return COMPETITOR_NAME
     */
    public String getCompetitorName() {
        return competitorName;
    }

    /**
     * @param competitorName
     */
    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName == null ? null : competitorName.trim();
    }

    /**
     * @return COMPETITOR_TYPE
     */
    public String getCompetitorType() {
        return competitorType;
    }

    /**
     * @param competitorType
     */
    public void setCompetitorType(String competitorType) {
        this.competitorType = competitorType == null ? null : competitorType.trim();
    }

    /**
     * @return COMPETITOR_END
     */
    public String getCompetitorEnd() {
        return competitorEnd;
    }

    /**
     * @param competitorEnd
     */
    public void setCompetitorEnd(String competitorEnd) {
        this.competitorEnd = competitorEnd == null ? null : competitorEnd.trim();
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