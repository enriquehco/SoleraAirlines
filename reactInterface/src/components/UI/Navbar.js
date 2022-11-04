import React from "react";
import "./Navbar.css";
import { useNavigate } from "react-router-dom";

const Navbar = (props) => {
  const navigate = useNavigate();

  const goAboutHandler = () =>{
    navigate('/about');
  }

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
          <a href="#" onClick={goAboutHandler}>About</a>
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
