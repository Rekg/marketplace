package com.codewithrekik.marketplace.application.interfaces;

public interface QueryHandler<TQuery, TResult> {
    TResult handle(TQuery query);
}