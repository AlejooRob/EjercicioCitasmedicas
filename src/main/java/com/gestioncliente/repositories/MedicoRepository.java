package com.gestioncliente.repositories;

import com.gestioncliente.models.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
