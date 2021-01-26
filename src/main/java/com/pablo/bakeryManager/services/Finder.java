package com.pablo.bakeryManager.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.interf.Params;
import com.pablo.bakeryManager.repository.CustomRepository;
import com.pablo.bakeryManager.response.PageResponse;

@Component
public final class Finder<T,D> {

	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>,
		C extends Converter<T,D>> PageResponse getData(Params<T> request, R repository, C converter ) {
		
		if (request.hasFilterAndPagingAndSortParameters()) {
			Page<T> TPage = repository.findAll(request.getFilterSpecification(), request.getPagingAndSort());
			return toPageResponse(TPage, converter);
		}
		
		if (request.hasFilterAndPagingAndSortParameters()) {
			Page<T> TPage = repository.findAll(request.getFilterSpecification(), request.getPagingAndSort());
			return toPageResponse(TPage, converter);
		}
		
		if (request.hasFilterAndPagingParameters()) {
			Page<T> TPage = repository.findAll(request.getFilterSpecification(), request.getPaging());
			return toPageResponse(TPage, converter);
		}
		
		if (request.hasFilterAndSortParameters()) {
			List<T> TList = repository.findAll(request.getFilterSpecification(), request.getSort());
			return toPageResponse(TList, converter);
		}
		
		if (request.hasPagingAndSortParameters()) {
			Page<T> TPage = repository.findAll(request.getPagingAndSort());
			return toPageResponse(TPage, converter);
		}
		
		if (request.hasFilterParameters()) {
			List<T> TList = repository.findAll(request.getFilterSpecification());
			return toPageResponse(TList, converter);
		}

		if (request.hasPagingParameters()) {
			Page<T> TPage = repository.findAll(request.getPaging());
			return toPageResponse(TPage, converter);
		}
		
		if (request.hasSortParameters()) {
			List<T> TList = repository.findAll(request.getSort());
			return toPageResponse(TList, converter);
		}
		
		List<T> bakeTicketList = repository.findAll();
		return toPageResponse(bakeTicketList, converter);
	}
	
	private <C extends Converter<T,D>> PageResponse toPageResponse(Page<T> TPage, C converter) {
		
		List<D> DTOList = converter.toDTOList(TPage.getContent());
		return PageResponse.builder()
				.data(DTOList)
				.totalPages(TPage.getTotalPages())
				.build();
	}
	
	private <C extends Converter<T,D>> PageResponse toPageResponse(List<T> TList, C converter) {
		
		List<D> DTOList = converter.toDTOList(TList);
		return PageResponse.builder()
				.data(DTOList)
				.totalPages(DTOList.size() == 0 ? 0 : 1)
				.build();
	}
}
