import React, { useState, useEffect } from "react";
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

  const [definitiveprice, setDefinitiveprice] = useState();
  const [defsuccess, setDefsuccess] = useState();
  const [finalid, setFinalid] = useState();
  const [reqtime, setReqtime] = useState();

  const [isprice, setIsprice] = useState(false);
  const [issucc, setIssucc] = useState(false);
  const [isid, setIsid] = useState(false);
  const [istime, setIstime] = useState(false);

  const navigate = useNavigate();

  function timeout(delay) {
    return new Promise((res) => setTimeout(res, delay));
  }

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
    navigate("/home");
  };

  const adduserasync = (body) => {
    const userrequestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    };

    let res = fetch("http://localhost:8081/users", userrequestOptions)
      .then((response) => response.json())
      .then((data) => {
        if (data != undefined) {
          setFinalid(data.id);
          console.log(data.id);
        }
      });
  };

  const sendUserFormsHandler = async () => {
    userArray.map((item) => {
      const postbody = {
        name: item.name,
        surname: item.surname,
        nationality: item.nationality,
        identification: item.identification,
        age: Number(item.age),
      };
      adduserasync(postbody);
      let now = new Date().toJSON();
      setReqtime(now.replace(/T/g, " ").replace(/Z/g, "").slice(0, -4));
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
          setDefinitiveprice(Number(data));
        });
      console.log(item.surname);
      let fetchSuccessRoute =
        "http://localhost:8084/purchases/saleCompleted/" + item.surname;
      fetch(fetchSuccessRoute)
        .then((response) => response.json())
        .then((data) => {
          setDefsuccess(data);
        });
      //sendPurchaseHandler();
    });
  };

  useEffect(() => {
    //purchaseBody.final_price = definitiveprice;
    if (definitiveprice != undefined) {
      setIsprice(true);
    }
  }, [definitiveprice]);

  useEffect(() => {
    //purchaseBody.purchase_date = reqtime;
    setIstime(true);
  }, [reqtime]);

  useEffect(() => {
    //purchaseBody.success = defsuccess;
    setIssucc(true);
  }, [defsuccess]);

  useEffect(() => {
    if (issucc && istime && isprice && isid) {
      sendPurchaseHandler();
    }
  }, [definitiveprice, reqtime, defsuccess, finalid]);

  useEffect(() => {
    //purchaseBody.user_id = finalid;
    setIsid(true);
    console.log("value for id has changed to " + finalid);
  }, [finalid]);

  const sendPurchaseHandler = () => {
    userArray.map(() => {
      let purchaseBody = {
        finalPrice: definitiveprice,
        purchase_date: reqtime,
        success: defsuccess,
        userId: finalid,
      };
      console.log(reqtime);
      const purchaserequestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(purchaseBody),
      };
      console.log(purchaseBody);
      let res = fetch("http://localhost:8084/purchases", purchaserequestOptions)
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
        });
      setIssucc(false);
      setIstime(false);
      setIsprice(false);
      setIsid(false);
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
