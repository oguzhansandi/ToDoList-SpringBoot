package com.oguzhansandi.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhansandi.controller.ITaskController;
import com.oguzhansandi.controller.RootEntity;
import com.oguzhansandi.dto.DtoToDo;
import com.oguzhansandi.dto.DtoToDoUI;
import com.oguzhansandi.model.ToDo;
import com.oguzhansandi.service.ITaskService;

import jakarta.validation.Valid;

@Controller
public class TaskController extends RestBaseController implements ITaskController{

	@Autowired
	private ITaskService taskService;
	
	@Override
	@PostMapping
	public String saveTask(@Valid @ModelAttribute DtoToDoUI dtoToDoUI) {
		taskService.saveTask(dtoToDoUI);
		return "redirect:/";
	}

	@Override
	@GetMapping(path = "delete/{id}")
	public String deleteTask(@Valid @PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}

	@Override
	@GetMapping(path = "/toogle/{id}")
	public String toogleTask(@PathVariable Long id) {
		 taskService.toogleTask(id);
		 return "redirect:/";
	}

	@Override
	@GetMapping("/")
	public String getAllTasks(Model model) {
		List<DtoToDo> tasks = taskService.getAllTasks();
		model.addAttribute("allTasks", tasks);
		return "tasks";
	}

}
