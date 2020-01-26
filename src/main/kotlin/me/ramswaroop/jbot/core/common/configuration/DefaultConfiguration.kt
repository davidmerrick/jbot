package me.ramswaroop.jbot.core.common.configuration

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

private val log = KotlinLogging.logger {}

// Todo: Not sure why, but this class is needed to run the bot. Get rid of it.

@Configuration
class DefaultConfiguration {
    /**
     * @return a new rest template object without any additional configuration if there are no other RestTemplate beans,
     * otherwise user-defined bean will be used
     */
    @ConditionalOnMissingBean
    @Bean
    fun restTemplate(): RestTemplate {
        log.info("There are no any rest template beans defined, creating default rest template...")
        return RestTemplate()
    }
}