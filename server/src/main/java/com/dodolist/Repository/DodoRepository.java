package com.dodolist.Repository;

import com.dodolist.Entity.DodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DodoRepository extends JpaRepository<DodoEntity, Long> {
}
