package com.fam.sur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fam.sur.entity.Surveillance;


@Repository
public interface SurveillanceRepository extends JpaRepository<Surveillance, Long>{

}
