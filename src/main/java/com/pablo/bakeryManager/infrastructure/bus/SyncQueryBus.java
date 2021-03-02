package com.pablo.bakeryManager.infrastructure.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.dominio.interfaces.QueryBus;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.interfaces.Response;

@Component
public class SyncQueryBus implements QueryBus {

	@Autowired
	private QueryHandlerReflection queryHandlerReflection;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Response ask(Query query) {
	
		QueryHandler queryHandler = queryHandlerReflection.getQueryHandler(query);
		
		return queryHandler.handle(query);
	}
}
