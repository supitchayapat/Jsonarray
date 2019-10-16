package com.ais.ws.business.server.vo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TTSCreateDocRequestVO {

	private String companyOwnerId;
	private String transferType;
	private String serviceGroupId;
	private String objectiveCode;
	private String title;
	private String remark;

	private String fromLocationTypeId;
	private String fromOrgLocationId;
	private String fromLocationId;
	private String fromSiteCode;
	private String regionFrom;
	private String zoneFrom;
	private String toLocationTypeId;
	private String toOrgLocationId;
	private String toSiteCode;
	private String regionTo;
	private String zoneTo;
	private String storeLB;
	private String serialNo;
	
	private List<TTSDocDetailVO> docDetailList;

	private String pinCreatedBy;
	private String userName;


	public String getCompanyOwnerId() {
		return companyOwnerId;
	}

	public void setCompanyOwnerId(String companyOwnerId) {
		this.companyOwnerId = companyOwnerId;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}

	public String getObjectiveCode() {
		return objectiveCode;
	}

	public void setObjectiveCode(String objectiveCode) {
		this.objectiveCode = objectiveCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFromLocationTypeId() {
		return fromLocationTypeId;
	}

	public void setFromLocationTypeId(String fromLocationTypeId) {
		this.fromLocationTypeId = fromLocationTypeId;
	}


	public String getFromSiteCode() {
		return fromSiteCode;
	}

	public void setFromSiteCode(String fromSiteCode) {
		this.fromSiteCode = fromSiteCode;
	}

	public String getToLocationTypeId() {
		return toLocationTypeId;
	}

	public void setToLocationTypeId(String toLocationTypeId) {
		this.toLocationTypeId = toLocationTypeId;
	}

	public String getToOrgLocationId() {
		return toOrgLocationId;
	}

	public void setToOrgLocationId(String toOrgLocationId) {
		this.toOrgLocationId = toOrgLocationId;
	}

	public String getToSiteCode() {
		return toSiteCode;
	}

	public void setToSiteCode(String toSiteCode) {
		this.toSiteCode = toSiteCode;
	}

	public List<TTSDocDetailVO> getDocDetailList() {
		return docDetailList;
	}

	public void setDocDetailList(List<TTSDocDetailVO> docDetailList) {
		this.docDetailList = docDetailList;
	}


	public static TTSCreateDocRequestVO fromJson(String json)  {
		TTSCreateDocRequestVO vo = new TTSCreateDocRequestVO(); 
		if (json == null || json.length() <= 4) {
			return vo;
		}
		
		JSONObject jo = JSONObject.fromObject(json);	
		
		vo = (TTSCreateDocRequestVO) JSONObject.toBean(jo, TTSCreateDocRequestVO.class);
		
		List<TTSDocDetailVO> dtlList = new ArrayList<TTSDocDetailVO>();
		
		JSONArray jaDtl = jo.getJSONArray("docDetailList");
		for(int i = 0; i < jaDtl.size(); i++) {
			JSONObject joDtl = jaDtl.getJSONObject(i);
			TTSDocDetailVO voDtl = (TTSDocDetailVO) JSONObject.toBean(joDtl, TTSDocDetailVO.class);
			
			if(voDtl.getSerialNoList() != null){
			//if(joDtl.getJSONArray("serialNoList") != null){
			JSONArray jaSnList = joDtl.getJSONArray("serialNoList");			
			@SuppressWarnings("unchecked")
			List<TTSSerialNoRecVO> snList = (List<TTSSerialNoRecVO>) JSONArray.toCollection(jaSnList, TTSSerialNoRecVO.class);
			voDtl.setSerialNoList(snList);
			}
			dtlList.add(voDtl);
		}

		vo.setDocDetailList(dtlList);
		
	    return vo;
	}

	public String getPinCreatedBy() {
		return pinCreatedBy;
	}

	public void setPinCreatedBy(String pinCreatedBy) {
		this.pinCreatedBy = pinCreatedBy;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegionFrom() {
		return regionFrom;
	}

	public void setRegionFrom(String regionFrom) {
		this.regionFrom = regionFrom;
	}

	public String getRegionTo() {
		return regionTo;
	}

	public void setRegionTo(String regionTo) {
		this.regionTo = regionTo;
	}

	public String getZoneFrom() {
		return zoneFrom;
	}

	public void setZoneFrom(String zoneFrom) {
		this.zoneFrom = zoneFrom;
	}

	public String getZoneTo() {
		return zoneTo;
	}

	public void setZoneTo(String zoneTo) {
		this.zoneTo = zoneTo;
	}

	public String getFromOrgLocationId() {
		return fromOrgLocationId;
	}

	public void setFromOrgLocationId(String fromOrgLocationId) {
		this.fromOrgLocationId = fromOrgLocationId;
	}

	public String getFromLocationId() {
		return fromLocationId;
	}

	public void setFromLocationId(String fromLocationId) {
		this.fromLocationId = fromLocationId;
	}

	public String getStoreLB() {
		return storeLB;
	}

	public void setStoreLB(String storeLB) {
		this.storeLB = storeLB;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
