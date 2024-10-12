package com.invoiceservice.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoiceservice.app.dto.request.CreateInvoiceRequest;
import com.invoiceservice.app.dto.response.CreateInvoiceResponse;
import com.invoiceservice.app.dto.response.GetAllInvoicesResponse;
import com.invoiceservice.app.service.InvoiceService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
	
    private InvoiceService invoiceService;

    @PostMapping
    public CreateInvoiceResponse add(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest) {
        return this.invoiceService.add(createInvoiceRequest);
    }
    @GetMapping("/getall")
	public List<GetAllInvoicesResponse> getAll(){
		return this.invoiceService.getAll();
	}
    

}