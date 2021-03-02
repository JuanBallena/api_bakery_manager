package com.pablo.bakeryManager.infrastructure.bus;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.ApplicationContextProvider;
import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;

@Component
public class CommandHandlerReflection {

	@SuppressWarnings("rawtypes")
	public CommandHandler getCommandHandler(Command command) {
		
		Reflections reflections = new Reflections("com.pablo.bakeryManager");

		Set<Class<? extends CommandHandler>> subTypes = reflections.getSubTypesOf(CommandHandler.class);
		
		Map<Class<? extends Command>, Class<? extends CommandHandler>> mapCommandHandlerReference = this.createMapCommandHandlerReference(subTypes);
        
		Class<? extends CommandHandler> commandHandlerClass = mapCommandHandlerReference.get(command.getClass());
		
		CommandHandler commandHandler = ApplicationContextProvider.getApplicationContext().getBean(commandHandlerClass);
		
		return commandHandler;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<Class<? extends Command>, Class<? extends CommandHandler>> createMapCommandHandlerReference(Set<Class<? extends CommandHandler>> subTypes) {
		
		Map<Class<? extends Command>, Class<? extends CommandHandler>> mapCommandHandlerReference = new HashMap<>();

        for (Class<? extends CommandHandler> commandHandlerClass : subTypes) {
        	
            ParameterizedType paramType  = (ParameterizedType) commandHandlerClass.getGenericInterfaces()[0];
			Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            mapCommandHandlerReference.put(commandClass, commandHandlerClass);
        }
        
        return mapCommandHandlerReference;
	}
}
