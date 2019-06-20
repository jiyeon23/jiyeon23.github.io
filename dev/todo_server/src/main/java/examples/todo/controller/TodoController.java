package examples.todo.controller;

import examples.todo.domain.PostParam;
import examples.todo.domain.Todo;
import examples.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private TodoService todoservice;

    //리스트
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoservice.getTodos();
    }

    //추가
    @PostMapping("/todos")
    public Todo postTodo(@RequestBody PostParam postparam){
        Todo todo = new Todo();
        todo.setTodo(postparam.getTodo());
        todo.setDone(false);

        todoservice.postTodo(todo);
        return todo;
    }

    @DeleteMapping("/todos")
    public void deleteTodo(@RequestBody Todo todo){
        todoservice.deleteTodo(todo);
    }

    @PutMapping
    public void updateTodo(@RequestBody Todo todo){
        todoservice.updateTodo(todo);
    }

}

