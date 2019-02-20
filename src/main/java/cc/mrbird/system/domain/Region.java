package cc.mrbird.system.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "SPC_REGION")
public class Region implements Serializable {
    @Id
    @Column(name = "REGION_ID")
    private String regionId;

    @Column(name = "REGION_NAME")
    @ExportConfig(value = "区域名称")
    private String regionName;

    @Column(name = "REGION_NO")
    @ExportConfig(value = "区域编码")
    private String regionNo;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "CHINA_NAME_AB")
    @ExportConfig(value = "区域简称")
    private String chinaNameAb;

    @Column(name = "SUPER_REGION_ID")
    private String superRegionId;

    @ExportConfig(value = "上级区域")
    private String superRegionName;

    @Column(name = "GRADE_ID")
    private Integer gradeId;

    @ExportConfig(value = "区域等级")
    private String gradeName;

    @Column(name = "TYPE_ID")
    private Integer typeId;

    @Column(name = "ADDRESS")
    @ExportConfig(value = "区域中心地址")
    private String address;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "NAME_AB")
    private String nameAb;

    @Column(name = "RES_TYPE_ID")
    private Integer resTypeId;

    @Column(name = "MODIFY_OP")
    private Integer modifyOp;

    @Column(name = "MODIRY_DATE")
    private Date modiryDate;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "SYNC_DATE")
    private Date syncDate;

    @Column(name = "OLD_ID_EQP")
    private String oldIdEqp;

    @Column(name = "OLD_SP")
    private String oldSp;

    @Column(name = "LAN_ID")
    private Integer lanId;

    @Column(name = "PPDOM_ID")
    private Integer ppdomId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_OP")
    private Integer createOp;

    @Column(name = "CRM_REGION")
    private Integer crmRegion;

    @Column(name = "CRM_LAN")
    private Integer crmLan;

    @Column(name = "SP_REGION_ID")
    private String spRegionId;

    @Column(name = "COUNTRY_TYPE")
    private Integer countryType;

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
     * @return REGION_NO
     */
    public String getRegionNo() {
        return regionNo;
    }

    /**
     * @param regionNo
     */
    public void setRegionNo(String regionNo) {
        this.regionNo = regionNo == null ? null : regionNo.trim();
    }

    /**
     * @return REGION_NAME
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * @param regionName
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
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
     * @return GRADE_ID
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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
     * @return SUPER_REGION_ID
     */
    public String getSuperRegionId() {
        return superRegionId;
    }

    /**
     * @param superRegionId
     */
    public void setSuperRegionId(String superRegionId) {
        this.superRegionId = superRegionId == null ? null : superRegionId.trim();
    }

    public String getSuperRegionName() {
        return superRegionName;
    }

    public void setSuperRegionName(String superRegionName) {
        this.superRegionName = superRegionName;
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
     * @return CRM_REGION
     */
    public Integer getCrmRegion() {
        return crmRegion;
    }

    /**
     * @param crmRegion
     */
    public void setCrmRegion(Integer crmRegion) {
        this.crmRegion = crmRegion;
    }

    /**
     * @return CRM_LAN
     */
    public Integer getCrmLan() {
        return crmLan;
    }

    /**
     * @param crmLan
     */
    public void setCrmLan(Integer crmLan) {
        this.crmLan = crmLan;
    }

    /**
     * @return SP_REGION_ID
     */
    public String getSpRegionId() {
        return spRegionId;
    }

    /**
     * @param spRegionId
     */
    public void setSpRegionId(String spRegionId) {
        this.spRegionId = spRegionId == null ? null : spRegionId.trim();
    }

    /**
     * @return COUNTRY_TYPE
     */
    public Integer getCountryType() {
        return countryType;
    }

    /**
     * @param countryType
     */
    public void setCountryType(Integer countryType) {
        this.countryType = countryType;
    }
}