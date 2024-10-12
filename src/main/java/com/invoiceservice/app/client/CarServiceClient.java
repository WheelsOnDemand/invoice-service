package com.invoiceservice.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invoiceservice.app.dto.response.GetCarResponse;

import feign.Headers;

@FeignClient(value="inventory-service",url="${microservice.inventory}")
public interface CarServiceClient {
	@RequestMapping(method=RequestMethod.GET , value = "api/cars/{carId}")
	@Headers(value="Content-Type:application/json")
	 GetCarResponse getByCarId(@PathVariable String carId);
}
