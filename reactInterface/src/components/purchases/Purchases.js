import React, { useState } from "react";
import Card from "../UI/Card";
import PurchaseForm from "./PurchaseForm";
import { useNavigate } from "react-router-dom";

import "./Purchases.css";

const Purchases = (props) => {
  const finfo = props.flightInfo.data;
  const [nPassengers, setNPassengers] = useState(0);
  const [isPassengers, setIsPassengers] = useState(false);
  const [allPSubmit, setAllPSubmit] = useState(false);
  const [elArray, setElArray] = useState([]);
  const [userArray, setUserArray] = useState([]);

  const [definitiveprice, setDefinitiveprice] = useState(0);
  const [defsuccess, setDefsuccess] = useState(false);
  const [finalid, setFinalid] = useState(0);

  const navigate = useNavigate();

  const submitNumberHandler = (event, data) => {
    event.preventDefault();
    if (data != 0) {
      //setNPassengers(data);
      setElArray(Array(Number(nPassengers)).fill(" "));
      setIsPassengers(true);
    } else {
      setIsPassengers(false);
    }
  };

  const userSubmitHandler = (userData) => {
    console.log(userData);
    setUserArray([...userArray, userData]);
    if (Number([...userArray, userData].length) === Number(nPassengers)) {
      setAllPSubmit(true);
    }
  };

  const rejectUserFormsHandler = () => {
    navigate("/");
  };

  const sendUserFormsHandler = () => {
    userArray.map((item) => {
      const postbody = {
        name: item.name,
        surname: item.surname,
        nationality: item.nationality,
        identification: item.identification,
        age: Number(item.age),
      };
      const userrequestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(postbody),
      };
      fetch("http://localhost:8081/users", userrequestOptions)
        .then((response) => response.json())
        .then((data) => {
          setFinalid(data.id);
        });
      let now = new Date().toJSON();
      let reqtime = now.replace(/T/g, " ").replace(/Z/g, "").slice(0, -4);
      let fetchPriceRoute =
        "http://localhost:8084/purchases/userPrice/" +
        finfo.basePrice +
        "/" +
        item.age +
        "/" +
        item.luggage;
      fetch(fetchPriceRoute)
        .then((response) => response.json())
        .then((data) => {
          setDefinitiveprice(data);
        });
      let fetchSuccessRoute = "http://localhost:8084/purchases/saleCompleted/" + item.surname;
      fetch(fetchSuccessRoute)
        .then((response) => response.json())
        .then((data) => {
          setDefsuccess(data);
        });
      console.log(defsuccess);
      const purchaseItem = {
        final_price: definitiveprice,
        purchase_date: reqtime,
        success: defsuccess,
        user_id: finalid
      };
      console.log(purchaseItem);
      const purchaserequestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(purchaseItem),
      };
      {/*fetch("http://localhost:8084/purchases", purchaserequestOptions)
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
        });*/}
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
