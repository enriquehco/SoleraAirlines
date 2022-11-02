import React from 'react';
import {useLocation} from 'react-router-dom';
import Purchases from '../purchases/Purchases';

const Purchase = () => {

    const location = useLocation();
    console.log(location.state.info);

    return (
        <div>
            <Purchases />
        </div>
    );
}

export default Purchase;
