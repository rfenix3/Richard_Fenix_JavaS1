package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.viewmodel.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    private TaskerDao dao;
    private AdClient adClient;

    // This is a constructor. These values below gets included when ServiceLayer is instantiated (like in each controller).
    public TaskerServiceLayer(TaskerDao taskerDao, AdClient adClient) {
        this.dao = taskerDao;
        this.adClient = adClient;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
//        TaskViewModel tvm = new TaskViewModel();
//
//        tvm.setId(task.getId());
//        tvm.setDescription(task.getDescription());
//        tvm.setCreateDate(task.getCreateDate());
//        tvm.setDueDate(task.getDueDate());
//        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
//        tvm.setAdvertisement(client);
//        return tvm;
        return buildTaskViewModel(task);
    }

    public List<TaskViewModel> fetchAllTasks() {

        List<Task> taskList = dao.getAllTasks();

        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task task : taskList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            tvmList.add(tvm);
        }
        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);

        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task task : taskList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(adClient.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        // Update the invoice information
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getCreateDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);
    }

    // Helper Methods
    private TaskViewModel buildTaskViewModel(Task task) {

        // Assemble the InvoiceViewModel
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(adClient.getAd());
        // Return the InvoiceViewModel
        return tvm;
    }
}
