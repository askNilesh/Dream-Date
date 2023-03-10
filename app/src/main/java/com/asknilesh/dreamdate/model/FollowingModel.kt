package com.asknilesh.dreamdate.model

class FollowingModel (
  val userName: String,
  val userImage: String,
  val totalFollower: String,
  val liveUserCount: String,
  val posterImage: String,
  val isLive : Boolean,
)

fun getFollowingList() =
  mutableListOf(
    FollowingModel(
      userName = "lil_cutie",
      totalFollower = "12K followers",
      liveUserCount = "3.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1484800089236-7ae8f5dffc8e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Z2lybCUyMGJhY2t8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "superb_guy",
      totalFollower = "12K followers",
      liveUserCount = "13.8K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1541260894924-7ff059b93d54?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1527973750241-88d016dd9631?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGJhY2t8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "beauty.babe",
      totalFollower = "10K followers",
      liveUserCount = "22.8K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1621184455862-c163dfb30e0f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1624488438878-8f0b39de307a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "ghost_rider",
      totalFollower = "18K followers",
      liveUserCount = "20K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1621184455862-c163dfb30e0f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1614888773670-c6241b01f8aa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "instafreack",
      totalFollower = "50K followers",
      liveUserCount = "20.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1626818590242-5a5f27ee3971?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1520310809185-5cc119cf8b08?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
    ),
    FollowingModel(
      userName = "romantic_boy",
      totalFollower = "50K followers",
      liveUserCount = "20.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1629189858155-9eb2649ec778?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1612272361525-a50a032ea9c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjF8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "dilokirani",
      totalFollower = "100K followers",
      liveUserCount = "22K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1503185912284-5271ff81b9a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1619855515064-d32bc5e68b2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "girlyapa",
      totalFollower = "10K followers",
      liveUserCount = "44K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1502219684198-fa9b5164d9d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1478118903267-73d6cc9a2ce0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "lil_cutie",
      totalFollower = "12K followers",
      liveUserCount = "3.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1526335312770-53f81826be2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzB8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "superb_guy",
      totalFollower = "12K followers",
      liveUserCount = "22K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1541260894924-7ff059b93d54?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1591369376214-b9f91924f10d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "beauty.babe",
      totalFollower = "10K followers",
      liveUserCount = "1K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1621184455862-c163dfb30e0f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1527631746610-bca00a040d60?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "ghost_rider",
      totalFollower = "18K followers",
      liveUserCount = "20K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1621184455862-c163dfb30e0f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1530136163523-12e48a0a192c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzh8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "instafreack",
      totalFollower = "50K followers",
      liveUserCount = "20.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1626818590242-5a5f27ee3971?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1528237074387-90c50df511e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDF8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "romantic_boy",
      totalFollower = "50K followers",
      liveUserCount = "20.8K",
      isLive = true,
      userImage = "https://images.unsplash.com/photo-1629189858155-9eb2649ec778?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1619107096537-d9f3079fee1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDR8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "dilokirani",
      totalFollower = "100K followers",
      liveUserCount = "30K",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1503185912284-5271ff81b9a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1513142084143-6747a6cdeaab?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDh8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),
    FollowingModel(
      userName = "girlyapa",
      totalFollower = "10K followers",
      liveUserCount = "4M",
      isLive = false,
      userImage = "https://images.unsplash.com/photo-1502219684198-fa9b5164d9d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
      posterImage = "https://images.unsplash.com/photo-1490945284861-4103094cc827?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTF8fGdpcmwlMjBiYWNrfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    ),

    )