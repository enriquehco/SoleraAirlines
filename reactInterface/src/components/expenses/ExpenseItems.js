import React, { useState } from "react";

import ExpenseDate from "./ExpenseDate";
import Card from "../UI/Card";
import "./ExpenseItems.css";

function ExpenseItems(data) {
  return (
    <li>
      <Card className="expense-item">
        <ExpenseDate date={data.date} />
        <div className="expense-item__description">
          <h2>{data.company}</h2>
          <h2>{data.departure}</h2>
          <h2>{data.arrival}</h2>
          <div className="expense-item__price">{data.amount}</div>
          <h2>{data.duration}</h2>
          <h2>{data.luggage}</h2>
        </div>
      </Card>
    </li>
  );
}

export default ExpenseItems;
