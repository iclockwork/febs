package cc.mrbird.system.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {
    @Id
    @Column(name = "STAFF_ID")
    private Integer staffId;

    @Column(name = "LOGIN_NAME")
    @ExportConfig(value = "登录名")
    private String loginName;

    @Column(name = "NAME")
    @ExportConfig(value = "姓名")
    private String name;

    @Column(name = "REGION_ID")
    private String regionId;

    @ExportConfig(value = "区域名称")
    private String regionName;

    @Column(name = "TITLE")
    private Integer title;

    @Column(name = "STATION")
    private String station;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "WORKGROUP_ID")
    private Integer workgroupId;

    @Column(name = "SITE_ID")
    private Long siteId;

    @ExportConfig(value = "部门名称")
    private String deptName;

    @Column(name = "DEPT_LEVEL_ID")
    private Integer deptLevelId;

    @Column(name = "EFF_DATE")
    private Date effDate;

    @Column(name = "EXP_DATE")
    private Date expDate;

    @Column(name = "STATE")
    private String state;

    @Column(name = "STATE_DATE")
    private Date stateDate;

    @Column(name = "IP_LIMIT")
    private String ipLimit;

    @Column(name = "IP_SUBNET")
    private String ipSubnet;

    @Column(name = "IP_NETMASK")
    private String ipNetmask;

    @Column(name = "IP_HOSTNAME")
    private String ipHostname;

    @Column(name = "PC_LIMIT")
    private Integer pcLimit;

    @Column(name = "PC_ID")
    private Integer pcId;

    @Column(name = "INVOICE_SERIAL_NBR")
    private Integer invoiceSerialNbr;

    @Column(name = "LAST_DATE")
    private Date lastDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NO")
    @ExportConfig(value = "电话")
    private String phoneNo;

    @Column(name = "DELETE_STATE")
    private String deleteState;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "STAFF_ALIAS")
    private String staffAlias;

    @Column(name = "PWD_MOD_DATE")
    private Date pwdModDate;

    @Column(name = "LAN_ID")
    private String lanId;

    @Column(name = "LOGINUID")
    private String loginuid;

    @Column(name = "STAFF_CODE")
    private String staffCode;

    @Column(name = "STAFF_STATE")
    private Integer staffState;

    @Column(name = "LAST_LOGIN_DATE")
    private Date lastLoginDate;

    @Column(name = "ERRO_TIMES")
    private Integer erroTimes;

    @Column(name = "CAPTCHA")
    private String captcha;

    @Column(name = "VALIDATE_TIME")
    private Date validateTime;

    @Column(name = "HIS_PWD")
    private String hisPwd;

    @Column(name = "SAFE_STRATEGY")
    private Integer safeStrategy;

    @Column(name = "IDENTITY_ID")
    @ExportConfig(value = "身份证号")
    private String identityId;

    @Column(name = "HR_CODE")
    @ExportConfig(value = "人力资源编码")
    private String hrCode;

    @Column(name = "UNIT_ID")
    private Integer unitId;

    /**
     * @return STAFF_ID
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return TITLE
     */
    public Integer getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(Integer title) {
        this.title = title;
    }

    /**
     * @return STATION
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station
     */
    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return DEPARTMENT
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * @return WORKGROUP_ID
     */
    public Integer getWorkgroupId() {
        return workgroupId;
    }

    /**
     * @param workgroupId
     */
    public void setWorkgroupId(Integer workgroupId) {
        this.workgroupId = workgroupId;
    }

    /**
     * @return SITE_ID
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * @return DEPT_LEVEL_ID
     */
    public Integer getDeptLevelId() {
        return deptLevelId;
    }

    /**
     * @param deptLevelId
     */
    public void setDeptLevelId(Integer deptLevelId) {
        this.deptLevelId = deptLevelId;
    }

    /**
     * @return EFF_DATE
     */
    public Date getEffDate() {
        return effDate;
    }

    /**
     * @param effDate
     */
    public void setEffDate(Date effDate) {
        this.effDate = effDate;
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
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return STATE_DATE
     */
    public Date getStateDate() {
        return stateDate;
    }

    /**
     * @param stateDate
     */
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    /**
     * @return IP_LIMIT
     */
    public String getIpLimit() {
        return ipLimit;
    }

    /**
     * @param ipLimit
     */
    public void setIpLimit(String ipLimit) {
        this.ipLimit = ipLimit == null ? null : ipLimit.trim();
    }

    /**
     * @return IP_SUBNET
     */
    public String getIpSubnet() {
        return ipSubnet;
    }

    /**
     * @param ipSubnet
     */
    public void setIpSubnet(String ipSubnet) {
        this.ipSubnet = ipSubnet == null ? null : ipSubnet.trim();
    }

    /**
     * @return IP_NETMASK
     */
    public String getIpNetmask() {
        return ipNetmask;
    }

    /**
     * @param ipNetmask
     */
    public void setIpNetmask(String ipNetmask) {
        this.ipNetmask = ipNetmask == null ? null : ipNetmask.trim();
    }

    /**
     * @return IP_HOSTNAME
     */
    public String getIpHostname() {
        return ipHostname;
    }

    /**
     * @param ipHostname
     */
    public void setIpHostname(String ipHostname) {
        this.ipHostname = ipHostname == null ? null : ipHostname.trim();
    }

    /**
     * @return PC_LIMIT
     */
    public Integer getPcLimit() {
        return pcLimit;
    }

    /**
     * @param pcLimit
     */
    public void setPcLimit(Integer pcLimit) {
        this.pcLimit = pcLimit;
    }

    /**
     * @return PC_ID
     */
    public Integer getPcId() {
        return pcId;
    }

    /**
     * @param pcId
     */
    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    /**
     * @return INVOICE_SERIAL_NBR
     */
    public Integer getInvoiceSerialNbr() {
        return invoiceSerialNbr;
    }

    /**
     * @param invoiceSerialNbr
     */
    public void setInvoiceSerialNbr(Integer invoiceSerialNbr) {
        this.invoiceSerialNbr = invoiceSerialNbr;
    }

    /**
     * @return LAST_DATE
     */
    public Date getLastDate() {
        return lastDate;
    }

    /**
     * @param lastDate
     */
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return PHONE_NO
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
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
     * @return STAFF_ALIAS
     */
    public String getStaffAlias() {
        return staffAlias;
    }

    /**
     * @param staffAlias
     */
    public void setStaffAlias(String staffAlias) {
        this.staffAlias = staffAlias == null ? null : staffAlias.trim();
    }

    /**
     * @return LOGIN_NAME
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * @return PWD_MOD_DATE
     */
    public Date getPwdModDate() {
        return pwdModDate;
    }

    /**
     * @param pwdModDate
     */
    public void setPwdModDate(Date pwdModDate) {
        this.pwdModDate = pwdModDate;
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
     * @return LOGINUID
     */
    public String getLoginuid() {
        return loginuid;
    }

    /**
     * @param loginuid
     */
    public void setLoginuid(String loginuid) {
        this.loginuid = loginuid == null ? null : loginuid.trim();
    }

    /**
     * @return STAFF_CODE
     */
    public String getStaffCode() {
        return staffCode;
    }

    /**
     * @param staffCode
     */
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    /**
     * @return STAFF_STATE
     */
    public Integer getStaffState() {
        return staffState;
    }

    /**
     * @param staffState
     */
    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }

    /**
     * @return LAST_LOGIN_DATE
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * @param lastLoginDate
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return ERRO_TIMES
     */
    public Integer getErroTimes() {
        return erroTimes;
    }

    /**
     * @param erroTimes
     */
    public void setErroTimes(Integer erroTimes) {
        this.erroTimes = erroTimes;
    }

    /**
     * @return CAPTCHA
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * @param captcha
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    /**
     * @return VALIDATE_TIME
     */
    public Date getValidateTime() {
        return validateTime;
    }

    /**
     * @param validateTime
     */
    public void setValidateTime(Date validateTime) {
        this.validateTime = validateTime;
    }

    /**
     * @return HIS_PWD
     */
    public String getHisPwd() {
        return hisPwd;
    }

    /**
     * @param hisPwd
     */
    public void setHisPwd(String hisPwd) {
        this.hisPwd = hisPwd == null ? null : hisPwd.trim();
    }

    /**
     * @return SAFE_STRATEGY
     */
    public Integer getSafeStrategy() {
        return safeStrategy;
    }

    /**
     * @param safeStrategy
     */
    public void setSafeStrategy(Integer safeStrategy) {
        this.safeStrategy = safeStrategy;
    }

    /**
     * @return IDENTITY_ID
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * @param identityId
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * @return HR_CODE
     */
    public String getHrCode() {
        return hrCode;
    }

    /**
     * @param hrCode
     */
    public void setHrCode(String hrCode) {
        this.hrCode = hrCode == null ? null : hrCode.trim();
    }

    /**
     * @return UNIT_ID
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * @param unitId
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}