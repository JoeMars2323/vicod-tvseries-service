package com.marsoft.vicod.tvshows.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marsoft.vicod.tvshows.rest.VicodRestResponse;
import com.marsoft.vicod.tvshows.utils.ExceptionConstants;


@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class VicodRestExceptionHandler {

	
	
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public VicodRestResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new VicodRestResponse(ExceptionConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
	}

	
	
	@ExceptionHandler({ VicodException.class })
	@ResponseBody
	public VicodRestResponse handleLmException(final HttpServletRequest request, final HttpServletResponse response,
			final VicodException ex) {
		response.setStatus(ex.getCode());
		return new VicodRestResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()), ex.getMessage(),
				ex.getErrorList());
	}
	
	
	
}