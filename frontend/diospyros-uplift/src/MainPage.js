import React from 'react';

function MainPage({ loggedIn }) {
    const handleLogout = () => {
        // Implement your logout logic here
        // This can include clearing user data, making API calls, etc.
        // After the logout logic, you can redirect the user to the login page.
        // For simplicity, we will just reload the page in this example.
        window.location.reload();
    };

    return (
        <div className="main-page">
            {loggedIn && (
                <div>
                    <button onClick={handleLogout} className="logout-button">Logout</button>
                </div>
            )}
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
