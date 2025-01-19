package hanuri.website;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
@Configuration
public class MybatisConfig {

    /*
    * SqlSessionFactory 빈 생성
    * @param dataSource 데이터베이스 연결을 위한 DataSource 객체
    * @return SqlSessionFactoryBean 객체
    *   그래서 뭐하는건지는 사실 잘 모르겠음;;
    * */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
