package study.springbatch.batch.chunk.processor;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import study.springbatch.batch.domain.Product;
import study.springbatch.batch.domain.ProductVO;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {


    @Override
    public Product process(ProductVO item) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(item, Product.class);
        return product;
    }
}
