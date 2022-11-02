import React, { useState } from "react";
import Expenses from "../expenses/Expenses";
import NewExpense from "../newexpense/NewExpense";
import '../../App.css';

const dummy_flights = [
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e1",
    company: "ryanair",
    duration: 1.30,
    luggage: false,
    date: new Date(2020, 7, 14),
    id_city: "c1",
    base_price: 30
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e2",
    company: "ryanair",
    duration: 2.30,
    luggage: false,
    date: new Date(2020, 7, 13),
    id_city: "c2",
    base_price: 30
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e3",
    company: "aireuropa",
    duration: 2.00,
    luggage: false,
    date: new Date(2021, 2, 12),
    id_city: "c3",
    base_price: 30
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e4",
    company: "easyjet",
    duration: 4.00,
    luggage: false,
    date: new Date(2021, 2, 28),
    id_city: "c4",
    base_price: 30
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
    base_price: 30
  },
];
//company was title
//duration was amount

const Home = () => {
  const [flightObjects, setFlightObjects] = useState(dummy_flights);
  const [expenses, setExpenses] = useState(dummy_flights);
  const [filterData, setFilterData] = useState();
  const [showFlights, setShowFlights] = useState(false);
  //dummy item delete after trying to fetch from localhost
  const [courses, setCourses] = useState();

  const addExpenseHandler = (flightinfo) => {
    setFilterData(flightinfo);
    setShowFlights(true);
  };

  const getFilteredFlights = () => {
    {
      /* Make petition to api using filterData to get flights
    -city of departure
    -city of arrival*/
    }
  };

  //dummy method to fetch courses with http request to localhost
  function fetchCoursesHandler() {
    fetch("http://localhost:8080/courses")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        //setMovies(data.results);
        console.log(data);
      });
  }

  return (
    <div className="App">
      <h2>Welcome to Solera Airlines</h2>
      <NewExpense onAddExpense={addExpenseHandler} />
      <Expenses
        items={flightObjects}
        filters={filterData}
        showf={showFlights}
      />
      <button onClick={fetchCoursesHandler}>Fetch course info</button>
    </div>
  );
}

export default Home;