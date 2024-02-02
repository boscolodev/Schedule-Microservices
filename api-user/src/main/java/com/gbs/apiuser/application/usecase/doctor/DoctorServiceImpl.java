package com.gbs.apiuser.application.usecase.doctor;

import com.gbs.apiuser.api.dto.doctor.DoctorRequest;
import com.gbs.apiuser.api.dto.doctor.DoctorResponse;
import com.gbs.apiuser.infrastructure.doctor.DoctorCrudService;
import com.gbs.apiuser.model.entities.Address;
import com.gbs.apiuser.model.entities.Doctor;
import com.gbs.apiuser.rest.RestApi;
import com.gbs.apiuser.shared.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    private final DoctorCrudService service;
    private final RestApi restApi;

    @Override
    public DoctorResponse findById(Long id) {
        return Mapper.converte(service.findById(id), DoctorResponse.class);
    }

    @Override
    public Page<DoctorResponse> findAll(Pageable pageable) {
        return service.findAll(pageable).map(row -> Mapper.converte(row, DoctorResponse.class));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }


    @Override
    public DoctorResponse update(Long id, DoctorRequest request) {

        Doctor doctor = service.findById(id);
        Mapper.copyEntity(request, doctor);
        doctor.setAddress(createFullAddress(request.getCep(), request.getNumero(), request.getEnderecoObservacao()));

        if (!Objects.equals(service.findByEmail(request.getEmail()).getId(), id)) {
            validateDatabaseEmailIntegrity(request.getEmail());
        }

        return Mapper.converte(service.save(doctor), DoctorResponse.class);

    }

    @Override
    public DoctorResponse save(DoctorRequest request) {
        validateDatabaseEmailIntegrity(request.getEmail());
        Doctor doctor = createFullDoctor(request);

        return Mapper.converte(service.save(doctor), DoctorResponse.class);
    }

    private void validateDatabaseEmailIntegrity(String email){
        if (service.existsEmail(email)) {
            log.error(String.format("Email já cadastrado: %s ", email));
            throw new DataIntegrityViolationException("Erro ao cadastrar usuário, entre em contato com o suporte. Cod: 976431");
        }
    }

    private Address createFullAddress(String cep, String number, String obs) {
        Address address = Mapper.converte(restApi.findCep(cep), Address.class);
        address.setNumero(number);
        address.setObservacao(obs);

        return address;
    }

    private Doctor createFullDoctor(DoctorRequest request){
        Doctor doctor = Mapper.converte(request, Doctor.class);
        Address address = createFullAddress(request.getCep(), request.getNumero(), request.getEnderecoObservacao());
        doctor.setAddress(address);

        return doctor;
    }
}
