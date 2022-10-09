package com.core.logging;

public class FileLogger implements ILogger {

    @Override
    public void log(String data) {
        System.out.println("dosyaya loglandı: " + data);
    }
}
