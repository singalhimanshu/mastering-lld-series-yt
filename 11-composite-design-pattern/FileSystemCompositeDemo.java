import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
  void print(String indent);

  int getSize();
}

class File implements FileSystemItem {
  private final String name;
  private final int size;

  public File(String name, int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void print(String indent) {
    System.out.println(indent + "File: " + name + " (" + size + "KB)");
  }

}

class Directory implements FileSystemItem {
  private final String name;
  private final List<FileSystemItem> children;

  public Directory(final String name) {
    children = new ArrayList<>();
    this.name = name;
  }

  public void mkdir(FileSystemItem item) {
    children.add(item);
  }

  @Override
  public void print(String indent) {
    System.out.println(indent + "Directory: " + this.name);
    for (FileSystemItem item : children) {
      item.print(indent + " ");
    }
  }

  @Override
  public int getSize() {
    int total = 0;
    for (FileSystemItem fileSystemItem : children) {
      total += fileSystemItem.getSize();
    }
    return total;
  }
}

public class FileSystemCompositeDemo {
  public static void main(String[] args) {
    final File file1 = new File("resume.pdf", 120);
    final File file2 = new File("dp.jpg", 900);
    final File file3 = new File("video.mp4", 12000);

    final Directory docs = new Directory("docs");
    docs.mkdir(file1);

    final Directory images = new Directory("image");
    images.mkdir(file2);

    final Directory videos = new Directory("videos");
    videos.mkdir(file3);

    final Directory home = new Directory("home");
    home.mkdir(docs);
    home.mkdir(images);
    home.mkdir(videos);

    home.print("");
    System.out.println("Total size: " + home.getSize() + " KB");
  }
}
