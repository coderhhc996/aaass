package com.xjtu.job.store;

<<<<<<< HEAD

import com.google.gson.*;

=======
import com.google.gson.*;
>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2
import com.xjtu.job.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskStore {
    @Value("${todo.store.filename}")
    private String fileName;
    @Value("${env}")
    private String env;
<<<<<<< HEAD

    public List<Task> readTasks() {
        try {
            String contents = new String(Files.readAllBytes(getFile().toPath()));
            Task[] tasks = getGson().fromJson(contents, Task[].class);
            return Arrays.asList(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

=======

    public List<Task> readTasks() {
        try {
            String contents = new String(Files.readAllBytes(getFile().toPath()));
            Task[] tasks = getGson().fromJson(contents, Task[].class);
            return Arrays.asList(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2
    public void writeTasks(List<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(getFile().getAbsolutePath());
            fileWriter.write(getGson().toJson(tasks));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD

    private File getFile() {
        if (env.equals("test")) {
            return new File(getClass().getClassLoader().getResource(fileName).getFile());
        }
        return new File(fileName);
    }

    private Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                        (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>)
                        (localDateTime, typeOfT, context) -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .create();


    }
=======
>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2

    private File getFile() {
        if (env.equals("test")) {
            return new File(getClass().getClassLoader().getResource(fileName).getFile());
        }
        return new File(fileName);
    }

    private Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                        (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>)
                        (localDateTime, typeOfT, context) -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .create();
    }
}

