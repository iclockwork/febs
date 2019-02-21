package cc.mrbird.res.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "SPC_ACCESS_AREA")
public class AccessArea implements Serializable {
    @Column(name = "ACCESS_AREA_ID")
    private String accessAreaId;

    @Column(name = "ACCESS_AREA_NO")
    @ExportConfig(value = "综合接入区编码")
    private String accessAreaNo;

    @Column(name = "ACCESS_AREA_NAME")
    @ExportConfig(value = "综合接入区名称")
    private String accessAreaName;

    @Column(name = "FOCUS_AREA_NAME")
    @ExportConfig(value = "汇聚区名称")
    private String focusAreaName;

    @Column(name = "RES_TYPE_ID")
    private Integer resTypeId;

    @Column(name = "AREA_TYPE_ID")
    private Integer areaTypeId;

    @ExportConfig(value = "所属区域")
    private String areaTypeName;

    @Column(name = "REGION_ID")
    private String regionId;

    @ExportConfig(value = "所属地市")
    private String dsRegionName;

    @Column(name = "IS_COMPLETE")
    private String isComplete;

    @ExportConfig(value = "是否已完成建设")
    private String isCompleteName;

    @Column(name = "PROBLEM")
    @ExportConfig(value = "目前存在问题")
    private String problem;

    @Column(name = "WORK_LOAD")
    @ExportConfig(value = "工作量")
    private String workLoad;

    @Column(name = "NOTES")
    @ExportConfig(value = "备注")
    private String notes;

    @Column(name = "CREATE_TIME")
    @ExportConfig(value = "创建时间", convert = "c:cc.mrbird.common.util.poi.convert.TimeConvert")
    private Date createTime;

    @Column(name = "CREATE_OP")
    private Integer createOp;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private Integer modifyOp;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "FOCUS_AREA_ID")
    private String focusAreaId;

    @Column(name = "ACCESS_AREA_TYPE")
    private String accessAreaType;

    @Column(name = "WO_ID")
    private Long woId;

    @Column(name = "MNT_STATE_ID")
    private Integer mntStateId;

    @Column(name = "AREA")
    private BigDecimal area;

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
     * @return ACCESS_AREA_NO
     */
    public String getAccessAreaNo() {
        return accessAreaNo;
    }

    /**
     * @param accessAreaNo
     */
    public void setAccessAreaNo(String accessAreaNo) {
        this.accessAreaNo = accessAreaNo == null ? null : accessAreaNo.trim();
    }

    /**
     * @return ACCESS_AREA_NAME
     */
    public String getAccessAreaName() {
        return accessAreaName;
    }

    /**
     * @param accessAreaName
     */
    public void setAccessAreaName(String accessAreaName) {
        this.accessAreaName = accessAreaName == null ? null : accessAreaName.trim();
    }

    /**
     * @return FOCUS_AREA_NAME
     */
    public String getFocusAreaName() {
        return focusAreaName;
    }

    /**
     * @param focusAreaName
     */
    public void setFocusAreaName(String focusAreaName) {
        this.focusAreaName = focusAreaName == null ? null : focusAreaName.trim();
    }

    /**
     * @return RES_TYPE_ID
     */
    public Integer getResTypeId() {
        return resTypeId;
    }

    /**
     * @param resTypeId
     */
    public void setResTypeId(Integer resTypeId) {
        this.resTypeId = resTypeId;
    }

    /**
     * @return AREA_TYPE_ID
     */
    public Integer getAreaTypeId() {
        return areaTypeId;
    }

    /**
     * @param areaTypeId
     */
    public void setAreaTypeId(Integer areaTypeId) {
        this.areaTypeId = areaTypeId;
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
     * @return IS_COMPLETE
     */
    public String getIsComplete() {
        return isComplete;
    }

    /**
     * @param isComplete
     */
    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete == null ? null : isComplete.trim();
    }

    /**
     * @return PROBLEM
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem
     */
    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    /**
     * @return WORK_LOAD
     */
    public String getWorkLoad() {
        return workLoad;
    }

    /**
     * @param workLoad
     */
    public void setWorkLoad(String workLoad) {
        this.workLoad = workLoad == null ? null : workLoad.trim();
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
     * @return FOCUS_AREA_ID
     */
    public String getFocusAreaId() {
        return focusAreaId;
    }

    /**
     * @param focusAreaId
     */
    public void setFocusAreaId(String focusAreaId) {
        this.focusAreaId = focusAreaId == null ? null : focusAreaId.trim();
    }

    /**
     * @return ACCESS_AREA_TYPE
     */
    public String getAccessAreaType() {
        return accessAreaType;
    }

    /**
     * @param accessAreaType
     */
    public void setAccessAreaType(String accessAreaType) {
        this.accessAreaType = accessAreaType == null ? null : accessAreaType.trim();
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

    public String getAreaTypeName() {
        return areaTypeName;
    }

    public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }

    public String getDsRegionName() {
        return dsRegionName;
    }

    public void setDsRegionName(String dsRegionName) {
        this.dsRegionName = dsRegionName;
    }

    public String getIsCompleteName() {
        return isCompleteName;
    }

    public void setIsCompleteName(String isCompleteName) {
        this.isCompleteName = isCompleteName;
    }
}