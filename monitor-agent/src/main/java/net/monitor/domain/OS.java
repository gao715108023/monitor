package net.monitor.domain;

/**
 * @author gaochuanjun
 * @since 15/4/15
 */
public enum OS {

  /**
   * LINUX
   */
  LINUX(0),
  /**
   * WINDOWS
   */
  WINDOWS(1),
  /**
   * MAC_OS
   */
  MAC_OS(2),
  /**
   * MAC_OS_X
   */
  MAC_OS_X(3),
  /**
   * OTHERS
   */
  OTHERS(-1);

  private final int os;

  OS(int os) {
    this.os = os;
  }

  public static OS findOS(int os) {
    switch (os) {
      case 0:
        return LINUX;
      case 1:
        return WINDOWS;
      case 2:
        return MAC_OS;
      case 3:
        return MAC_OS_X;
      default:
        return OTHERS;
    }
  }

  public int getOS() {
    return os;
  }
}
