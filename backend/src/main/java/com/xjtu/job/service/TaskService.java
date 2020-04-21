package com.xjtu.job.service;

<<<<<<< HEAD
=======

>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2
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
<<<<<<< HEAD


    public Task saveTask(Task task) {



        return task;
    }

=======

    public Optional<Task> delete(Long id) {
        List<Task> tasks = store.readTasks();
        Optional<Task> any = tasks.stream().filter(task1 -> task1.getId() == id).findAny();
        if (any.isPresent()) {
            store.writeTasks(tasks.stream().filter(task -> task.getId() != id).collect(Collectors.toList()));
            return any;
        }
        return any;
    }
>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2

}


