package com.user.aggregation_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AggregationService {



}


//public String getBucketIdAndMenu(){
//   ResponseEntity<String> menuResponse = restTemplate.getForEntity("http://localhost:8083/api/v1/menu", String.class);
//   ResponseEntity<String> cartResponse = restTemplate.getForEntity("http://localhost:8082/api/v1/bucket", String.class);
//}



//@Service
//public class AggregationService {
//
//   private final RestTemplate restTemplate;
//
//   @Autowired
//   public AggregationService(RestTemplate restTemplate) {
//      this.restTemplate = restTemplate;
//   }
//
//   public String fetchAndAggregateData() {
//      ResponseEntity<String> menuResponse = restTemplate.getForEntity("http://menu-service/api/v1/menu", String.class);
//      ResponseEntity<String> cartResponse = restTemplate.getForEntity("http://cart-service/api/v1/cart", String.class);
//
//      // Проверка на успешные статусы ответов:
//      if (menuResponse.getStatusCode().is2xxSuccessful() && cartResponse.getStatusCode().is2xxSuccessful()) {
//         return menuResponse.getBody() + " " + cartResponse.getBody();
//      } else {
//         // Обработка ошибок
//         return "Error fetching data";
//      }
//   }
//}

