package com.cricketanalyse.entities;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.cricketanalyse.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@MappedSuperclass
public class AuditParams {

	@JsonFormat (timezone = Constants.TIME_ZONE, shape = Shape.STRING, pattern= Constants.DATE_TIME_FORMAT )
	protected Date createdTs;
	

	@JsonFormat (timezone = Constants.TIME_ZONE, shape = Shape.STRING, pattern= Constants.DATE_TIME_FORMAT )
	protected Date modifiedTs;
	
	public AuditParams(Date createdTs, Date modifiedTs) {
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}

	public AuditParams()
	{
		
	}
	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public Date getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	@PrePersist
	void onCreate()
	{
		this.setCreatedTs(new Date());
	}
	
	@PreUpdate
	void onUpdate()
	{
		this.setModifiedTs(new Date());
	}
	
}
