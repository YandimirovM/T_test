package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
