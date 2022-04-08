package com.miniproject.api.repository;

import com.miniproject.api.entity.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocketRepository extends JpaRepository<Pocket, String> {
}
