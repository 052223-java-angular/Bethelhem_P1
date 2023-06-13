package com.revature.park.Repositories;

import com.revature.park.Entities.Parks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Transactional
@Repository
public interface ParkRepository extends JpaRepository<Parks, Long> {
    // Custom query methods can be defined here if needed
    Parks findByName(String name);
}

