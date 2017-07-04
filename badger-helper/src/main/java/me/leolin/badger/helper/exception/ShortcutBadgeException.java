package me.leolin.badger.helper.exception;

public class ShortcutBadgeException extends Exception {
    public ShortcutBadgeException(String message) {
        super(message);
    }

    public ShortcutBadgeException(String message, Exception e) {
        super(message, e);
    }

}
