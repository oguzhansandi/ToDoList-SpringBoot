package com.oguzhansandi.controller;

import org.springframework.ui.Model;

import com.oguzhansandi.dto.DtoToDo;
import com.oguzhansandi.dto.DtoToDoUI;

public interface ITaskController {

	public String saveTask(DtoToDoUI dtoToDoUI);
	
	public String deleteTask(Long id);
	
	public String toogleTask(Long id);

	public String getAllTasks(Model model);
}
