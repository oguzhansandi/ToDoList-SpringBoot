package com.oguzhansandi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oguzhansandi.dto.DtoToDo;
import com.oguzhansandi.dto.DtoToDoUI;
import com.oguzhansandi.exception.BaseException;
import com.oguzhansandi.exception.ErrorMessage;
import com.oguzhansandi.exception.MessageType;
import com.oguzhansandi.model.ToDo;
import com.oguzhansandi.repository.TaskRepository;
import com.oguzhansandi.service.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService{
	DtoToDo dtoToDo = new DtoToDo();

	@Autowired
	private TaskRepository taskRepository;
	
	private ToDo createTask(DtoToDoUI dtoToDoUI) {
		ToDo toDo = new ToDo();
		
		toDo.setCreateTime(new Date());
		toDo.setCompleted(false);
		toDo.setTask(dtoToDoUI.getTask());
		
		return toDo;
	}
	
	@Override
	public DtoToDo saveTask(DtoToDoUI dtoToDoUI) {
		
		ToDo savedTask = taskRepository.save(createTask(dtoToDoUI));
		
		BeanUtils.copyProperties(savedTask, dtoToDo);
		
		return dtoToDo;
	}

	@Override
	public DtoToDo deleteTask(Long id) {
		
		Optional<ToDo> optTask = taskRepository.findById(id);
		if(optTask.isPresent()) {
			
			ToDo taskToDelete = optTask.get();
			DtoToDo deletedDto = new DtoToDo();
			BeanUtils.copyProperties(taskToDelete, deletedDto);
			taskRepository.delete(taskToDelete);
			return deletedDto;
		}
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
	}

	@Override
	public DtoToDo toogleTask(Long id) {
		Optional<ToDo> optTask = taskRepository.findById(id);
		if (optTask.isPresent()) {
			ToDo toogleToDo = optTask.get();
			
			toogleToDo.setCompleted(!toogleToDo.isCompleted());
		
			ToDo uptadedTask = taskRepository.save(toogleToDo);
			
			DtoToDo dtoToDo= new DtoToDo();
			
			BeanUtils.copyProperties(uptadedTask, dtoToDo);
			
			return dtoToDo;
		}
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
	}

	@Override
	public List<DtoToDo> getAllTasks() {
	    List<ToDo> allTasks = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	    
	    return allTasks.stream()
	    		.map(task-> {
	    			DtoToDo dtoToDo = new DtoToDo();
	    			BeanUtils.copyProperties(task, dtoToDo);
	    			return dtoToDo;
	    		})
	    		.collect(Collectors.toList());
	}

}
