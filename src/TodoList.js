import React, { useState, Fragment, useEffect } from "react";
import TodoItem from "./TodoItem";
import { getTodos, addTodo, deleteTodo, updateTodo } from "./api/TodoApi";
import "./style.css";
import _ from "lodash";

const TodoList = () => {
  const [inputValue, setInputValue] = useState("");
  const [list, setList] = useState(null);
  const [error, setError] = useState("");

  const handleLoadTasks = () => {
    getTodos()
      .then((response) => {
        setList(response);
      })
      .catch((error) => {
        setError("Unable to retrieve todo's");
      });
  };

  useEffect(() => {
    handleLoadTasks();
  }, []);

  if (list === null) {
    return <div>Tasks is loading ...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <Fragment>
      <div>
        <input
          className="task-input"
          type="text"
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
          data-testid="task-input"
        />
      </div>
      <ul data-testid="task-items" className="task-items">
        {list.map((item) => (
          <TodoItem
            key={item.id}
            item={item}
            index={item.id}
          />
        ))}
      </ul>
    </Fragment>
  );
};

export default TodoList;
