package com.insignia.assessment.repository;

import com.insignia.assessment.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
