package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
    // dao is the implementation interface that we want Spring to wire with the test class
    @Autowired
    //@Qualifier("This bean")
    protected TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Task> mList = dao.getAllTasks();
        mList.stream()
                .forEach(task -> dao.deleteTask(task.getId()));
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));

        // Creates task object
        task = dao.createTask(task);

        Task task2 = dao.getTask((task.getId()));

        assertEquals(task, task2);

        dao.deleteTask(task.getId());

        task2 = dao.getTask(task.getId());

        assertNull(task2);
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));
        task.setCategory("house work");

        Task task2 = new Task();
        task2.setDescription("Clean car");
        task2.setCreateDate(LocalDate.of(2019, 9, 29));
        task2.setDueDate(LocalDate.of(2019, 10, 7 ));
        task2.setCategory("house work");

        // Creates task object
        task = dao.createTask(task);

        // Creates task2 object
        task2 = dao.createTask(task2);

        List<Task> mList = dao.getAllTasks();

        int mListSize = mList.size();

        assertEquals(2, mListSize);
    }

    @Test
    public void updateTask() {
        Task task = new Task();  // Create task object.
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));

        task = dao.createTask(task);

        // Java object is now changed from hereon. DB data not yet changed.
        task.setDescription("Mow and water lawn");
        task.setDueDate(LocalDate.of(2019, 10, 9 ));

        // Change Database data using update.
        dao.updateTask(task);

        Task task2 = dao.getTask(task.getId());  // Create task record or rows in the database.

        assertEquals(task, task2);
    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();  // Create task object.
        task.setDescription("Mow lawn");
        task.setCreateDate(LocalDate.of(2019, 9, 30));
        task.setDueDate(LocalDate.of(2019, 10, 8 ));
        task.setCategory("house work");

        Task task2 = new Task();  // Create task2 object.
        task2.setDescription("Clean car");
        task2.setCreateDate(LocalDate.of(2019, 9, 29));
        task2.setDueDate(LocalDate.of(2019, 10, 7 ));
        task2.setCategory("house work");

        Task task3 = new Task();  // Create task2 object.
        task3.setDescription("Get haircut");
        task3.setCreateDate(LocalDate.of(2019, 9, 25));
        task3.setDueDate(LocalDate.of(2019, 10, 7 ));
        task3.setCategory("grooming");

        // Creates task object
        task = dao.createTask(task);  // Create task record or rows in the database.

        // Creates task2 object
        task2 = dao.createTask(task2);  // Create task2 record in the database.

        // Creates task3 object
        task3 = dao.createTask(task3);  // Create task2 record in the database.

        List<Task> bList = dao.getTasksByCategory("house work");
        assertEquals(2, bList.size());
    }
}
