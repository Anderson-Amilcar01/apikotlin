package com.u.apikotlin.repository;

import com.u.apikotlin.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}

