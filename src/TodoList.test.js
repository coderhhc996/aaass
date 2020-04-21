import React from "react";
import {
  render,
  fireEvent,
  act,
  wait,
  getByTestId,
  getAllByTestId,
} from "@testing-library/react";
import TodoList from "./TodoList";
import * as TodoApi from "./api/TodoApi";

describe("<TodoList>", () => {
  const item = { id: 1, content: "First Item", createAt: "2020/04/21" };

  beforeEach(() => {
    jest
      .spyOn(TodoApi, "getTodos")
      .mockImplementation(() => Promise.resolve([item]));
  });
    act(() => {
      fireEvent.click(getByTestId(document.body, "add-button"));
    });
    await wait(() => expect(TodoApi.addTodo).toHaveBeenCalled());

    const taskItems = getAllByTestId(document.body, "task-item");
    expect(taskItems.length).toEqual(2);
    expect(taskItems[1]).toHaveTextContent(addedItem.content);
  });
});
