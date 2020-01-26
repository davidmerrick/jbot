package example.jbot.slack

import me.ramswaroop.jbot.core.common.Controller
import me.ramswaroop.jbot.core.common.EventType.DIRECT_MESSAGE
import me.ramswaroop.jbot.core.common.JBot
import me.ramswaroop.jbot.core.slack.Bot
import me.ramswaroop.jbot.core.slack.models.Event
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.web.socket.WebSocketSession

@JBot
@Profile("slack")
class SlackBot : Bot() {

    @Value("\${slackBotToken}")
    private val slackToken: String? = null

    override fun getSlackToken() = slackToken!!
    override fun getSlackBot() = this

    @Controller(pattern = "^help", events = [DIRECT_MESSAGE])
    fun help(session: WebSocketSession, event: Event) {
        reply(session, event, """
            Available commands:
            `start`: Create an incident
            `status`: Set incident status
            `title`: Set incident title
            `sev`: Set incident severity
        """.trimIndent())
    }
}