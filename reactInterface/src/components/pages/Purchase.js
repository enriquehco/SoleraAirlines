import React, { useState } from 'react';
import {useLocation} from 'react-router-dom';
import ExpenseItems from '../expenses/ExpenseItems';
import Purchases from '../purchases/Purchases';

const Purchase = () => {
    const location = useLocation();
    const [pData, setPData] = useState(location.state);

    return (
        <div>
            <div>Flight Information</div><br/>
            <ExpenseItems 
                key={pData.data.id}
                departure={pData.data.departureCity}
                arrival={pData.data.arrivalCity}
                company={pData.data.company}
                duration={pData.data.duration}
                luggage={pData.data.cabinLuggage}
                date={pData.data.dateTime}
                id_city={pData.data.cityId}
                base_price={pData.data.basePrice}
            />
            <Purchases />
        </div>
    );
}

export default Purchase;
