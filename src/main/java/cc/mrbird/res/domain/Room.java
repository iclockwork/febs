package cc.mrbird.res.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "SPC_ROOM")
public class Room implements Serializable {
    @Id
    @Column(name = "ROOM_ID")
    private String roomId;

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

    @Column(name = "CHINA_NAME")
    @ExportConfig(value = "机房名称")
    private String chinaName;

    @Column(name = "ROOM_NO")
    @ExportConfig(value = "机房编码")
    private String roomNo;

    @Column(name = "CHINA_NAME_AB")
    private String chinaNameAb;

    @Column(name = "ALIAS")
    @ExportConfig(value = "机房别名")
    private String alias;

    @ExportConfig(value = "所属局站")
    private String stationName;

    @Column(name = "NAME_AB")
    private String nameAb;

    @Column(name = "CODE")
    private String code;

    @Column(name = "STATION_ID")
    private String stationId;

    @Column(name = "BLDG_ID")
    private String bldgId;

    @Column(name = "TYPE_ID")
    private Integer typeId;

    @ExportConfig(value = "机房类型")
    private String typeName;

    @Column(name = "CLASS_ID")
    private Integer classId;

    @ExportConfig(value = "机房等级")
    private String className;

    @Column(name = "SPECIALITY_ID")
    private Integer specialityId;

    @Column(name = "PROPERTY")
    private Integer property;

    @ExportConfig(value = "机房状态")
    private String propertyName;

    @Column(name = "LENGTH")
    @ExportConfig(value = "长度(米)")
    private BigDecimal length;

    @Column(name = "WIDTH")
    @ExportConfig(value = "宽度(米)")
    private BigDecimal width;

    @Column(name = "HEIGHT")
    private BigDecimal height;

    @Column(name = "AREA")
    @ExportConfig(value = "机房面积")
    private BigDecimal area;

    @Column(name = "PROPERTY_BELONG")
    private Integer propertyBelong;

    @ExportConfig(value = "产权归属")
    private String propertyBelongName;

    @Column(name = "REINFORCE")
    private String reinforce;

    @ExportConfig(value = "是否安装动力环境监控")
    private String reinforceName;

    @Column(name = "MAINTENANCE_UNIT")
    @ExportConfig(value = "维护单位")
    private String maintenanceUnit;

    @Column(name = "LINK_MAN")
    @ExportConfig(value = "维护人")
    private String linkMan;

    @Column(name = "ONDUTY_TELE")
    private String ondutyTele;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "HISTORY_NAME")
    private String historyName;

    @Column(name = "HISTORY_CODE")
    private String historyCode;

    @Column(name = "DISTRICT_ID")
    private String districtId;

    @Column(name = "ENVIR_GRADE")
    private String envirGrade;

    @Column(name = "EFIELD_STRENGTH")
    private String efieldStrength;

    @Column(name = "MFIELD_STRENGTH")
    private String mfieldStrength;

    @Column(name = "BACK_NOISE")
    private String backNoise;

    @Column(name = "STATIC_PROTECT")
    private String staticProtect;

    @Column(name = "EARTHING_R")
    private String earthingR;

    @Column(name = "FLOOR_BEARING")
    private BigDecimal floorBearing;

    @Column(name = "LIFTOFF_HEIGHT")
    private BigDecimal liftoffHeight;

    @Column(name = "WNG_STYLE")
    private String wngStyle;

    @Column(name = "AIRBLAST_STYLE")
    private String airblastStyle;

    @Column(name = "OPR_STATE_ID")
    private Integer oprStateId;

    @Column(name = "MNT_STATE_ID")
    private Integer mntStateId;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "NOTES")
    @ExportConfig(value = "备注")
    private String notes;

    @Column(name = "POS_X")
    private BigDecimal posX;

    @Column(name = "POS_Y")
    private BigDecimal posY;

    @Column(name = "GRAPH_WIDTH")
    private BigDecimal graphWidth;

    @Column(name = "GRAPH_HEIGHT")
    private BigDecimal graphHeight;

    @Column(name = "ISOFFSET")
    private String isoffset;

    @Column(name = "GRAPH_ID")
    private Long graphId;

    @Column(name = "CELL_NO")
    private String cellNo;

    @Column(name = "FLOOR_NO")
    private String floorNo;

    @Column(name = "ROOM_CODE")
    private String roomCode;

    @Column(name = "DRAWINGNO")
    private String drawingno;

    @Column(name = "COM_ID")
    private String comId;

    @Column(name = "DRAINAGE_MODE")
    private String drainageMode;

    @Column(name = "MODIFY_OP")
    private Integer modifyOp;

    @Column(name = "MODIRY_DATE")
    private Date modiryDate;

    @Column(name = "ROOM_PROPERTY")
    private Integer roomProperty;

    @Column(name = "PROP_CHAR_ID")
    private Integer propCharId;

    @Column(name = "RENT_UNIT_ID")
    private Integer rentUnitId;

    @Column(name = "MNT_TYPE_ID")
    private Integer mntTypeId;

    @Column(name = "FIREPROTECTION")
    private String fireprotection;

    @Column(name = "START_USE_DATE")
    private Date startUseDate;

    @Column(name = "LINK_TEL")
    private String linkTel;

    @Column(name = "MAPX")
    private BigDecimal mapx;

    @Column(name = "MAPY")
    private BigDecimal mapy;

    @Column(name = "OLD_ID_EQP")
    private String oldIdEqp;

    @Column(name = "OLD_SP")
    private String oldSp;

    @Column(name = "FLAG")
    private String flag;

    @Column(name = "DATACOLLECT_UNIT")
    private String datacollectUnit;

    @Column(name = "DATA_COLLECTOR")
    private String dataCollector;

    @Column(name = "DATADATACOLLECT_TIME")
    private Date datadatacollectTime;

    @Column(name = "OLD_PROJECT_NO")
    private String oldProjectNo;

    @Column(name = "OLD_PROJECT_NAME")
    private String oldProjectName;

    @Column(name = "RESOURCE_FROM")
    private Integer resourceFrom;

    @Column(name = "IS_SHARE")
    private Integer isShare;

    @Column(name = "SHARE_TYPE")
    private Integer shareType;

    @Column(name = "POS_Z")
    private BigDecimal posZ;

    @Column(name = "IS_OUTDOOR")
    private String isOutdoor;

    @Column(name = "LAN_ID")
    private String lanId;

    @Column(name = "CREATE_OP")
    private Integer createOp;

    @Column(name = "ADDR_SEGM_ID")
    private String addrSegmId;

    @Column(name = "LONG_LOCAL_ID")
    private Integer longLocalId;

    @ExportConfig(value = "长本属性")
    private String longLocalName;

    @Column(name = "TERRITORIAL_NATURE_ID")
    private Integer territorialNatureId;

    @ExportConfig(value = "属地性质")
    private String territorialNatureName;

    @Column(name = "CONSTRUCTION_SHARE_ID")
    private Integer constructionShareId;

    @ExportConfig(value = "共建 / 共享")
    private String constructionShareName;

    @Column(name = "START_TIME")
    @ExportConfig(value = "开始时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date startTime;

    @Column(name = "CONTRACT_EXPIRES_TIME")
    @ExportConfig(value = "合同到期时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date contractExpiresTime;

    @Column(name = "LONGORLOCAL")
    private Long longorlocal;

    @Column(name = "ROW_NUM")
    private Integer rowNum;

    @Column(name = "COL_NUM")
    private Integer colNum;

    @Column(name = "WO_ID")
    private Long woId;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "录入时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date createDate;

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
     * @return ROOM_NO
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    /**
     * @return CHINA_NAME
     */
    public String getChinaName() {
        return chinaName;
    }

    /**
     * @param chinaName
     */
    public void setChinaName(String chinaName) {
        this.chinaName = chinaName == null ? null : chinaName.trim();
    }

    /**
     * @return CHINA_NAME_AB
     */
    public String getChinaNameAb() {
        return chinaNameAb;
    }

    /**
     * @param chinaNameAb
     */
    public void setChinaNameAb(String chinaNameAb) {
        this.chinaNameAb = chinaNameAb == null ? null : chinaNameAb.trim();
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
     * @return NAME_AB
     */
    public String getNameAb() {
        return nameAb;
    }

    /**
     * @param nameAb
     */
    public void setNameAb(String nameAb) {
        this.nameAb = nameAb == null ? null : nameAb.trim();
    }

    /**
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return STATION_ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * @param stationId
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * @return BLDG_ID
     */
    public String getBldgId() {
        return bldgId;
    }

    /**
     * @param bldgId
     */
    public void setBldgId(String bldgId) {
        this.bldgId = bldgId == null ? null : bldgId.trim();
    }

    /**
     * @return TYPE_ID
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * @return CLASS_ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return SPECIALITY_ID
     */
    public Integer getSpecialityId() {
        return specialityId;
    }

    /**
     * @param specialityId
     */
    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
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
     * @return HEIGHT
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * @return ONDUTY_TELE
     */
    public String getOndutyTele() {
        return ondutyTele;
    }

    /**
     * @param ondutyTele
     */
    public void setOndutyTele(String ondutyTele) {
        this.ondutyTele = ondutyTele == null ? null : ondutyTele.trim();
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return HISTORY_NAME
     */
    public String getHistoryName() {
        return historyName;
    }

    /**
     * @param historyName
     */
    public void setHistoryName(String historyName) {
        this.historyName = historyName == null ? null : historyName.trim();
    }

    /**
     * @return HISTORY_CODE
     */
    public String getHistoryCode() {
        return historyCode;
    }

    /**
     * @param historyCode
     */
    public void setHistoryCode(String historyCode) {
        this.historyCode = historyCode == null ? null : historyCode.trim();
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
     * @return ENVIR_GRADE
     */
    public String getEnvirGrade() {
        return envirGrade;
    }

    /**
     * @param envirGrade
     */
    public void setEnvirGrade(String envirGrade) {
        this.envirGrade = envirGrade == null ? null : envirGrade.trim();
    }

    /**
     * @return EFIELD_STRENGTH
     */
    public String getEfieldStrength() {
        return efieldStrength;
    }

    /**
     * @param efieldStrength
     */
    public void setEfieldStrength(String efieldStrength) {
        this.efieldStrength = efieldStrength == null ? null : efieldStrength.trim();
    }

    /**
     * @return MFIELD_STRENGTH
     */
    public String getMfieldStrength() {
        return mfieldStrength;
    }

    /**
     * @param mfieldStrength
     */
    public void setMfieldStrength(String mfieldStrength) {
        this.mfieldStrength = mfieldStrength == null ? null : mfieldStrength.trim();
    }

    /**
     * @return BACK_NOISE
     */
    public String getBackNoise() {
        return backNoise;
    }

    /**
     * @param backNoise
     */
    public void setBackNoise(String backNoise) {
        this.backNoise = backNoise == null ? null : backNoise.trim();
    }

    /**
     * @return STATIC_PROTECT
     */
    public String getStaticProtect() {
        return staticProtect;
    }

    /**
     * @param staticProtect
     */
    public void setStaticProtect(String staticProtect) {
        this.staticProtect = staticProtect == null ? null : staticProtect.trim();
    }

    /**
     * @return EARTHING_R
     */
    public String getEarthingR() {
        return earthingR;
    }

    /**
     * @param earthingR
     */
    public void setEarthingR(String earthingR) {
        this.earthingR = earthingR == null ? null : earthingR.trim();
    }

    /**
     * @return FLOOR_BEARING
     */
    public BigDecimal getFloorBearing() {
        return floorBearing;
    }

    /**
     * @param floorBearing
     */
    public void setFloorBearing(BigDecimal floorBearing) {
        this.floorBearing = floorBearing;
    }

    /**
     * @return LIFTOFF_HEIGHT
     */
    public BigDecimal getLiftoffHeight() {
        return liftoffHeight;
    }

    /**
     * @param liftoffHeight
     */
    public void setLiftoffHeight(BigDecimal liftoffHeight) {
        this.liftoffHeight = liftoffHeight;
    }

    /**
     * @return WNG_STYLE
     */
    public String getWngStyle() {
        return wngStyle;
    }

    /**
     * @param wngStyle
     */
    public void setWngStyle(String wngStyle) {
        this.wngStyle = wngStyle == null ? null : wngStyle.trim();
    }

    /**
     * @return AIRBLAST_STYLE
     */
    public String getAirblastStyle() {
        return airblastStyle;
    }

    /**
     * @param airblastStyle
     */
    public void setAirblastStyle(String airblastStyle) {
        this.airblastStyle = airblastStyle == null ? null : airblastStyle.trim();
    }

    /**
     * @return OPR_STATE_ID
     */
    public Integer getOprStateId() {
        return oprStateId;
    }

    /**
     * @param oprStateId
     */
    public void setOprStateId(Integer oprStateId) {
        this.oprStateId = oprStateId;
    }

    /**
     * @return MNT_STATE_ID
     */
    public Integer getMntStateId() {
        return mntStateId;
    }

    /**
     * @param mntStateId
     */
    public void setMntStateId(Integer mntStateId) {
        this.mntStateId = mntStateId;
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
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
     * @return POS_X
     */
    public BigDecimal getPosX() {
        return posX;
    }

    /**
     * @param posX
     */
    public void setPosX(BigDecimal posX) {
        this.posX = posX;
    }

    /**
     * @return POS_Y
     */
    public BigDecimal getPosY() {
        return posY;
    }

    /**
     * @param posY
     */
    public void setPosY(BigDecimal posY) {
        this.posY = posY;
    }

    /**
     * @return GRAPH_WIDTH
     */
    public BigDecimal getGraphWidth() {
        return graphWidth;
    }

    /**
     * @param graphWidth
     */
    public void setGraphWidth(BigDecimal graphWidth) {
        this.graphWidth = graphWidth;
    }

    /**
     * @return GRAPH_HEIGHT
     */
    public BigDecimal getGraphHeight() {
        return graphHeight;
    }

    /**
     * @param graphHeight
     */
    public void setGraphHeight(BigDecimal graphHeight) {
        this.graphHeight = graphHeight;
    }

    /**
     * @return ISOFFSET
     */
    public String getIsoffset() {
        return isoffset;
    }

    /**
     * @param isoffset
     */
    public void setIsoffset(String isoffset) {
        this.isoffset = isoffset == null ? null : isoffset.trim();
    }

    /**
     * @return GRAPH_ID
     */
    public Long getGraphId() {
        return graphId;
    }

    /**
     * @param graphId
     */
    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    /**
     * @return CELL_NO
     */
    public String getCellNo() {
        return cellNo;
    }

    /**
     * @param cellNo
     */
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo == null ? null : cellNo.trim();
    }

    /**
     * @return FLOOR_NO
     */
    public String getFloorNo() {
        return floorNo;
    }

    /**
     * @param floorNo
     */
    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo == null ? null : floorNo.trim();
    }

    /**
     * @return ROOM_CODE
     */
    public String getRoomCode() {
        return roomCode;
    }

    /**
     * @param roomCode
     */
    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    /**
     * @return DRAWINGNO
     */
    public String getDrawingno() {
        return drawingno;
    }

    /**
     * @param drawingno
     */
    public void setDrawingno(String drawingno) {
        this.drawingno = drawingno == null ? null : drawingno.trim();
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
     * @return DRAINAGE_MODE
     */
    public String getDrainageMode() {
        return drainageMode;
    }

    /**
     * @param drainageMode
     */
    public void setDrainageMode(String drainageMode) {
        this.drainageMode = drainageMode == null ? null : drainageMode.trim();
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
     * @return REINFORCE
     */
    public String getReinforce() {
        return reinforce;
    }

    /**
     * @param reinforce
     */
    public void setReinforce(String reinforce) {
        this.reinforce = reinforce == null ? null : reinforce.trim();
    }

    /**
     * @return ROOM_PROPERTY
     */
    public Integer getRoomProperty() {
        return roomProperty;
    }

    /**
     * @param roomProperty
     */
    public void setRoomProperty(Integer roomProperty) {
        this.roomProperty = roomProperty;
    }

    /**
     * @return PROP_CHAR_ID
     */
    public Integer getPropCharId() {
        return propCharId;
    }

    /**
     * @param propCharId
     */
    public void setPropCharId(Integer propCharId) {
        this.propCharId = propCharId;
    }

    /**
     * @return RENT_UNIT_ID
     */
    public Integer getRentUnitId() {
        return rentUnitId;
    }

    /**
     * @param rentUnitId
     */
    public void setRentUnitId(Integer rentUnitId) {
        this.rentUnitId = rentUnitId;
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
     * @return FIREPROTECTION
     */
    public String getFireprotection() {
        return fireprotection;
    }

    /**
     * @param fireprotection
     */
    public void setFireprotection(String fireprotection) {
        this.fireprotection = fireprotection == null ? null : fireprotection.trim();
    }

    /**
     * @return LINK_MAN
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * @param linkMan
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * @return START_USE_DATE
     */
    public Date getStartUseDate() {
        return startUseDate;
    }

    /**
     * @param startUseDate
     */
    public void setStartUseDate(Date startUseDate) {
        this.startUseDate = startUseDate;
    }

    /**
     * @return LINK_TEL
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * @param linkTel
     */
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    /**
     * @return MAPX
     */
    public BigDecimal getMapx() {
        return mapx;
    }

    /**
     * @param mapx
     */
    public void setMapx(BigDecimal mapx) {
        this.mapx = mapx;
    }

    /**
     * @return MAPY
     */
    public BigDecimal getMapy() {
        return mapy;
    }

    /**
     * @param mapy
     */
    public void setMapy(BigDecimal mapy) {
        this.mapy = mapy;
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
     * @return FLAG
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * @return LENGTH
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    /**
     * @return WIDTH
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    /**
     * @return DATACOLLECT_UNIT
     */
    public String getDatacollectUnit() {
        return datacollectUnit;
    }

    /**
     * @param datacollectUnit
     */
    public void setDatacollectUnit(String datacollectUnit) {
        this.datacollectUnit = datacollectUnit == null ? null : datacollectUnit.trim();
    }

    /**
     * @return DATA_COLLECTOR
     */
    public String getDataCollector() {
        return dataCollector;
    }

    /**
     * @param dataCollector
     */
    public void setDataCollector(String dataCollector) {
        this.dataCollector = dataCollector == null ? null : dataCollector.trim();
    }

    /**
     * @return DATADATACOLLECT_TIME
     */
    public Date getDatadatacollectTime() {
        return datadatacollectTime;
    }

    /**
     * @param datadatacollectTime
     */
    public void setDatadatacollectTime(Date datadatacollectTime) {
        this.datadatacollectTime = datadatacollectTime;
    }

    /**
     * @return OLD_PROJECT_NO
     */
    public String getOldProjectNo() {
        return oldProjectNo;
    }

    /**
     * @param oldProjectNo
     */
    public void setOldProjectNo(String oldProjectNo) {
        this.oldProjectNo = oldProjectNo == null ? null : oldProjectNo.trim();
    }

    /**
     * @return OLD_PROJECT_NAME
     */
    public String getOldProjectName() {
        return oldProjectName;
    }

    /**
     * @param oldProjectName
     */
    public void setOldProjectName(String oldProjectName) {
        this.oldProjectName = oldProjectName == null ? null : oldProjectName.trim();
    }

    /**
     * @return RESOURCE_FROM
     */
    public Integer getResourceFrom() {
        return resourceFrom;
    }

    /**
     * @param resourceFrom
     */
    public void setResourceFrom(Integer resourceFrom) {
        this.resourceFrom = resourceFrom;
    }

    /**
     * @return PROPERTY_BELONG
     */
    public Integer getPropertyBelong() {
        return propertyBelong;
    }

    /**
     * @param propertyBelong
     */
    public void setPropertyBelong(Integer propertyBelong) {
        this.propertyBelong = propertyBelong;
    }

    /**
     * @return PROPERTY
     */
    public Integer getProperty() {
        return property;
    }

    /**
     * @param property
     */
    public void setProperty(Integer property) {
        this.property = property;
    }

    /**
     * @return IS_SHARE
     */
    public Integer getIsShare() {
        return isShare;
    }

    /**
     * @param isShare
     */
    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    /**
     * @return SHARE_TYPE
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param shareType
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return POS_Z
     */
    public BigDecimal getPosZ() {
        return posZ;
    }

    /**
     * @param posZ
     */
    public void setPosZ(BigDecimal posZ) {
        this.posZ = posZ;
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
     * @return IS_OUTDOOR
     */
    public String getIsOutdoor() {
        return isOutdoor;
    }

    /**
     * @param isOutdoor
     */
    public void setIsOutdoor(String isOutdoor) {
        this.isOutdoor = isOutdoor == null ? null : isOutdoor.trim();
    }

    /**
     * @return LAN_ID
     */
    public String getLanId() {
        return lanId;
    }

    /**
     * @param lanId
     */
    public void setLanId(String lanId) {
        this.lanId = lanId == null ? null : lanId.trim();
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
     * @return ADDR_SEGM_ID
     */
    public String getAddrSegmId() {
        return addrSegmId;
    }

    /**
     * @param addrSegmId
     */
    public void setAddrSegmId(String addrSegmId) {
        this.addrSegmId = addrSegmId == null ? null : addrSegmId.trim();
    }

    /**
     * @return MAINTENANCE_UNIT
     */
    public String getMaintenanceUnit() {
        return maintenanceUnit;
    }

    /**
     * @param maintenanceUnit
     */
    public void setMaintenanceUnit(String maintenanceUnit) {
        this.maintenanceUnit = maintenanceUnit == null ? null : maintenanceUnit.trim();
    }

    /**
     * @return LONG_LOCAL_ID
     */
    public Integer getLongLocalId() {
        return longLocalId;
    }

    /**
     * @param longLocalId
     */
    public void setLongLocalId(Integer longLocalId) {
        this.longLocalId = longLocalId;
    }

    /**
     * @return TERRITORIAL_NATURE_ID
     */
    public Integer getTerritorialNatureId() {
        return territorialNatureId;
    }

    /**
     * @param territorialNatureId
     */
    public void setTerritorialNatureId(Integer territorialNatureId) {
        this.territorialNatureId = territorialNatureId;
    }

    /**
     * @return CONSTRUCTION_SHARE_ID
     */
    public Integer getConstructionShareId() {
        return constructionShareId;
    }

    /**
     * @param constructionShareId
     */
    public void setConstructionShareId(Integer constructionShareId) {
        this.constructionShareId = constructionShareId;
    }

    /**
     * @return START_TIME
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return CONTRACT_EXPIRES_TIME
     */
    public Date getContractExpiresTime() {
        return contractExpiresTime;
    }

    /**
     * @param contractExpiresTime
     */
    public void setContractExpiresTime(Date contractExpiresTime) {
        this.contractExpiresTime = contractExpiresTime;
    }

    /**
     * @return LONGORLOCAL
     */
    public Long getLongorlocal() {
        return longorlocal;
    }

    /**
     * @param longorlocal
     */
    public void setLongorlocal(Long longorlocal) {
        this.longorlocal = longorlocal;
    }

    /**
     * @return ROW_NUM
     */
    public Integer getRowNum() {
        return rowNum;
    }

    /**
     * @param rowNum
     */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    /**
     * @return COL_NUM
     */
    public Integer getColNum() {
        return colNum;
    }

    /**
     * @param colNum
     */
    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    /**
     * @return WO_ID
     */
    public Long getWoId() {
        return woId;
    }

    /**
     * @param woId
     */
    public void setWoId(Long woId) {
        this.woId = woId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyBelongName() {
        return propertyBelongName;
    }

    public void setPropertyBelongName(String propertyBelongName) {
        this.propertyBelongName = propertyBelongName;
    }

    public String getReinforceName() {
        return reinforceName;
    }

    public void setReinforceName(String reinforceName) {
        this.reinforceName = reinforceName;
    }

    public String getLongLocalName() {
        return longLocalName;
    }

    public void setLongLocalName(String longLocalName) {
        this.longLocalName = longLocalName;
    }

    public String getTerritorialNatureName() {
        return territorialNatureName;
    }

    public void setTerritorialNatureName(String territorialNatureName) {
        this.territorialNatureName = territorialNatureName;
    }

    public String getConstructionShareName() {
        return constructionShareName;
    }

    public void setConstructionShareName(String constructionShareName) {
        this.constructionShareName = constructionShareName;
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