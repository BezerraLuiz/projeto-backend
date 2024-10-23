package com.example.demo.repositories;

import com.example.demo.models.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorRepository extends JpaRepository<JogadorModel, UUID> {
}
