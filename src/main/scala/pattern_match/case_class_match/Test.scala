package pattern_match.case_class_match

object Test {

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! message is: $message"
      case VoiceRecording(name, link) =>
        s"You received a vioce Recording from $name! Click the link to hear it: $link"
    }
  }

  def main(args: Array[String]): Unit = {
    val someSms = SMS("12345", "Are u there?")
    val someEmail = Email("dida", "rainy", "remember take your umbrellel")
    val voiceRecording = VoiceRecording("hi", "/Pandy/record/123")

    println(showNotification(someSms))
    println(showNotification(someEmail))
    println(showNotification(voiceRecording))


    // pattern guard
    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
          "You got an email from special someone!"
        case SMS(number, _) if importantPeopleInfo.contains(number) =>
          "You got an SMS from special someone!"
        case other =>
          showNotification(other) // nothing special, delegate to our original showNotification function
      }
    }

    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

    val someSms2 = SMS("867-5309", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println(showImportantNotification(someSms2, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))
  }

}
