package com.invoiceservice.app.service;

import java.util.List;

import com.invoiceservice.app.dto.request.CreateInvoiceRequest;
import com.invoiceservice.app.dto.response.CreateInvoiceResponse;
import com.invoiceservice.app.dto.response.GetAllInvoicesResponse;
import com.invoiceservice.app.model.Invoice;

public interface InvoiceService {
	CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);

	List<GetAllInvoicesResponse> getAll();

	void createInvoice(Invoice invoice);

}