package com.xjtu.job.service;

import com.xjtu.job.model.Task;
import com.xjtu.job.store.TaskStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    public TaskStore store;

    public Optional<Task> delete(Long id) {
        List<Task> tasks = store.readTasks();
        Optional<Task> any = tasks.stream().filter(task1 -> task1.getId() == id).findAny();
        if (any.isPresent()) {
            store.writeTasks(tasks.stream().filter(task -> task.getId() != id).collect(Collectors.toList()));
            return any;
        }
        return any;
    }

    public Optional<Task> update(Task task) {
        List<Task> tasks = new ArrayList<>(store.readTasks());
        Optional<Task> any = tasks.stream().filter(task1 -> task1.getId() == task.getId()).findAny();
        if (any.isPresent()) {
            any.get().setContent(task.getContent());
            any.get().setUpdatedAt();
            store.writeTasks(tasks);
        }
        return any;
    }


    public Task saveTask(Task task) {
        List<Task> tasks = new ArrayList<>(store.readTasks());
        task.setUpdatedAt();
        tasks.add(task);
        store.writeTasks(tasks);
        return task;
    }


    public List<Task> getAll() {
        return store.readTasks();
    }

    public Optional<Task> find(Long id) {
        return store.readTasks().stream().filter(task -> task.getId() == id).findAny();
    }



}


