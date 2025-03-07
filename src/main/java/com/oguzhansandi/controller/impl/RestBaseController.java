package com.oguzhansandi.controller.impl;

import com.oguzhansandi.controller.RootEntity;

public class RestBaseController {
	
	public <T> RootEntity<T> ok(T payload){
		return RootEntity.ok(payload);
	}
	
	public <T> RootEntity<T> error(String ErrorMessage){
		return RootEntity.error(ErrorMessage);
	}
}
