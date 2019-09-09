package com.company.VideoGameCollectionDaoRichardFenix.model;

import java.util.Objects;

public class Game {
    private int game_id;
    private int console_id;
    private int publisher_id;
    private int type_id;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return game_id == game.game_id &&
                console_id == game.console_id &&
                publisher_id == game.publisher_id &&
                type_id == game.type_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, console_id, publisher_id, type_id);
    }

}
