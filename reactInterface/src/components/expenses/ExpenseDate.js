import "./ExpenseItems.css";

function ExpenseDate(data) {
  const day = data.date.substring(8, 10);
  const month = data.date.substring(5, 7);
  const year = data.date.substring(0, 4);

  return (
    <div className="expense-date">
      <div className="expense-date__day">{day}</div>
      <div className="expense-date__month">{month}</div>
      <div className="expense-date__year">{year}</div>
    </div>
  );
}

export default ExpenseDate;
