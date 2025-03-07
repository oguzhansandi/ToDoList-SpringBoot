package com.oguzhansandi.service;

import java.util.List;

import com.oguzhansandi.dto.DtoToDo;
import com.oguzhansandi.dto.DtoToDoUI;
import com.oguzhansandi.model.ToDo;

public interface ITaskService {
	
	public DtoToDo saveTask(DtoToDoUI dtoToDoUI);
	
	public DtoToDo deleteTask(Long id);

	public DtoToDo toogleTask(Long id);

	public List<DtoToDo> getAllTasks();
}
