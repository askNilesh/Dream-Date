package com.asknilesh.dreamdate.navigation

enum class DreamDateScreens {
  INTRO_SCREEN,
  LOGIN_SCREEN,
  ENTER_PHONE_NUMBER_SCREEN,
  VERIFY_OTP_SCREEN,
  GENDER_SELECTION_SCREEN,
  SIGNUP_SCREEN,
  HOME_SCREEN,
  BOOK_DETAILS_SCREEN,
  BOOK_SEARCH_SCREEN;

  companion object {
    fun fromRoute(route: String?): DreamDateScreens =
      when (route?.substringBefore("/")) {
        INTRO_SCREEN.name -> INTRO_SCREEN
        LOGIN_SCREEN.name -> LOGIN_SCREEN
        ENTER_PHONE_NUMBER_SCREEN.name -> ENTER_PHONE_NUMBER_SCREEN
        SIGNUP_SCREEN.name -> SIGNUP_SCREEN
        HOME_SCREEN.name -> HOME_SCREEN
        BOOK_DETAILS_SCREEN.name -> BOOK_DETAILS_SCREEN
        BOOK_SEARCH_SCREEN.name -> BOOK_SEARCH_SCREEN
        else -> throw IllegalArgumentException("$route is not valid route name")
      }
  }
}