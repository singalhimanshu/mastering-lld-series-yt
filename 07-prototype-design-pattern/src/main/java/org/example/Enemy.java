package org.example;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements Prototype<Enemy> {
  private String type;
  private int health;
  private List<String> weapons;
  private Position position;

  public Enemy(String type, int health, List<String> weapons, Position position) {
    this.type = type;
    this.health = health;
    this.weapons = weapons;
    this.position = position;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public List<String> getWeapons() {
    return weapons;
  }

  public void setWeapons(List<String> weapons) {
    this.weapons = weapons;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public Enemy clone() {
    return new Enemy(
        this.type,
        this.health,
        new ArrayList<>(this.weapons),
        new Position(this.position.getX(), this.position.getY()));
  }

  @Override
  public String toString() {
    return "Enemy{" +
            "type='" + type + '\'' +
            ", health=" + health +
            ", weapons=" + weapons +
            ", position=" + position +
            '}';
  }
}
