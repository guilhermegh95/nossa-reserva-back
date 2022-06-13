package com.nossareserva.repositories;

import com.nossareserva.model.CondominioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<CondominioModel, Long> {
}
