package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BD_BUILDING_OPPORTUNITY")
public class BuildingOpportunity {
    @Id
    @Column(name = "BUILDING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer buildingId;

    @Column(name = "BUILDING_NAME")
    private String buildingName;

    @ExportConfig(value = "地市")
    private String dsRegionName;

    @ExportConfig(value = "区县")
    private String regionName;

    @Column(name = "BUILDING_LEVEL")
    private String buildingLevel;

    @ExportConfig(value = "楼宇等级")
    private String buildingLevelName;

    @Column(name = "BUILDING_TYPE")
    private String buildingType;

    @ExportConfig(value = "楼宇所属区域类型")
    private String buildingTypeDesc;

    @Column(name = "BUILDING_TYPE_NAME")
    @ExportConfig(value = "楼宇所属区域名称")
    private String buildingTypeName;

    @Column(name = "BUILDING_ADDRESS")
    @ExportConfig(value = "楼宇地址")
    private String buildingAddress;

    private String dsRegionId;

    @Column(name = "REGION_ID")
    private String regionId;

    @Column(name = "FLOOR_NUMBER")
    @ExportConfig(value = "楼层数")
    private Short floorNumber;

    @Column(name = "AREA")
    @ExportConfig(value = "建筑面积（万m2）")
    private BigDecimal area;

    @Column(name = "HOUSEHOLDER_NUMBER")
    @ExportConfig(value = "商户数（户）")
    private Short householderNumber;

    @Column(name = "PROPERTY_COMPANY")
    @ExportConfig(value = "物业单位")
    private String propertyCompany;

    @Column(name = "PROPERTY_MANAGER")
    @ExportConfig(value = "物业联系人")
    private String propertyManager;

    @Column(name = "PROPERTY_MANAGER_CONTACT")
    @ExportConfig(value = "物业联系人电话")
    private String propertyManagerContact;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "DELETE_FLAG")
    private Short deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Long createStaffId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Integer modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;

    public String getBuildingLevelName() {
        return buildingLevelName;
    }

    public void setBuildingLevelName(String buildingLevelName) {
        this.buildingLevelName = buildingLevelName;
    }

    public String getBuildingTypeDesc() {
        return buildingTypeDesc;
    }

    public void setBuildingTypeDesc(String buildingTypeDesc) {
        this.buildingTypeDesc = buildingTypeDesc;
    }

    public String getDsRegionName() {
        return dsRegionName;
    }

    public void setDsRegionName(String dsRegionName) {
        this.dsRegionName = dsRegionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDsRegionId() {
        return dsRegionId;
    }

    public void setDsRegionId(String dsRegionId) {
        this.dsRegionId = dsRegionId;
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
     * @return BUILDING_NAME
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * @param buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    /**
     * @return BUILDING_LEVEL
     */
    public String getBuildingLevel() {
        return buildingLevel;
    }

    /**
     * @param buildingLevel
     */
    public void setBuildingLevel(String buildingLevel) {
        this.buildingLevel = buildingLevel == null ? null : buildingLevel.trim();
    }

    /**
     * @return BUILDING_TYPE
     */
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * @param buildingType
     */
    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType == null ? null : buildingType.trim();
    }

    /**
     * @return BUILDING_TYPE_NAME
     */
    public String getBuildingTypeName() {
        return buildingTypeName;
    }

    /**
     * @param buildingTypeName
     */
    public void setBuildingTypeName(String buildingTypeName) {
        this.buildingTypeName = buildingTypeName == null ? null : buildingTypeName.trim();
    }

    /**
     * @return BUILDING_ADDRESS
     */
    public String getBuildingAddress() {
        return buildingAddress;
    }

    /**
     * @param buildingAddress
     */
    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress == null ? null : buildingAddress.trim();
    }

    /**
     * @return REGION_ID
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
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
     * @return AREA
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /**
     * @return HOUSEHOLDER_NUMBER
     */
    public Short getHouseholderNumber() {
        return householderNumber;
    }

    /**
     * @param householderNumber
     */
    public void setHouseholderNumber(Short householderNumber) {
        this.householderNumber = householderNumber;
    }

    /**
     * @return PROPERTY_COMPANY
     */
    public String getPropertyCompany() {
        return propertyCompany;
    }

    /**
     * @param propertyCompany
     */
    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    /**
     * @return PROPERTY_MANAGER
     */
    public String getPropertyManager() {
        return propertyManager;
    }

    /**
     * @param propertyManager
     */
    public void setPropertyManager(String propertyManager) {
        this.propertyManager = propertyManager == null ? null : propertyManager.trim();
    }

    /**
     * @return PROPERTY_MANAGER_CONTACT
     */
    public String getPropertyManagerContact() {
        return propertyManagerContact;
    }

    /**
     * @param propertyManagerContact
     */
    public void setPropertyManagerContact(String propertyManagerContact) {
        this.propertyManagerContact = propertyManagerContact == null ? null : propertyManagerContact.trim();
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

    public Long getCreateStaffId() {
        return createStaffId;
    }

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