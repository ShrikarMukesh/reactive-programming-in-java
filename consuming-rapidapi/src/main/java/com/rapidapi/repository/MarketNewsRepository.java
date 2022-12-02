package com.rapidapi.repository;

import com.rapidapi.api.request.MarketNewRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketNewsRepository extends JpaRepository<MarketNewRequest,Long> {

}
