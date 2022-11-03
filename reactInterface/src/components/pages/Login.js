import React, { useState } from "react";
import NewExpense from "../newexpense/NewExpense";
import { useNavigate } from "react-router-dom";
import Card from "../UI/Card";
import "../../App.css";
import "./Login.css";
import logo from "../../images/logo.png";

const Login = (props) => {
  const [userName, setUserName] = useState("");
  const [passwd, setPasswd] = useState("");

  const navigate = useNavigate();

  const goHomeHandler = () => {

    navigate("/home",{state: userName});
  };

  return (
    <div>
      <div className="login_card">
        <Card>
            <img src={logo} alt="this is car image" style={{width:"300px"}}/>
        </Card>
      </div>
      <div className="login_card">
        <Card>
          <form>
            <div>
              <label>Username</label>
              <input
                type="text"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
              ></input>
            </div>
            <div>
              <label>Password</label>
              <input
                type="password"
                value={passwd}
                onChange={(e) => setPasswd(e.target.value)}
              ></input>
            </div>
            <button onClick={goHomeHandler}>Login</button>
          </form>
        </Card>
      </div>
    </div>
  );
};

export default Login;
