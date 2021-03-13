package mom.sda.projectmanagement.services;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.repositories.TaskRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(TaskNameEntity newTask) {
        taskRepository.save(newTask);
    }

    public List<TaskNameEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public void editTask(TaskNameEntity editedTask) {
        taskRepository.save(editedTask);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
