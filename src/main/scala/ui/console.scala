package blocklandglass.wrapper.ui.console

import blocklandglass._
import wrapper.ui._

import akka.actor._

import jline.ConsoleReader

/**
  * Console UI implementation, to use, create actor as /ui
  */
class ConsoleUI extends Actor {
	def readLong(console: ConsoleReader, message: String = ""): Long = try {
		console.readLine(message).toLong
	} catch {
		case _: NumberFormatException => readLong(console, message)
	}

	def receive = {
		case UIGetAuthCredentials =>
			val console = new ConsoleReader
			val blid = readLong(console, "BL_ID: ")
			val password = console.readLine("Password: ", '*')
			sender ! UIAuthCredentials(blid, password.mkString)
	}
}