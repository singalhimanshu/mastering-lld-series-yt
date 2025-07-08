class AuthService {
  public boolean isPremiumUser(final String userId) {
    System.out.println("Check is premium user: " + userId);
    return true;
  }
}

class SongLoader {
  public void load(String songId) {
    System.out.println("Loading song: " + songId);
  }
}

class AudioPlayer {
  public void play(final String songId) {
    System.out.println("Playing song: " + songId);
  }
}

public class FacadeBadDesign {
  public static void main(String[] args) {
    // PROBLEMS:
    // - Tight coupling
    // - Hard to maintain or extend
    // - Code duplication in every client
    // - Low readability
    final AuthService authService = new AuthService();
    final String userId = "1234";
    final String songId = "4321";
    if (!authService.isPremiumUser(userId)) {
      System.out.println("Upgrade to premium to play this song.");
      return;
    }

    final SongLoader songLoader = new SongLoader();
    songLoader.load(songId);

    final AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play(songId);
  }
}
