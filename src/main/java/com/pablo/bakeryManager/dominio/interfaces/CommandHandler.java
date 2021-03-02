package com.pablo.bakeryManager.dominio.interfaces;

public interface CommandHandler<T extends Command, R extends Response> {

	public R handle(T command);
}
