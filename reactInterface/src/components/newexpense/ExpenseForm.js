import React, { useState } from "react";

import "./ExpenseForm.css";
import ListArrivals from "./ListArrivals";

const ExpenseForm = (props) => {
  const [EnteredDeparture, setEnteredDeparture] = useState("--select--");
  const [EnteredArrival, setEnteredArrival] = useState("--select--");
  const [isDeparture, setIsDeparture] = useState(false);
  const [isArrival, setIsArrival] = useState(false);
  const [isCheckedOneWay, setIsCheckedOneWay] = useState(false)

  const departuresList = [
    "roma",
    "paris",
    "bhagdad",
    "iowa",
    "sevilla"
  ];

  const titleChangeHandler = (event) => {
    setEnteredDeparture(event.target.value);
  };

  const submitHandler = (event) => {
    event.preventDefault();

    const expenseData = {
      departure: EnteredDeparture,
      arrival: EnteredArrival,
      oneway: isCheckedOneWay
    };
    props.onSaveExpenseData(expenseData);
  };

  const cancelHandler = () => {
    props.onCancelSubmit();
  };

  const departureHandler = (event) => {
    event.preventDefault();
    if(EnteredDeparture != "--select--"){
        setIsDeparture(true); 
    }
  };

  const arrivalHandler = (event,arrivalData) => {
    event.preventDefault();
    setEnteredArrival(arrivalData);
    console.log(arrivalData);
    setIsArrival(true);
  }

  const checkHandler = () => {
    setIsCheckedOneWay(!isCheckedOneWay)
  }

  return (
    <form onSubmit={submitHandler}>
      <div className="new-expense__controls">
        <div className="new-expense__control">
          <label>From</label>
          {/*<input type='text' value={EnteredDeparture} onChange={titleChangeHandler}/>*/}
          <select
            id="departures"
            value={EnteredDeparture}
            onChange={(e) => setEnteredDeparture(e.target.value)}
          >
            <option >--select--</option>
            {departuresList.map((item) => (
                <option value={item}>{item}</option>
            ))}
          </select>
          <button onClick={departureHandler}>Continue</button>
        </div>
        {isDeparture && <ListArrivals onArrivalSelected={arrivalHandler}/>}
        {isArrival && <div><input type="checkbox" id="checkbox" checked={isCheckedOneWay} onChange={checkHandler}/><label htmlFor="checkbox">One Way Trip?</label></div>}
      </div>
      <div className="new-expense__actions">
        <button onClick={cancelHandler}>Cancel</button>
        <button type="submit">Search for flights</button>
      </div>
    </form>
  );
};

export default ExpenseForm;
