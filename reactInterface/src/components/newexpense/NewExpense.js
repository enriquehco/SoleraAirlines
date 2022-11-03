import React, {useState} from "react";

import ExpenseForm from "./ExpenseForm";
import './NewExpense.css';

const NewExpense = (props) => {
    const [isEditing, setIsEditing] = useState(false);
    const [depCitOptions, setDepCitOptions] = useState([]);

    const saveExpenseDataHandler = (enteredExpenseData) => {
        const expenseData = {
            ...enteredExpenseData,
            id: Math.random().toString()
        };
        props.onAddExpense(expenseData);
    }

    const startEditingHandler = () => {
        setIsEditing(true);
        fetch("http://localhost:8082/flights").then((response) => {
            return response.json();
          })
          .then((data) => {
            setDepCitOptions([... new Set(data.map(option => option.departureCity))]);
          });
    }

    const stopEditingHandler = () => {
        setIsEditing(false);
    }

    return (
        <div className="new-expense">
            {!isEditing && <button onClick={startEditingHandler}>Search for a new Flight</button>}
            {isEditing && <ExpenseForm depCits={depCitOptions} onCancelSubmit={stopEditingHandler} onSaveExpenseData={saveExpenseDataHandler}/>}
        </div>
    )
}

export default NewExpense;