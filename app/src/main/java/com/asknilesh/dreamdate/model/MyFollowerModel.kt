package com.asknilesh.dreamdate.model

data class MyFollowerModel(
  val userName: String,
  val userImage: String,
  var following: Boolean = false,
  val name: String = ""
)

fun getMyFollowersList() = mutableListOf(
  MyFollowerModel(
    userName = "lil_cutie",
    following = true,
    name = "Olivia Smith",
    userImage = "https://images.unsplash.com/photo-1609241728358-53d49c22c01a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "superb_guy",
    following = false,
    name = "Emma Jones",
    userImage = "https://images.unsplash.com/photo-1503185912284-5271ff81b9a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "beauty.babe",
    following = true,
    name = "Charlotte Williams",
    userImage = "https://images.unsplash.com/photo-1624001051001-8287dfecc07c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "ghost_rider",
    following = false,
    name = "Amelia Williams",
    userImage = "https://images.unsplash.com/photo-1613287673032-e7129d1bcda4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "instafreack",
    following = true,
    name = "Ava Brown",
    userImage = "https://images.unsplash.com/photo-1623930731024-c57e19ea83f6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "romantic_boy",
    following = false,
    name = "Sophia Davies",
    userImage = "https://images.unsplash.com/photo-1613257033999-4249e8a9158d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "dilokirani",
    following = true,
    name = "Isabella Evans",
    userImage = "https://images.unsplash.com/photo-1623930354140-03c5ae186bf2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Njl8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "girlyapa",
    following = false,
    name = "Mia Thomas",
    userImage = "https://images.unsplash.com/photo-1620523065180-0773a2aebea7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzF8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  MyFollowerModel(
    userName = "lil_cutie",
    following = true,
    name = "Evelyn Adams",
    userImage = "https://images.unsplash.com/photo-1623931080811-2509a9963611?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "superb_guy",
    following = false,
    name = "Harper Allen",
    userImage = "https://images.unsplash.com/photo-1624441725393-60629167a2d1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODB8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "beauty.babe",
    following = true,
    name = "Raya Anderson",
    userImage = "https://images.unsplash.com/photo-1532308787675-c690de917ec9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "ghost_rider",
    following = false,
    name = "Elia Armstrong",
    userImage = "https://images.unsplash.com/photo-1620523233793-1b1379f397c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTAxfHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "instafreack",
    following = true,
    name = "Jaylani Bailey",
    userImage = "https://images.unsplash.com/photo-1604004555489-723a93d6ce74?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTA5fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "romantic_boy",
    following = false,
    name = "Zayla Barker",
    userImage = "https://images.unsplash.com/photo-1614275696879-1759006c4e6e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE1fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "dilokirani",
    following = true,
    name = "Navy Barnes",
    userImage = "https://images.unsplash.com/photo-1616565397499-39bc8abaaa7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE5fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  MyFollowerModel(
    userName = "girlyapa",
    following = false,
    name = "Nyra Bennett",
    userImage = "https://images.unsplash.com/photo-1612751747121-543c0be0f58f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI1fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),

  )