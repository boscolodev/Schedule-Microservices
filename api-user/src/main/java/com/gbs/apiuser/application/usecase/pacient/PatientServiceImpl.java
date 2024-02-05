package com.gbs.apiuser.application.usecase.pacient;

import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PatientResponse;
import com.gbs.apiuser.infrastructure.pacient.PacientCrudService;
import com.gbs.apiuser.model.entities.Address;
import com.gbs.apiuser.model.entities.Pacient;
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
public class PatientServiceImpl implements PatientService {

    private final PacientCrudService service;
    private final RestApi restApi;

    @Override
    public PatientResponse findById(Long id) {
        return Mapper.converte(service.findById(id), PatientResponse.class);
    }

    @Override
    public Page<PatientResponse> findAll(Pageable pageable) {
        return service.findAll(pageable).map(row -> Mapper.converte(row, PatientResponse.class));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public PatientResponse update(Long id, PacientRequest request) {

        Pacient pacient = service.findById(id);
        Mapper.copyEntity(request, pacient);
        pacient.setAddress(createFullAddress(request.getCep(), request.getNumero(), request.getEnderecoObservacao()));

        if (!Objects.equals(service.findByEmail(request.getEmail()).getId(), id)) {
            validateDatabaseEmailIntegrity(request.getEmail());
        }

        return Mapper.converte(service.save(pacient), PatientResponse.class);

    }

    @Override
    public PatientResponse save(PacientRequest request) {
        validateDatabaseEmailIntegrity(request.getEmail());
        Pacient pacient = createFullPacient(request);

        return Mapper.converte(service.save(pacient), PatientResponse.class);
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

    private Pacient createFullPacient(PacientRequest request){
        Pacient pacient = Mapper.converte(request, Pacient.class);
        Address address = createFullAddress(request.getCep(), request.getNumero(), request.getEnderecoObservacao());
        pacient.setAddress(address);

        return pacient;
    }
}
