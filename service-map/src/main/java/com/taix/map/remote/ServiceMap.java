package com.taix.map.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-map")
public interface ServiceMap {

}
