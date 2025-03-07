package com.oguzhansandi.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoToDo {

	private Long id;
	
	private String task;
	
	private Date createTime;
	
	private Boolean completed;
}
