package com.pablo.bakeryManager.infrastructure.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.dominio.interfaces.CommandBus;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.interfaces.Response;

@Component
public class SyncCommandBus implements CommandBus {

	@Autowired
	private CommandHandlerReflection commandHandlderReflection;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Response dispatch(Command command) {
		
		CommandHandler commandHandler = commandHandlderReflection.getCommandHandler(command);
		
		return commandHandler.handle(command);      
	}
}
