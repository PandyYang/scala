package pattern_match.case_class_match

// case class 样例类
case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contractName: String, message: String) extends Notification