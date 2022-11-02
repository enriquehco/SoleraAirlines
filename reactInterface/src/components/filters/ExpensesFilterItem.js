import React, {useState} from "react";

import './ExpensesFilter.css'

const ExpensesFilterItem = (props) => {

  const [selected, setSelected] = useState('');

  const changeFieldHandler = (val) => {
    setSelected(val);
    props.onReturnDropdown(selected)
  }

  return (
    <div className="expenses-filter__control">
      <label>Filter by {props.params.name}</label>
      <select value={selected} onChange={(e) => changeFieldHandler(e.target.value)}>
        {props.params.options.map((item) => (
            <option value={item}>{item}</option>
        ))}
      </select>
    </div>
  );
};

export default ExpensesFilterItem;
