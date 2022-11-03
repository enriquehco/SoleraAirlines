import React, { useState } from "react";

const ListArrivals = (props) => {
  const arrivals = props.arrList;
  const [EnteredArrival, setEnteredArrival] = useState("--select--");

  return (
    <div className="new-expense__control">
      <label>To</label>
      <select
        id="arrivals"
        value={EnteredArrival}
        onChange={(e) => {
          setEnteredArrival(e.target.value);
          props.onArrivalSelected(e, e.target.value);
        }}
      >
        <option value="--select--">--select--</option>
        {arrivals.map((item) => (
          <option value={item}>{item}</option>
        ))}
      </select>
    </div>
  );
};

export default ListArrivals;
