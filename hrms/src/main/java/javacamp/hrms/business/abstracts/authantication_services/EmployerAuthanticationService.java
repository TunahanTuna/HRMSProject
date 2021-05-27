package javacamp.hrms.business.abstracts.authantication_services;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.dtos.RegisterForEmployerDto;

public interface EmployerAuthanticationService {
    Result register(RegisterForEmployerDto registerForEmployerDto);

}
