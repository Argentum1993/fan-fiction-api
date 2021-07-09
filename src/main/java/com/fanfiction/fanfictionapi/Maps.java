package com.fanfiction.fanfictionapi;

import com.fanfiction.fanfictionapi.controller.FanficController;

public class Maps {
  public static final String VERSION_API = "/api/v1";

  // Controllers
  public static final String AUTH = VERSION_API + "/auth";
  public static final String FANFIC = VERSION_API + "/fanfic";
  public static final String USERS = VERSION_API + "/users";

  // Config allowed endpoints
  public static final String LOGIN = "/login";
  public static final String SING_UP = "/sign_up";

  // Allowed FanficController endpoints
  private static final String FANFIC_ENDPOINT = FANFIC + FanficController.FANFIC_ENDPOINT;
  private static final String RATING_FANFICS_ENDPOINT =
      FANFIC + FanficController.RATING_FANFICS_ENDPOINT;
  private static final String LATEST_FANFICS_ENDPOINT =
      FANFIC + FanficController.LATEST_FANFICS_ENDPOINT;
  private static final String FANFIC_CHAPTERS_ENDPOINT =
      FANFIC + FanficController.FANFIC_CHAPTERS_ENDPOINT;
  private static final String FANFIC_CHAPTER_ENDPOINT =
      FANFIC + FanficController.FANFIC_CHAPTER_ENDPOINT;
  private static final String FANFIC_CHAPTER_NAMES_ENDPOINT =
      FANFIC + FanficController.FANFIC_CHAPTER_NAMES_ENDPOINT;

  public static final String FULL_MAP_LOGIN = AUTH + LOGIN;
  public static final String FULL_MAP_SING_UP = AUTH + SING_UP;
  public static final String[] ALLOWED_ALL_PATHS = new String[] {
      FULL_MAP_LOGIN,
      FULL_MAP_SING_UP,
      FANFIC_ENDPOINT,
      RATING_FANFICS_ENDPOINT,
      LATEST_FANFICS_ENDPOINT,
      FANFIC_CHAPTERS_ENDPOINT,
      FANFIC_CHAPTERS_ENDPOINT,
      FANFIC_CHAPTER_ENDPOINT,
      FANFIC_CHAPTER_ENDPOINT,
      FANFIC_CHAPTER_NAMES_ENDPOINT

  };
}
