package br.com.contmatic.model;

import java.util.Date;

public abstract class AbstractAuditable {
	
	private Usuario createdBy;
	
	private Date createdDate;
	
	private Usuario lastModifiedBy;
	
	private Date lastModifiedDate;

	public Usuario getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Usuario createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Usuario getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Usuario lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
