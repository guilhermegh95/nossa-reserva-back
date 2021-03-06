package com.nossareserva.repositories;

import com.nossareserva.model.AreaComumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaComumRepository extends JpaRepository<AreaComumModel, Long> {
}
