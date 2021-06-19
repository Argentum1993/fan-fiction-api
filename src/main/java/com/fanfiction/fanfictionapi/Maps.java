package com.fanfiction.fanfictionapi;

public class Maps {
  public static final String VERSION_API = "/api/v1";

  // Controllers
  public static final String AUTH = VERSION_API + "/auth";
  public static final String FANFIC = VERSION_API + "/fanfic";

  // Config
  public static final String AUTH_LOGIN = AUTH + "/login";
  public static final String AUTH_SING_UP = AUTH + "/sign_up";
  public static final String[] ALLOWED_ALL_PATHS = new String[] {AUTH_LOGIN, AUTH_SING_UP};
}
