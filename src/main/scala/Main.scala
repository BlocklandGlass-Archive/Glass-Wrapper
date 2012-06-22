package blocklandglass.wrapper

import akka.actor._
import akka.pattern.ask
import akka.dispatch.Await
import akka.util.Timeout
import akka.util.duration._

class MainActor extends Actor {
	override def preStart() {
		println("hi")
		val authc = {
			implicit val timeout = Timeout(365 days) // We don't want to time out on UI but Akka isn't too happy about that, so this is the best we can do
			Await.result((context.actorFor(context.system / "ui") ? ui.UIGetAuthCredentials).mapTo[ui.UIAuthCredentialRetrievalResult], timeout.duration)
		}
		println(authc)
		context.system.shutdown()
	}

	def receive = {
		case _ =>
	}
}

object Main extends App {
	val system = ActorSystem()

	system.actorOf(Props[ui.console.ConsoleUI], "ui")
	system.actorOf(Props[MainActor], "main")
}