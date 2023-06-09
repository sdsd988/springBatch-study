package study.springbatch.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import study.springbatch.batch.domain.ApiInfo;
import study.springbatch.batch.domain.ApiResponseVO;

@Service
public class ApiService3 extends AbstractApiService {
    @Override
    protected ApiResponseVO doApiService(RestTemplate restTemplate, ApiInfo.ApiInfoBuilder apiInfo) {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8083/api/product/3", apiInfo, String.class);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        ApiResponseVO apiResponseVO = ApiResponseVO.builder().status(statusCodeValue).msg(responseEntity.getBody()).build();
        return apiResponseVO;


    }
}
