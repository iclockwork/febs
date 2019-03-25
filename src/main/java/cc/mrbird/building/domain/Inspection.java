package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "BD_INSPECTION")
public class Inspection {
    @Id
    @Column(name = "INSPECTION_ID")
    private Long inspectionId;

    @Column(name = "INSPECTION_TYPE")
    private Integer inspectionType;

    @Transient
    @ExportConfig(value = "巡检类型")
    private String inspectionTypeName;

    @Column(name = "INSPECTION_NO")
    @ExportConfig(value = "巡检编码")
    private String inspectionNo;

    @Column(name = "POSITION")
    @ExportConfig(value = "自动定位信息")
    private String position;

    @Column(name = "INTRODUCTION")
    @ExportConfig(value = "拜访描述")
    private String introduction;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Long createStaffId;

    @Transient
    @ExportConfig(value = "巡检人")
    private String createStaffName;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "巡检时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Long modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;

    @Column(name = "SEGM_ID")
    private String segmId;

    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    @Column(name = "LATITUDE")
    private BigDecimal latitude;

    /**
     * @return INSPECTION_ID
     */
    public Long getInspectionId() {
        return inspectionId;
    }

    /**
     * @param inspectionId
     */
    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    /**
     * @return INSPECTION_TYPE
     */
    public Integer getInspectionType() {
        return inspectionType;
    }

    /**
     * @param inspectionType
     */
    public void setInspectionType(Integer inspectionType) {
        this.inspectionType = inspectionType;
    }

    /**
     * @return INSPECTION_NO
     */
    public String getInspectionNo() {
        return inspectionNo;
    }

    /**
     * @param inspectionNo
     */
    public void setInspectionNo(String inspectionNo) {
        this.inspectionNo = inspectionNo == null ? null : inspectionNo.trim();
    }

    /**
     * @return POSITION
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * @return INTRODUCTION
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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

    public String getInspectionTypeName() {
        return inspectionTypeName;
    }

    public void setInspectionTypeName(String inspectionTypeName) {
        this.inspectionTypeName = inspectionTypeName;
    }

    public String getCreateStaffName() {
        return createStaffName;
    }

    public void setCreateStaffName(String createStaffName) {
        this.createStaffName = createStaffName;
    }
}