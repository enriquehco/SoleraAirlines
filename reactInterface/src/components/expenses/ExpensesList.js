import React from "react";

import ExpenseItems from "./ExpenseItems";
import "./ExpensesList.css";

const ExpensesList = (props) => {

  if (props.items.length === 0) {
    return <h2 className="expenses-list__fallback">No expenses found for this year.</h2>
  }

  return (
    <ul className="expenses-list">
      {props.items.map((item) => (
        <ExpenseItems
          key={item.id}
          departure={item.departure}
          arrival={item.arrival}
          company={item.company}
          duration={item.duration}
          luggage={item.luggage}
          date={item.date}
          id_city={item.id_city}
        />
      ))}
    </ul>
  );
};

export default ExpensesList;
