import React, { useState } from "react";
import {useLocation} from 'react-router-dom';
import Expenses from "../expenses/Expenses";
import NewExpense from "../newexpense/NewExpense";
import "../../App.css";
import Navbar from "../UI/Navbar";

const dummy_flights = [
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e1",
    company: "ryanair",
    duration: 1.3,
    luggage: false,
    date: new Date(2020, 7, 14),
    id_city: "c1",
    base_price: 30,
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e2",
    company: "ryanair",
    duration: 2.3,
    luggage: false,
    date: new Date(2020, 7, 13),
    id_city: "c2",
    base_price: 30,
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e3",
    company: "aireuropa",
    duration: 2.0,
    luggage: false,
    date: new Date(2021, 2, 12),
    id_city: "c3",
    base_price: 30,
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e4",
    company: "easyjet",
    duration: 4.0,
    luggage: false,
    date: new Date(2021, 2, 28),
    id_city: "c4",
    base_price: 30,
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e5",
    company: "airgermany",
    duration: 3.5,
    luggage: false,
    date: new Date(2021, 5, 12),
    id_city: "c5",
    base_price: 30,
  },
];
//company was title
//duration was amount

const Home = () => {
  const [flightObjects, setFlightObjects] = useState([]);
  const [expenses, setExpenses] = useState(dummy_flights);
  const [filterData, setFilterData] = useState();
  const [showFlights, setShowFlights] = useState(false);
  //dummy item delete after trying to fetch from localhost
  const [courses, setCourses] = useState();

  const location = useLocation();

  const addExpenseHandler = (flightinfo) => {
    setFilterData(flightinfo);
    getFilteredFlights(flightinfo);
    setShowFlights(true);
  };

  const getFilteredFlights = (finfo) => {
    fetch("http://localhost:8082/flights")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setFlightObjects(
          data.filter((obj) => {
            return (
              obj.departureCity == finfo.departure &&
              obj.arrivalCity == finfo.arrival
            );
          })
        );
      });
  };

  return (
    <div className="App">
      <Navbar info={location.state}/>
      <h2>Welcome to Solera Airlines</h2>
      <NewExpense onAddExpense={addExpenseHandler} />
      <Expenses
        items={flightObjects}
        filters={filterData}
        showf={showFlights}
      />
    </div>
  );
};

export default Home;
