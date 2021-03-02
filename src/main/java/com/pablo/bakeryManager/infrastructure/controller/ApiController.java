package com.pablo.bakeryManager.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.bus.SyncCommandBus;
import com.pablo.bakeryManager.infrastructure.bus.SyncQueryBus;

public class ApiController {

	@Autowired
	private SyncQueryBus queryBus;
	
	@Autowired
	private SyncCommandBus commandBus;
	
	public Response ask(Query query) {
		
		return queryBus.ask(query);
	}
	
	public Response dispatch(Command command) {
		
		return commandBus.dispatch(command);
	}
}
