import React, { useState } from "react";
import Card from "../UI/Card";
import PurchaseForm from "./PurchaseForm";
import { useNavigate } from "react-router-dom";

import "./Purchases.css";

const Purchases = () => {
  const [nPassengers, setNPassengers] = useState(0);
  const [isPassengers, setIsPassengers] = useState(false);
  const [allPSubmit, setAllPSubmit] = useState(false);
  const [elArray, setElArray] = useState([]);
  const [userArray, setUserArray] = useState([]);

  const navigate = useNavigate();

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

  const userSubmitHandler = (userData) => {
    setUserArray([...userArray, userData]);
    console.log([...userArray, userData].length);
    console.log(nPassengers);
    if (Number([...userArray, userData].length) === Number(nPassengers)) {
      setAllPSubmit(true);
    }
  };

  const rejectUserFormsHandler = () => {
    navigate("/");
  };

  const sendUserFormsHandler = () => {
    userArray.map((item) => {
      console.log(item);
      const userrequestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item),
      };
      fetch("http://localhost:8081/users", userrequestOptions)
        .then((response) => response.json())
        .then((data) => console.log(data));
    });
  };

  return (
    <div className="general_borders">
      <Card className="form_element">
        <form>
          <label for="npass">Number of passengers to buy for</label>
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
      {isPassengers && (
        <Card>
          {elArray.map(() => (
            <div>
              <PurchaseForm onSubmitUser={userSubmitHandler} />
            </div>
          ))}
          {allPSubmit && (
            <div>
              <div>
                <button onClick={rejectUserFormsHandler}>
                  Reject purchase
                </button>
              </div>
              <div>
                <button onClick={sendUserFormsHandler}>Confirm purchase</button>
              </div>
            </div>
          )}
        </Card>
      )}
    </div>
  );
};

export default Purchases;
