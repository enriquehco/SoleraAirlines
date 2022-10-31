import './ExpenseItems.css';

function ExpenseDate(data){
    const day = data.date.toLocaleString('en-US',{ day: '2-digit'});
    const month = data.date.toLocaleString('en-US',{ month: 'long'});
    const year = data.date.getFullYear();

    return (
      <div className='expense-date'>
        <div className='expense-date__day'>{day}</div>
        <div className='expense-date__month'>{month}</div>
        <div className='expense-date__year'>{year}</div>
      </div>
    );
}

export default ExpenseDate;