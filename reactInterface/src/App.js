import React, { useState } from "react";
import Expenses from "./components/expenses/Expenses";
import NewExpense from "./components/newexpense/NewExpense";
import "./App.css";

const dummy_flights = [
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e1",
    company: "Expensive Toilet Paper",
    duration: 94.12,
    luggage: false,
    date: new Date(2020, 7, 14),
    id_city: "c1",
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e2",
    company: "Cheap Toilet Paper",
    duration: 93.12,
    luggage: false,
    date: new Date(2020, 7, 13),
    id_city: "c2",
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e3",
    company: "Dingus",
    duration: 420.99,
    luggage: false,
    date: new Date(2021, 2, 12),
    id_city: "c3",
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e4",
    company: "Car Insurance",
    duration: 22.22,
    luggage: false,
    date: new Date(2021, 2, 28),
    id_city: "c4",
  },
  {
    departure: "babilonia",
    arrival: "atlantis",
    id: "e5",
    company: "A friend  ",
    duration: 3.5,
    luggage: false,
    date: new Date(2021, 5, 12),
    id_city: "c5",
  },
];
//company was title
//duration was amount

function App() {
  const [flightObjects, setFlightObjects] = useState([]);
  const [expenses, setExpenses] = useState(dummy_flights);
  const [filterData, setFilterData] = useState();
  const [showFlights, setShowFlights] = useState(false);
  //dummy item delete after trying to fetch from localhost
  const [courses, setCourses] = useState();

  const addExpenseHandler = (flightinfo) => {
    {
      /*setExpenses(prevExpenses => {
      return [expense, ...prevExpenses];
    });*/
    }
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

export default App;
