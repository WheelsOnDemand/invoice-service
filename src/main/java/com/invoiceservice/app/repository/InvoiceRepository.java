package com.invoiceservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoiceservice.app.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
}