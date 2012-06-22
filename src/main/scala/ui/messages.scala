package blocklandglass.wrapper.ui

case object UIGetAuthCredentials

sealed trait UIAuthCredentialRetrievalResult
case class UIAuthCredentials(blid: Long, password: String) extends UIAuthCredentialRetrievalResult
case object UIAuthCredentialRetrievalFailed extends UIAuthCredentialRetrievalResult