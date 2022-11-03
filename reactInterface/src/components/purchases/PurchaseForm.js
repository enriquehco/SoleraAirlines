import React, { useState } from "react";
import Card from "../UI/Card";
import "../newexpense/ExpenseForm.css"

const PurchaseForm = (props) => {

  const [selAge,setSelAge] = useState(20);
  const [selName, setSelName] = useState("");
  const [selSurname, setSelSurname] = useState("");
  const [selNat, setSelNat] = useState("");
  const [selId,setSelId] = useState("");
  const [selLuggage,setSelLuggage] = useState(false);

  const [isSubmit, setIsSubmit] = useState(false);

  const saveUserForm = (event) => {
    event.preventDefault();
    const returnobj = {
      name: selName,
      surname: selSurname,
      nationality: selNat,
      identification: selId,
      age: Number(selAge),
      luggage: selLuggage    
    }
    props.onSubmitUser(returnobj);
  }

  const checkboxHandler = () => {
    setSelLuggage(!selLuggage);
  }

  const enableSubmit = () => {
    if(selName.length != 0 && selSurname.length != 0 && selNat.length != 0 && selId.length != 0){
      setIsSubmit(true);
    } else{
      setIsSubmit(false);
    }
  }

  return (<Card className="individual_form_item">
    <form>
      <div>
        <label>Name</label>
        <input type="text" onChange={(e)=> {setSelName(e.target.value); enableSubmit()}} required></input>
      </div>
      <div>
        <label>Surname</label>
        <input type="text" onChange={(e)=>{setSelSurname(e.target.value); enableSubmit()}} required></input>
      </div>
      <div>
        <label>Nationality</label>
        <input type="text" onChange={(e)=>{setSelNat(e.target.value); enableSubmit()}} required></input>
      </div>
      <div>
        <label>Identification {"("}id or passport{")"}</label>
        <input type="text" onChange={(e)=>{setSelId(e.target.value); enableSubmit()}} required></input>
      </div>
      <div>
        <label>Age</label>
        <input type="number" onChange={(e)=>{setSelAge(e.target.value); enableSubmit()}} required></input>
      </div>
      <div>
        <label>Luggage</label>
        <input type="checkbox" value={selLuggage} onChange={(e) =>{checkboxHandler(); enableSubmit()}}></input>
      </div>
      {isSubmit && <button onClick={(e) => saveUserForm(e)}>Save user data</button>}
    </form>
  </Card>);
};

export default PurchaseForm;
