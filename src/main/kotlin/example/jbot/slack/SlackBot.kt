package example.jbot.slack

import me.ramswaroop.jbot.core.common.Controller
import me.ramswaroop.jbot.core.common.JBot
import me.ramswaroop.jbot.core.slack.Bot
import me.ramswaroop.jbot.core.slack.models.Event
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.web.socket.WebSocketSession

private val log = KotlinLogging.logger {}

@JBot
@Profile("slack")
class SlackBot : Bot() {

    @Value("\${slackBotToken}")
    private val slackToken: String? = null

    override fun getSlackToken(): String {
        return slackToken!!
    }

    override fun getSlackBot(): Bot {
        return this
    }

    @Controller(pattern = "(911)", next = "confirmSeverity")
    fun startIncident(session: WebSocketSession?, event: Event?) {
        log.info("Starting incident")
        startConversation(event, "confirmSeverity") // start conversation
        reply(session, event, "Starting an incident. What's the severity?")
    }

    /**
     * This method will be invoked after [SlackBot.startIncident].
     *
     * @param session
     * @param event
     */
    @Controller()
    fun confirmSeverity(session: WebSocketSession?, event: Event) {
        reply(session, event, "Severity set to: ${event.text}")
        stopConversation(event)
    }
}