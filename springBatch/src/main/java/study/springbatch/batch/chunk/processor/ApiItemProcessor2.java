package study.springbatch.batch.chunk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import study.springbatch.batch.domain.ApiRequestVO;
import study.springbatch.batch.domain.ProductVO;

@Component
public class ApiItemProcessor2 implements ItemProcessor<ProductVO, ApiRequestVO> {


    @Override
    public ApiRequestVO process(ProductVO productVO) throws Exception {
        return ApiRequestVO.builder()
                .id(productVO.getId())
                .productVO(productVO)
                .build();
    }


}
