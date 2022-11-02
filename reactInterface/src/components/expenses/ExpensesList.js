import React from "react";
import { useNavigate } from 'react-router-dom';

import ExpenseItems from "./ExpenseItems";
import "./ExpensesList.css";

const headerNames = [
  "Date",
  "Company",
  "From",
  "To",
  "Luggage",
  "Duration",
  "Base Price",
];

const ExpensesList = (props) => {

  const navigate = useNavigate();

  if (props.items.length === 0) {
    return (
      <h2 className="expenses-list__fallback">
        No expenses found for these filters.
      </h2>
    );
  }

  const selectFlightHandler = () => {
    navigate('/purchase',{state:{info: 'hello', message: 'somethingelse'}});
  }

  return (
    <div>
      {headerNames.map((item) => (
        <div className="header-element">{item}</div>
      ))}
      <br />
      <ul className="expenses-list">
        {props.items.map((item) => (
          <div onClick={selectFlightHandler} style={{ cursor: 'pointer' }}>
            <ExpenseItems
              key={item.id}
              departure={item.departure}
              arrival={item.arrival}
              company={item.company}
              duration={item.duration}
              luggage={item.luggage}
              date={item.date}
              id_city={item.id_city}
              base_price={item.base_price}
            />
          </div>
        ))}
      </ul>
    </div>
  );
};

export default ExpensesList;
