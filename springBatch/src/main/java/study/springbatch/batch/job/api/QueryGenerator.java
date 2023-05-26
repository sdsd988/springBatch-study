package study.springbatch.batch.job.api;

import org.springframework.jdbc.core.JdbcTemplate;
import study.springbatch.batch.domain.ProductVO;
import study.springbatch.batch.rowmapper.ProductRowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryGenerator {

    private static ProductVO[] getProductList(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ProductVO> productList = jdbcTemplate.query("select type from product group by type", new ProductRowMapper() {

            @Override
            public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ProductVO.builder().type(rs.getString("type")).build();
            }
        });

        return productList.toArray(new ProductVO[]{});
    }

    public static Map<String, Object> getParameterForQuery(String parameter, String value) {

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(parameter,value);

        return parameters;
    }
}
