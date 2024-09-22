package com.invoiceservice.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="carId")
	private String carId;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="modelName")
	private String modelName;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	@Column(name="rentedForDays")
	private int rentedForDays;
	
	@Column(name="rentedDate")
	private LocalDate rentedDate;
}
