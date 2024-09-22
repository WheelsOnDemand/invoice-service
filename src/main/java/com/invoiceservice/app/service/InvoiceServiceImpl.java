package com.invoiceservice.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.invoiceservice.app.dto.request.CreateInvoiceRequest;
import com.invoiceservice.app.dto.response.CreateInvoiceResponse;
import com.invoiceservice.app.dto.response.GetAllInvoicesResponse;
import com.invoiceservice.app.model.Invoice;
import com.invoiceservice.app.repository.InvoiceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public  class InvoiceServiceImpl implements InvoiceService {

	private InvoiceRepository invoiceRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {
		Invoice invoice = modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		invoice.setId(UUID.randomUUID().toString());
		invoiceRepository.save(invoice);
		
		CreateInvoiceResponse response = this.modelMapperService.forResponse().map(invoice,
				CreateInvoiceResponse.class);
		return response;
	}
	
	
	@Override
	public List<GetAllInvoicesResponse> getAll() {
		List<Invoice> invoices = this.invoiceRepository.findAll();
		List<GetAllInvoicesResponse> allInvoiceResponses = invoices.stream()
				.map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class))
				.collect(Collectors.toList());
		
		return allInvoiceResponses ;
	}


	@Override
	public void createInvoice(Invoice invoice) {
		invoice.setId(UUID.randomUUID().toString());
		invoiceRepository.save(invoice);
		
	}
	
	
}