package cc.mrbird.res.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "ADDR_SEGM")
public class Address implements Serializable {
    @Id
    @Column(name = "SEGM_ID")
    private String segmId;

    @Transient
    private String dsRegionId;

    @Transient
    @ExportConfig(value = "地市")
    private String dsRegionName;

    @Column(name = "REGION_ID")
    private String regionId;

    @Transient
    @ExportConfig(value = "区县")
    private String regionName;

    @Column(name = "SEGM_TYPE")
    private Integer segmType;

    @Column(name = "STAND_NAME")
    @ExportConfig(value = "标准地址全称")
    private String standName;

    @Column(name = "SEGM_NAME")
    @ExportConfig(value = "分段地址名称")
    private String segmName;

    @Column(name = "ALIAS")
    @ExportConfig(value = "地址别名")
    private String alias;

    @ExportConfig(value = "上级地址名称")
    private String parentStandName;

    @ExportConfig(value = "地址等级")
    private String segmTypeName;

    @Column(name = "X")
    @ExportConfig(value = "经度")
    private BigDecimal x;

    @Column(name = "Y")
    @ExportConfig(value = "纬度")
    private BigDecimal y;

    @Column(name = "SEGM_NO")
    private String segmNo;

    @Column(name = "PARENT_SEGM_ID")
    private String parentSegmId;

    @Column(name = "OUTSIDE")
    private Integer outside;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "TIME")
    private Date time;

    @Column(name = "OUTREGION")
    private Integer outregion;

    @Column(name = "POST_CODE")
    private String postCode;

    @Column(name = "IS_CITY")
    private String isCity;

    @Column(name = "IS_BAND")
    private String isBand;

    @Column(name = "IS_USER")
    private String isUser;

    @ExportConfig(value = "是否可受理")
    private String isUserName;

    @ExportConfig(value = "是否绑定局向")
    private String isBindDire;

    @ExportConfig(value = "是否绑定设备")
    private String isBindDevice;

    @ExportConfig(value = "接入点名称")
    private String comRegionName;

    @ExportConfig(value = "业务点名称")
    private String serviceRegionName;

    @ExportConfig(value = "客户分群")
    private String custGroupName;

    @Column(name = "STAND_NO")
    private String standNo;

    @Column(name = "TEMPLATE_ID")
    private Integer templateId;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "OLD_DATA")
    private Integer oldData;

    @Column(name = "MODIFY_OP")
    private Integer modifyOp;

    @Column(name = "SYNC_DATE")
    private Date syncDate;

    @Column(name = "CREATE_TIME")
    @ExportConfig(value = "录入时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date createTime;

    @Column(name = "MODIRY_DATE")
    @ExportConfig(value = "修改时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date modiryDate;

    @Column(name = "IS4GIS")
    private String is4gis;

    @Column(name = "SERVICE_REGION_ID")
    private String serviceRegionId;

    @Column(name = "LAN_ID")
    private Integer lanId;

    @Column(name = "PPDOM_ID")
    private Integer ppdomId;

    @Column(name = "OLD_ID_EQP")
    private String oldIdEqp;

    @Column(name = "OLD_SP")
    private String oldSp;

    @Column(name = "ADDR_FROM")
    private String addrFrom;

    @Column(name = "IS_HIGHCLASS_AREA")
    private String isHighclassArea;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_OP")
    private Integer createOp;

    @Column(name = "BORDER_ADDRESS")
    private String borderAddress;

    @Column(name = "EXP_DATE")
    private Date expDate;

    @Column(name = "ADDR_TYPE")
    private Integer addrType;

    @Column(name = "IS_COMPETE_REGION")
    private String isCompeteRegion;

    @Column(name = "IS_COMPETE_MODIFY_OP")
    private Integer isCompeteModifyOp;

    @Column(name = "IS_COMPETE_MODIFY_DATE")
    private Date isCompeteModifyDate;

    @Column(name = "BUILD_UNITS")
    private Integer buildUnits;

    @Column(name = "BUILD_FLOORS")
    private Integer buildFloors;

    @Column(name = "FLOOR_HEIGHT")
    private BigDecimal floorHeight;

    @Column(name = "ISBUILDING")
    private String isbuilding;

    @Column(name = "IS_NORMAL_ADDR")
    private String isNormalAddr;

    @Column(name = "IS_INSTAL_ADDR")
    private String isInstalAddr;

    @Column(name = "MNT_TYPE_ID")
    private Integer mntTypeId;

    @Column(name = "OPTIC_NODE")
    private String opticNode;

    @Column(name = "DISTRICT_ID")
    private String districtId;

    @Column(name = "IS_SUPPORT_IPQQM")
    private String isSupportIpqqm;

    @Column(name = "NET_STRUCT_ID")
    private Integer netStructId;

    @Column(name = "LINE_EXTENSION_FEE")
    private BigDecimal lineExtensionFee;

    @Column(name = "IS_SUPPORT_EOC")
    private String isSupportEoc;

    @Column(name = "IS_INSTEAD_INDOOR_DEVICES")
    private String isInsteadIndoorDevices;

    @Column(name = "IS_SUPPORT_CM")
    private String isSupportCm;

    @Column(name = "IS_LINE_INSTALL")
    private String isLineInstall;

    @Column(name = "IS_STOP_IP_PLUG_FLOW")
    private String isStopIpPlugFlow;

    @Column(name = "BUILD_TYPE_ID")
    private Integer buildTypeId;

    @Column(name = "NET_AREA_TYPE_ID")
    private Integer netAreaTypeId;

    @Column(name = "BUILD_GRADE_ID")
    private Integer buildGradeId;

    @Column(name = "SERVICES_INFO")
    private String servicesInfo;

    @Column(name = "NET_TYPE")
    private Integer netType;

    @Column(name = "COM_ID")
    private String comId;

    @Column(name = "LAST_ADDR")
    private Integer lastAddr;

    @Column(name = "CHECK_OP")
    private String checkOp;

    @Column(name = "AUDITOR")
    private String auditor;

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
     * @return SEGM_TYPE
     */
    public Integer getSegmType() {
        return segmType;
    }

    /**
     * @param segmType
     */
    public void setSegmType(Integer segmType) {
        this.segmType = segmType;
    }

    /**
     * @return SEGM_NAME
     */
    public String getSegmName() {
        return segmName;
    }

    /**
     * @param segmName
     */
    public void setSegmName(String segmName) {
        this.segmName = segmName == null ? null : segmName.trim();
    }

    /**
     * @return SEGM_NO
     */
    public String getSegmNo() {
        return segmNo;
    }

    /**
     * @param segmNo
     */
    public void setSegmNo(String segmNo) {
        this.segmNo = segmNo == null ? null : segmNo.trim();
    }

    /**
     * @return PARENT_SEGM_ID
     */
    public String getParentSegmId() {
        return parentSegmId;
    }

    /**
     * @param parentSegmId
     */
    public void setParentSegmId(String parentSegmId) {
        this.parentSegmId = parentSegmId == null ? null : parentSegmId.trim();
    }

    /**
     * @return OUTSIDE
     */
    public Integer getOutside() {
        return outside;
    }

    /**
     * @param outside
     */
    public void setOutside(Integer outside) {
        this.outside = outside;
    }

    /**
     * @return STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return TIME
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return OUTREGION
     */
    public Integer getOutregion() {
        return outregion;
    }

    /**
     * @param outregion
     */
    public void setOutregion(Integer outregion) {
        this.outregion = outregion;
    }

    /**
     * @return POST_CODE
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * @return IS_CITY
     */
    public String getIsCity() {
        return isCity;
    }

    /**
     * @param isCity
     */
    public void setIsCity(String isCity) {
        this.isCity = isCity == null ? null : isCity.trim();
    }

    /**
     * @return IS_BAND
     */
    public String getIsBand() {
        return isBand;
    }

    /**
     * @param isBand
     */
    public void setIsBand(String isBand) {
        this.isBand = isBand == null ? null : isBand.trim();
    }

    /**
     * @return IS_USER
     */
    public String getIsUser() {
        return isUser;
    }

    /**
     * @param isUser
     */
    public void setIsUser(String isUser) {
        this.isUser = isUser == null ? null : isUser.trim();
    }

    /**
     * @return STAND_NAME
     */
    public String getStandName() {
        return standName;
    }

    /**
     * @param standName
     */
    public void setStandName(String standName) {
        this.standName = standName == null ? null : standName.trim();
    }

    /**
     * @return STAND_NO
     */
    public String getStandNo() {
        return standNo;
    }

    /**
     * @param standNo
     */
    public void setStandNo(String standNo) {
        this.standNo = standNo == null ? null : standNo.trim();
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
     * @return TEMPLATE_ID
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * @return NOTES
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * @return DELETE_STATE
     */
    public String getDeleteState() {
        return deleteState;
    }

    /**
     * @param deleteState
     */
    public void setDeleteState(String deleteState) {
        this.deleteState = deleteState == null ? null : deleteState.trim();
    }

    /**
     * @return DELETE_TIME
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * @return OLD_DATA
     */
    public Integer getOldData() {
        return oldData;
    }

    /**
     * @param oldData
     */
    public void setOldData(Integer oldData) {
        this.oldData = oldData;
    }

    /**
     * @return MODIFY_OP
     */
    public Integer getModifyOp() {
        return modifyOp;
    }

    /**
     * @param modifyOp
     */
    public void setModifyOp(Integer modifyOp) {
        this.modifyOp = modifyOp;
    }

    /**
     * @return MODIRY_DATE
     */
    public Date getModiryDate() {
        return modiryDate;
    }

    /**
     * @param modiryDate
     */
    public void setModiryDate(Date modiryDate) {
        this.modiryDate = modiryDate;
    }

    /**
     * @return ALIAS
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * @return SYNC_DATE
     */
    public Date getSyncDate() {
        return syncDate;
    }

    /**
     * @param syncDate
     */
    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return IS4GIS
     */
    public String getIs4gis() {
        return is4gis;
    }

    /**
     * @param is4gis
     */
    public void setIs4gis(String is4gis) {
        this.is4gis = is4gis == null ? null : is4gis.trim();
    }

    /**
     * @return SERVICE_REGION_ID
     */
    public String getServiceRegionId() {
        return serviceRegionId;
    }

    /**
     * @param serviceRegionId
     */
    public void setServiceRegionId(String serviceRegionId) {
        this.serviceRegionId = serviceRegionId == null ? null : serviceRegionId.trim();
    }

    /**
     * @return LAN_ID
     */
    public Integer getLanId() {
        return lanId;
    }

    /**
     * @param lanId
     */
    public void setLanId(Integer lanId) {
        this.lanId = lanId;
    }

    /**
     * @return PPDOM_ID
     */
    public Integer getPpdomId() {
        return ppdomId;
    }

    /**
     * @param ppdomId
     */
    public void setPpdomId(Integer ppdomId) {
        this.ppdomId = ppdomId;
    }

    /**
     * @return OLD_ID_EQP
     */
    public String getOldIdEqp() {
        return oldIdEqp;
    }

    /**
     * @param oldIdEqp
     */
    public void setOldIdEqp(String oldIdEqp) {
        this.oldIdEqp = oldIdEqp == null ? null : oldIdEqp.trim();
    }

    /**
     * @return OLD_SP
     */
    public String getOldSp() {
        return oldSp;
    }

    /**
     * @param oldSp
     */
    public void setOldSp(String oldSp) {
        this.oldSp = oldSp == null ? null : oldSp.trim();
    }

    /**
     * @return ADDR_FROM
     */
    public String getAddrFrom() {
        return addrFrom;
    }

    /**
     * @param addrFrom
     */
    public void setAddrFrom(String addrFrom) {
        this.addrFrom = addrFrom == null ? null : addrFrom.trim();
    }

    /**
     * @return IS_HIGHCLASS_AREA
     */
    public String getIsHighclassArea() {
        return isHighclassArea;
    }

    /**
     * @param isHighclassArea
     */
    public void setIsHighclassArea(String isHighclassArea) {
        this.isHighclassArea = isHighclassArea == null ? null : isHighclassArea.trim();
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
     * @return CREATE_OP
     */
    public Integer getCreateOp() {
        return createOp;
    }

    /**
     * @param createOp
     */
    public void setCreateOp(Integer createOp) {
        this.createOp = createOp;
    }

    /**
     * @return BORDER_ADDRESS
     */
    public String getBorderAddress() {
        return borderAddress;
    }

    /**
     * @param borderAddress
     */
    public void setBorderAddress(String borderAddress) {
        this.borderAddress = borderAddress == null ? null : borderAddress.trim();
    }

    /**
     * @return X
     */
    public BigDecimal getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(BigDecimal x) {
        this.x = x;
    }

    /**
     * @return Y
     */
    public BigDecimal getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(BigDecimal y) {
        this.y = y;
    }

    /**
     * @return EXP_DATE
     */
    public Date getExpDate() {
        return expDate;
    }

    /**
     * @param expDate
     */
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    /**
     * @return ADDR_TYPE
     */
    public Integer getAddrType() {
        return addrType;
    }

    /**
     * @param addrType
     */
    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    /**
     * @return IS_COMPETE_REGION
     */
    public String getIsCompeteRegion() {
        return isCompeteRegion;
    }

    /**
     * @param isCompeteRegion
     */
    public void setIsCompeteRegion(String isCompeteRegion) {
        this.isCompeteRegion = isCompeteRegion == null ? null : isCompeteRegion.trim();
    }

    /**
     * @return IS_COMPETE_MODIFY_OP
     */
    public Integer getIsCompeteModifyOp() {
        return isCompeteModifyOp;
    }

    /**
     * @param isCompeteModifyOp
     */
    public void setIsCompeteModifyOp(Integer isCompeteModifyOp) {
        this.isCompeteModifyOp = isCompeteModifyOp;
    }

    /**
     * @return IS_COMPETE_MODIFY_DATE
     */
    public Date getIsCompeteModifyDate() {
        return isCompeteModifyDate;
    }

    /**
     * @param isCompeteModifyDate
     */
    public void setIsCompeteModifyDate(Date isCompeteModifyDate) {
        this.isCompeteModifyDate = isCompeteModifyDate;
    }

    /**
     * @return BUILD_UNITS
     */
    public Integer getBuildUnits() {
        return buildUnits;
    }

    /**
     * @param buildUnits
     */
    public void setBuildUnits(Integer buildUnits) {
        this.buildUnits = buildUnits;
    }

    /**
     * @return BUILD_FLOORS
     */
    public Integer getBuildFloors() {
        return buildFloors;
    }

    /**
     * @param buildFloors
     */
    public void setBuildFloors(Integer buildFloors) {
        this.buildFloors = buildFloors;
    }

    /**
     * @return FLOOR_HEIGHT
     */
    public BigDecimal getFloorHeight() {
        return floorHeight;
    }

    /**
     * @param floorHeight
     */
    public void setFloorHeight(BigDecimal floorHeight) {
        this.floorHeight = floorHeight;
    }

    /**
     * @return ISBUILDING
     */
    public String getIsbuilding() {
        return isbuilding;
    }

    /**
     * @param isbuilding
     */
    public void setIsbuilding(String isbuilding) {
        this.isbuilding = isbuilding == null ? null : isbuilding.trim();
    }

    /**
     * @return IS_NORMAL_ADDR
     */
    public String getIsNormalAddr() {
        return isNormalAddr;
    }

    /**
     * @param isNormalAddr
     */
    public void setIsNormalAddr(String isNormalAddr) {
        this.isNormalAddr = isNormalAddr == null ? null : isNormalAddr.trim();
    }

    /**
     * @return IS_INSTAL_ADDR
     */
    public String getIsInstalAddr() {
        return isInstalAddr;
    }

    /**
     * @param isInstalAddr
     */
    public void setIsInstalAddr(String isInstalAddr) {
        this.isInstalAddr = isInstalAddr == null ? null : isInstalAddr.trim();
    }

    /**
     * @return MNT_TYPE_ID
     */
    public Integer getMntTypeId() {
        return mntTypeId;
    }

    /**
     * @param mntTypeId
     */
    public void setMntTypeId(Integer mntTypeId) {
        this.mntTypeId = mntTypeId;
    }

    /**
     * @return OPTIC_NODE
     */
    public String getOpticNode() {
        return opticNode;
    }

    /**
     * @param opticNode
     */
    public void setOpticNode(String opticNode) {
        this.opticNode = opticNode == null ? null : opticNode.trim();
    }

    /**
     * @return DISTRICT_ID
     */
    public String getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     */
    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    /**
     * @return IS_SUPPORT_IPQQM
     */
    public String getIsSupportIpqqm() {
        return isSupportIpqqm;
    }

    /**
     * @param isSupportIpqqm
     */
    public void setIsSupportIpqqm(String isSupportIpqqm) {
        this.isSupportIpqqm = isSupportIpqqm == null ? null : isSupportIpqqm.trim();
    }

    /**
     * @return NET_STRUCT_ID
     */
    public Integer getNetStructId() {
        return netStructId;
    }

    /**
     * @param netStructId
     */
    public void setNetStructId(Integer netStructId) {
        this.netStructId = netStructId;
    }

    /**
     * @return LINE_EXTENSION_FEE
     */
    public BigDecimal getLineExtensionFee() {
        return lineExtensionFee;
    }

    /**
     * @param lineExtensionFee
     */
    public void setLineExtensionFee(BigDecimal lineExtensionFee) {
        this.lineExtensionFee = lineExtensionFee;
    }

    /**
     * @return IS_SUPPORT_EOC
     */
    public String getIsSupportEoc() {
        return isSupportEoc;
    }

    /**
     * @param isSupportEoc
     */
    public void setIsSupportEoc(String isSupportEoc) {
        this.isSupportEoc = isSupportEoc == null ? null : isSupportEoc.trim();
    }

    /**
     * @return IS_INSTEAD_INDOOR_DEVICES
     */
    public String getIsInsteadIndoorDevices() {
        return isInsteadIndoorDevices;
    }

    /**
     * @param isInsteadIndoorDevices
     */
    public void setIsInsteadIndoorDevices(String isInsteadIndoorDevices) {
        this.isInsteadIndoorDevices = isInsteadIndoorDevices == null ? null : isInsteadIndoorDevices.trim();
    }

    /**
     * @return IS_SUPPORT_CM
     */
    public String getIsSupportCm() {
        return isSupportCm;
    }

    /**
     * @param isSupportCm
     */
    public void setIsSupportCm(String isSupportCm) {
        this.isSupportCm = isSupportCm == null ? null : isSupportCm.trim();
    }

    /**
     * @return IS_LINE_INSTALL
     */
    public String getIsLineInstall() {
        return isLineInstall;
    }

    /**
     * @param isLineInstall
     */
    public void setIsLineInstall(String isLineInstall) {
        this.isLineInstall = isLineInstall == null ? null : isLineInstall.trim();
    }

    /**
     * @return IS_STOP_IP_PLUG_FLOW
     */
    public String getIsStopIpPlugFlow() {
        return isStopIpPlugFlow;
    }

    /**
     * @param isStopIpPlugFlow
     */
    public void setIsStopIpPlugFlow(String isStopIpPlugFlow) {
        this.isStopIpPlugFlow = isStopIpPlugFlow == null ? null : isStopIpPlugFlow.trim();
    }

    /**
     * @return BUILD_TYPE_ID
     */
    public Integer getBuildTypeId() {
        return buildTypeId;
    }

    /**
     * @param buildTypeId
     */
    public void setBuildTypeId(Integer buildTypeId) {
        this.buildTypeId = buildTypeId;
    }

    /**
     * @return NET_AREA_TYPE_ID
     */
    public Integer getNetAreaTypeId() {
        return netAreaTypeId;
    }

    /**
     * @param netAreaTypeId
     */
    public void setNetAreaTypeId(Integer netAreaTypeId) {
        this.netAreaTypeId = netAreaTypeId;
    }

    /**
     * @return BUILD_GRADE_ID
     */
    public Integer getBuildGradeId() {
        return buildGradeId;
    }

    /**
     * @param buildGradeId
     */
    public void setBuildGradeId(Integer buildGradeId) {
        this.buildGradeId = buildGradeId;
    }

    /**
     * @return SERVICES_INFO
     */
    public String getServicesInfo() {
        return servicesInfo;
    }

    /**
     * @param servicesInfo
     */
    public void setServicesInfo(String servicesInfo) {
        this.servicesInfo = servicesInfo == null ? null : servicesInfo.trim();
    }

    /**
     * @return NET_TYPE
     */
    public Integer getNetType() {
        return netType;
    }

    /**
     * @param netType
     */
    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    /**
     * @return COM_ID
     */
    public String getComId() {
        return comId;
    }

    /**
     * @param comId
     */
    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    /**
     * @return LAST_ADDR
     */
    public Integer getLastAddr() {
        return lastAddr;
    }

    /**
     * @param lastAddr
     */
    public void setLastAddr(Integer lastAddr) {
        this.lastAddr = lastAddr;
    }

    /**
     * @return CHECK_OP
     */
    public String getCheckOp() {
        return checkOp;
    }

    /**
     * @param checkOp
     */
    public void setCheckOp(String checkOp) {
        this.checkOp = checkOp == null ? null : checkOp.trim();
    }

    /**
     * @return AUDITOR
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * @param auditor
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getParentStandName() {
        return parentStandName;
    }

    public void setParentStandName(String parentStandName) {
        this.parentStandName = parentStandName;
    }

    public String getSegmTypeName() {
        return segmTypeName;
    }

    public void setSegmTypeName(String segmTypeName) {
        this.segmTypeName = segmTypeName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getIsUserName() {
        return isUserName;
    }

    public void setIsUserName(String isUserName) {
        this.isUserName = isUserName;
    }

    public String getIsBindDire() {
        return isBindDire;
    }

    public void setIsBindDire(String isBindDire) {
        this.isBindDire = isBindDire;
    }

    public String getIsBindDevice() {
        return isBindDevice;
    }

    public void setIsBindDevice(String isBindDevice) {
        this.isBindDevice = isBindDevice;
    }

    public String getComRegionName() {
        return comRegionName;
    }

    public void setComRegionName(String comRegionName) {
        this.comRegionName = comRegionName;
    }

    public String getServiceRegionName() {
        return serviceRegionName;
    }

    public void setServiceRegionName(String serviceRegionName) {
        this.serviceRegionName = serviceRegionName;
    }

    public String getCustGroupName() {
        return custGroupName;
    }

    public void setCustGroupName(String custGroupName) {
        this.custGroupName = custGroupName;
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
}