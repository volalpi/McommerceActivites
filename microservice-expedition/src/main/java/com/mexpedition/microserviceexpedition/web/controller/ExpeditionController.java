package com.mexpedition.microserviceexpedition.web.controller;

import com.mexpedition.microserviceexpedition.dao.ExpeditionDao;
import com.mexpedition.microserviceexpedition.model.Expedition;
import com.mexpedition.microserviceexpedition.web.exceptions.ExpeditionIntrouvableException;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ExpeditionController {
    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping(path = "/addExpedition")
    public ResponseEntity<Void> addExpedition(@RequestBody Expedition expedition) {
        Expedition newExpedition = expeditionDao.save(expedition);
        if (newExpedition == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newExpedition.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/Expedition/{id}")
    public Expedition getExpeditionById(@PathVariable int id) throws ExpeditionIntrouvableException {

        Expedition expedition = expeditionDao.findById(id);

        if (expedition == null) throw new ExpeditionIntrouvableException("L'expédition avec l'id " + id + " est introuvable");

        return expedition;
    }

    @PutMapping(value = "/Expedition")
    public void updateExpedition(@RequestBody Expedition expedition) {
        expeditionDao.save(expedition);
    }

}
