package example.jbot.slack

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["me.ramswaroop.jbot", "example.jbot"])
class JBotApplication

fun main(args: Array<String>) {
    SpringApplication.run(JBotApplication::class.java, *args)
}