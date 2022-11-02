import React, { useState } from "react";
import Card from "../UI/Card";
import "./Purchases.css";

const Purchases = () => {
  const [nPassengers, setNPassengers] = useState();

  const submitNumberHandler = (event, data) => {
    event.preventDefault();
    setNPassengers(data);
    console.log(data);
  };

  return (
    <div className="general_borders">
      <Card className="form_element">
        <form>
          <label for="npass">Number of passengers to buy</label>
          <input
            type="number"
            id="npass"
            name="npass"
            onChange={(e) => setNPassengers(e.target.value)}
          ></input>
          <button onClick={(e) => submitNumberHandler(e, nPassengers)}>
            Continue
          </button>
        </form>
      </Card>
    </div>
  );
};

export default Purchases;
