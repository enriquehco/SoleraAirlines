import React from "react";
import { useNavigate } from "react-router-dom";

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

  const selectFlightHandler = (data) => {
    navigate("/purchase", {state: {data}});
  };

  return (
    <div>
      {headerNames.map((item) => (
        <div className="header-element">{item}</div>
      ))}
      <br />
      <ul className="expenses-list">
        {props.items.map((item) => (
          <div onClick={(e) => {selectFlightHandler(item)}} style={{ cursor: "pointer" }}>
            <ExpenseItems
              key={item.id}
              departure={item.departureCity}
              arrival={item.arrivalCity}
              company={item.company}
              duration={item.duration}
              luggage={item.cabinLuggage}
              date={item.dateTime}
              id_city={item.cityId}
              base_price={item.basePrice}
            />
          </div>
        ))}
      </ul>
    </div>
  );
};

export default ExpensesList;
