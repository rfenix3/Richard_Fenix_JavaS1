package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.viewmodel.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    // since 'service' is autowired when it is instantiated, all taskDao methods are now available using 'service'.
    @Autowired
    TaskerServiceLayer service;

//    @Autowired
//    private final AdClient client;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel addTaskViewModel(@RequestBody @Valid TaskViewModel taskViewModel) throws Exception {
        return service.newTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTaskViewModel(@RequestBody @Valid TaskViewModel taskViewModel) {
        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTaskViewModel(@PathVariable int id) throws Exception {
        TaskViewModel taskViewModel = service.fetchTask(id);
        if (taskViewModel == null) {
            throw new Exception("Task not found.");
        }
        return taskViewModel;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTaskViewModelList() {
        return service.fetchAllTasks();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @RequestMapping(value = "/tasks/category/{category}", method= RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTaskViewModelByCategory(@PathVariable String category) {
        return service.fetchTasksByCategory(category);
    }
}