package com.springboot.microservices.faculityservice.feignClientService;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "courseMicroservice-feign-client")
public class CourseServiceLoadBalancerConfiguration
{
    @LoadBalanced
    @Bean
    public Feign.Builder courseServiceFeignBuilder()
    {
        return Feign.builder();
    }
}
