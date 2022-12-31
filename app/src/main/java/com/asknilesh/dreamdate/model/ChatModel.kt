package com.asknilesh.dreamdate.model

data class ChatModel(
  val userName: String = "",
  val message: String = "",
  val unReadMessage: String = "",
  val userImage: String = "",
  val lastMessage: String = "",
)

fun getChatList() = mutableListOf(
  ChatModel(
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    unReadMessage = "5",
    userName = "Olivia Smith",
    userImage = "https://images.unsplash.com/photo-1609241728358-53d49c22c01a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    unReadMessage = "12",
    userName = "superb_guy",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1503185912284-5271ff81b9a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    unReadMessage = "10",
    userName = "Charlotte Williams",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1624001051001-8287dfecc07c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Amelia Williams",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1613287673032-e7129d1bcda4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Ava Brown",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1623930731024-c57e19ea83f6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Sophia Davies",
    unReadMessage = "10",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1613257033999-4249e8a9158d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Isabella Evans",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1623930354140-03c5ae186bf2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Njl8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Mia Thomas",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1620523065180-0773a2aebea7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzF8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  ChatModel(
    userName = "Evelyn Adams",
    unReadMessage = "10",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1623931080811-2509a9963611?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Harper Allen",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1624441725393-60629167a2d1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODB8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Raya Anderson",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1532308787675-c690de917ec9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Elia Armstrong",
    unReadMessage = "10",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1620523233793-1b1379f397c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTAxfHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Jaylani Bailey",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1604004555489-723a93d6ce74?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTA5fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Zayla Barker",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1614275696879-1759006c4e6e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE1fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Navy Barnes",
    unReadMessage = "10",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1616565397499-39bc8abaaa7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE5fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  ChatModel(
    userName = "Nyra Bennett",
    lastMessage = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    userImage = "https://images.unsplash.com/photo-1612751747121-543c0be0f58f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI1fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
)