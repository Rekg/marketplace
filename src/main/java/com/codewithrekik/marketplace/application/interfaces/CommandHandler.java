package com.codewithrekik.marketplace.application.interfaces;

public interface CommandHandler<T> {
    void handle(T command);
}