import React, { useState } from "react";
import ExpensesFilterItem from "./ExpensesFilterItem";

import "./ExpensesFilter.css";

const ExpensesFilter = (props) => {

  const [timeFrame, setTimeFrame] = useState();

  const yearChangedHandler = (event) => {
    props.onSaveFilterYear(event.target.value);
  }

  function getIntervals() {
    let timesarray = [48];
    for (let i=0; i < 48; i+=2){
        timesarray[i] = (i/2).toString() + ":00";
        timesarray[i+1] = (i/2).toString() + ":30";
    }
    return timesarray;
  }


  const filterParameters = [
    {name:"Company", options:["ryanair","easyjet","deutscheflug"]},
    {name:"Scales", options:["with","without"]},
    {name:"Luggage", options:["allowed","not allowed"]},
    {name:"Time of Departure", options:['0:00', '0:30', '1:00', '1:30', '2:00', '2:30', '3:00', '3:30', '4:00', '4:30', '5:00', '5:30', '6:00', '6:30', '7:00', '7:30', '8:00', '8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30', '18:00', '18:30', '19:00', '19:30', '20:00', '20:30', '21:00', '21:30', '22:00', '22:30', '23:00', '23:30']}
  ];

  console.log(timeFrame);

  return (
    <div className="expenses-filter">
      {filterParameters.map((item) => (
        <ExpensesFilterItem
          params={item}
        />
      ))}
    </div>
  );
};

export default ExpensesFilter;
