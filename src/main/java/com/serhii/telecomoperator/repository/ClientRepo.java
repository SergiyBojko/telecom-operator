package com.serhii.telecomoperator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serhii.telecomoperator.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
