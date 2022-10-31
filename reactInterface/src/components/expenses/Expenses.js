import React, { useState } from 'react';

import ExpensesList from './ExpensesList';
import ExpensesFilter from "../filters/ExpensesFilter";
import Card from "../UI/Card";
import "./Expenses.css";

const Expenses = (props) => {

  const [filteredYear, setFilteredYear] = useState('2020');

  const saveFilterYearHandler = (enteredFilterYear) => {
    setFilteredYear(enteredFilterYear)
    console.log(filteredYear);
  };

  const filteredExpenses = props.items.filter(expense => {
    return expense.date.getFullYear().toString() === filteredYear;
  });

  return (
    <div>
      <Card className="expenses">
        <ExpensesFilter selected={filteredYear} onSaveFilterYear={saveFilterYearHandler} />     
        <ExpensesList items={filteredExpenses} />   
      </Card>
    </div>
  );
};

export default Expenses;
