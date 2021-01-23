package com.pablo.bakeryManager.definition;

public class ResponseCodeDefinition {

	public static final Integer RESPONSE_CODE_OK = 200;
	public static final String RESPONSE_CODE_OK_S = "Exito";
	
	public static final Integer RESPONSE_CODE_CREATED = 201;
	public static final String RESPONSE_CODE_CREATED_S = "Guardado con éxito";
	
	public static final Integer RESPONSE_CODE_NO_CONTENT = 204;
	public static final String RESPONSE_CODE_NO_CONTENT_S = "Sin contenido";
	
	public static final Integer RESPONSE_CODE_BAD_REQUEST = 400;
	public static final String RESPONSE_CODE_BAD_REQUEST_S = "Solicitud incorrecta";
	
	public static final Integer RESPONSE_CODE_UNAUTHORIZED = 401;
	public static final String RESPONSE_CODE_UNAUTHORIZED_S = "No autorizado";
	
	public static final Integer RESPONSE_CODE_FORBIDDEN = 403;
	public static final String RESPONSE_CODE_FORBIDDEN_S = "Prohibido";
	
	public static final Integer RESPONSE_CODE_NOT_FOUND = 404;
	public static final String RESPONSE_CODE_NOT_FOUND_S = "Sin contenido";
	
	public static final Integer RESPONSE_CODE_UNPROCESSABLE_ENTITY = 422;
	public static final String RESPONSE_CODE_UNPROCESSABLE_ENTITY_S = "Entidad no procesable, error semántico";
	
	public static final Integer RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500;
	public static final String RESPONSE_CODE_INTERNAL_SERVER_ERROR_S = "Error de servidor";
	
	public static final Integer RESPONSE_CODE_SERVICE_UNAVAILABLE = 503;
	public static final String RESPONSE_CODE_SERVICE_UNAVAILABLE_S = "Servicio no disponible";
}
