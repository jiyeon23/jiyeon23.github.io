package examples.todo.service;

import examples.todo.domain.Todo;
import examples.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public void postTodo(Todo todo){
        todoRepository.save(todo);
    }
    @Transactional
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
    @Transactional
    public void deleteTodo(Todo todo){
        todoRepository.deleteById(todo.getId());
    }

    //done
    @Transactional
    public void updateTodo(Todo todo){
        Todo updatedTodo =todoRepository.findById(todo.getId()).get();
        updatedTodo.setDone(todo.getDone());
        todoRepository.save(updatedTodo);
    }
}
