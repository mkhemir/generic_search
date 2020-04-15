package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * Spring Data JPA repository for the Device entity.
 */
@SuppressWarnings("unused")
public interface DeviceDataRepository extends JpaRepository<Device,Long>, JpaSpecificationExecutor<Device> {

}