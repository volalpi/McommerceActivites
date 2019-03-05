package com.mexpedition.microserviceexpedition.dao;

import com.mexpedition.microserviceexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dida on 3/5/19.
 */
@Repository
public interface ExpeditionDao extends JpaRepository<Expedition, Integer> {
    Expedition findById(int id);
}
