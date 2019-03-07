package com.mproduits.configurations;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfig {


    public Sampler defaultSampler(){
        //ALWAYS_SAMPLE : dit à sleuth de prendre toute les requêtes et de les exporter vers zipkin afin que celui-ci puisse les analyser
        return Sampler.ALWAYS_SAMPLE;
    }
}
