package com.william.finance.demo.repository;

import com.william.finance.demo.model.Spends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendsRepository extends JpaRepository<Spends, Long> {
}
