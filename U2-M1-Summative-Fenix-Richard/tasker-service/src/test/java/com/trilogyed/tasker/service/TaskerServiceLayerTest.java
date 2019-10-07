package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Ad;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.util.feign.AdClient;
import com.trilogyed.tasker.viewmodel.TaskViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {

    TaskerServiceLayer service; // Make TaskerServiceLayer's methods available in this class.
    AdClient adClient;  // Make AdClient's getAd() method be available in this class.
    TaskerDao dao; // Make TaskerDao's methods available in this class.

    @Before
    public void setUp() throws Exception {
        setupTaskerDaoMock();
        setupAdMock();

        service = new TaskerServiceLayer(dao, adClient);

    }

    @Test
    public void deleteTask() {
        // When we remove a task, we capture an Integer value.
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(dao).deleteTask(integerCaptor.capture());

        // Act
        service.deleteTask(10);

        verify(dao, atLeastOnce()).deleteTask(integerCaptor.getValue());

        Assert.assertEquals(10, integerCaptor.getValue().intValue());
    }

    @Test
    public void updateTask() {
        //Instantiate an TaskViewModel;
        TaskViewModel tvm = new TaskViewModel();

        // Since we are not actually working with a db, we do not need to
        // insert a new row.
        tvm.setId(1);  // <-- artificial Task ID number;

        // plus other task properties...;
        tvm.setDescription("Mow lawn");
        tvm.setCreateDate(LocalDate.of(2019, 9, 30));
        tvm.setDueDate(LocalDate.of(2019, 10, 8 ));
        tvm.setCategory("house work");

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass((Task.class));
        doNothing().when(dao).updateTask(taskCaptor.capture());

        // Act phase. execution.
        service.updateTask(tvm);

        // A phase. must be invoked one time only.
        verify(dao, times(1)).updateTask(taskCaptor.getValue());

        Task task = taskCaptor.getValue();

        assertEquals(1, task.getId());
        assertEquals(tvm.getDescription(), task.getDescription());
        assertEquals(tvm.getCreateDate(), task.getCreateDate());
    }

    @Test
    public void saveFindFindAllTaskViewModel() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("Mow lawn");
        tvm.setCreateDate(LocalDate.of(2019, 9, 30));
        tvm.setDueDate(LocalDate.of(2019, 10, 8 ));
        tvm.setCategory("house work");
        tvm.setAdvertisement("Get a new phone NOW!");

        tvm = service.newTask(tvm);

        TaskViewModel fromService = service.fetchTask(tvm.getId());

        assertEquals(tvm, fromService);
    }

    @Test
    public void fetchTasksByCategory() {

        return;
    }


    // Helper methods
    private void setupTaskerDaoMock(){
        dao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task task = new Task();
        task.setId(1);
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));
        task.setCategory("house work");

        // Below is mock retrieved output data when addTask(task2) is ran.
        Task task2 = new Task();
        //task.setId(0);
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));
        task.setCategory("house work");

        Task task3 = new Task();  // Create task2 object.
        task3.setId(2);
        task3.setDescription("Get haircut");
        task3.setCreateDate(LocalDate.of(2019, 9, 25));
        task3.setDueDate(LocalDate.of(2019, 10, 7 ));
        task3.setCategory("house work");

        List<Task> tList = new ArrayList();
        tList.add(task);
        tList.add(task3);

        doReturn(task).when(dao).createTask(task2);
        doReturn(task).when(dao).getTask(1);
        doReturn(tList).when(dao).getAllTasks();
        doReturn(tList).when(dao).getTasksByCategory("house work");
    }

    private void setupAdMock(){
        adClient = mock(AdClient.class);
        String randomAd = "Get a new phone NOW!";

        doReturn(randomAd).when(adClient).getAd();
    }

    private void setupTaskerServiceLayerMock(){
        service = mock(TaskerServiceLayer.class);
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Mow lawn");
        tvm.setCreateDate(LocalDate.of(2019, 9, 30));
        tvm.setDueDate(LocalDate.of(2019, 10, 8 ));
        tvm.setCategory("house work");
        tvm.setAdvertisement("Get a new phone NOW!");


        // Below is mock retrieved output data when addTask(task2) is ran.
        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Mow lawn");
        tvm2.setCreateDate(LocalDate.of(2019, 9, 30));
        tvm2.setDueDate(LocalDate.of(2019, 10, 8 ));
        tvm2.setCategory("house work");

        List<TaskViewModel> tList = new ArrayList();
        tList.add(tvm);

        doReturn(tvm).when(service).newTask(tvm2);
        doReturn(tvm).when(service).fetchTask(1);
        doReturn(tList).when(service).fetchAllTasks();
    }


}