package com.oguzhansandi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoToDoUI {

	@NotEmpty
	private String task;
}
