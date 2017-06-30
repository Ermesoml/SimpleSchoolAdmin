package br.ufg.inf;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Classe de Configuração de Beans
 * @author ygors
 * 
 */
@Configuration
public class Config {

    /**
     * Spring liquibase.
     * Responsável por migração de banco
     *
     * @param dataSource the data source
     * @return the spring liquibase
     */
    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/db.changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
