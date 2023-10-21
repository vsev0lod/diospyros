import React, { useState } from 'react';
import { Router, Link, navigate } from '@reach/router';
import LoginPage from './LoginPage';
import MainPage from './MainPage';

function App() {
    const [loggedIn, setLoggedIn] = useState(false);

    const handleSuccessfulLogin = () => {
        setLoggedIn(true);
        navigate('/main');
    };

    const handleLogout = () => {
        setLoggedIn(false);
        navigate('/login');
    };

    return (
        <div>
            <nav>
                {loggedIn ? (
                    <Link to="/main">Main</Link> | <button onClick={handleLogout}>Logout</button>
                ) : (
                    null
                )}
            </nav>
            <Router>
                <LoginPage path="/login" onLogin={handleSuccessfulLogin} />
                <MainPage path="/main" loggedIn={loggedIn} />
            </Router>
        </div>
    );
}

export default App;
