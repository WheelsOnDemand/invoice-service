package com.invoiceservice.app.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService {
	
		private ModelMapper modelMapper;

		@Override
		public ModelMapper forResponse() {
			this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
			return this.modelMapper;
		}

		@Override
		public ModelMapper forRequest() {
			this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
			return this.modelMapper;

		}

	}