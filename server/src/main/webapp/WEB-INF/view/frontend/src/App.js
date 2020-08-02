import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import "./assets/style/style.css";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Home from "./pages/Home";
import Likes from "./pages/Likes";
import Profile from "./pages/Profile";

function App() {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Login} />
      <Route path="/index.html" component={Login} />
      <Route path="/login" component={Login} />
      <Route path="/register" component={Register} />

      <Route path="/home" component={Home} />
      <Route path="/likes" component={Likes} />
      <Route path="/profile" component={Profile} />
    </BrowserRouter>
  );
}

export default App;
