import React from "react";
import "./Navbar.css";

const Navbar = (props) => {
  return (
    <div>
      <ul id="nav">
        <li>
          <h3>Solera Airlines</h3>
        </li>
        <li>
          <a href="#">Home</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="#">FAQ</a>
        </li>
        <li>
          <a href="#">Contact</a>
        </li>
        <li>
            <h4>Welcome! {props.info}</h4>
        </li>
        <li>
            <h4>Logout</h4>
        </li>
      </ul>
    </div>
  );
};

export default Navbar;
