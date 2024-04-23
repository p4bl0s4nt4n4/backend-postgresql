package cl.psantana.backend_postgresql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.psantana.backend_postgresql.entities.ChargePointEntity;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePointEntity, Long> {}
