package com.oguzhansandi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "to_do_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "task")
	private String task;
	
	@Column(name="completed")
	private boolean completed;

	@Column(name = "create_time")
	private Date createTime;
}
