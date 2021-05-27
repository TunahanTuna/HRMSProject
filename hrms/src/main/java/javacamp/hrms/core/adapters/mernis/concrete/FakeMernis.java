package javacamp.hrms.core.adapters.mernis.concrete;

import org.springframework.stereotype.Component;

import javacamp.hrms.core.adapters.mernis.FakePerson;
import javacamp.hrms.core.adapters.mernis.service.FakeCheckService;

@Component
public class FakeMernis implements FakeCheckService {
    

    @Override
    public boolean validate(FakePerson FakePerson) {
       
        return true;
    }
}