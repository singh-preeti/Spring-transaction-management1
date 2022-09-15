package com.transaction.SpringTransactionDemo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.SpringTransactionDemo.controller.dto.AppointmentFormDto;
import com.transaction.SpringTransactionDemo.entity.Appointment;
import com.transaction.SpringTransactionDemo.entity.Patient;
import com.transaction.SpringTransactionDemo.repo.AppointmentRepo;
import com.transaction.SpringTransactionDemo.repo.PatientRepo;

@Service
@Transactional
public class BookAppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private PatientRepo patientRepo;

	public String bookAppointment(AppointmentFormDto appointmentFormDto) {

		Patient patient = new ObjectMapper().convertValue(appointmentFormDto, Patient.class);

		Long patientNumber = patientRepo.save(patient).getPatientNumber();

		System.out.println("Patient saved successfully.");

		Appointment appointment = new Appointment(new Date(System.currentTimeMillis()), 101L, patientNumber);

		Long appointmentNumber = appointmentRepo.save(appointment).getAppointmentNumber();

		return "Appointment Confirmed."+appointmentNumber;
	}

}
