package com.laregn.pizzariadakrida.crud.pizzariadakrida.repositories;

import com.laregn.pizzariadakrida.crud.pizzariadakrida.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
