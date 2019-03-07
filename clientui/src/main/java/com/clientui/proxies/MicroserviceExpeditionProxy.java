package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expedition")
public interface MicroserviceExpeditionProxy {

    @PostMapping(path = "/microservice-expedition/addExpedition")
    public void addExpedition(@RequestBody ExpeditionBean expedition);

    @GetMapping(value = "/microservice-expedition/Expedition/{id}")
    public ExpeditionBean getExpeditionById(@PathVariable("id") int id);

    @PutMapping(value = "/microservice-expedition/Expedition")
    public void updateExpedition(@RequestBody ExpeditionBean expedition);

}
