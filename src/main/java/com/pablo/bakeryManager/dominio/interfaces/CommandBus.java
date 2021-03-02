package com.pablo.bakeryManager.dominio.interfaces;

public interface CommandBus {

	public Response dispatch(Command command);
}
