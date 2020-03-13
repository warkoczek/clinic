package com.example.clinic.service;

import com.example.clinic.exception.DuplicateUsernameException;
import com.example.clinic.exception.PatientNotFoundException;
import com.example.clinic.model.Address;
import com.example.clinic.model.AddressDTO;
import com.example.clinic.model.Patient;
import com.example.clinic.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService  {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<Patient> retrieveAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> retrievePatientByUsername(String username){

        return patientRepository.findPatientByUsername(username);
    }


    public String addPatient(Patient patient) {

         patientRepository.findPatientByUsername(patient.getUsername())
                .ifPresent( patient1 -> throwDuplicateUsernameException(patient.getUsername()));

        patientRepository.save(patient);

        return patient.getUsername();

    }

    private void throwDuplicateUsernameException(String username) {
        throw new DuplicateUsernameException("Patient with username " + username + " already exists");
    }

    public void removePatientByUsername(String username) {
        patientRepository.deleteById(username);
    }

    public Patient updatePatient(Patient patient) {

        Patient patientToUpdate = patientRepository.findPatientByUsername(patient.getUsername())
                .orElseThrow(()-> new PatientNotFoundException("No such a patient exists"));
        patientRepository.delete(patientToUpdate);
        patientRepository.save(patient);
        return patient;
    }

    public Optional<AddressDTO> retrieveAddressByPatientId(String username){
         Optional<Patient> patientByUsername = patientRepository.findPatientByUsername(username);
        if(patientByUsername.isPresent()) {
            return Optional.ofNullable(convertAddressToAddressDTO(patientByUsername.get().getAddress()));
        }
        return Optional.empty();
    }
    private AddressDTO convertAddressToAddressDTO(Address address){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(address, AddressDTO.class);
    }
}
