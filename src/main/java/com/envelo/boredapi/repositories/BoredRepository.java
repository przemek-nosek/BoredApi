package com.envelo.boredapi.repositories;

import com.envelo.boredapi.model.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoredRepository extends JpaRepository<ActivityEntity, String> {
}
