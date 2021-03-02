package com.pablo.bakeryManager.infrastructure.bus;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.ApplicationContextProvider;
import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;

@Component
public class QueryHandlerReflection {

	@SuppressWarnings("rawtypes")
	public QueryHandler getQueryHandler(Query query) {
		
		Reflections reflections = new Reflections("com.pablo.bakeryManager");

		Set<Class<? extends QueryHandler>> subTypes = reflections.getSubTypesOf(QueryHandler.class);
		
		Map<Class<? extends Query>, Class<? extends QueryHandler>> mapQueryHandlerReference = this.createMapQueryHandlerReference(subTypes);
        
		Class<? extends QueryHandler> queryHandlerClass = mapQueryHandlerReference.get(query.getClass());
		
		QueryHandler queryHandler = ApplicationContextProvider.getApplicationContext().getBean(queryHandlerClass);
		
		return queryHandler;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<Class<? extends Query>, Class<? extends QueryHandler>> createMapQueryHandlerReference(Set<Class<? extends QueryHandler>> subTypes) {
		
		Map<Class<? extends Query>, Class<? extends QueryHandler>> mapQueryHandlerReference = new HashMap<>();

        for (Class<? extends QueryHandler> queryHandlerClass : subTypes) {
        	
            ParameterizedType paramType       = (ParameterizedType) queryHandlerClass.getGenericInterfaces()[0];
			Class<? extends Query> queryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            mapQueryHandlerReference.put(queryClass, queryHandlerClass);
        }
        
        return mapQueryHandlerReference;
	}
}
