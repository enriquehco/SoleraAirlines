
import React, { useState } from "react";
import Expenses from "./components/expenses/Expenses";
import NewExpense from "./components/newexpense/NewExpense";
import "./App.css";

const dummy_expenses = [
  { id: "e1", title: "Expensive Toilet Paper", amount: 94.12, date: new Date(2020, 7, 14) },
  { id: "e2", title: "Cheap Toilet Paper", amount: 93.12, date: new Date(2020, 7, 13) },
  { id: "e3", title: "Dingus", amount: 420.99, date: new Date(2021, 2, 12) },
  { id: "e4", title: "Car Insurance", amount: 22.22, date: new Date(2021, 2, 28) },
  { id: "e5", title: "A friend  ", amount: 3.50, date: new Date(2021, 5, 12) },
];

function App() {
  

  const [expenses, setExpenses] = useState(dummy_expenses);

  const addExpenseHandler = (expense) => {
    setExpenses(prevExpenses => {
      return [expense, ...prevExpenses];
    });
  }

  return (
    <div className="App">
      <h2>You are about to experience the power of street knowledge</h2>
      <NewExpense onAddExpense={addExpenseHandler}/>
      <Expenses items={expenses} />
    </div>
  );
}

export default App;
