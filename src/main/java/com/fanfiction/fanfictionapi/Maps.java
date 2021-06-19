package com.fanfiction.fanfictionapi;

import liquibase.pro.packaged.L;

public class Maps {
  public static final String VERSION_API = "/api/v1";

  // Controllers
  public static final String AUTH = VERSION_API + "/auth";
  public static final String FANFIC = VERSION_API + "/fanfic";


  // Config allowed endpoints
  public static final String LOGIN = "/login";
  public static final String SING_UP = "/sign_up";

  public static final String FULL_MAP_LOGIN = AUTH + LOGIN;
  public static final String FULL_MAP_SING_UP = AUTH + SING_UP;
  public static final String[] ALLOWED_ALL_PATHS = new String[] {FULL_MAP_LOGIN, FULL_MAP_SING_UP};
}
