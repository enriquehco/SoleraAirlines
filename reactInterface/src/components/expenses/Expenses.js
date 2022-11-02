import React, { useState } from 'react';

import ExpensesList from './ExpensesList';
import ExpensesFilter from "../filters/ExpensesFilter";
import Card from "../UI/Card";
import "./Expenses.css";
import ExpenseItems from './ExpenseItems';

const Expenses = (props) => {

  const [filteredYear, setFilteredYear] = useState('2020');
  const [showFilters, setShowFilters] = useState(false);

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
        {props.showf && <ExpensesFilter selected={filteredYear} onSaveFilterYear={saveFilterYearHandler} /> }
        {props.showf && <ExpensesList items={filteredExpenses} />}   
      </Card>
    </div>
  );
};

export default Expenses;
