import React, { useState } from "react";
import Card from "../UI/Card";
import PurchaseForm from "./PurchaseForm";
import "./Purchases.css";

const Purchases = () => {
  const [nPassengers, setNPassengers] = useState(0);
  const [isPassengers, setIsPassengers] = useState(false);
  const [elArray, setElArray] = useState([]);

  const submitNumberHandler = (event, data) => {
    event.preventDefault();
    if (data != 0) {
      //setNPassengers(data);
      console.log(nPassengers);
      setElArray(Array(Number(nPassengers)).fill(" "));
      setIsPassengers(true);
    } else {
      setIsPassengers(false);
    }
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
            value={nPassengers}
            onChange={(e) => setNPassengers(e.target.value)}
          ></input>
          <button onClick={(e) => submitNumberHandler(e, nPassengers)}>
            Continue
          </button>
        </form>
      </Card>
      {isPassengers && console.log(elArray)}
      {isPassengers && elArray.map(() => (
        <div>
          <PurchaseForm />
        </div>
      ))}
    </div>
  );
};

export default Purchases;
