package org.example;

import java.util.List;

public class Main {
  private static final String ZOMBIE = "zombie";
  public static void main(String[] args) {
    final Enemy zombieEnemy = new Enemy("zombie", 100, List.of("sword"), new Position(0, 0));
    final EnemyRegistry registry = new EnemyRegistry();

    registry.register(ZOMBIE, zombieEnemy);

    final Enemy zombie1 = registry.spawn(ZOMBIE);
    final Position position1 = new Position(10, 10);
    zombie1.setPosition(position1);
    final Enemy zombie2 = registry.spawn(ZOMBIE);
    final Position position2 = new Position(20, 20);
    zombie2.setPosition(position2);
    zombie2.setWeapons(List.of("long sword"));

    System.out.println(zombie1);
    System.out.println(zombie2);
  }
}
