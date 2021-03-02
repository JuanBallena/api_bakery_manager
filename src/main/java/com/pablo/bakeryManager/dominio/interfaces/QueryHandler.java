package com.pablo.bakeryManager.dominio.interfaces;

public interface QueryHandler<T extends Query, R extends Response> {
	
    public R handle(T query);
}
