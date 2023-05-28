package study.springbatch.batch.chunk.writer;

import org.springframework.batch.item.ItemWriter;
import study.springbatch.batch.domain.ApiRequestVO;
import study.springbatch.batch.domain.ApiResponseVO;
import study.springbatch.service.AbstractApiService;

import java.util.List;

public class ApiItemWriter2 implements ItemWriter<ApiRequestVO> {
    private final AbstractApiService apiService;

    public ApiItemWriter2(AbstractApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVO> list) throws Exception {
        ApiResponseVO responseVO = apiService.service(list);
        System.out.println("responseVO =  " + responseVO );
    }
}
