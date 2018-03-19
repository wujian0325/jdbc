package com.wj.demo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * njdatanew日志记录数据源配置
 * created 2018-01-22 15:40
 *
 * @author 吴健
 */
@Configuration
@MapperScan(basePackages = {
        "com.wj.demo.domain.sqlserver.mapper",
        "com.wj.demo.domain.sqlserver.mapper"
}, sqlSessionFactoryRef = "njdatanewSqlSessionFactoryBean")
public class SpringNjdataNewDataSourceConfig {

    @Bean(name = "njdatanewDataSource")
    @ConfigurationProperties(prefix = "jdbc.njdatanew")
    public DataSource userDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "njdatanewDSTXM")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("njdatanewDataSource") DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    /**
     * MyBatis Configurations
     */
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean(name = "njdatanewSqlSessionFactoryBean")
    public SqlSessionFactoryBean userDSSqlSessionFactory(@Qualifier("njdatanewDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage(
                "com.wj.demo.domain.sqlserver.mapper"
        );
        sqlSessionFactory.setMapperLocations(
                ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                        .getResources("classpath:com/wj/demo/domain/sqlserver/mapper/*.xml"));
        return sqlSessionFactory;
    }

}
