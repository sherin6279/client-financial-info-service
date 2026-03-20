package com.insignia.assessment.service;

import com.insignia.assessment.model.*;
import com.insignia.assessment.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientService {
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public Client save(ClientRequest req) {

        Client client = new Client();
        client.setClientName(req.clientName());
        client.setCreatedAt(LocalDateTime.now());

        ContactDetails cd = new ContactDetails();
        cd.setEmail(req.contactDetails().email());
        cd.setPhone(req.contactDetails().phone());

        Address addr = new Address();
        addr.setUnitNumber(req.contactDetails().address().unitNumber());
        addr.setStreet(req.contactDetails().address().street());
        addr.setCity(req.contactDetails().address().city());
        addr.setState(req.contactDetails().address().state());
        addr.setPostcode(req.contactDetails().address().postcode());
        addr.setCountry(req.contactDetails().address().country());

        cd.setAddress(addr);
        client.setContactDetails(cd);

        InvestmentGoal goal = new InvestmentGoal();
        goal.setGoalName(req.investmentGoal().goalName());
        goal.setTargetAmount(req.investmentGoal().targetAmount());
        goal.setPeriodYears(req.investmentGoal().periodYears());
        goal.setInitialInvestmentAmount(req.investmentGoal().initialInvestmentAmount());

        client.setInvestmentGoal(goal);

        Beneficiary benificiary = new Beneficiary();
        benificiary.setName(req.beneficiary().name());
        benificiary.setRelation(req.beneficiary().relation());

        client.setBeneficiary(benificiary);

        return repo.save(client);
    }
}
