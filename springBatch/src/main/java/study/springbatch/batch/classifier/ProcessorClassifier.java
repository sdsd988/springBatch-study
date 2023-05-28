package study.springbatch.batch.classifier;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;
import study.springbatch.batch.domain.ApiRequestVO;
import study.springbatch.batch.domain.ProductVO;

import java.util.HashMap;
import java.util.Map;

public class ProcessorClassifier<C, T> implements Classifier<C,T> {

    private Map<String, ItemProcessor<ProductVO, ApiRequestVO>> processorMap = new HashMap<>();


    @Override
    public T classify(C classifiable) {

        return (T) processorMap.get(((ProductVO) classifiable).getType());

    }

    public void setProcessorMap(Map<String, ItemProcessor<ProductVO, ApiRequestVO>> processorMap) {
        this.processorMap = processorMap;
    }

}
