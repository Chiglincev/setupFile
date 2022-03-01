package ru.chpetr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        File src = new File("E://Games/src");
            createCatalog(src);
        File res = new File("E://Games/res");
            createCatalog(res);
        File savegames = new File("E://Games/savegames");
            createCatalog(savegames);
        File temp = new File("E://Games/temp");
            createCatalog(temp);
        File main = new File("E://Games/src/main");
            createCatalog(main);
        File test = new File("E://Games/src/test");
            createCatalog(test);
        File fileMain = new File("E://Games/src/main", "Main.java");
            createFile(fileMain);
        File fileUtils = new File("E://Games/src/main", "Utils.java");
            createFile(fileUtils);
        File drawables = new File("E://Games/res/drawables");
            createCatalog(drawables);
        File vectors = new File("E://Games/res/vectors");
            createCatalog(vectors);
        File icons = new File("E://Games/res/icons");
            createCatalog(icons);
        File fileTemp = new File("E://Games/temp", "temp.txt");
            createFile(fileTemp);

        try (FileWriter writer = new FileWriter(fileTemp, false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void createCatalog(File name) {
        if (name.mkdir()) {
            log.append("Каталог создан: " + name + "\n");
        } else {
            log.append("Каталог не создан: " + name + "\n");
        }
    }

    static void createFile(File name) {
        try {
            if (name.createNewFile()) {
                log.append("Файл создан: " + name + "\n");
            }
        } catch (IOException e) {
            log.append("Не удалось создать файл " + name + ": " + e.getMessage() + "\n");
        }
    }
}
