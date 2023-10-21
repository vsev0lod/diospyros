import React, { useState } from 'react';
import { Router, Link, navigate } from '@reach/router';
import LoginPage from './LoginPage';
import MainPage from './MainPage';

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  // Function to handle successful login and redirection to the main page
  const handleSuccessfulLogin = () => {
    setLoggedIn(true);
    // Redirect to the main page
    navigate('/main');
  };

  // Function to handle logging out and returning to the login page
  const handleLogout = () => {
    setLoggedIn(false);
    // Redirect to the login page
    navigate('/login');
  };

  return (
      <div>
        <nav>
          {loggedIn ? (
              <Link to="/main">Main</Link> | <button onClick={handleLogout}>Logout</button>
          ) : (
              <Link to="/login">Login</Link>
          )}
        </nav>
        <Router>
          <LoginPage path="/login" onLogin={handleSuccessfulLogin} />
          <MainPage path="/main" />
        </Router>
      </div>
  );
}

export default App;
