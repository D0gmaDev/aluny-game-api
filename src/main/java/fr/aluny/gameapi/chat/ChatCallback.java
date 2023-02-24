package fr.aluny.gameapi.chat;

import java.util.function.Consumer;

public interface ChatCallback {

    void callback(String value);

    void onError();

    static ChatCallback of(Consumer<String> callback, Runnable error) {
        return new ChatCallback() {
            @Override
            public void callback(String value) {
                callback.accept(value);
            }

            @Override
            public void onError() {
                error.run();
            }
        };
    }

}
