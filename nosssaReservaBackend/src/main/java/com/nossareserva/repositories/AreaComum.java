package com.nossareserva.repositories;

import com.nossareserva.AreaComumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaComum extends JpaRepository<AreaComumModel, Long> {
}
