package ru.vladuss.railwayadministrationscisservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vladuss.railwayadministrationscisservice.entity.RailwayAdmins;

import java.util.Optional;

@Repository
public interface RailwayAdminsRepository extends JpaRepository<RailwayAdmins, Long> {

    Optional<RailwayAdmins> findByCodeJa(Long codeJa);
}
