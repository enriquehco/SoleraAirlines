import React, { useState } from "react";

import ExpensesList from "./ExpensesList";
import ExpensesFilter from "../filters/ExpensesFilter";
import Card from "../UI/Card";
import "./Expenses.css";
import ExpenseItems from "./ExpenseItems";

const Expenses = (props) => {
  const [filteredYear, setFilteredYear] = useState("2020");
  const [showFilters, setShowFilters] = useState(false);

  const showFiltersHandler = () => {
    setShowFilters(!showFilters);
  };

  const saveFilterYearHandler = (enteredFilterYear) => {
    setFilteredYear(enteredFilterYear);
  };

  {
    /*const filteredExpenses = props.items.filter(expense => {
    return expense.date.getFullYear().toString() === filteredYear;
  });*/
  }

  return (
    <div>
      <Card className="expenses">
        {props.showf && (
          <button onClick={showFiltersHandler}>Show filters</button>
        )}
        {props.showf && showFilters && (
          <ExpensesFilter
            selected={filteredYear}
            onSaveFilterYear={saveFilterYearHandler}
          />
        )}
        {props.showf && <ExpensesList items={props.items} />}
      </Card>
    </div>
  );
};

export default Expenses;
