package study.springbatch.batch.classifier;


import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;
import study.springbatch.batch.domain.ApiRequestVO;

import java.util.HashMap;
import java.util.Map;

public class WriteClassifier<C, T> implements Classifier<C,T> {
    
    private Map<String, ItemWriter<ApiRequestVO>> writerMap = new HashMap<>();
    
    
    @Override
    public T classify(C classifiable) {

        return (T) writerMap.get(((ApiRequestVO) classifiable).getProductVO().getType());

    }

    public void setWriterMap(Map<String, ItemWriter<ApiRequestVO>> writerMap) {
        this.writerMap = writerMap;
    }

}
