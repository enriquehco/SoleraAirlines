import React, { useState } from "react";
import Expenses from "./components/expenses/Expenses";
import NewExpense from "./components/newexpense/NewExpense";
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./components/pages/Home";
import Purchase from "./components/pages/Purchase";
import Login from "./components/pages/Login";

//company was title
//duration was amount

function App() {
  return (
    <div >
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
          <Route path="/purchase" element={<Purchase />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
