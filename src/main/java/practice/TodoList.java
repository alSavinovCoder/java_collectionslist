package practice;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private boolean exist(Integer index) {
        return index != null && index >= 0 && index < todoList.size();
    }

    private final List<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        if (exist(index)) {
          todoList.add(index, todo);
        } else {
            add(todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(int index, String todo) {
        if (exist(index)) {
            todoList.set(index, todo);
        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if (exist(index)) {
            todoList.remove(index);
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        ArrayList<String> todos = new ArrayList<String>();
        for (String item : todoList) {
            todos.add(item);
        }
        // TODO: вернуть список дел
        return todos;
    }

}