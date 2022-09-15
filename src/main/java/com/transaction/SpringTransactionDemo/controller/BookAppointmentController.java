package com.transaction.SpringTransactionDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.SpringTransactionDemo.controller.dto.AppointmentFormDto;
import com.transaction.SpringTransactionDemo.service.BookAppointmentService;

@RestController
public class BookAppointmentController {

	@Autowired
	private BookAppointmentService bookAppointmentService;
	
	@PostMapping("/book")
	public String bookAppointment(@RequestBody AppointmentFormDto appointmentFormDto) {
		return bookAppointmentService.bookAppointment(appointmentFormDto);
		
	}
}
