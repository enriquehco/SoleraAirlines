import React, { useState } from "react";

import "./ExpenseForm.css";
import ListArrivals from "./ListArrivals";

const ExpenseForm = (props) => {
  const departuresList = props.depCits;

  const [EnteredDeparture, setEnteredDeparture] = useState("--select--");
  const [EnteredArrival, setEnteredArrival] = useState("--select--");
  const [isDeparture, setIsDeparture] = useState(false);
  const [isArrival, setIsArrival] = useState(false);
  const [isCheckedOneWay, setIsCheckedOneWay] = useState(false);
  const [arrivalsList, setArrivalsList] = useState([]);
  //const [departuresList, setDeparturesList] = useState(dummyflights);

  const titleChangeHandler = (event) => {
    setEnteredDeparture(event.target.value);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    if (isDeparture && isArrival) {
      const expenseData = {
        departure: EnteredDeparture,
        arrival: EnteredArrival,
        oneway: isCheckedOneWay,
      };
      props.onSaveExpenseData(expenseData);
    }
  };

  const cancelHandler = () => {
    props.onCancelSubmit();
  };

  const getArrivals = (departure) => {
    fetch("http://localhost:8082/flights")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setArrivalsList([... new Set(data.filter(obj => {
          return obj.departureCity == departure;
        }).map((option) => option.arrivalCity))]);
      });
      setIsDeparture(true);
  };

  const departureHandler = (event, departureData) => {
    event.preventDefault();
    if (departureData != "--select--") {
      getArrivals(departureData);
    } else {
      setIsDeparture(false);
    }
  };

  const arrivalHandler = (event, arrivalData) => {
    event.preventDefault();
    if (arrivalData != "--select--") {
      setEnteredArrival(arrivalData);
      setIsArrival(true);
    } else {
      setIsArrival(false);
    }
  };

  const checkHandler = () => {
    setIsCheckedOneWay(!isCheckedOneWay);
  };

  return (
    <form onSubmit={submitHandler}>
      <div className="new-expense__controls">
        <div className="new-expense__control">
          <label>From</label>
          {/*<input type='text' value={EnteredDeparture} onChange={titleChangeHandler}/>*/}
          <select
            id="departures"
            value={EnteredDeparture}
            onChange={(e) => {
              setEnteredDeparture(e.target.value);
              departureHandler(e, e.target.value);
            }}
          >
            <option>--select--</option>
            {departuresList.map((item) => (
              <option value={item}>{item}</option>
            ))}
          </select>
          {/*<button onClick={departureHandler}>Continue</button>*/}
        </div>
        {isDeparture && <ListArrivals arrList={arrivalsList} onArrivalSelected={arrivalHandler} />}
        {isArrival && (
          <div>
            <input
              type="checkbox"
              id="checkbox"
              checked={isCheckedOneWay}
              onChange={checkHandler}
            />
            <label htmlFor="checkbox">One Way Trip?</label>
          </div>
        )}
      </div>
      <div className="new-expense__actions">
        <button onClick={cancelHandler}>Cancel</button>
        <button type="submit">Search for flights</button>
      </div>
    </form>
  );
};

export default ExpenseForm;
