package com.asknilesh.dreamdate.model

data class MessageModel(
  val message: String = "",
  val timeStamp: String = "",
  val isOtherUserMessage: Boolean = true,
)

fun getMessageList() = mutableListOf(
  MessageModel(
    message = "There are many variations of passages of Lorem Ipsum available",
    timeStamp = "9:12PM",
    isOtherUserMessage = true
  ),
  MessageModel(
    message = "Lorem Ipsum is simply dummy text ",
    timeStamp = "9:12PM",
    isOtherUserMessage = false
  ),

  MessageModel(
    message = "Hey, how’s it going?",
    timeStamp = "9:12PM",
    isOtherUserMessage = false
  ),
  MessageModel(
    message = "Good, how’ve you been? ",
    timeStamp = "9:12PM",
    isOtherUserMessage = true
  ),
  MessageModel(
    message = "There are many variations of passages of Lorem Ipsum available",
    timeStamp = "9:12PM",
    isOtherUserMessage = true
  ),
  MessageModel(
    message = "Lorem Ipsum is simply dummy text ",
    timeStamp = "9:12PM",
    isOtherUserMessage = false
  ),

  MessageModel(
    message = "Hey, how’s it going?",
    timeStamp = "9:12PM",
    isOtherUserMessage = false
  ),
  MessageModel(
    message = "Good, how’ve you been? ",
    timeStamp = "9:12PM",
    isOtherUserMessage = true
  ),

  )