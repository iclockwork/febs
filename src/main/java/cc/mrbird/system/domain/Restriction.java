package cc.mrbird.system.domain;

import cc.mrbird.common.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "PUB_RESTRICTION")
public class Restriction implements Serializable {
    @Id
    @Column(name = "SERIAL_NO")
    @ExportConfig(value = "流水号")
    private Long serialNo;

    @Column(name = "DESC_ID")
    private Long descId;

    @Column(name = "DESC_CHINA")
    @ExportConfig(value = "属性名称")
    private String descChina;

    @Column(name = "CODE")
    private String code;

    @Column(name = "KEYWORD")
    @ExportConfig(value = "关键字")
    private String keyword;

    @Column(name = "IS_DISPLAY")
    private String isDisplay;

    @Column(name = "KEYWORD_DESC")
    @ExportConfig(value = "关键字描述")
    private String keywordDesc;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "OLD_ID_EQP")
    private String oldIdEqp;

    @Column(name = "OLD_SP")
    private String oldSp;

    @Column(name = "LAN_ID")
    private String lanId;

    /**
     * @return SERIAL_NO
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * @return DESC_ID
     */
    public Long getDescId() {
        return descId;
    }

    /**
     * @param descId
     */
    public void setDescId(Long descId) {
        this.descId = descId;
    }

    /**
     * @return DESC_CHINA
     */
    public String getDescChina() {
        return descChina;
    }

    /**
     * @param descChina
     */
    public void setDescChina(String descChina) {
        this.descChina = descChina == null ? null : descChina.trim();
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
     * @return KEYWORD
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * @return IS_DISPLAY
     */
    public String getIsDisplay() {
        return isDisplay;
    }

    /**
     * @param isDisplay
     */
    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay == null ? null : isDisplay.trim();
    }

    /**
     * @return KEYWORD_DESC
     */
    public String getKeywordDesc() {
        return keywordDesc;
    }

    /**
     * @param keywordDesc
     */
    public void setKeywordDesc(String keywordDesc) {
        this.keywordDesc = keywordDesc == null ? null : keywordDesc.trim();
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
    public String getLanId() {
        return lanId;
    }

    /**
     * @param lanId
     */
    public void setLanId(String lanId) {
        this.lanId = lanId == null ? null : lanId.trim();
    }
}