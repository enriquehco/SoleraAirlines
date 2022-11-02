import React, { useState } from "react";

const ListArrivals = (props) => {
  const [EnteredArrival, setEnteredArrival] = useState("--select--");

  return (
    <div className="new-expense__control">
      <label>To</label>
      <select
        id="arrivals"
        value={EnteredArrival}
        onChange={(e) => {setEnteredArrival(e.target.value); props.onArrivalSelected(e,e.target.value)}}
      >
        <option value="--select--">--select--</option>
        <option value="otro sitio">otro sitio</option>
        <option value="nunca jamas">nunca jamas</option>
      </select>
    </div>
  );
};

export default ListArrivals;
