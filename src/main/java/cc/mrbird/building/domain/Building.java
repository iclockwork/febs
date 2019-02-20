package cc.mrbird.building.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BD_BUILDING")
public class Building implements Serializable {
    @Id
    @Column(name = "BUILDING_ID")
    private Integer buildingId;

    @Column(name = "BUILDING_NO")
    private String buildingNo;

    @Column(name = "BUILDING_NAME")
    private String buildingName;

    @Column(name = "BUILDING_LEVEL")
    private String buildingLevel;

    @Column(name = "BUILDING_TYPE")
    private String buildingType;

    @Column(name = "BUILDING_TYPE_NAME")
    private String buildingTypeName;

    @Column(name = "BUILDING_ADDRESS")
    private String buildingAddress;

    @Column(name = "REGION_ID")
    private String regionId;

    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    @Column(name = "LATITUDE")
    private BigDecimal latitude;

    @Column(name = "FLOOR_NUMBER")
    private Short floorNumber;

    @Column(name = "AREA")
    private BigDecimal area;

    @Column(name = "HOUSEHOLDER_NUMBER")
    private Short householderNumber;

    @Column(name = "PROPERTY_COMPANY")
    private String propertyCompany;

    @Column(name = "PROPERTY_MANAGER")
    private String propertyManager;

    @Column(name = "PROPERTY_MANAGER_CONTACT")
    private String propertyManagerContact;

    @Column(name = "BUILDING_MANAGER_ID")
    private Integer buildingManagerId;

    @Column(name = "STATE")
    private Short state;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "SEGM_ID")
    private String segmId;

    @Column(name = "ACCESS_AREA_ID")
    private String accessAreaId;

    @Column(name = "ROOM_ID")
    private String roomId;

    @Column(name = "LIGHT_NAME")
    private String lightName;

    @Column(name = "LIGHT_ADDRESS")
    private String lightAddress;

    @Column(name = "LIGHT_LONGITUDE")
    private BigDecimal lightLongitude;

    @Column(name = "LIGHT_LATITUDE")
    private BigDecimal lightLatitude;

    @Column(name = "ROOM_CABINET_FLAG")
    private Short roomCabinetFlag;

    @Column(name = "CABLE_ACCESS_FLAG")
    private Short cableAccessFlag;

    @Column(name = "CABLE_NUMBER")
    private Short cableNumber;

    @Column(name = "CABLE_REMAIN_NUMBER")
    private Short cableRemainNumber;

    @Column(name = "VERTICAL_COVERAGE_FLAG")
    private Short verticalCoverageFlag;

    @Column(name = "HORIZONTAL_COVERAGE_FLAG")
    private Short horizontalCoverageFlag;

    @Column(name = "COVERAGE_METHOD")
    private Short coverageMethod;

    @Column(name = "COOPERATION_METHOD")
    private Short cooperationMethod;

    @Column(name = "INDOOR_DISTRIBUTION_FLAG")
    private Short indoorDistributionFlag;

    @Column(name = "COVERAGE_NETWORK_STANDARD")
    private Short coverageNetworkStandard;

    @Column(name = "WLAN_FLAG")
    private Short wlanFlag;

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
     * @return LONGITUDE
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * @return LATITUDE
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
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
     * @return BUILDING_MANAGER_ID
     */
    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    /**
     * @param buildingManagerId
     */
    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
    }

    /**
     * @return STATE
     */
    public Short getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Short state) {
        this.state = state;
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
     * @return ACCESS_AREA_ID
     */
    public String getAccessAreaId() {
        return accessAreaId;
    }

    /**
     * @param accessAreaId
     */
    public void setAccessAreaId(String accessAreaId) {
        this.accessAreaId = accessAreaId == null ? null : accessAreaId.trim();
    }

    /**
     * @return ROOM_ID
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * @return LIGHT_NAME
     */
    public String getLightName() {
        return lightName;
    }

    /**
     * @param lightName
     */
    public void setLightName(String lightName) {
        this.lightName = lightName == null ? null : lightName.trim();
    }

    /**
     * @return LIGHT_ADDRESS
     */
    public String getLightAddress() {
        return lightAddress;
    }

    /**
     * @param lightAddress
     */
    public void setLightAddress(String lightAddress) {
        this.lightAddress = lightAddress == null ? null : lightAddress.trim();
    }

    /**
     * @return LIGHT_LONGITUDE
     */
    public BigDecimal getLightLongitude() {
        return lightLongitude;
    }

    /**
     * @param lightLongitude
     */
    public void setLightLongitude(BigDecimal lightLongitude) {
        this.lightLongitude = lightLongitude;
    }

    /**
     * @return LIGHT_LATITUDE
     */
    public BigDecimal getLightLatitude() {
        return lightLatitude;
    }

    /**
     * @param lightLatitude
     */
    public void setLightLatitude(BigDecimal lightLatitude) {
        this.lightLatitude = lightLatitude;
    }

    /**
     * @return ROOM_CABINET_FLAG
     */
    public Short getRoomCabinetFlag() {
        return roomCabinetFlag;
    }

    /**
     * @param roomCabinetFlag
     */
    public void setRoomCabinetFlag(Short roomCabinetFlag) {
        this.roomCabinetFlag = roomCabinetFlag;
    }

    /**
     * @return CABLE_ACCESS_FLAG
     */
    public Short getCableAccessFlag() {
        return cableAccessFlag;
    }

    /**
     * @param cableAccessFlag
     */
    public void setCableAccessFlag(Short cableAccessFlag) {
        this.cableAccessFlag = cableAccessFlag;
    }

    /**
     * @return CABLE_NUMBER
     */
    public Short getCableNumber() {
        return cableNumber;
    }

    /**
     * @param cableNumber
     */
    public void setCableNumber(Short cableNumber) {
        this.cableNumber = cableNumber;
    }

    /**
     * @return CABLE_REMAIN_NUMBER
     */
    public Short getCableRemainNumber() {
        return cableRemainNumber;
    }

    /**
     * @param cableRemainNumber
     */
    public void setCableRemainNumber(Short cableRemainNumber) {
        this.cableRemainNumber = cableRemainNumber;
    }

    /**
     * @return VERTICAL_COVERAGE_FLAG
     */
    public Short getVerticalCoverageFlag() {
        return verticalCoverageFlag;
    }

    /**
     * @param verticalCoverageFlag
     */
    public void setVerticalCoverageFlag(Short verticalCoverageFlag) {
        this.verticalCoverageFlag = verticalCoverageFlag;
    }

    /**
     * @return HORIZONTAL_COVERAGE_FLAG
     */
    public Short getHorizontalCoverageFlag() {
        return horizontalCoverageFlag;
    }

    /**
     * @param horizontalCoverageFlag
     */
    public void setHorizontalCoverageFlag(Short horizontalCoverageFlag) {
        this.horizontalCoverageFlag = horizontalCoverageFlag;
    }

    /**
     * @return COVERAGE_METHOD
     */
    public Short getCoverageMethod() {
        return coverageMethod;
    }

    /**
     * @param coverageMethod
     */
    public void setCoverageMethod(Short coverageMethod) {
        this.coverageMethod = coverageMethod;
    }

    /**
     * @return COOPERATION_METHOD
     */
    public Short getCooperationMethod() {
        return cooperationMethod;
    }

    /**
     * @param cooperationMethod
     */
    public void setCooperationMethod(Short cooperationMethod) {
        this.cooperationMethod = cooperationMethod;
    }

    /**
     * @return INDOOR_DISTRIBUTION_FLAG
     */
    public Short getIndoorDistributionFlag() {
        return indoorDistributionFlag;
    }

    /**
     * @param indoorDistributionFlag
     */
    public void setIndoorDistributionFlag(Short indoorDistributionFlag) {
        this.indoorDistributionFlag = indoorDistributionFlag;
    }

    /**
     * @return COVERAGE_NETWORK_STANDARD
     */
    public Short getCoverageNetworkStandard() {
        return coverageNetworkStandard;
    }

    /**
     * @param coverageNetworkStandard
     */
    public void setCoverageNetworkStandard(Short coverageNetworkStandard) {
        this.coverageNetworkStandard = coverageNetworkStandard;
    }

    /**
     * @return WLAN_FLAG
     */
    public Short getWlanFlag() {
        return wlanFlag;
    }

    /**
     * @param wlanFlag
     */
    public void setWlanFlag(Short wlanFlag) {
        this.wlanFlag = wlanFlag;
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