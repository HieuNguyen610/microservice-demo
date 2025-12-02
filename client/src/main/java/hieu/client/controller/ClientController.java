package hieu.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/")
    public String getServices() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service", false);
        String serviceUrl = instanceInfo.getHomePageUrl();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        return "Response from Service: " + responseEntity.getBody();
    }
}
