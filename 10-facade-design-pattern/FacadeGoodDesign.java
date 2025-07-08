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

class SpotifyFacade {
  private final AuthService authService;
  private final SongLoader songLoader;
  private final AudioPlayer audioPlayer;

  public SpotifyFacade(AuthService authService, SongLoader songLoader, AudioPlayer audioPlayer) {
    this.authService = authService;
    this.songLoader = songLoader;
    this.audioPlayer = audioPlayer;
  }

  public void playSong(final String userId, final String songId) {
    if (!authService.isPremiumUser(userId)) {
      System.out.println("Upgrade to premium to play this song.");
      return;
    }
    songLoader.load(songId);
    audioPlayer.play(songId);
  }

}

public class FacadeGoodDesign {
  public static void main(String[] args) {
    final AuthService authService = new AuthService();
    final SongLoader songLoader = new SongLoader();
    final AudioPlayer audioPlayer = new AudioPlayer();
    SpotifyFacade spotifyFacade = new SpotifyFacade();
  }
}