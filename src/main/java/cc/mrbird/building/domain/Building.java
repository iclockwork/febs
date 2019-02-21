package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "BD_BUILDING")
public class Building implements Serializable {
    @Id
    @Column(name = "BUILDING_ID")
    private Integer buildingId;

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

    @Column(name = "BUILDING_NAME")
    @ExportConfig(value = "楼宇名称")
    private String buildingName;

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

    @Column(name = "LONGITUDE")
    @ExportConfig(value = "经度")
    private BigDecimal longitude;

    @Column(name = "LATITUDE")
    @ExportConfig(value = "纬度")
    private BigDecimal latitude;

    @Column(name = "FLOOR_NUMBER")
    @ExportConfig(value = "楼层数")
    private Integer floorNumber;

    @Column(name = "AREA")
    @ExportConfig(value = "建筑面积（万m2）")
    private BigDecimal area;

    @Column(name = "HOUSEHOLDER_NUMBER")
    @ExportConfig(value = "商户数（户）")
    private Integer householderNumber;

    @Column(name = "PROPERTY_COMPANY")
    @ExportConfig(value = "物业单位")
    private String propertyCompany;

    @Column(name = "PROPERTY_MANAGER")
    @ExportConfig(value = "物业联系人")
    private String propertyManager;

    @Column(name = "PROPERTY_MANAGER_CONTACT")
    @ExportConfig(value = "物业联系人电话")
    private String propertyManagerContact;

    @Column(name = "BUILDING_MANAGER_ID")
    private Integer buildingManagerId;

    @ExportConfig(value = "楼长")
    private String buildingManager;

    @Column(name = "STATE")
    private Integer state;

    @ExportConfig(value = "楼宇状态")
    private String stateName;

    @Column(name = "REMARK")
    @ExportConfig(value = "备注")
    private String remark;

    @Column(name = "SEGM_ID")
    private String segmId;

    @ExportConfig(value = "标准地址")
    private String standName;

    @Column(name = "ACCESS_AREA_ID")
    private String accessAreaId;

    @ExportConfig(value = "综合业务接入区")
    private String accessAreaName;

    @Column(name = "ROOM_ID")
    private String roomId;

    @ExportConfig(value = "综合业务接入机房")
    private String roomName;

    @Column(name = "LIGHT_NAME")
    @ExportConfig(value = "光交名称")
    private String lightName;

    @Column(name = "LIGHT_ADDRESS")
    @ExportConfig(value = "光交地址")
    private String lightAddress;

    @Column(name = "LIGHT_LONGITUDE")
    @ExportConfig(value = "光交经度")
    private BigDecimal lightLongitude;

    @Column(name = "LIGHT_LATITUDE")
    @ExportConfig(value = "光交纬度")
    private BigDecimal lightLatitude;

    @Column(name = "ROOM_CABINET_FLAG")
    private Integer roomCabinetFlag;

    @ExportConfig(value = "是否有机房/机柜")
    private String roomCabinetFlagName;

    @Column(name = "CABLE_ACCESS_FLAG")
    private Integer cableAccessFlag;

    @ExportConfig(value = "光缆资源是否接入")
    private String cableAccessFlagName;

    @Column(name = "CABLE_NUMBER")
    @ExportConfig(value = "进楼光缆条数")
    private Integer cableNumber;

    @Column(name = "CABLE_REMAIN_NUMBER")
    @ExportConfig(value = "空余芯数")
    private Integer cableRemainNumber;

    @Column(name = "VERTICAL_COVERAGE_FLAG")
    private Integer verticalCoverageFlag;

    @ExportConfig(value = "是否具备垂直覆盖")
    private String verticalCoverageFlagName;

    @Column(name = "HORIZONTAL_COVERAGE_FLAG")
    private Integer horizontalCoverageFlag;

    @ExportConfig(value = "是否具备水平覆盖")
    private String horizontalCoverageFlagName;

    @Column(name = "COVERAGE_METHOD")
    private Integer coverageMethod;

    @ExportConfig(value = "楼宇覆盖方式")
    private String coverageMethodName;

    @Column(name = "COOPERATION_METHOD")
    private Integer cooperationMethod;

    @ExportConfig(value = "合作方式")
    private String cooperationMethodName;

    @Column(name = "INDOOR_DISTRIBUTION_FLAG")
    private Integer indoorDistributionFlag;

    @ExportConfig(value = "是否具备室分")
    private String indoorDistributionFlagName;

    @Column(name = "COVERAGE_NETWORK_STANDARD")
    private Integer coverageNetworkStandard;

    @ExportConfig(value = "已覆盖网络制式")
    private String coverageNetworkStandardName;

    @Column(name = "WLAN_FLAG")
    private Integer wlanFlag;

    @ExportConfig(value = "WLAN是否已覆盖")
    private String wlanFlagName;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Integer createStaffId;

    @ExportConfig(value = "录入人")
    private String createStaffName;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "录入时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
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
    public Integer getFloorNumber() {
        return floorNumber;
    }

    /**
     * @param floorNumber
     */
    public void setFloorNumber(Integer floorNumber) {
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
    public Integer getHouseholderNumber() {
        return householderNumber;
    }

    /**
     * @param householderNumber
     */
    public void setHouseholderNumber(Integer householderNumber) {
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
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
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
    public Integer getRoomCabinetFlag() {
        return roomCabinetFlag;
    }

    /**
     * @param roomCabinetFlag
     */
    public void setRoomCabinetFlag(Integer roomCabinetFlag) {
        this.roomCabinetFlag = roomCabinetFlag;
    }

    /**
     * @return CABLE_ACCESS_FLAG
     */
    public Integer getCableAccessFlag() {
        return cableAccessFlag;
    }

    /**
     * @param cableAccessFlag
     */
    public void setCableAccessFlag(Integer cableAccessFlag) {
        this.cableAccessFlag = cableAccessFlag;
    }

    /**
     * @return CABLE_NUMBER
     */
    public Integer getCableNumber() {
        return cableNumber;
    }

    /**
     * @param cableNumber
     */
    public void setCableNumber(Integer cableNumber) {
        this.cableNumber = cableNumber;
    }

    /**
     * @return CABLE_REMAIN_NUMBER
     */
    public Integer getCableRemainNumber() {
        return cableRemainNumber;
    }

    /**
     * @param cableRemainNumber
     */
    public void setCableRemainNumber(Integer cableRemainNumber) {
        this.cableRemainNumber = cableRemainNumber;
    }

    /**
     * @return VERTICAL_COVERAGE_FLAG
     */
    public Integer getVerticalCoverageFlag() {
        return verticalCoverageFlag;
    }

    /**
     * @param verticalCoverageFlag
     */
    public void setVerticalCoverageFlag(Integer verticalCoverageFlag) {
        this.verticalCoverageFlag = verticalCoverageFlag;
    }

    /**
     * @return HORIZONTAL_COVERAGE_FLAG
     */
    public Integer getHorizontalCoverageFlag() {
        return horizontalCoverageFlag;
    }

    /**
     * @param horizontalCoverageFlag
     */
    public void setHorizontalCoverageFlag(Integer horizontalCoverageFlag) {
        this.horizontalCoverageFlag = horizontalCoverageFlag;
    }

    /**
     * @return COVERAGE_METHOD
     */
    public Integer getCoverageMethod() {
        return coverageMethod;
    }

    /**
     * @param coverageMethod
     */
    public void setCoverageMethod(Integer coverageMethod) {
        this.coverageMethod = coverageMethod;
    }

    /**
     * @return COOPERATION_METHOD
     */
    public Integer getCooperationMethod() {
        return cooperationMethod;
    }

    /**
     * @param cooperationMethod
     */
    public void setCooperationMethod(Integer cooperationMethod) {
        this.cooperationMethod = cooperationMethod;
    }

    /**
     * @return INDOOR_DISTRIBUTION_FLAG
     */
    public Integer getIndoorDistributionFlag() {
        return indoorDistributionFlag;
    }

    /**
     * @param indoorDistributionFlag
     */
    public void setIndoorDistributionFlag(Integer indoorDistributionFlag) {
        this.indoorDistributionFlag = indoorDistributionFlag;
    }

    /**
     * @return COVERAGE_NETWORK_STANDARD
     */
    public Integer getCoverageNetworkStandard() {
        return coverageNetworkStandard;
    }

    /**
     * @param coverageNetworkStandard
     */
    public void setCoverageNetworkStandard(Integer coverageNetworkStandard) {
        this.coverageNetworkStandard = coverageNetworkStandard;
    }

    /**
     * @return WLAN_FLAG
     */
    public Integer getWlanFlag() {
        return wlanFlag;
    }

    /**
     * @param wlanFlag
     */
    public void setWlanFlag(Integer wlanFlag) {
        this.wlanFlag = wlanFlag;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

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

    public String getBuildingManager() {
        return buildingManager;
    }

    public void setBuildingManager(String buildingManager) {
        this.buildingManager = buildingManager;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStandName() {
        return standName;
    }

    public void setStandName(String standName) {
        this.standName = standName;
    }

    public String getAccessAreaName() {
        return accessAreaName;
    }

    public void setAccessAreaName(String accessAreaName) {
        this.accessAreaName = accessAreaName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomCabinetFlagName() {
        return roomCabinetFlagName;
    }

    public void setRoomCabinetFlagName(String roomCabinetFlagName) {
        this.roomCabinetFlagName = roomCabinetFlagName;
    }

    public String getCableAccessFlagName() {
        return cableAccessFlagName;
    }

    public void setCableAccessFlagName(String cableAccessFlagName) {
        this.cableAccessFlagName = cableAccessFlagName;
    }

    public String getVerticalCoverageFlagName() {
        return verticalCoverageFlagName;
    }

    public void setVerticalCoverageFlagName(String verticalCoverageFlagName) {
        this.verticalCoverageFlagName = verticalCoverageFlagName;
    }

    public String getHorizontalCoverageFlagName() {
        return horizontalCoverageFlagName;
    }

    public void setHorizontalCoverageFlagName(String horizontalCoverageFlagName) {
        this.horizontalCoverageFlagName = horizontalCoverageFlagName;
    }

    public String getCoverageMethodName() {
        return coverageMethodName;
    }

    public void setCoverageMethodName(String coverageMethodName) {
        this.coverageMethodName = coverageMethodName;
    }

    public String getCooperationMethodName() {
        return cooperationMethodName;
    }

    public void setCooperationMethodName(String cooperationMethodName) {
        this.cooperationMethodName = cooperationMethodName;
    }

    public String getIndoorDistributionFlagName() {
        return indoorDistributionFlagName;
    }

    public void setIndoorDistributionFlagName(String indoorDistributionFlagName) {
        this.indoorDistributionFlagName = indoorDistributionFlagName;
    }

    public String getCoverageNetworkStandardName() {
        return coverageNetworkStandardName;
    }

    public void setCoverageNetworkStandardName(String coverageNetworkStandardName) {
        this.coverageNetworkStandardName = coverageNetworkStandardName;
    }

    public String getWlanFlagName() {
        return wlanFlagName;
    }

    public void setWlanFlagName(String wlanFlagName) {
        this.wlanFlagName = wlanFlagName;
    }

    public String getCreateStaffName() {
        return createStaffName;
    }

    public void setCreateStaffName(String createStaffName) {
        this.createStaffName = createStaffName;
    }
}