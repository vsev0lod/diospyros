import React from 'react';
import './MainPage.css';

function MainPage() {
    return (
        <div className="main-page">
            <div className="user-info">
                <h2>User Information</h2>
                <p>Name: John Doe</p>
                <p>Email: john@example.com</p>
                <p>Balance: $1000</p>
            </div>
        </div>
    );
}

export default MainPage;
