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
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
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

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class) // This says that this will be unit tested.
public class TaskerServiceLayerTest {

    @InjectMocks  // we are loading all the beans for below item.
    TaskerServiceLayer service; // Make TaskerServiceLayer's methods available in this class.
    @Mock
    AdClient adClient;
    @Mock  // means we are going to mock below DAOs.
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setupTaskerDaoMock();
        setupAdMock();

        // Mockito will take care of below since @InjectMocks will load all the beans.
        // We should also comment out the other mock assignments in the setupTaskerDaoMock() and setupAdMock():
        // i.e. dao = mock(TaskerDaoJdbcTemplateImpl.class);
        //service = new TaskerServiceLayer(dao, adClient);

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

        // No need to set the ID since we are adding the data. The database is expected to
        // provide the ID.
        tvm.setDescription("Mow lawn");
        tvm.setCreateDate(LocalDate.of(2019, 9, 30));
        tvm.setDueDate(LocalDate.of(2019, 10, 8 ));
        tvm.setCategory("house work");

        tvm = service.newTask(tvm);

        TaskViewModel fromService = service.fetchTask(tvm.getId());

        assertEquals(tvm.getId(), fromService.getId());
        assertEquals(tvm.getDescription(), fromService.getDescription());
        assertEquals(tvm.getCreateDate(), fromService.getCreateDate());
        assertEquals(tvm.getDueDate(), fromService.getDueDate());
        assertEquals(tvm.getCategory(), fromService.getCategory());
        assertEquals(tvm.getAdvertisement(), fromService.getAdvertisement());

    }

    @Test
    public void fetchTasksByCategory() {
        List<TaskViewModel> tvmList = new ArrayList<>();

        tvmList = service.fetchTasksByCategory("house work");

        assertEquals(2, tvmList.size());
    }


    // Helper methods
    private void setupTaskerDaoMock(){
        //dao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task task = new Task();
        task.setId(1);
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));
        task.setCategory("house work");

        // Below is mock retrieved output data when addTask(task2) is ran.
        Task task2 = new Task();
        //task.setId(0);
        task2.setDescription("Mow lawn");
        task2.setCreateDate(LocalDate.of(2019, 9, 30));
        task2.setDueDate(LocalDate.of(2019, 10, 8 ));
        task2.setCategory("house work");

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
//        doReturn(tList).when(dao).getAllTasks();
        doReturn(tList).when(dao).getTasksByCategory("house work");
    }

    private void setupAdMock(){
        //adClient = mock(AdClient.class);
        String randomAd = "Get a new phone NOW!";

        doReturn(randomAd).when(adClient).getAd();
    }


}