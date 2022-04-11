package ru.akonyaev.camunda.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.camunda.bpm.engine.impl.cfg.IdGenerator
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@ConfigurationProperties(prefix = "camunda.datasource")
class JdbcCamundaProperties : HikariConfig()

@Configuration
@EnableConfigurationProperties(JdbcCamundaProperties::class)
class CamundaConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingBean(name = ["camundaBpmDataSource"])
    fun camundaBpmDataSource(jdbcCamundaProperties: JdbcCamundaProperties): DataSource =
        HikariDataSource(jdbcCamundaProperties)

    @Bean
    @ConditionalOnMissingBean
    fun transactionManager(
        @Qualifier("camundaBpmDataSource") dataSource: DataSource
    ): PlatformTransactionManager = DataSourceTransactionManager(dataSource)

    @Bean
    @ConditionalOnMissingBean
    fun idGenerator(): IdGenerator = StrongUuidGenerator()
}
