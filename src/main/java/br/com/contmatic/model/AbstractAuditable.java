package br.com.contmatic.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractAuditable {
	private Usuario createdBy;
	
	private Date createdDate;
	
	private Usuario lastModifiedBy;
	
	private Date lastModifiedDate;
	
}
