package com.dio_class.devweek.repo;

import com.dio_class.devweek.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo extends JpaRepository<Incidencia, Long> {
}
