package study.springbatch.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import study.springbatch.batch.domain.ApiInfo;
import study.springbatch.batch.domain.ApiRequestVO;
import study.springbatch.batch.domain.ApiResponseVO;

import java.io.IOException;
import java.util.List;

public abstract class AbstractApiService {

    public ApiResponseVO service(List<? extends ApiRequestVO> apiRequest){


        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.errorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        }).build();

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ApiInfo.ApiInfoBuilder apiInfo = ApiInfo.builder().apiRequestList(apiRequest);

        return doApiService(restTemplate, apiInfo);
    }

    protected abstract ApiResponseVO doApiService(RestTemplate restTemplate, ApiInfo.ApiInfoBuilder apiInfo);
}
