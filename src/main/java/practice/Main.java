package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            UserInput userInput = parse(scanner.nextLine());
            switch (userInput.getCommand()) {
                case "LIST":
                    System.out.println(todoList.getTodos());
                    break;
                case "ADD":
                    todoList.add(userInput.getIndex(), userInput.getTask());
                    break;
                case "EDIT":
                    todoList.edit(userInput.getIndex(), userInput.getTask());
                    break;
                case "DELETE":
                    todoList.delete(userInput.getIndex());
                    break;
            }

        }

    }

    private static UserInput parse(String input) {
        String[] split = input.split(" ");
        if (split.length == 1) {
            return new UserInput(input.toUpperCase(), null, null);
        }
        try {
            return new UserInput(split[0].toUpperCase(), Integer.valueOf(split[1]), String.join(" ",
                    Arrays.copyOfRange(split, 2, split.length)));
        } catch (NumberFormatException e) {
            return new UserInput(split[0].toUpperCase(), null, String.join(" ",
                    Arrays.copyOfRange(split, 1, split.length)));
        }
    }

    private static class UserInput {

        private final String command;

        private final Integer index;

        private final String task;

        public UserInput(String command, Integer index, String task) {
            this.command = command;
            this.index = index;
            this.task = task;
        }

        public String getCommand() {
            return command;
        }

        public Integer getIndex() {
            return index;
        }

        public String getTask() {
            return task;
        }

    }

}

