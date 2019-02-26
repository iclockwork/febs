package cc.mrbird.building.domain;

import cc.mrbird.common.annotation.ExportConfig;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 2/22
 * Features:
 */
@Table(name = "BD_COMP_PRODUCT")
public class CompProduct implements Serializable {
    @Id
    @Column(name = "COMP_PRODUCT_ID")
    private Long compProductId;

    @Column(name = "BUILDING_NO")
    @ExportConfig(value = "楼宇编码")
    private String buildingNo;

    @Column(name = "BUILDING_NAME")
    @ExportConfig(value = "楼宇名称")
    private String buildingName;

    @Column(name = "BUILDING_ID")
    private Long buildingId;

    @Column(name = "OPERATOR")
    @ExportConfig(value = "运营商")
    private Short operator;

    @Column(name = "BUSINESS_TYPE")
    @ExportConfig(value = "业务类型")
    private Short businessType;

    @Column(name = "INTRODUCTION")
    @ExportConfig(value = "资费描述")
    private String introduction;

    @Column(name = "DELETE_FLAG")
    private Short deleteFlag;

    @Column(name = "CREATE_STAFF_ID")
    private Integer createStaffId;

    @Column(name = "CREATE_DATE")
    @ExportConfig(value = "录入时间")
    private Date createDate;

    @Column(name = "MODIFY_STAFF_ID")
    private Integer modifyStaffId;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_OP")
    private String modifyOp;

    private Long compProductDocId;

    private Long docId;

    private String docName;

    private Long fileId;

    private String fileName;

    private byte[] fileContent;


    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public void setCompProductId(Long compProductId) {
        this.compProductId = compProductId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getCompProductDocId() {
        return compProductDocId;
    }

    public void setCompProductDocId(Long compProductDocId) {
        this.compProductDocId = compProductDocId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getCompProductId() {
        return compProductId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

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
     * @return OPERATOR
     */
    public Short getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(Short operator) {
        this.operator = operator;
    }

    /**
     * @return BUSINESS_TYPE
     */
    public Short getBusinessType() {
        return businessType;
    }

    /**
     * @param businessType
     */
    public void setBusinessType(Short businessType) {
        this.businessType = businessType;
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