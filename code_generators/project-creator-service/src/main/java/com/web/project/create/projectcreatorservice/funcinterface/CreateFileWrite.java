package com.web.project.create.projectcreatorservice.funcinterface;

@FunctionalInterface
public interface CreateFileWrite<Q, R, S, T, U, V> {

    V apply(Q q, R r, S s, T t, U u);
}
