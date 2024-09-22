package com.invoiceservice.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.invoiceservice.app.client.CarServiceClient;
import com.invoiceservice.app.dto.response.GetCarResponse;
import com.invoiceservice.app.kafka.events.InvoiceCreatedEvent;
import com.invoiceservice.app.model.Invoice;
import com.invoiceservice.app.service.InvoiceService;
import com.invoiceservice.app.service.ModelMapperService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@EnableKafka
public class InvoiceConsumer {
	private InvoiceService invoiceService;
	private ModelMapperService modelMapperService;
	private CarServiceClient carServiceClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceConsumer.class);

	@KafkaListener(topics = "invoice_created", groupId = "invoice_create")
	public void consume(InvoiceCreatedEvent event) {
		Invoice invoice =this.modelMapperService.forRequest().map(event, Invoice.class);
		GetCarResponse response= carServiceClient.getByCarId(event.getCarId());
		invoice.setDailyPrice(event.getDailyPrice());
		invoice.setTotalPrice(event.getTotalPrice());
		invoiceService.createInvoice(invoice);
		
		
		LOGGER.info("Invoice created consume : {} ", event.getCarId());
	
		
	}
}